package bus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataCollection {
	
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
	
}