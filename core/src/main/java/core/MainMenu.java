package core;

import java.util.Scanner;

public class MainMenu implements Menu {
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		
		String unloggedMenu = "1.Sign Up" + "\n" + "2.Sign In" + "\n" + "3.Product Catalog" 
		+ "\n" +"4.My Orders" + "\n" + "5.Settings" + "\n" +"6.Customer List";
		
		String loggedMenu = "1.Sign Up" + "\n" + "2.Sign Out" + "\n" + "3.Product Catalog" + "\n" 
				+"4.My Orders" + "\n" + "5.Settings" + "\n" +"6.Customer List";
		
		
		if (context.getLoggedInUser() == null) {
			System.out.println(unloggedMenu);
		} else {
			System.out.println(loggedMenu);
		}
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Write the number of your choice");
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
			
		
		}
	
	}

}
