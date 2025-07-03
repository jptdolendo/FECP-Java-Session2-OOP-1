package org.example;

public class BankAccount {
    // Instance variables
    private String accountName;
    private String accountNumber;
    private double availableBalance;

    // Constructor
    public BankAccount(String accountName, String accountNumber, double availableBalance){
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.availableBalance = availableBalance;
    }

    // Displays all bank account info
    void displayInfo() {
        System.out.println("Account Number: ".concat(this.accountNumber));
        System.out.println("Account Holder Name: ".concat(this.accountName));
        System.out.printf("Available Balance: %.2f\n", this.availableBalance);
        System.out.println("===");
    }

    // Gets the account number
    String getAccountNumber() {
        return this.accountNumber;
    }

    // Gets the available balance
    double getAvailableBalance() {
        return this.availableBalance;
    }

    // Sets the available balance when depositing
    void deposit(double amountToDeposit) {
        this.availableBalance += amountToDeposit;
    }

    // Sets the available balance when withdrawing
    void withdraw(double amountToWithdraw) {
        this.availableBalance -= amountToWithdraw;
    }
}
