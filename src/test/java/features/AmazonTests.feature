Feature: Amazon tests
  In this test suite we will verify selected device

  Scenario: Device view assessment
    Given From the hamburger menu in the upper left-hand corner select "Electronics & Computers"
    Given From the following menu select "Laptops"
    And Select Display Size /15" - 16"/
    And Select CPU Type /Intel Core i5/
    And Select Storage Type /SSD/
    And Sort by "Price: Low to High"
    When Select a 5 stared item
    Then Once the details page for the laptop is opened, verify it's the selected laptop
      | Size | CPU     | Storage |
      | 15   | Core i5 | SSD     |



