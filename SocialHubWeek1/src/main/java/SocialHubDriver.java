import java.util.Scanner;

import com.examples.models.User;
import com.examples.services.UserService;

public class SocialHubDriver {

	
	private static UserService uServ = new UserService("users.txt");
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		boolean done = false;
		
		User u = null;
		
		while(!done) {
			if(u == null) {
				System.out.println("Login or Signup? Press 1 to Login. Press 2 to Signup");
				int choice = Integer.parseInt(in.nextLine());
				if(choice == 1) {
					System.out.println("Please enter your username: ");
					String username = in.nextLine();
					System.out.println("Please enter your password: ");
					String password = in.nextLine();
					
				}
			}
		}
	}
}
