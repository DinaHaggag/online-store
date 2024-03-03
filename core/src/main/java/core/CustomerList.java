package core;

public class CustomerList implements Menu {
	
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		for (User customer : context.getLogInUsers()) {
			System.out.println(customer.getFirstName() + " " + customer.getLastName()
			+ " " + customer.getEmail());
		}
	
		context.getMainMenu().start();
	}

}
