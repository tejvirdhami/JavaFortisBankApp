package bus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHandler {
	
	private static String fileCustomers = "src//data// Customers.ser";
	
	//Public services offered
	public static void writeToFile(ArrayList<Customer> list) throws IOException
	{
		//Creating necessary objects to write the whole collection into serialized file
				FileOutputStream fos = new FileOutputStream(fileCustomers, true);
				@SuppressWarnings("resource")
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(list);
				oos.close();
				fos.close();
	}			
	public static ArrayList<Customer>  readFromFile() throws IOException, ClassNotFoundException
	{
		
        FileInputStream fis = new FileInputStream(fileCustomers);
        
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        @SuppressWarnings("unchecked")
		ArrayList<Customer> listFromFile = (ArrayList<Customer>)ois.readObject();	
		
		ois.close();
		fis.close();
		return listFromFile;
	}
	
	//------------------------------------------ACCOUNTS----------------------------------------------------
private static String fileAccounts = "src//data// Accounts.ser";
	
	//Public services offered
	public static void writeToFileAccounts(ArrayList<Account> list) throws IOException
	{
		//Creating necessary objects to write the whole collection into serialized file
				FileOutputStream fos = new FileOutputStream(fileAccounts, true);
				@SuppressWarnings("resource")
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(list);
	}			
	public static ArrayList<Account>  readFromFileAccounts() throws IOException, ClassNotFoundException
	{
		
        FileInputStream fis = new FileInputStream(fileAccounts);
        
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        @SuppressWarnings("unchecked")
		ArrayList<Account> listFromFileAccounts = (ArrayList<Account>)ois.readObject();	
		
		ois.close();
		return listFromFileAccounts;
	}
}