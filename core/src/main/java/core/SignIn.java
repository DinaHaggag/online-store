package core;

import java.util.Scanner;

public class SignIn implements Menu{
	
	private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your email : ");
		String email = sc.next();
		System.out.println("Enter your password : ");
		String password = sc.next();
		
		User user = userManagementService.getUserByEmail(email);
		
		if (user != null && user.getPassword().equals(password)) {
			System.out.printf("glad to see you back"+" "+user.getFirstName()
			+" "+ user.getLastName() + System.lineSeparator());
			context.setLoggedInUser(user);
		} else {
			System.out.println("Unfortunately, such login and password doesn’t exist");
		}
		context.getMainMenu().start();
	}

}
