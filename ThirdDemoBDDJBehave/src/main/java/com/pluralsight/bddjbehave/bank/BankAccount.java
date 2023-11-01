package com.pluralsight.bddjbehave.bank;

public class BankAccount {
    private int balance;
    private boolean lastTransactionSuccessful = true;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            lastTransactionSuccessful = true;
        } else {
            lastTransactionSuccessful = false;
        }
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            lastTransactionSuccessful = true;
        } else {
            lastTransactionSuccessful = false;
        }
    }

    public int getBalance() {
        return balance;
    }

    public boolean isLastTransactionSuccessful() {
        return lastTransactionSuccessful;
    }
}