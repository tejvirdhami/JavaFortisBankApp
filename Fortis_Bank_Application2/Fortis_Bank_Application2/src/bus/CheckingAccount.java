package bus;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

public class CheckingAccount extends Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static double extrafee = 0.5;
	private double freeTrans;
	private double transCount;
	
	
	public static double getExtrafee() {
		return extrafee;
	}
	public static void setExtrafee(double extrafee) {
		CheckingAccount.extrafee = extrafee;
	}
	public double getFreeTrans() {
		return freeTrans;
	}
	public void setFreeTrans(double freeTrans) {
		this.freeTrans = freeTrans;
	}
	public double getTransCount() {
		return transCount;
	}
	public void setTransCount(double transCount) {
		this.transCount = transCount;
	}
	public CheckingAccount() {
		super();
		extrafee = 0.5;
		freeTrans = 4;
		transCount = 0;
	}
	
//	public CheckingAccount(long accNumber, long cusNumber, double balance) {
//		super(accNumber, cusNumber, balance);
//		
//	}
	public CheckingAccount(long accNumber, double balance) {
		super(accNumber, balance);
		extrafee = 0.5;
		freeTrans = 4;
		transCount = 0;	
	}
	
	
	///////////////////////////////////////////////////////////////
	
	@Override
	public String toString() {
		return super.toString() + " CheckingAccount [freeTrans=" + freeTrans + ", transCount=" + transCount  + "]\n";
	}
	@Override 
	public void deposit(double amount) {
		if(amount > 0)
		{
		balance = balance + amount;
		}
		else
		System.out.println("Least amount to be deposited must be 20");
	}
	
	public void withdraw(double amount) {
		if(balance >= amount + extrafee)
		{
			balance = balance - amount - extrafee;
		}
		else
			System.out.println("Insufficient Funds in Checking Account!");
	}
	

	////////////////////////////////////////// class from interface and abstract class
	@Override
	public int reset() {
		return -1;
	}
		
	@Override
	public void openAccount(Account account) {
		if (Exist(account.getAccountNumber()) == true)
        {
			accountList.add(account);
        }
	}
	@Override
	public  void closeAccount(Account acc) {
		System.out.println("Cannot close Checking Account");
	}
}// end class 
