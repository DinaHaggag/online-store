package core;


import java.util.Scanner;

public class SignUp implements Menu  {

	private ApplicationContext context ;
	private UserManagementService userManagementService;
	
	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Input your first name ");
		String firstName = sc.nextLine();
		
		System.out.println("Input your last name ");
		String lastName = sc.nextLine();
		
		System.out.println("Input your email address ");
		String email = sc.nextLine();
		
		System.out.println("Input a password ");
		String password = sc.nextLine();
		
		
		
		User user = new DefaultUser(firstName, lastName, email, password);
		
		System.out.println(userManagementService.registerUser(user));
		
		context.getMainMenu().start();
	}
	
	

}
