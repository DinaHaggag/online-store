package core;

import java.util.Scanner;

public class Settings implements Menu {
	
	private ApplicationContext context;

	String option = "1-Change Password" + "\n" + "2-Change Email";
	
	{
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		if(context.getLoggedInUser()==null) {
			System.out.println("Please, log in or create new account to change your account settings");
			context.getMainMenu().start();
		}
		System.out.println(option);
		Scanner sc = new Scanner (System.in);
		String input = sc.next();
		if(input.equals("1")) {
			System.out.println("Enter new password");
			String pass = sc.next();
			context.getLoggedInUser().setPassword(pass);
			System.out.println("Your password has been successfully changed");
			context.getMainMenu().start();
		}
		else if(input.equals("2")) {
			System.out.println("Enter new email");
			String email = sc.next();
			context.getLoggedInUser().setEmail(email);
			System.out.println("Your email has been successfully changed");
			context.getMainMenu().start();
		}
		else if(input.equals("menu")) {
			context.getMainMenu().start();
		}
		else {
			System.out.println("Only 1, 2 is allowed. Try one more time");
			System.out.println(option);
		}
	}

}
