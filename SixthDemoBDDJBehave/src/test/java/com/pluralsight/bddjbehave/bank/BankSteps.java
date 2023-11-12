package com.pluralsight.bddjbehave.bank;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BankSteps {
    private BankAccount account;

    @Given("the customer has a bank account with a balance of \"$amount\"")
    public void givenAccountWithBalance(String amount) {
        account = new BankAccount(Integer.parseInt(amount.substring(1)));
    }

    @When("the customer withdraws \"$amount\"")
    public void whenCustomerWithdraws(String amount) {
        account.withdraw(Integer.parseInt(amount.substring(1)));
    }

    @When("the customer tries to withdraw \"$amount\"")
    public void whenCustomerTriesToWithdraw(String amount) {
        account.withdraw(Integer.parseInt(amount.substring(1)));
    }

    @Then("the account balance should be \"$expectedBalance\"")
    public void thenAccountBalanceShouldBe(String expectedBalance) {
        assertEquals(Integer.parseInt(expectedBalance.substring(1)), account.getBalance());
    }

    @Then("the withdrawal should be declined")
    public void thenWithdrawalShouldBeDeclined() {
        assertFalse(account.isLastTransactionSuccessful());
    }

    @When("the customer deposits \"$amount\"")
    public void whenCustomerDeposits(String amount) {
        account.deposit(Integer.parseInt(amount.substring(1)));
    }

    @Then("the deposit should be declined")
    public void thenDepositShouldBeDeclined() {
        assertFalse(account.isLastTransactionSuccessful());
    }

    @When("the customer tries to deposit \"$amount\"")
    public void whenCustomerTriesToDeposit(String amount) {
        account.deposit(Integer.parseInt(amount.substring(1)));
    }
}