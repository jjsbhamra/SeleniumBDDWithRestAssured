Feature: Login

  Scenario: Successful Login with Valid credential
    Given User Launch Browser
    When User Open URL "<url>"
    And User accept cookies and click on SignIn button
    And Enter login credentials
    And Click on finance tab
    And Click on Market tab
    And Click on Celander tab
    Examples:
    |url|
    |http://yahoo.com/|