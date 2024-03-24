package core;

import java.util.ResourceBundle;
import java.util.Scanner;

public class MainMenu implements Menu ,Runnable {
	private ApplicationContext context;
	private ResourceBundle rb;
	
	{
		context = ApplicationContext.getInstance();
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}

	@Override
	public void start() {
		
		System.out.println(rb.getString("main.menu.header"));
		
		if (context.getLoggedInUser() == null) {
			System.out.println(rb.getString("menu.for.not.logged.in.user"));
		} else {
			System.out.println(rb.getString("menu.for.logged.in.user"));
		}
	
		Scanner sc = new Scanner(System.in);
		System.out.print(rb.getString("user.input"));
		int userInput = sc.nextInt();
	
		switch(userInput) {
		case 1:
			SignUp signUp = new SignUp();
			signUp.start();
			
		case 2:
			if (context.getLoggedInUser() == null) {
				SignIn signIn = new SignIn();
				signIn.start();
			}
			else {
				SignOut signOut = new SignOut();
				signOut.start();
			}
			
		case 3:
			ProductCatalog productCatalog = new ProductCatalog();
			productCatalog.start();
			
		case 4:
			MyOrders myOrder = new MyOrders();
			myOrder.start();
			
		case 5:
			Settings settings = new Settings();
			settings.start();

		case 6:
			CustomerList customerList = new CustomerList();
			customerList.start();
			
		case 7:
			ResetMenu resetMenu = new ResetMenu();
			resetMenu.start();
			
			
		case 8:
			ChangeLanguage changeLanguage = new ChangeLanguage();
			changeLanguage.start();
			
		default :
			System.out.println(rb.getString("err.msg"));
			new MainMenu().start();
		}
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.start();
		
	}

}

