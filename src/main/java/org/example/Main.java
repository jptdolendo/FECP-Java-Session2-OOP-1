package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Displays the menu
    public static void displayMenu() {
        System.out.println("=== Bank Menu ===");
        System.out.println("1. Create Account");
        System.out.println("2. View All Accounts");
        System.out.println("3. Check Balance");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Exit");
    }

    // Creates a bank account
    static void createAccount(ArrayList<BankAccount> bankAccounts, String accountName, String accountNumber, double availableBalance) {
        // Checks for duplicate account numbers
        for (BankAccount account : bankAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Account number already exists. Account not created.");
                return;
            }
        }

        // Checks if initial deposit is less than zero
        if (availableBalance < 0) {
            System.out.println("Invalid input. Account not created.");
            return;
        }

        // Creates new bank account
        BankAccount newBankAccount = new BankAccount(accountName, accountNumber, availableBalance);
        bankAccounts.add(newBankAccount);
        System.out.println("Account created successfully!");
    }

    // Display all info of all bank accounts
    static void viewAllAccounts(ArrayList<BankAccount> bankAccounts) {
        System.out.println("=== All Bank Accounts ===");
        for (BankAccount account : bankAccounts){
            account.displayInfo();
        }
        System.out.println("=== End of All Accounts ===");
    }

    // Checks a balance of an individual account
    static void checkBalance(ArrayList<BankAccount> bankAccounts, String accountNumber) {
        // Prints the balance of an account
        for (BankAccount account : bankAccounts){
            if (account.getAccountNumber().equals(accountNumber)) {
                double currentAvailableBalance = account.getAvailableBalance();
                System.out.printf("Your current balance is: %.2f\n", currentAvailableBalance);
                return;
            }
        }

        System.out.println("Account not existing.");
    }

    // Deposits to a bank account
    static void deposit(ArrayList<BankAccount> bankAccounts, String accountNumber, double amountToDeposit) {
        // Checks if the amount to deposit is valid
        if (amountToDeposit < 0) {
            System.out.println("Invalid amount.");
            return;
        }

        // Finds the account and deposits the amount
        for (BankAccount account : bankAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.deposit(amountToDeposit);
                System.out.printf("%.2f has been deposited into your account.\n", amountToDeposit);
                return;
            }
        }

        System.out.println("Account not existing.");
    }

    // Withdraws from an account
    static void withdraw(ArrayList<BankAccount> bankAccounts, String accountNumber, double amountToWithdraw) {
        // Checks if the amount to withdraw is valid
        if (amountToWithdraw < 0) {
            System.out.println("Invalid amount.");
            return;
        }

        // Finds the account and withdraws the amount
        for (BankAccount account : bankAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                // Checks if the amount to withdraw is more than the available balance
                if (account.getAvailableBalance() < amountToWithdraw) {
                    System.out.println("Invalid amount, check your balance.");
                    return;
                }

                account.withdraw(amountToWithdraw);
                System.out.printf("%.2f has been withdrawn from your account. Thank you.\n", amountToWithdraw);

                double newAvailableBalance = account.getAvailableBalance();
                System.out.printf("Your new balance is: %.2f\n", newAvailableBalance);
            }
        }

        System.out.println("Account not existing.");
    }

    public static void main(String[] args) {
        // Variable initialization
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        int choice = 0;

        // Prints a menu until the user chooses to exit
        while (choice != 6) {
            displayMenu();
            System.out.print("Enter choice (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                // Creating a new bank account
                case 1:
                    System.out.print("Enter Account Number: ");
                    String newBankAccountNumber = scanner.nextLine();

                    System.out.print("Enter Holder Name: ");
                    String newBankAccountName = scanner.nextLine();

                    System.out.print("Initial deposit? (yes/no) ");
                    String hasInitialDeposit = scanner.nextLine();

                    if (hasInitialDeposit.equals("yes")) {
                        System.out.print("Enter initial deposit amount: ");
                        int newInitialDeposit = scanner.nextInt();
                        scanner.nextLine();

                        createAccount(bankAccounts, newBankAccountName, newBankAccountNumber, newInitialDeposit);
                        break;
                    }

                    createAccount(bankAccounts, newBankAccountName, newBankAccountNumber, 0);
                    break;
                // Viewing all bank accounts
                case 2:
                    viewAllAccounts(bankAccounts);
                    break;
                // Checking the available balance of an account
                case 3:
                    System.out.print("Enter Your Account Number: ");
                    String accountNumberToCheck = scanner.nextLine();

                    checkBalance(bankAccounts, accountNumberToCheck);
                    break;
                // Deposits to a bank account
                case 4:
                    System.out.print("Enter Your Account Number: ");
                    String accountNumberToDeposit = scanner.nextLine();

                    System.out.print("Enter amount to deposit: ");
                    double amountToDeposit = scanner.nextDouble();

                    deposit(bankAccounts, accountNumberToDeposit, amountToDeposit);
                    break;
                // Withdraws from a bank account
                case 5:
                    System.out.print("Enter Your Account Number: ");
                    String accountNumberToWithdraw = scanner.nextLine();

                    System.out.print("Enter amount to withdraw: ");
                    double amountToWithdraw = scanner.nextDouble();

                    withdraw(bankAccounts, accountNumberToWithdraw, amountToWithdraw);
                    break;
                // Exits the system
                case 6:
                    System.out.println("Thank you for using this system.");
                    break;
                // Defaults if the input is invalid
                default:
                    System.out.println("Invalid input.");
            }

            System.out.println();
        }
    }
}