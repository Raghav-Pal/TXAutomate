package mantisutil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.MimetypesFileTypeMap;

import org.mantisbt.connect.IMCSession;
import org.mantisbt.connect.MCException;
import org.mantisbt.connect.model.IProject;
import org.mantisbt.connect.model.Issue;
import org.mantisbt.connect.model.MCAttribute;

import utilities.GlobalUtil;

public class MantisReport{

	/*	public static void main(String[] args) throws Exception {
		reporIssue("test summary", "test descri", "General", "test info","C:\\Users\\Chandu\\Downloads\\IMG_20170710_090018.jpg");

	}
	 */
	public static String reporIssue(String summary, String description, String category, String additionalInformation, String filename) {

		if(GlobalUtil.getCommonSettings().getbugTool().equalsIgnoreCase("No")){
			return "No Bug tracking tool configured";
		}

		IMCSession sessions = null;
		String bugID = null;
		try {

			//getting the mantis connection
			sessions = ConnectMantis.getSession();

			//creating the issue for the project with the details mentioned
			IProject projet = sessions.getProject(ConnectMantis.MANTIS_PROJET);
			Issue issue = new Issue();

			issue.setProject(new MCAttribute(projet.getId(), projet.getName()));
			issue.setAdditionalInformation(null);
			if(GlobalUtil.getCommonSettings().getExecutionEnv().equalsIgnoreCase("LOCAL")){
				issue.setOs(System.getProperty("os.name"));
				issue.setOsBuild(System.getProperty("os.version"));
				issue.setPlatform(System.getProperty("os.arch"));
			} 
			else{
				issue.setOs(GlobalUtil.getCommonSettings().getRemoteOS());
				issue.setPlatform(GlobalUtil.getCommonSettings().getRemoteOS());
				issue.setOsBuild(GlobalUtil.getCommonSettings().getRemoteOS().split("_")[1]);
			}
			issue.setSeverity(new MCAttribute(70, "crash"));
			issue.setReproducibility(new MCAttribute(10, "always"));

			issue.setSummary(summary+"\n" + new Date());
			issue.setDescription(description);
			issue.setCategory(category);
			issue.setPriority(new MCAttribute(40, "high"));
			issue.setAdditionalInformation(additionalInformation);

			//adding the issue to the project
			long id = sessions.addIssue(issue);


			//adding the screentshot to the issue
			if(!filename.equalsIgnoreCase("RestAPI")){
				submitAttachment(sessions,id,new File(filename));
			}
			bugID = String.valueOf(id);
		} catch (MalformedURLException e) {
			System.err.println("Error no URL access to Mantis");
			e.printStackTrace();
		} catch (MCException e) {
			System.err.println("Error no connection to mantis");
			e.printStackTrace();
		}
		System.out.println("issue created successfully with Issue iD: " + bugID);
		return bugID;
	}


	protected static long addAttachment(IMCSession session, long issueId, byte[] data,
			String filename) throws MCException {
		return session.addIssueAttachment(issueId, filename, getMimeType(filename), data);
	}

	public static long submitAttachment(IMCSession session, long issueId, File file) throws MCException {
		try {

			//File fi = new File(filename);
			byte[] data = readFile(file);
			String filename = null;
			if (doCompress(file)) {
				filename = getCompressedFilename(file);
				data = compress(data, file.getName());
			} else {
				filename = file.getName();
			}
			return addAttachment(session, issueId, data, filename);
		} catch (IOException e) {
			throw new MCException(e);
		}		
	}

	public static String getMimeType(String string) {
		return new MimetypesFileTypeMap().getContentType(string);
	}

	public static byte[] readFile(File file) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int read = -1;
		while ((read = fis.read(buffer)) != -1) {
			baos.write(buffer, 0, read);
		}
		return baos.toByteArray();
	}

	public static boolean doCompress(File file) {
		return (!isCompressed(file) && true);
	}

	protected static String getCompressedFilename(File file) {
		String filename;
		filename = file.getName() + ".zip";
		return filename;
	}

	protected static boolean isCompressed(File file) {
		String filename = file.getName();
		int lastSeparator = filename.lastIndexOf('.');
		if (lastSeparator > 0 && lastSeparator < filename.length()) {
			String type = filename.substring(lastSeparator + 1).toLowerCase();
			return Arrays.binarySearch(COMPRESSED_FILES, type) >= 0;
		} else {
			return false;
		}
	}
	public final static String[] COMPRESSED_FILES = new String[] {
			"bz2", "gif", "gz", "jpg", "png", "rar", "zip"
	};

	protected static byte[] compress(byte[] data, String filename) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(baos);
		zos.putNextEntry(new ZipEntry(filename));
		zos.write(data);
		zos.close();
		data = baos.toByteArray();
		return data;
	}


}
