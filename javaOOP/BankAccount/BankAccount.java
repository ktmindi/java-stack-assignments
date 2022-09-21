package javaOOP.BankAccount;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;

    public static int numberOfAccounts = 0;
    public static double totalAccountBalance = 0;

    public BankAccount() {
        BankAccount.numberOfAccounts += 1;
        this.checkingBalance = 0;
        this.savingsBalance = 0;
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }
    public void depositMoney(double amount, String account) {

        if (account == "checking") {
            this.checkingBalance += amount;
        } 
        else { this.savingsBalance += amount;
        }
        BankAccount.totalAccountBalance += amount;
    }

    public void withdrawMoney(double amount, String account) {
        boolean successful = false;
        if(account.equals("savings")) {
            if(this.savingsBalance - amount >= 0) {
                successful = true;
                this.savingsBalance -= amount;
            }
        }
        else if(account.equals("checking")) {
            if(this.checkingBalance - amount >= 0) {
                successful = true;
                this.checkingBalance -= amount;
            }
        }
        if(successful) {
            BankAccount.totalAccountBalance -= amount;
        }
        else {
            System.out.println("Insufficient funds.");
        }
    }

    public void displayAccountBalance() {

        System.out.println(String.format("Savings: %.2f, Checking: %.2f", this.savingsBalance, this.checkingBalance));
    }
}