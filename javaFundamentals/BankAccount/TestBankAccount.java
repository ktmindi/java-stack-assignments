package javaFundamentals.BankAccount;

class TestBankAccount {
    public static void main(String[] args) {
		BankAccount millieBankAccount = new BankAccount(); //call constructor function
        millieBankAccount.depositMoney(1000, "checking");
        millieBankAccount.depositMoney(200, "savings");


        BankAccount joanBankAccount = new BankAccount();
        joanBankAccount.depositMoney(300, "savings");
        joanBankAccount.depositMoney(1000, "checking");

        //millieBankAccount.displayAccountBalance();
        //joanBankAccount.displayAccountBalance();
        System.out.println(millieBankAccount.getCheckingBalance());
        System.out.println(millieBankAccount.getSavingsBalance());

        System.out.println(BankAccount.totalHoldings);
        //System.out.println(joanBankAccount.getCheckingBalance());
        //System.out.println(joanBankAccount.getSavingsBalance());

        //System.out.println("New Acc No. - " + ba.getAccountNumber());
		//ba.depositMoney(100.49, "checking");
		//ba.depositMoney(3.00, "savings");
		//ba.displayAccountBalance();

		//System.out.println(BankAccount.totalHoldings);

		//ba.withdrawMoney(50, "checking");
		//ba.withdrawMoney(50, "savings");
		//ba.displayAccountBalance();

		//System.out.println(BankAccount.totalHoldings);

        //BankAccount ba2 = new BankAccount();
        //System.out.println("New Acc No. - " + ba2.getAccountNumber());
		//ba2.depositMoney(3, "checking");
		//ba2.depositMoney(99, "savings");
		//ba2.displayAccountBalance();
        //ba2.withdrawMoney(50, "checking");
	}
}