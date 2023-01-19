import java.sql.SQLException;
import java.util.Scanner;

public class View extends Account  {
	String nam;
	int pn;
	
	public View(String nam, int pn) {
		super();
		this.nam = nam;
		this.pn = pn;
	}
	public View() {
		super();
			}

	public void login() throws ClassNotFoundException, SQLException {
		
		
		if(nam.equalsIgnoreCase(Usrname)&& pn== pin) {
			System.out.println("The login was successful!!");
			System.out.println("Please select the Account_Type you want");
			System.out.println("SELECT \n---1>>> ordinary"
					+ "\n---2>>> executive"
					+ "\n---3>>> exit");
			Scanner input = new Scanner(System.in);
			int Acc = input.nextInt();
			
			switch(Acc) {
			case 1:
				System.out.println("You are accessing ur ordinary Account");
				ordinary();
				break;
			case 2:
				System.out.println("You are accessing ur executive Account");
				executive();
				break;
			case 3:
				System.out.println("You opt out");
			    Main.starter();
				break;
			default:
				System.out.println("You opt out");
				Main.starter();
				
			}
			
			
		}else {
			System.out.println("The login was not successful!!");
		}
		
	}
	
	
}
