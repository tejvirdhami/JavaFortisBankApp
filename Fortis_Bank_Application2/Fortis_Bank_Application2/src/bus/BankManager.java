package bus;
import java.util.ArrayList;

public class BankManager {

	
		// private static 
		private static ArrayList<IBank> listOfIBank = new ArrayList<IBank>();
		private static ArrayList<Account> accList = new ArrayList<Account>();
		private static ArrayList<CheckingAccount> checkList = new ArrayList<CheckingAccount>();
		private static ArrayList<SavingAccount> saveList = new ArrayList<SavingAccount>();
		private static ArrayList<Customer> cusList = new ArrayList<Customer>();
		private static ArrayList<Transaction> transList = new ArrayList<Transaction>();
		
		//-1 add the public static operations for Accounts
		
	  //add account
		public static void add(Account account) throws RaiseException {
			if (Exist(account.getAccountNumber()) == false)
	        {				
				accList.add(account);
				
	        }else {
	        	throw new RaiseException("This account num exists in the database. Cannot add this acc num.");
	        }
		}
		
		// only allow remove saving account, not checking account
		public static void remove(SavingAccount object) throws RaiseException {
				saveList.remove(object);		
		}
		
		public static void removeAt(int index) throws RaiseException{
			
			saveList.remove(index);
		}
		
		
		//-2 public static opereation for Customers
		
		public static void addCus(Customer cus) throws RaiseException {
			if (Exist(cus.getCustomerNumber()) == false)
	        {				
				cusList.add(cus);
				
	        }else {
	        	throw new RaiseException("This Customer num exists in the database. Cannot add this cus num.");
	        }
		}
		
		// remove customer
		public static void removeCus(Customer object) throws RaiseException {
				cusList.remove(object);	
		}
		
		public static void removeCusAt(int index) throws RaiseException{
			
			cusList.remove(index);
		}
		
		
		/////////////////////////////////////////////////////////////
		public static boolean Exist(long accNum)
	      {
			return accList.contains(accNum);
	      }
		
		public static boolean ExistCus(long cusNum)
	    {
			return accList.contains(cusNum);			
	    }
		
		public static void print() {
			
			for(SavingAccount element : saveList) {
			
				System.out.println(element + "\n");
			}	
			for(CheckingAccount element : checkList) {
				
				System.out.println(element + "\n");
			}	
		}
		
		// search for an acc by acc number: unique identifier
		public static Account search(long accNum) {	
			for (Account element: accList ) { //for each element of the type IBank from the listOfIBank
				if(element.getAccountNumber() == accNum) {
					return element;
				}
			}	
				return null;
				
		}
		
		// get the list of checking acc
		public static  ArrayList<CheckingAccount> getCheckAcc() {
	
			for(Account element : accList) {				
				if(element instanceof CheckingAccount) {
					checkList.add((CheckingAccount)element); //down-casting
				}
			}	
			return checkList; 		
			}	
		
		// get the list of saving acc
		public  static ArrayList<SavingAccount> getSaveAcc() {
		
			for(Account element : accList) {				
				if(element instanceof SavingAccount) {
					saveList.add((SavingAccount)element); //down-casting
				}
			}	
			return saveList; //never return in the loop, only outside of the loop			
			}	
		
		
		// get the list of account
		public static ArrayList<Account> getAccount(){
			
			return accList ;
		}
		
		// search for an cus by cus number: unique identifier
				public static Customer searchCus(long cusNum) {	
					for (Customer element: cusList ) { //for each element of the type IBank from the listOfIBank
						if(element.getCustomerNumber() == cusNum) {
							return element;
						}
					}	
						return null;
						
				}
				
				// get list of customer
				public static ArrayList<Customer>  getCustomer() {
					
					for(Customer element : cusList) {
						
						if(element instanceof Customer) {
							
							cusList.add((Customer)element); //down-casting
						}
					}
					
					return cusList; //never return in the loop, only outside of the loop
					
				}	
				
				public static void printCus() {
					
					for(Customer element : cusList) {
					
						System.out.println(element + "\n");
					}	
				}
		// display transaction
		 public static String Display()
		 {
			  String info = "";
			  for (Transaction element : transList)
			       {
			                info += element.toString() + "\n";
			       }
			   return info;
		 }
}// end class
