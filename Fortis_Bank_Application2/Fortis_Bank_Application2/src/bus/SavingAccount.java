package bus;

import java.util.ArrayList;
import java.util.Date;

public class SavingAccount extends Account{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4101158505983910205L;
	
	private double interestRate = 2.5;
	private static double extrafee = 0.5;

	public static ArrayList<SavingAccount> savingList = new ArrayList<SavingAccount>();

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public static double getExtrafee() {
		return extrafee;
	}

	public static void setExtrafee(double extrafee) {
		SavingAccount.extrafee = extrafee;
	}

//	public SavingAccount(long accNum, EnumAccType accType, Date openDate, double balance,
//			long transNum, String desc, Date transDate, double transAmount, EnumTransType transType) {
	
	public SavingAccount() {
		super();
		this.interestRate = 2.5;
		this.extrafee = 0.5;
	}
	
//	public SavingAccount(long accNumber, long cusNumber, double balance, double InteRate, double fee) {
//		super(accNumber, cusNumber, balance);
		public SavingAccount(long accNumber, double balance, double InteRate, double fee) {
			super(accNumber, balance);	
		interestRate = InteRate;
		extrafee = fee;
	}
	
	public SavingAccount(long accNumber, double balance) {
		super(accNumber, balance);
		this.interestRate = 2.5;
		this.interestRate = 0.5;
	}
	
//	@Override
//	public String toString() {
//		return "Account [accountNumber=" + super.getAccountNumber() + ", balance = " + super.getBalance() 
//				+ ", accType = Saving \n" + super.getTrans() 
//				+ "\n\tSavingAccount [interestRate=" + interestRate +"]";
//	}
	
	@Override
	public String toString() {
		return super.toString() + " SavingAccount [interestRate=" + interestRate + "]\n";
	}

	//////////////////////////////////////// function
	@Override
	public void deposit(double amount) {
		//Check amount
		if(amount > 0) {
			balance += amount;
		}else {
			System.out.println("A negative amount cannot be made!");
		}
		
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount > 0) {
			if((amount  + extrafee) <= balance ) {
				balance -= (amount + extrafee);
			}else {
				System.out.println("Insufficient Funds in Saving!");
			}
		}else {
			System.out.println("A negative amount cannot be made!");
		}
	}
	
	
	public double calcInterest() {
		return balance * interestRate;
	}
	
	public void applyInterest() throws RaiseException {
//		double interest = calcInterest();
//		deposit(interest);
		double interest = calcInterest();
		//System.out.printf("Interest amount %.2f added to total balance %n", interest);
		deposit(interest);
		      
	}
	
	////////////////////////////////////////// methods from interface + abstract class
	@Override
	public int reset() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public void closeAccount(Account account) {		
		 if (Exist(account.getAccountNumber()) == true)
         {
			 savingList.remove(account);
    
         }
	}
	
	@Override
	public void openAccount(Account account) {
		if (Exist(account.getAccountNumber()) == true)
        {
			 accountList.add(account);
   
        }
	}

	
}// end saving class
	