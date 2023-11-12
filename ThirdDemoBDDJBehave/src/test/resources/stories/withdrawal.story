Meta:
@feature WithdrawFunds
@component Backend
@priority medium

Narrative:
In order to access my money
As a bank account holder
I want to be able to withdraw funds from my account

Scenario: Successful withdrawal from a bank account with sufficient funds
Given the customer has a bank account with a balance of "$500"
When the customer withdraws "$200"
Then the account balance should be "$300"

Scenario: Unsuccessful withdrawal due to insufficient funds
Given the customer has a bank account with a balance of "$100"
When the customer tries to withdraw "$150"
Then the withdrawal should be declined