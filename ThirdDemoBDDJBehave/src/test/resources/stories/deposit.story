Meta:
@feature DepositFunds
@component Backend
@priority low

Narrative:
In order to increase my account balance
As a bank account holder
I want to be able to deposit funds into my account

Scenario: Successful deposit into a bank account
Given the customer has a bank account with a balance of "$100"
When the customer deposits "$400"
Then the account balance should be "$500"