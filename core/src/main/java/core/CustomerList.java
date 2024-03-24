package core;

import java.util.ResourceBundle;

public class CustomerList implements Menu {
	
	private ApplicationContext context;
	private ResourceBundle rb;
	
	{
		context = ApplicationContext.getInstance();
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
		if(context.getLogInUsers()==null) {
			System.out.println(rb.getString("no.users.msg"));
		}
		else {
			System.out.println(rb.getString("customer.list.header"));
			int num = 1;
			for (User customer : context.getLogInUsers()) {
				System.out.println("Customer"+num +" " + customer.getFirstName() + " " + customer.getLastName()
				+ " " + customer.getEmail());
				num++;
			}
		}
		
	
		context.getMainMenu().start();
	}

}
