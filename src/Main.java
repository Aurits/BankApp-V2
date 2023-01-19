import java.sql.*;
import java.util.*;

public class Main extends View {

	public Main(String nam, int pn) {
		super(nam, pn);
		// TODO Auto-generated constructor stub
	}
	
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void starter() throws ClassNotFoundException, SQLException {
		for (int i = 0; i < 3; i++) {
			System.out.println("Welcome to the log in page!");
			System.out.println("Please Enter the USERNAME:");
			String nm = input.nextLine();
			input.nextLine();
			System.out.println("Please Enter the PIN:");
			int pp = input.nextInt();
			Main customer = new Main(nm, pp);
			customer.login();
			input.nextLine();
	}

}

	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	    

		
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to our Aurit Banking group Limited!");
		System.out.println("Choose '1' to Register or '2' to Login ");

		int cc = input.nextInt();

		switch (cc) {
		case 1:

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://127.0.0.1/bankapp?username=root&password=";
				Connection conn = DriverManager.getConnection(url);
				System.out.println("The connetion has been set up successfully!");

//				Statement stmt = conn.createStatement();
//	            String qry = "CREATE DATABASE time";
//	            stmt.execute(qry);
//	            System.out.println("Database time has been successfully created");

//				String qry0 = "CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT NOT NULL, uname VARCHAR(100) NOT NULL, pin int(20) NOT NULL, amount int(100))";
//				stmt.execute(qry0);
//				System.out.println("The table users has been successfully created");
				
				
				System.out.println("Enter the your username");
				input.nextLine();
				String uname = input.nextLine();
				System.out.println("Enter your pin");
				int pin = input.nextInt();

				String qry1 = "INSERT INTO users(uname,pin) value(?,?)";
				
				

				PreparedStatement ps = conn.prepareStatement(qry1);
				ps.setString(1,uname);
				ps.setInt(2,pin);
				ps.execute();
				System.out.println("Your account has been created ! keep your details secret");
				Main.starter();
				input.nextLine();

			} catch (ClassNotFoundException e) {
				System.out.println("unable to register driver" + e.getMessage());

			} catch (SQLException e) {
				System.out.println("An error occured trying to connect to the database " + e.getMessage());
			}

			break;
		case 2:
         Main.starter();

			break;
		default:
			System.out.println("Unknown error occurred");

		}

	}}


