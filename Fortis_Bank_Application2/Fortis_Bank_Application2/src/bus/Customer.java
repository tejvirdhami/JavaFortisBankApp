package bus;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long customerNumber;
	private String firstName;
	private String lastName;
	private int pin;
	private String email;
	private String address;
	private Account account;
	
	//customer has a list of account
	public static ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public static ArrayList<Account> accList = new ArrayList<Account>();
	
    public static void add(Customer object) throws IOException
	 {
    	customerList.add(object);
    	FileHandler.writeToFile(customerList);
	 }
    
    // serialize file
    public static void remove(Customer object) throws IOException
	 {
    	customerList.remove(object);
    	FileHandler.writeToFile(customerList);
	 }	 
	
    public static void removeAt(int index) throws IOException
	 {
    	customerList.remove(index);
    	FileHandler.writeToFile(customerList);
	 }	 
	 
	 public static  void   getCustomerList() throws ClassNotFoundException, IOException
	 {    
		 customerList = FileHandler.readFromFile();
			for( Customer element : customerList)
			 { 
					 System.out.println(element);				 
			 }
	      //return customerList ;		 
	 }
	 
	 
	public long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getPin() {
		return pin;
	}

	public void setPin(int pin) throws RaiseException {
		Validator.IsInRange(pin);
		this.pin = pin;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Customer() {
		super();
	}
	public Customer(long customerNumber, String firstName, String lastName, int pin2, String email, String address) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pin = pin2;
		this.email = email;
		this.address = address;
	}
	
	public Customer(long customerNumber, String firstName, String lastName, int pin, String email, String address,
			Account account) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pin = pin;
		this.email = email;
		this.address = address;
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", pin=" + pin + ", email=" + email + ", address=" + address + ", account=" + account + "]";
	}

	
}// end class