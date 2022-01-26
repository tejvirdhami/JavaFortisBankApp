package client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import bus.*;
import data.ConnectionDB;
public class TesterDatabaseWithMenu {
	
	static Customer acustomer = null;
	
	
	public static void displayCustomers() throws SQLException
	{
		ArrayList<Customer> customerList = null;
		String query = "";
		Statement stmt = null;
		ResultSet rs = null;;
		
		//Temp variables
		long customerNumber;
		String firstName;
		String lastName;
		int pin;
		String email;
		String address; 
		query = "SELECT * FROM customers";
		Connection con = ConnectionDB.getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		
		customerList =  new ArrayList<>();
		while(rs.next())
		{
			customerNumber = Long.parseLong(rs.getString(1)) ;
			firstName = rs.getString(2);
			lastName = rs.getString(3);
			pin = Integer.parseInt(rs.getString(4));
			email = rs.getString(5);
			address = rs.getString(6);
			
			acustomer = new Customer(customerNumber, firstName, lastName,pin, email, address);
			customerList.add(acustomer);
		}
		
		System.out.println(customerList);
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		ArrayList<Customer> customerList = null;
		String query = "";
		Statement stmt = null;
		ResultSet rs = null;
		
		//Temp variables
		long customerNumber;
		String firstName;
		String lastName;
		int pin;
		String email;
		String address;
		String request;
		
		
		//-----------------------------------------------Connect to database: bankdb--------------------------------------------------
		Connection con = null;
		
		con = ConnectionDB.getConnection();
		if(con != null)
		{
			System.out.println("\n\n Connection established successfully!\n\n");
		}
		else
		{
			System.out.println("\n\n Connection failed!\n\n");
		}
		
		
		//---------------------------------------------------Creating a Menu-------------------------------------------------------
		System.out.println("Enter one of the following commands:");
		System.out.println("1 - Display the existing customers.");
		System.out.println("2 - Search a Customer.");
		System.out.println("3 - Add a new Customer");
		System.out.println("4 - Remove a Customer");
		System.out.println("5 - Exit");
		System.out.println("\nEnter your option: ");
		
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		
		while (choice != 5) {

		    if(choice == 1) {
		    	displayCustomers();
		    	break;
		    }
			else if (choice == 2)
			{
				
				//------------------------------------------------Search customer by customerNumber:------------------------------------------------
				
				System.out.println("\n\n---------------SEARCH A CUSTOMER--------------------\n\n");
				String cNumber;
				stmt = null;
				System.out.println("CustomerNumber? : ");
				cNumber = scan.next();
				query = "SELECT * FROM customers WHERE customerNumber = " + cNumber;
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				
				customerList =  new ArrayList<>();
				while(rs.next())
				{
					customerNumber = Long.parseLong(rs.getString(1));
					firstName = rs.getString(2);
					lastName = rs.getString(3);
					pin = Integer.parseInt(rs.getString(4));
					email = rs.getString(5);
					address = rs.getString(6);
					
					acustomer = new Customer(customerNumber, firstName, lastName,pin, email, address);
					customerList.add(acustomer);
				}
				
				System.out.println(customerList);
				break;
			}
		    
			else if(choice == 3)
			{
				//----------------------------------Add new customer---------------------------------------
		
				System.out.println("\n\n---------------ADD A NEW CUSTOMER--------------------\n\n");
				
				stmt = con.createStatement();
				
				System.out.println("Customer Number? : ");
				customerNumber = scan.nextLong();
				System.out.println("First name? : ");
				firstName = scan.next();
				System.out.println("Last name? : ");
				lastName = scan.next();
				System.out.println("Pin ? : ");
				pin = scan.nextInt();
				System.out.println("Email ? : ");
				email = scan.next();
				System.out.println("Address ? : ");
				address = scan.next();
				
				acustomer = new Customer(customerNumber, firstName, lastName,pin, email, address);
				
				request = "INSERT into customers(customerNumber, firstName,"
						+ " lastName, pin, email, address) values(" + acustomer.getCustomerNumber()
																	+ ",\'" + acustomer.getfirstName() + "\'"
																	+ ",\'" + acustomer.getlastName() + "\'"
																	+ ",\'" + acustomer.getPin() + "\'"
																	+ ",\'" + acustomer.getEmail() + "\'"
																	+ ",\'" + acustomer.getAddress() + "\')";
				
				stmt.executeUpdate(request);
				con.commit();
				
				System.out.println("\nCustomer added Successfully\n");
				
				//DISPLAY TABLE
				displayCustomers();
				break;
			}
		    
			else if(choice == 4)
			{
				//----------------------------------------Remove customer----------------------------------------------
				
				stmt = con.createStatement();
				System.out.println("\n\n---------------REMOVE A CUSTOMER--------------------\n\n");
				System.out.println("Customer Number? : ");
				String cNumber = scan.next();
				request = "delete FROM customers WHERE customerNumber = " + cNumber;
				
				stmt.executeUpdate(request);
				con.commit();
				
				System.out.println("\nCustomer removed Successfully\n");
				//DISPLAY AGAIN
				displayCustomers();
				break;
			}
			else if(choice == 5)
			{
				break;
			}
		    
			else {
				System.out.println("\nKindly enter a value between 1 to 5");
		        choice = scan.nextInt();
			}
		    scan.close();
		}

	}

}
