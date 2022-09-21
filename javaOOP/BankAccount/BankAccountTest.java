package javaOOP.BankAccount;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount stanAccount = new BankAccount();
        stanAccount.depositMoney(1000, "checking");
        stanAccount.depositMoney(300, "savings");
        stanAccount.displayAccountBalance();

        BankAccount mannyAccount = new BankAccount();
        mannyAccount.depositMoney(100.50, "checking");
        mannyAccount.depositMoney(300.70, "savings");
        mannyAccount.displayAccountBalance();

        System.out.printf("Total number of accounts = %d", BankAccount.numberOfAccounts);

        mannyAccount.withdrawMoney(30, "savings");
        mannyAccount.displayAccountBalance();

    }
}
