package core;


import java.util.ResourceBundle;
import java.util.Scanner;

public class SignUp implements Menu  {

	private ApplicationContext context ;
	private UserManagementService userManagementService;
	private ResourceBundle rb;

	
	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println(rb.getString("sign.up.header"));
		
		System.out.println(rb.getString("enter.your.first.name"));
		String firstName = sc.nextLine();
		
		System.out.println(rb.getString("enter.your.last.name"));
		String lastName = sc.nextLine();
		
		System.out.println(rb.getString("enter.your.email"));
		String email = sc.nextLine();
		
		System.out.println(rb.getString("enter.your.pass"));
		String password = sc.nextLine();
		
		
		
		User user = new DefaultUser(firstName, lastName, email, password);
		
		System.out.println(userManagementService.registerUser(user));
		
		context.getMainMenu().start();
	}
	
	

}
