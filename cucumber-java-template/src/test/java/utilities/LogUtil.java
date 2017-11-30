package utilities;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.spi.LoggingEvent;

import com.gargoylesoftware.htmlunit.html.HtmlAttributeChangeEvent;

/**
 * @author TestLink
 *
 */
public class LogUtil {
	static Logger errorLogger;
	static Logger normalLogger;
	static Logger htmlLogger;
	static FileAppender normalFileApp;
	static FileAppender errorFileApp;
	static FileAppender htmlFileApp;
	
	static ConsoleAppender conApp;
	static RollingFileAppender normalRap;
	static RollingFileAppender errorRap;
	private static boolean isInit = false;
	private LogUtil(){}



	static PatternLayout patternLayout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p - %m%n");
	static PatternLayout consolePatternLayout = new PatternLayout("\tLOG-: [%m -  %d{yyyy-MM-dd HH:mm:ss a}] %n");
	static HTMLLayout htmlLayout = new HTMLLayout();
	/**
	 * @param clazz
	 */
	public static void init(Class clazz) {
		if (!isInit) {

			try {
				htmlLogger = Logger.getLogger(clazz+",HtmlLogger");
				htmlLogger .setLevel(Level.INFO);
				htmlLayout.setTitle("Automation Logs");
				htmlFileApp = new FileAppender(htmlLayout, ConfigReader.getValue("logHtmlFilePath"));
				htmlFileApp.setImmediateFlush(true);
				htmlFileApp .setAppend(false);
				htmlFileApp.activateOptions();
				htmlLogger.addAppender(htmlFileApp);
				
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
			
			
			normalLogger = Logger.getLogger(clazz + ",NormalLogger");
			normalLogger.setLevel(Level.INFO);

			normalFileApp = new FileAppender();
			normalFileApp.setLayout(patternLayout);
			normalFileApp.setFile(ConfigReader.getValue("logInfoFilePath"));

			normalFileApp.setImmediateFlush(true);
			normalLogger.addAppender(normalFileApp);
			normalFileApp.activateOptions();

			// Rolling File Appender for maximum 5 mb log file size
			try {
				normalRap = new RollingFileAppender(patternLayout, normalFileApp.getFile());
				normalRap.setMaxBackupIndex(5);
				normalRap.setMaximumFileSize(5);
				normalRap.activateOptions();
			} catch (IOException e) {
				LogUtil.errorLog(LogUtil.class, "Exception caught", e);
			}

			errorLogger = Logger.getLogger(clazz + ",ErrorLogger");
			errorLogger.setLevel(Level.ERROR);
			errorFileApp = new FileAppender();
			errorFileApp.setLayout(patternLayout);
			errorFileApp.setFile(ConfigReader.getValue("logErrorFilePath"));

			errorFileApp.setImmediateFlush(true);
			errorLogger.addAppender(errorFileApp);
			errorFileApp.activateOptions();

			try {
				errorRap = new RollingFileAppender(patternLayout, errorFileApp.getFile());
				normalRap.setMaxBackupIndex(5);
				normalRap.setMaximumFileSize(5);
				normalRap.activateOptions();
			} catch (IOException e) {
				LogUtil.errorLog(LogUtil.class, "Exception caught", e);
			}

			conApp = new ConsoleAppender();
			conApp.setLayout(consolePatternLayout);
			conApp.setTarget("System.out");
			conApp.activateOptions();
			
			normalLogger.addAppender(conApp);

			isInit = true;
		}
	}

	/**
	 * @param className
	 */
	public static void init(String className) {
		if (!isInit) {
			
			try {
				htmlLogger = Logger.getLogger(className+",HtmlLogger");
				htmlLogger .setLevel(Level.DEBUG);
				
				htmlLayout.setTitle("Automation Logs");
				
				htmlFileApp = new FileAppender(htmlLayout, ConfigReader.getValue("logHtmlFilePath"));
				htmlFileApp.setImmediateFlush(true);
				htmlFileApp.activateOptions();
				htmlLogger.addAppender(htmlFileApp);
				
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			normalLogger = Logger.getLogger(className + ",NormalLogger");
			normalLogger.setLevel(Level.INFO);

			normalFileApp = new FileAppender();
			normalFileApp.setLayout(patternLayout);
			normalFileApp.setFile("Logs\\AppLog.txt");
			normalFileApp.setImmediateFlush(true);
			normalLogger.addAppender(normalFileApp);
			normalFileApp.activateOptions();

			errorLogger = Logger.getLogger(className + ",ErrorLogger");
			errorLogger.setLevel(Level.DEBUG);
			errorFileApp = new FileAppender();
			errorFileApp.setLayout(patternLayout);
			errorFileApp.setFile("Logs\\ErrorLog.txt");
			errorFileApp.setImmediateFlush(true);
			errorLogger.addAppender(errorFileApp);
			errorFileApp.activateOptions();

			conApp = new ConsoleAppender();
			conApp.setLayout(consolePatternLayout);
			conApp.setTarget("System.out");
			conApp.activateOptions();

			normalLogger.addAppender(conApp);

			isInit = true;
		}
	}

	/**
	 * @param clazz
	 * @param message
	 */
	public static void infoLog(Class clazz, String message) {
		init(clazz);
		normalLogger.info(message);
		htmlLogger.info(message);

	}

	/**
	 * @param className
	 * @param message
	 */
	public static void infoLog(String className, String message) {
		init(className);
		normalLogger.info(message);
		htmlLogger.info(message);

	}

	/**
	 * @param clazz
	 * @param message
	 * @param t
	 */
	public static void errorLog(Class clazz, String message, Throwable t) {
		init(clazz);
		htmlLogger.error(message,t);
		errorLogger.error(message, t);
		errorLogger.error("----------------------------------------------------------------------");

	}

	/**
	 * @param clazz
	 * @param message
	 */
	public static void errorLog(Class clazz, String message) {
		init(clazz);
		htmlLogger.error(message);
		errorLogger.error(message);
		errorLogger.error("-----------------------------------------------------------------------");

	}

	/**
	 * @param name
	 * @param message
	 */
	public static void errorLog(String name, String message) {
		init(name);
		htmlLogger.error(message);
		errorLogger.error(message);
		errorLogger.error("-----------------------------------------------------------------------");

	}


}
