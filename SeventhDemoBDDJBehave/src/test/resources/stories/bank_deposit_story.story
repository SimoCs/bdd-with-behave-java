Meta:
@feature Deposit
@component Backend
@priority High

Narrative:
In order to keep track of my finances
As a bank customer
I want to deposit money in my bank account

Scenario: A customer operates a bank account
Given the customer has a bank account with a balance of "$500"
When the customer deposits "$200"
Then the account balance should be "$700"
When the customer withdraws "$100"
Then the account balance should be "$600"