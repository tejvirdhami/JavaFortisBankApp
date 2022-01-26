package bus;

import java.util.Date;

public class Transaction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long transNumber;
	private String desc;
	private Date transDate;
	private double transAmount;
	private EnumTransType transType;
	private int counter;
	
	public long getTransactionNumber() {
		return transNumber;
	}

	public void setTransactionNumber(long transactionNumber) {
		this.transNumber = transactionNumber;
	}

	public String getDescription() {
		return desc;
	}

	public void setDescription(String description) {
		this.desc = description;
	}

	public Date getTransactionDate() {
		return transDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transAmount = transactionAmount;
	}

	public EnumTransType getTransactionType() {
		return transType;
	}

	public void setTransactionType(EnumTransType transactionType) {
		this.transType = transactionType;
	}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Transaction() {
		super();
		this.counter = 0;
		this.transNumber = 0;
		this.desc = "Undefined";
		this.transDate = new Date();
		this.transAmount = 0;
		this.transType = EnumTransType.Undefined;
		
	}

	public Transaction(long transNumber, String desc, Date transDate, double transAmount, EnumTransType transType,
			int counter) {
		super();
		this.transNumber = transNumber;
		this.desc = desc;
		this.transDate = transDate;
		this.transAmount = transAmount;
		this.transType = transType;
		this.counter = counter;
	}

	public Transaction(long transNumber, String desc, Date transDate, double transAmount, EnumTransType transType) {
		super();
		this.transNumber = transNumber;
		this.desc = desc;
		this.transDate = transDate;
		this.transAmount = transAmount;
		this.transType = transType;
		this.counter = 0;
	}
	@Override
	public String toString() {
		return "Transaction [transNumber=" + transNumber + ", desc=" + desc + ", transDate=" + transDate
				+ ", transAmount=" + transAmount + ", transType=" + transType + ", counter=" + counter + "]";
	}
	public void increment() {
		this.counter++;
	}	
	
	

}
