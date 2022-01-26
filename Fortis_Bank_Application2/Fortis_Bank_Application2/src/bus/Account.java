package bus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public abstract class Account extends Customer implements IBank, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long accountNumber;
	private EnumAccType accType;
	private Date openDate;
	protected double balance;
	//private Transaction trans;
	private static ArrayList<Transaction> transList = new ArrayList<Transaction> ();
	
	public static ArrayList<Account> accountList = new ArrayList<Account> ();
	
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
//	public long getCustomerNumber() {
//		return customerNumber;
//	}
//	public void setCustomerNumber(long customerNumber) {
//		this.customerNumber = customerNumber;
//	}
	
	public EnumAccType getAccType() {
		return accType;
	}
	public void setAccType(EnumAccType accType) {
		this.accType = accType;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) throws RaiseException {
		Validator.isPositive(balance);
		this.balance = balance;
	}
	
//	public Transaction getTrans() {
//		return trans;
//	}
//	public void setTrans(Transaction trans) {
//		this.trans = trans;
//	}
	public static ArrayList<Transaction> getTransList() {
		return transList;
	}
	
	public Account() {
		super();
		this.accountNumber = 0;
	//	this.customerNumber = 0;
		this.accType = EnumAccType.Undefined;
		this.openDate = new Date();
		this.balance = 0;
	}

	// open account
		//public Account(long accountNumber, long customerNumber, EnumAccType accType, Date openDate, double balance) {
	public Account(long accountNumber, EnumAccType accType, Date openDate, double balance) {
		super();
		this.accountNumber = accountNumber;
		//this.customerNumber = customerNumber;
		this.accType = accType;
		this.openDate = openDate;
		this.balance = balance;
		this.transList = new ArrayList<Transaction>();
	}
	public Account(long accountNumber, double balance) { // to close + create account
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	//public Account(long accountNumber, long customerNumber, EnumAccType accType) { // open account
		public Account(long accountNumber, EnumAccType accType) { // open account
		super();
		this.accountNumber = accountNumber;
		this.accType = accType;
	}
	
//		public Account(long accountNumber, EnumAccType accType, Date openDate, double balance,
//				long transNum, String desc, Date transDate, double transAmount, EnumTransType transType) {
		public Account(long accountNumber, EnumAccType accType, Date openDate, double balance,
				ArrayList<Transaction> transList) {
		super();
		this.accountNumber = accountNumber;
		//this.customerNumber = customerNumber;
		this.accType = accType;
		this.openDate = openDate;
		this.balance = balance;
		this.transList = transList;
	}
		
	@Override
		public String toString() {
			return "Account [accountNumber=" + accountNumber + ", accType=" + accType + ", openDate=" + openDate
					+ ", balance=" + balance + ", transaction=" + BankManager.Display() + "]\n";
		}
	
	
	public void deposit(double amount) throws RaiseException { 
		if(amount > 0)
		{
		balance = balance + amount;
		}
		else {
			System.out.println("At least amount to be deposited must be 1$");	
		}
		
	}
	
	public void withdraw(double amount){
		if(balance >= amount)
		{
			balance = balance - amount;
		}
		else {
			System.out.println("Insufficient Funds!");
		}
			
	}
	
	// transfer between accounts
	public void transferFund(Account fromacc, Account toacc, double amount) throws RaiseException {
//		acc.balance += amount; // destination - receiver
//		this.balance -= amount; //sender 
		
		if(fromacc.balance < 0) {
			throw new RaiseException("Insufficient Funds! ");
		}else {
			toacc.deposit(amount);
			fromacc.withdraw(amount);
		}	
	}
	
	  @SuppressWarnings("unlikely-arg-type")
		public static boolean Exist(long accNum)
	      {
	          return accountList.contains(accNum);
	      }
	  
	  
	// abstract class from interface	
	public abstract void closeAccount(Account acc);
	public abstract void openAccount(Account acc);
		
	public abstract int reset();
	
	
	
	
}
