package com.dn5.tdd;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(1000.0);
    }

    @After
    public void tearDown() {
        account = null;
    }

    @Test
    public void depositShouldIncreaseBalance() {
        // Arrange
        double depositAmount = 500.0;

        // Act
        account.deposit(depositAmount);

        // Assert
        Assert.assertEquals(1500.0, account.getBalance(), 0.001);
    }

    @Test
    public void withdrawShouldDecreaseBalance() {
        // Arrange
        double withdrawalAmount = 300.0;

        // Act
        account.withdraw(withdrawalAmount);

        // Assert
        Assert.assertEquals(700.0, account.getBalance(), 0.001);
    }
}
