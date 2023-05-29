# language: en

  Feature: Balance Service
    Scenario: Adding money to balance
      Given A client with zero balance
      When Add a 300 money to balance
      Then Balance should be equal 300

    Scenario: Removing money from balance
      Given A client with zero balance
      When Withdraw 200 money from balance
      Then Balance should be equal -200