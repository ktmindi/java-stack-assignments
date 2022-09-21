package javaFundamentals.BankAccount;

//import java.util.Random;

class BankAccount {

    private double checkingBalance;
    private double savingsBalance;

    public static int numberOfAccounts = 0;
    public static double totalHoldings = 0;

    // this instance only gets called once -- constructor function
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
        //before we can increment we must check which account we are incrementing
        //if checking 
        if (account == "checking") {
            this.checkingBalance += amount;
        } 
        else { this.savingsBalance += amount;
        }
        this.totalHoldings += amount;
    }
        //else if savings
        // we must increment the balance and the total holdings

}