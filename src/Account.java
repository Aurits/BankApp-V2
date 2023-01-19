import java.util.Scanner;
import java.sql.*;

public class Account {
    int Amount;
	String Usrname = "Aurit";
	int pin = 1234;
	//Scanner object
	static Scanner input = new Scanner(System.in);
	
	//Showcase method
	public void showcase() {
		System.out.println("Please select the action you want to perform ");
		System.out.println("SELECT \n---1>>> Deposit"
				+ "\n---2>>> Withdraw"
				+ "\n---3>>> CheckBalance"
				+ "\n---4>>> exit");
	}
	
	public static Connection establishCon() throws SQLException, ClassNotFoundException{
		

        Class.forName("com.mysql.cj.jdbc.Driver");//Registration
        
        String url = "jdbc:mysql://127.0.0.1/head?username=root&password=";
        
        Connection conn = DriverManager.getConnection(url);// opening a  connection
        
        System.out.println("The connetion has been set up successfully!");
		return conn;
		
	}
	
	//deposit method
	public void deposit()  throws SQLException, ClassNotFoundException {

        
		System.out.println("You are on the deposit page");
        System.out.println("Please enter the Amount to deposit");
    	
    	int Amount =  input.nextInt();
    	
    	System.out.println("Enter your passcode");
    	int passcode = input.nextInt();
        
        Connection conn = Account.establishCon();
        
    	String update2 = "UPDATE users SET Amount = Amount+? WHERE passcode = ? ";
    	PreparedStatement pst = conn.prepareStatement(update2);
    	pst.setInt(1, Amount);
    	pst.setInt(2, passcode);
      	pst.execute();
      	
        System.out.println("Your new balance is now usd" + Amount);
    	System.out.print("\n\nBack to Home page!! ");
	}
	
	
	public void checkUser() throws ClassNotFoundException, SQLException {
		System.out.println("Pease Enter your pin!!");
		int pincode = input.nextInt();
		if(pin==pincode) {
			
			
		Connection conn = Account.establishCon();
		Statement stmt = conn.createStatement();
           String readQry = "SELECT * from users";
           ResultSet rs = stmt.executeQuery(readQry);
          
          while(rs.next()) {
          	String name = rs.getString("name");
          	String Amounts = rs.getString("Amount");
          	System.out.println("Your account balance is " + Amounts);
          	}
          
		}
		else {
			System.out.println("Your pin is wrong...!!");
			
		}	
		
	}
	
	
	//withdraw method
	public void withdraw() throws SQLException, ClassNotFoundException {
		System.out.println("You are on the withdraw page \nEnter "
				+ "the AMOUNT you want to withdraw???");
		int withdrawn = input.nextInt();
		//check user again
		System.out.println("Pease Enter your pin!!");
		int pincode = input.nextInt();
		if(pin==pincode) {
			
			Connection conn = Account.establishCon();
			Statement stmt = conn.createStatement();
	           String readQry = "SELECT * from users";
	           ResultSet rs = stmt.executeQuery(readQry);
	          
	          while(rs.next()) {
	          	String name = rs.getString("name");
	          	Amount = (int) rs.getDouble("Amount");
	          	System.out.println("Your account balance is " + Amount);
	          	}
			
			if(withdrawn<Amount && (Amount-withdrawn)>=100) {
				System.out.println("\n\nYour withdraw request was successful!!"
						+ "\nAnd your new balance is " + (Amount-withdrawn)
						);
				
				String update2 = "UPDATE users SET Amount = Amount-? WHERE passcode = ? ";
		    	PreparedStatement pst = conn.prepareStatement(update2);
		    	pst.setInt(1, withdrawn);
		    	pst.setInt(2, pincode);
		      	pst.execute();
		      	
				System.out.println("Done");
				
				
			}
			else {
				System.out.println("Your current balance is usd"+ Amount);
				System.out.println("Your Amount is insufficient!!! SORRY"
						+ "\n minimum balance is usd100");
			}
			
			
		}
		else {
			System.out.println("Your pin is wrong...!!");
			
		}	
		
	}
	
	
	//checkBalance method
	public void checkBalance() throws ClassNotFoundException, SQLException {
		checkUser();
		
	}
	
	
	//Create the Accounts
	public void ordinary() throws ClassNotFoundException, SQLException {
	showcase();
		Scanner input = new Scanner(System.in);
		int opt = input.nextInt();
		
		switch(opt) {
		case 1:
			deposit();
            ordinary();
			break;
		case 2:
			withdraw();
			ordinary();
			break;
		case 3:
			checkBalance();
			ordinary();
			break;
		default:
			System.out.println("You opt out");
			
			
		}
	}
	public void executive() throws ClassNotFoundException, SQLException {
		showcase();
		Scanner input = new Scanner(System.in);
		int opt = input.nextInt();
		
		switch(opt) {
		case 1:
			deposit();
            executive();
			break;
		case 2:
			 withdraw();
			 executive();
			break;
		case 3:
		    checkBalance();
		    executive();
			break;
		default:
			System.out.println("You opt out");
			
			
		}
	}
	

}
