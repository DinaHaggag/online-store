package core;

public class SignOut implements Menu {

	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		context.setLoggedInUser(null);
		context.getMainMenu().start();
	}

}
