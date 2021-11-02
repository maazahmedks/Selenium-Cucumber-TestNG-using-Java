Feature: Login page

  Scenario: Login with invalid user and invalid pass
    Given Open website url
    When user logged with invalid username "01asdftesst" and invalid password "sdsclick123"
    Then Validation message should be displayed

  Scenario: Login with valid user and invalid pass
    When user logged with valid username "5demoa2pp" and invalid password "8click123"
    Then Error message should be displayed

  Scenario: Login with invalid user and valid pass
    When user logged with invalid username "7demoa2p2p" and valid password "9click123"
    Then Valid error message should be displayed

  Scenario: Login with empty user and pass
    When user logged with empty username and password
    Then Required error message should be displayed