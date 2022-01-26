package client;


import java.util.ArrayList;
import java.util.Scanner;
import bus.*;
public class CustomerTest {

	 // Entry point of program
    public static void main(String [] args) throws RaiseException {
    	Scanner keyboard = new Scanner(System.in);
		long accNum, cusNum; 
		String fname, lname, email, address;
		Account account;
		int pin, choice;
		
		double balance;
		EnumTransType transType = EnumTransType.Undefined; int accChoose;
		EnumAccType accType = EnumAccType.Undefined;
		
		ArrayList<Account> accList = new ArrayList<Account>();
		ArrayList<Customer> cusList = new ArrayList<Customer>();
		CheckingAccount ca1 = null; CheckingAccount ca2 = null;
		SavingAccount sa1 = null; SavingAccount sa2 = null;
        
        Customer cu = new Customer(432892549, "Thao", "Tran", 7596, "thao.gmail.com", "LaSalle College");
        BankManager.addCus(cu);
        Customer newCus = null;
        
        int numAccounts = 0;  // number of account in the list

        System.out.println("Bank Menu");
        System.out.println("1. Create New Client");
        System.out.println("2. Login your Account");
        System.out.println("3. Quit");

        do {
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
        } while(choice < 1 || choice > 3);

 //       do {
//            choice = keyboard.nextInt();
//            System.out.println();
            
            if(choice == 1) {
            	
            createCus(keyboard);
            BankManager.printCus(); 
                
            } else if(choice == 2) {
            	
            	System.out.print("Enter Customer Number: "); cusNum = keyboard.nextLong();  
                System.out.println("Enter your pin"); pin = keyboard.nextInt();       
                LoginCus(cusNum, pin, keyboard); 
                
            } else {
            	
                System.out.println("Thank you for using our Bank system!");
            }
            BankManager.printCus(); 
//        } while(choice != 3);
      
        
        
        
        
    } // end main class

    public static void createCus (Scanner keyboard) throws RaiseException {

        Customer cus = null; 
        long cusNum; boolean result;
        System.out.print("Enter Customer Number: ");
        cusNum = keyboard.nextLong();
        result = BankManager.ExistCus(cusNum);
        
        if(result == true)  { 
            System.out.print("\t\tDuplicate Customer number!!!!!");
            
        } else {
        	String fname, lname, email, address;
        	int pin;
        	System.out.println("Enter first name");
    		fname = keyboard.next();
    		
    		System.out.println("Enter last name");
    		lname = keyboard.next();
    		
    		System.out.println("Enter pin");
    		pin = keyboard.nextInt();
    		
    		System.out.println("Enter email");
    		email = keyboard.next();
    		
    		System.out.println("Enter address");
    		address = keyboard.next();
    		
  
            cus = new Customer(cusNum, fname, lname, pin, email, address); BankManager.addCus(cus);
        }
    }
    

    public static Customer LoginCus (long cusNum, int pin ,Scanner keyboard) {
    	Customer cus = null;
        cus = BankManager.searchCus(cusNum);
        
        if(cus != null) {
        	if(cus.getPin() == pin) {
        		return cus;
        	}else {
        		System.out.println("Incorrect pin");
        		return null;
        	}
        }else {
        	System.out.println("Incorrect customer number");
        }
    
    	return null;
    }
    
}// end class

   
//    public static void doDeposit(Account accounts [], int count, Scanner keyboard) throws RaiseException {
//        // Get the account number
//        System.out.print("\nPlease enter account number: ");
//        int accountNumber = keyboard.nextInt();
//
//        // search for account
//        int index = searchAccount(accounts, count, accountNumber);
//
//        if(index >= 0) {
//            // Amount
//            System.out.print("Please enter Deposit Amount: ");
//            double amount = keyboard.nextDouble();
//
//            accounts[index].deposit(amount);
//        } else {
//            System.out.println("No account exist with AccountNumber: " + accountNumber);
//        }
//    }
//
//    public static void doWithdraw(Account accounts [], int count, Scanner keyboard) {
//        // Get the account number
//        System.out.print("\nPlease enter account number: ");
//        int accountNumber = keyboard.nextInt();
//
//        // search for account
//        int index = searchAccount(accounts, count, accountNumber);
//
//        if(index >= 0) {
//            // Amount
//            System.out.print("Please enter Withdraw Amount: ");
//            double amount = keyboard.nextDouble();
//            accounts[index].withdraw(amount);
//        } else {
//            System.out.println("No account exist with AccountNumber: " + accountNumber);
//        }
//    }
//
//    public static void applyInterest(Account accounts [], int count, Scanner keyboard) throws RaiseException {
//        // Get the account number
//        System.out.print("\nPlease enter account number: ");
//        int accountNumber = keyboard.nextInt();
//
//        // search for account
//        int index = searchAccount(accounts, count, accountNumber);
//
//        if(index >= 0) {
//            
//            // must be instance of savings account
//            if(accounts[index] instanceof SavingAccount) {
//                ((SavingAccount)accounts[index]).applyInterest();
//            }
//        } else {
//            System.out.println("No account exist with AccountNumber: " + accountNumber);
//        }
//    }
//
//}
