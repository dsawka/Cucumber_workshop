Feature: Coders Guru

  Scenario Outline: : User can register on the website
    Given there is a browser with home page
    When user clicks registration button
    Then user is on registration page
    And input field firstname is filled with <firstnameparameter>
    And input field lastname is filled with <lastnameparameter>
    And input field password is filled with <passwordparameter>
    And input field city is filled with <cityparameter>
    And input field postal code is filled with <postalcodeparameter>
    And input field street is filled with <streetparameter>
    And input field street number is filled with <streetnumberparameter>
    And mark that he knows regulations
    And click register
    And user is logged <firstnameparameter>


    Examples:
      | firstnameparameter | lastnameparameter | passwordparameter | cityparameter | postalcodeparameter | streetparameter | streetnumberparameter |
      | Karol              | kowalski          | pass123           | Krakow        | 31-300              | krakowska       | 21                    |
