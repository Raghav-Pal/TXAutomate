Feature: placing order with a guest user

  @OrderWithGuest
  Scenario: 10445_Selecting a product from Home page
    Given Navigate to Home page of Vitamin Shoppe
    When Navaigate to the category "SHOP BY DEPARTMENT > HOME & LIFESTYLE > Air & Water Filtration > Himalayan Salt Lamps"
    And Click on "ADD TO CART" button and further click on "VIEW CART & CHECK OUT" button.
    And Click on "CHECK OUT NOW" buton on "Shopping Cart" page.
    And Fill all the details under SIGNIN section on "Secure Checkout" page.
    And Fill all the details under SHIPPING INFORMATION section on "Secure Checkout" page.
    And Choose a shipping option under 'Choose a Shipping Option' section
    And Enter required details under "Credit & Debit Cards" section
    And Click on 'Submit Order' button under 'Review and Submit' section.
    Then Wait for and Verify that odere has been placed successfully
