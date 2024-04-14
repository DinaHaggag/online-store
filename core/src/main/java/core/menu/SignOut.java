package core.menu;

import java.util.ResourceBundle;

import core.context.ApplicationContext;

public class SignOut implements Menu {

	private ApplicationContext context;
	private ResourceBundle rb;
	
	{
		context = ApplicationContext.getInstance();
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}
	
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println(rb.getString("sign.out.header"));
		System.out.println(rb.getString("bye.msg"));
		context.setLoggedInUser(null);
		context.getMainMenu().start();
	}

}
