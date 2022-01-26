package client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import bus.*;
import data.ConnectionDB;
public class TesterDatabaseWithoutMenu {

	public static void main(String[] args) throws SQLException {
		
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Customer> customerList = null;
		String query = "";
		Statement stmt = null;
		ResultSet rs = null;
		
		Customer acustomer = null;
		
		// 1. Connect to oracle database: bankdb database
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
		
		
		// 2. Display customers from bankdb database:--------------------------------------------
				// QUERY the bankdb: SELECT statement
				// Implementation:
				
				long customerNumber;
				//Temp variables
				String firstName, lastName, email, address;
				int pin;
				
				query = "SELECT * FROM customers";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				
				customerList =  new ArrayList<>();
				while(rs.next())
				{
					customerNumber =  Long.parseLong(rs.getString(1));
					firstName = rs.getString(2);
					lastName = rs.getString(3);
					pin = Integer.parseInt(rs.getString(4));
					email = rs.getString(5);
					address = rs.getString(6);
					
					acustomer = new Customer(customerNumber, firstName, lastName,pin, email, address);
					customerList.add(acustomer);
				}
				
				System.out.println(customerList);
				
				
				// 3. Search customer by customerNumber:------------------------------------------------
				
				System.out.println("\n\n---------------SEARCH A CUSTOMER--------------------\n\n");
				String cNumber;
				System.out.println("CustomerNumber? : ");
				cNumber = scan.next();
				query = "SELECT * FROM customers WHERE customerNumber = " + cNumber;
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				
				customerList =  new ArrayList<>();
				while(rs.next())
				{
					customerNumber =  Long.parseLong(rs.getString(1));
					firstName = rs.getString(2);
					lastName = rs.getString(3);
					pin = Integer.parseInt(rs.getString(4));
					email = rs.getString(5);
					address = rs.getString(6);
					
					acustomer = new Customer(customerNumber, firstName, lastName,pin, email, address);
					customerList.add(acustomer);
				}
				
				System.out.println(customerList);
				
				
				// 4. Add new customer---------------------------------------
				System.out.println("\n\n---------------ADD A NEW CUSTOMER--------------------\n\n");
				
				String request = null;
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
				
				request = "INSERT into customers(customerNumber, firstName, lastName, pin, email, address) values(" + acustomer.getCustomerNumber()
																	+ ",\'" + acustomer.getfirstName() + "\'"
																	+ ",\'" + acustomer.getlastName() + "\'"
																	+ ",\'" + acustomer.getPin() + "\'"
																	+ ",\'" + acustomer.getEmail() + "\'"
																	+ ",\'" + acustomer.getAddress() + "\')";
				
				stmt.executeUpdate(request);
				con.commit();
				
				System.out.println("\n--------------------------\n");
				
				//DISPLAY TABLE
				customerList =  new ArrayList<>();
				while(rs.next())
				{
					customerNumber =  Long.parseLong(rs.getString(1));
					firstName = rs.getString(2);
					lastName = rs.getString(3);
					pin = Integer.parseInt(rs.getString(4));
					email = rs.getString(5);
					address = rs.getString(6);
					
					acustomer = new Customer(customerNumber, firstName, lastName,pin, email, address);
					customerList.add(acustomer);
				}
				
				System.out.println(customerList);
				
				// 5. Remove customer
				System.out.println("\n\n---------------REMOVE A CUSTOMER--------------------\n\n");
				System.out.println("Customer Number? : ");
				cNumber = scan.next();
				request = "delete FROM customers WHERE customerNumber = " + cNumber;
				
				stmt.executeUpdate(request);
				con.commit();
				
				
				//DISPLAY AGAIN
				customerList =  new ArrayList<>();
				while(rs.next())
				{
					customerNumber =  Long.parseLong(rs.getString(1));
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

}
