package win;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import bus.*;
import data.ConnectionDB;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;



public class TesterGUI2 {

	private JFrame frame;
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JTextField txtPin;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtCustomernumber;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblPin;
	private JLabel lblEmail;
	private JLabel lblAddress;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JLabel lblNewLabel_1;
	private JLabel lblCustomerManagementSystem;
	private JScrollBar scrollBar_1;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesterGUI2 window = new TesterGUI2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TesterGUI2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 744, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtFirstname = new JTextField();
		txtFirstname.setBounds(158, 125, 138, 20);
		frame.getContentPane().add(txtFirstname);
		txtFirstname.setColumns(10);
		
		txtLastname = new JTextField();
		txtLastname.setColumns(10);
		txtLastname.setBounds(158, 156, 138, 20);
		frame.getContentPane().add(txtLastname);
		
		txtPin = new JTextField();
		txtPin.setColumns(10);
		txtPin.setBounds(158, 187, 138, 20);
		frame.getContentPane().add(txtPin);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(158, 218, 138, 20);
		frame.getContentPane().add(txtEmail);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(158, 249, 138, 20);
		frame.getContentPane().add(txtAddress);
		
		txtCustomernumber = new JTextField();
		txtCustomernumber.setColumns(10);
		txtCustomernumber.setBounds(158, 94, 138, 20);
		frame.getContentPane().add(txtCustomernumber);
		
		JTextArea txtResult = new JTextArea();
		txtResult.setEditable(false);
		txtResult.setBounds(10, 277, 708, 153);
		frame.getContentPane().add(txtResult);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(701, 277, 17, 153);
		frame.getContentPane().add(scrollBar);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Customer> customerList = null;
				String query = "";
				Statement stmt = null;
				ResultSet rs = null;
				
				Customer acustomer = null;
				
				// 1. Connect to oracle database: bankdb database
				Connection con = null;
				
				try {
					con = ConnectionDB.getConnection();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				long customerNumber;
				//Temp variables
				String firstName, lastName, email, address;
				int pin;
				
				String request = null;
				customerNumber = Long.parseLong(txtCustomernumber.getText());
				firstName = txtFirstname.getText();
				lastName = txtLastname.getText() ;
				pin = pin = Integer.parseInt(txtPin.getText());
				email = txtEmail.getText();
				address = txtAddress.getText();
				
				acustomer = new Customer(customerNumber, firstName, lastName,pin, email, address);
				
				request = "INSERT into customers(customerNumber, firstName, lastName, pin, email, address) values(" + acustomer.getCustomerNumber()
																	+ ",\'" + acustomer.getfirstName() + "\'"
																	+ ",\'" + acustomer.getlastName() + "\'"
																	+ ",\'" + acustomer.getPin() + "\'"
																	+ ",\'" + acustomer.getEmail() + "\'"
																	+ ",\'" + acustomer.getAddress() + "\')";
				try {
					stmt = con.createStatement();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					rs = stmt.executeQuery(query);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					stmt.executeUpdate(request);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					con.commit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//DISPLAY TABLE
				customerList =  new ArrayList<>();
				try {
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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				txtResult.setText("CUSTOMER ADDED SUCCESSFULLY\n\n" +  customerList.toString());
				
			}
		});
		btnAdd.setBounds(333, 94, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Statement stmt = null;
				
				
				// 1. Connect to oracle database: bankdb database
				Connection con = null;
				
				//Temp variables
				try {
					con = ConnectionDB.getConnection();
					stmt = con.createStatement();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
//				---------------REMOVE A CUSTOMER--------------------
				String cNumber = txtCustomernumber.getText();
				String request = "delete FROM customers WHERE customerNumber = " + cNumber;
				
					try {
						stmt = con.createStatement();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						stmt.executeUpdate(request);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						con.commit();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				txtResult.setText("CUSTOMER Removed SUCCESSFULLY\n\n");
				
				
			}
		});
		btnRemove.setBounds(333, 125, 89, 23);
		frame.getContentPane().add(btnRemove);
		
		JButton btnDisplayAll = new JButton("Display All");
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Customer> customerList = null;
				String query = "";
				Statement stmt = null;
				ResultSet rs = null;
				
				Customer acustomer = null;
				
				// 1. Connect to oracle database: bankdb database
				Connection con = null;
				
				try {
					con = ConnectionDB.getConnection();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				long customerNumber;
				//Temp variables
				String firstName, lastName, email, address;
				int pin;
				
				query = "SELECT * FROM customers";
				try {
					stmt = con.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					rs = stmt.executeQuery(query);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				customerList =  new ArrayList<>();
				try {
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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				txtResult.setText(customerList.toString());
			}
		});
		btnDisplayAll.setBounds(333, 217, 89, 23);
		frame.getContentPane().add(btnDisplayAll);
		
		JLabel lblNewLabel = new JLabel("Customer Number:");
		lblNewLabel.setBounds(23, 97, 125, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(23, 128, 125, 14);
		frame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(23, 159, 125, 14);
		frame.getContentPane().add(lblLastName);
		
		lblPin = new JLabel("Pin:");
		lblPin.setBounds(23, 190, 125, 14);
		frame.getContentPane().add(lblPin);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(23, 221, 125, 14);
		frame.getContentPane().add(lblEmail);
		
		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(23, 252, 125, 14);
		frame.getContentPane().add(lblAddress);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		txtSearch.setBounds(565, 125, 138, 20);
		frame.getContentPane().add(txtSearch);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long customerNumber;
				//Temp variables
				String firstName, lastName, email, address;
				int pin;
				ArrayList<Customer> customerList = null;
				String query = "";
				Statement stmt = null;
				ResultSet rs = null;
				Customer acustomer = null;
				String cNumber;
				Connection con;
				try {
					con = ConnectionDB.getConnection();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cNumber = txtSearch.getText();
				query = "SELECT * FROM customers WHERE customerNumber = " + cNumber;
					try {
						con = ConnectionDB.getConnection();
						stmt = con.createStatement();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				try {
					rs = stmt.executeQuery(query);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				customerList =  new ArrayList<>();
				try {
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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				txtResult.setText(customerList.toString());
			}
		});
		btnSearch.setBounds(614, 155, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		lblNewLabel_1 = new JLabel("Customer Number:");
		lblNewLabel_1.setBounds(452, 128, 103, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblCustomerManagementSystem = new JLabel("Customer Management System");
		lblCustomerManagementSystem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblCustomerManagementSystem.setBounds(226, 11, 284, 50);
		frame.getContentPane().add(lblCustomerManagementSystem);
		
		scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(701, 277, 17, 153);
		frame.getContentPane().add(scrollBar_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResult.setText(null);
				txtAddress.setText(null);
				txtCustomernumber.setText(null);
				txtEmail.setText(null);
				txtFirstname.setText(null);
				txtLastname.setText(null);
				txtPin.setText(null);
				txtSearch.setText(null);
			}
		});
		btnReset.setBounds(333, 155, 89, 23);
		frame.getContentPane().add(btnReset);
		
		
	}
}
