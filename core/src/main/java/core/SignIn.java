package core;

import java.util.ResourceBundle;
import java.util.Scanner;

public class SignIn implements Menu{
	
	private ApplicationContext context;
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
		
		System.out.println("sign.in.header");
		
		System.out.println("please.enter.email");
		String email = sc.next();
		System.out.println("please.enter.pass");
		String password = sc.next();
		
		User user = userManagementService.getUserByEmail(email);
		
		if (user != null && user.getPassword().equals(password)) {
			System.out.printf(rb.getString("glad.to.see.you.back")+user.getFirstName()
			+" "+ user.getLastName() + System.lineSeparator());
			context.setLoggedInUser(user);
		} else {
			System.out.println(rb.getString("login.and.password.not.exist"));
		}
		context.getMainMenu().start();
	}

}
