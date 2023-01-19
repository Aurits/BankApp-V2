import java.sql.*;
import java.util.*;


public class Times {

	
	
	
	public static void main(String[] args) {
		
		
		
		Scanner input = new Scanner(System.in);
		
		try {
			
            Class.forName("com.mysql.cj.jdbc.Driver");//Registration
            
            String url = "jdbc:mysql://127.0.0.1/tell?username=root&password=";
            
            Connection conn = DriverManager.getConnection(url);// opening a  connection
            
            System.out.println("The connetion has been set up successfully!");
            
          
            //Delete, Update, Read, Create ///Static Data
//            Statement stmt = conn.createStatement();
//            
//            String qry = "CREATE DATABASE tell";
//            stmt.execute(qry);
//            System.out.println("Database time has been successfully created");
            
            
//             Statement stmtr = conn.createStatement();
              
              
//              String qry = "CREATE DATABASE head";
//            stmtr.execute(qry);
////            System.out.println("Database time has been successfully created");
//            
////  CREATE TABLE users1(id INT primary key auto_increment not null, name varchar(3) not null, passcode varchar(5))
//              Statement stmt = conn.createStatement();
//              String qry = "CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT NOT NULL, name VARCHAR(100), passcode VARCHAR(80), Amount int(100))";
//              stmt.execute(qry);
//               System.out.println("The table users has been successfully created");
////            

//            Statement stmts = conn.createStatement();
//             String qrys = "INSERT INTO tell.users(name, passcode ,Amount) values('GLo','TT',100) ";
//            stmts.execute(qrys);
//             System.out.println("The customet Anna has been added successfully ");
            
            
          // The input of the dynamic data into the database
            
           System.out.println("Enter the name of  the customer");
           String name = input.nextLine();
//           input.nextLine();
           
           System.out.println("Enter the passcode of the customer");
           String passcode = input.nextLine();  
           
           System.out.println("Enter the initial amount of the customer");
            int  Amount = input.nextInt();   
            
           String qrye = "INSERT INTO users(name,passcode, Amount) value(?,?,?)";
           
            PreparedStatement ps = conn.prepareStatement(qrye);
            ps.setString(1, name);
            ps.setString(2,  passcode);
            ps.setInt(3, Amount);
            ps.execute();
            System.out.println(name+" has been added to the database with initail Amount = "+ Amount);
           
       //Read the database Data 
//            String readQry = "SELECT * from users";
//            ResultSet rs = stmts.executeQuery(readQry);
//            
//            while(rs.next()) {
//            	String name = rs.getString("name");
//            	String  passcode = rs.getString("passcode");
//            	System.out.println(name + " teaches " + passcode);
//
//            	}
//            
//            System.out.println("Enter lecturers id to see thier details");
//           	
//            	String id_str = input.nextLine();
//            	int id = Integer.parseInt(id_str);
//            	
//            	String rQuery = "SELECT * FROM lecturers WHERE id =?";
//            	PreparedStatement ps = conn.prepareStatement(rQuery);
//            	ps.setInt(1, id);
//            	ResultSet res = ps.executeQuery();
//            	if(!res.isBeforeFirst()) {
//            		System.out.print("No data for the lecture whose id is " + id);
//            		
//            	}else {
//            	while(res.next()) {
//                	String name = res.getString("name");
//                	String course = res.getString("course");
//                	System.out.println(name + " teaches " + course);
//
//                	}
//            	
//            	}
              
              // The update of the data in the database 
              
//              String updateQry = "UPDATE lecturers SET course = 'the new course added' WHERE id = 2";
//              stmt.execute(updateQry);
//              System.out.println("Lecturer details have been updated successfully !");
            	
//        
//              System.out.println("Enter lecturers details to update thier details !");
//            	String id_str = input.nextLine();
//            	int id = Integer.parseInt(id_str);
//            	
//            	System.out.println("Enter the new course for the lecturer");
//            	String course = input.nextLine();
//            	String update2 = "UPDATE lecturers SET course = ? WHERE id = ? ";
//            	PreparedStatement pst = conn.prepareStatement(update2);
//            	pst.setString(1, course);
//            	pst.setInt(2, id);
//            	pst.execute();
//            	System.out.print("Teaching details for the lecturer with is " + id + " have been updated successfully");
//              
              // deletion of the data
               //String delQry = "DELETE from lecturers WHERE id = 1";
               //stmt.execute(delQry);
               //System.out.println("The datails of the lecturer with id 1 have been deleted well ");
              
              
              
              
        } catch (ClassNotFoundException e) {
            System.out.println("unable to register driver" + e.getMessage());

        } catch (SQLException e) {
            System.out.println("An error occured trying to connect to the database " + e.getMessage());
        }

	}
}
