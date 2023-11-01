package com.pluralsight.bddjbehave.bank;

import org.jbehave.core.annotations.*;

import static org.junit.Assert.assertEquals;

public class BankSteps {

    private BankAccount account;

    @Given("the customer has a bank account with a balance of \"$balance\"")
    public void givenBankAccountWithBalance(String balance) {
        account = new BankAccount(Integer.parseInt(balance.substring(1)));
    }

    @When("the customer deposits \"$amount\"")
    public void whenCustomerDeposits(String amount) {
        account.deposit(Integer.parseInt(amount.substring(1)));
    }

    @When("the customer withdraws \"$amount\"")
    public void whenCustomerWithdraws(String amount) {
        account.withdraw(Integer.parseInt(amount.substring(1)));
    }

    @Then("the account balance should be \"$balance\"")
    public void thenAccountBalanceShouldBe(String balance) {
        assertEquals(Integer.parseInt(balance.substring(1)), account.getBalance());
    }
}
