package client;
import bus.*;

import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountTest {

	/**
	 * @param args
	 * @throws IOException
	 * @throws Exception
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException, Exception {
		Scanner scan = new Scanner(System.in);
		long accNum, transNum;
		Account account;
		int  choice;
		String desc;
		Date transDate = new Date();
		double transAmount;
		
		double balance = 0;
		EnumTransType transType = EnumTransType.Undefined;
		EnumAccType accType = EnumAccType.Undefined;
		
		ArrayList<Account> accList = new ArrayList<Account>();
		ArrayList<CheckingAccount> checkList = new ArrayList<CheckingAccount>();
		ArrayList<SavingAccount> saveList = new ArrayList<SavingAccount>();
		ArrayList<Customer> cusList = new ArrayList<Customer>();
		ArrayList<Transaction> transList = new ArrayList<Transaction>();
		
		/////////////////////////////////////////////////////////
		
		CheckingAccount ca1 = null; CheckingAccount ca2 = null;
		SavingAccount sa1 = null; SavingAccount sa2 = null;
		Transaction trans1 = null;
		
		//bank acc starts with 4328, cus acc starts with year
		ca1 = new CheckingAccount(4328987, 10000); BankManager.add(ca1);
		ca2 = new CheckingAccount(4328124, 1200); BankManager.add(ca2);
		sa1 = new SavingAccount(4328345, 12903); BankManager.add(sa1);
		sa2 = new SavingAccount(4328765, 12332); BankManager.add(sa2);
		
		System.out.println(BankManager.getAccount());
		//////////////////////////////////////////////////////////
		
		
		  System.out.println("Choose type of transaction: ");
		  System.out.println("\t 1- Deposit: ");
		  System.out.println("\t 2- Withdraw: ");
		  System.out.println("\t\t Choose your transaction 1- deposit, 2-withdraw");
		  System.out.println("\t\t Or review your transaction");
		
		 
		  do {
//		      System.out.print("Enter again the type of transaction: ");
//		      System.out.println("\n\t 1- Deposit: ");
//				System.out.println("\n\t 2- Withdraw: ");
				 choice = scan.nextInt(); 
		  }while(choice < 1 || choice > 2);
		
		  System.out.print("\nPlease enter account number: ");
		  accNum = scan.nextLong();
		  
		  Account acc = BankManager.search(accNum);
		  
		  // check account num
		  if(acc != null) {
			  System.out.println("Enter your transaction number: ");   transNum = scan.nextLong();
			  
			  System.out.println("Enter amount of transaction: ");   transAmount = scan.nextLong();
			    		  
			  System.out.println("Any description? "); desc = scan.nextLine(); 
			  
			  trans1 = new Transaction(transNum, desc, transDate, transAmount, transType);
			  transList.add(trans1);
			  
			  if(choice == 1) {  //////// transaction type
				  acc.deposit(transAmount);
				  transType = transType.Deposit;
			  }else {
				  acc.withdraw(transAmount);
				  transType = transType.Withdraw;
			  }
			
			 // BankManager.add(acc); 
			  System.out.println("Deposit successfully");
			  System.out.println(acc);
			  
		  }else {
			  System.out.print("There is no account number like that.");
		  }
		  		 	
			
		scan.close();





	}// end main class
	
	
	
	//   System.out.println(acc);
	
	///////////draft//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
//	public static void createAcc(Scanner scan) throws RaiseException {
//		 System.out.print("\nPlease enter account number: ");
//         long accNum = scan.nextLong(); //choice = scan.nextInt();
//		 Account acc = BankManager.search(accNum);
//	          
//	          // check account num
//	          if(acc != null) {
//	        	  System.out.println("Enter your transaction number: ");  long transNum = scan.nextLong();
//	    		  
//	    		  System.out.println("Enter amount of transaction: ");  long transAmount = scan.nextLong();
//	    		    		  
//	    		  System.out.println("Any description? "); String desc = scan.nextLine(); 
//	    		  
//	    		  EnumTransType transType = EnumTransType.Undefined; Date transDate = new Date();
//	    		  ArrayList<Transaction> transList = new ArrayList<Transaction>();
//	    		  Transaction trans1 = new Transaction(transNum, desc, transDate, transAmount, transType);
//	    		  transList.add(trans1);
//	    		  int choice = 0;
//	    		  
//	    		  if(choice == 1) {  //////// transaction type
//	    			  acc.deposit(transAmount);
//	    			  transType = transType.Deposit;
//	    			  System.out.println("Deposit successfully");
//	    		  }else {
//	    			  acc.withdraw(transAmount);
//	    			  transType = transType.Withdraw;
//	    			  System.out.println("Withdraw successfully");
//	    		  }
//	    		
//	    		 BankManager.add(acc);  System.out.println(acc);   		
//	    		  
//	          }else {
//	        	  System.out.print("There is no account number like that.");
//	        	  
//	          }	          		
//	}
//		
//		
//	
//	// return balance after transaction
//	public static double curBalance(EnumTransType transType, double iniBalance, double transAmount) {
//		double fBalance;
//		if(transType.Deposit != null) {
//			fBalance = iniBalance + transAmount;
//			
//		}else if(transType.Withdraw != null) {
//			fBalance = iniBalance - transAmount;
//		}else{
//			fBalance = iniBalance;		
//			
//		}
//		return fBalance;
//		
//	}
//	
//	// return acc type after choosing
//	public static Account curAccount(EnumAccType accType) {
//		Account sa;
//		if(accType.Checking != null) {
//			sa = new CheckingAccount();
//			
//		}else if(accType.Saving != null) {
//			sa = new SavingAccount();
//		}else{
//			sa = null;	
//			
//		}
//		return sa ;
//	}

} // end AccountTest


//ca1 = new CheckingAccount(43281111, 2013123, 130.50);
//ca2 = new CheckingAccount(43283333, 20534357, 150.50)	;
//sa2 = new SavingAccount(43288000, 20234567, 120.50);

//ca1 = new CheckingAccount(43281111, 130.50);
//ca2 = new CheckingAccount(43283333, 150.50)	;
//sa2 = new SavingAccount(43288000, 120.50);

//System.out.println("\n\n\nMy Checking accounts are: ");
//System.out.println(BankManager.getCheckAcc());
//
//
//System.out.println("\n\n\nMy Saving accounts are: ");
//System.out.println(BankManager.getSaveAcc());
//System.out.println("--------------------------------");
//BankManager.print();

//System.out.println("---------------Remove an account-----------------");
//BankManager.remove(sa2);
//BankManager.print(); 

//Add through Collection
		//BankManager.add(sa2); BankManager.add(ca1); BankManager.add(ca2);
		
		
//		System.out.println("\n\n\nMy Accounts are: ");
//		System.out.println(BankManager.getAccount());

//System.out.println("\nAfter transaction\n"); 
//fBalance = curBalance(transType,balance, transAmount); BankManager.remove(sa1);
//
////sa2 = new SavingAccount(accNum, accType, openDate, fBalance ,transNum, desc, transDate, transAmount, transType); BankManager.add(sa2);
//System.out.println(sa2);




