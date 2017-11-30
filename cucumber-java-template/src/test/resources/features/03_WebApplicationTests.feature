Feature: Create a new Insurance policy

  @Webtest
  Scenario Outline: 10004_Create A Home Insurance Policy
    Given Read "<TestData>" from Testdata file
    And I open UPC website
    And I login into the application
    And I select to start a new qoute for policy creation
    When I fill the address details in the prompt
    And I fill the household property information details
    And I fill the property details of the insurer
    And I fill the coverage details of the insurer
    And I fill the point of sale details
    And I submit for authorization
    Then I verify the status of the created policy
    And I sign out from application

    Examples: 
      | TestData  |
      | Testdata1 |

  @Webtest
  Scenario Outline: 10005_Create Home Insurance Policy with mandatory details
    Given Read "<TestData>" from Testdata file
    And I open UPC website
    And I login into the application
    And I select to start a new qoute for policy creation
    When I fill the address details in the prompt
    And I fill the household property information details
    And I fill the property details of the insurer
    And I fill the coverage details of the insurer
    And I fill the point of sale details
    And I submit for authorization
    Then I verify the status of the created policy
    And I sign out from application

    Examples: 
      | TestData  |
      | Testdata2 |

  @WebtestSmoke
  Scenario Outline: 10004_Create A Home Insurance Policy
    Given Read "<TestData>" from Testdata file
    And I open UPC website
    And I login into the application
    And I select to start a new qoute for policy creation
    When I fill the address details in the prompt
    And I fill the household property information details
    And I fill the property details of the insurer
    And I fill the coverage details of the insurer
    And I fill the point of sale details
    And I submit for authorization
    Then I verify the status of the created policy
    And I sign out from application

    Examples: 
      | TestData  |
      | Testdata1 |

  @WebtestAcceptance
  Scenario Outline: 10004_Create A Home Insurance Policy
    Given Read "<TestData>" from Testdata file
    And I open UPC website
    And I login into the application
    And I select to start a new qoute for policy creation
    When I fill the address details in the prompt
    And I fill the household property information details
    And I fill the property details of the insurer
    And I fill the coverage details of the insurer
    And I fill the point of sale details
    And I submit for authorization
    Then I verify the status of the created policy
    And I sign out from application

    Examples: 
      | TestData  |
      | Testdata1 |
