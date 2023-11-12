package com.pluralsight.bddjbehave.bank;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;

public class BankDeposit {

    private BankAccount account;

    @Given("the customer has a bank account with a balance of $500")
    public void givenBankAccountWithBalance(String balance) {
        account = new BankAccount(Integer.parseInt(balance.substring(1)));
    }

    @When("the customer deposits $200")
    public void whenCustomerDeposits(String amount) {
        account.deposit(Integer.parseInt(amount.substring(1)));
    }

    @Then("the account balance should be $700")
    public void thenAccountBalanceShouldBe(String balance) {
        assertEquals(Integer.parseInt(balance.substring(1)), account.getBalance());
    }
}