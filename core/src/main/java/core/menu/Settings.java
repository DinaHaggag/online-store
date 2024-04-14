package core.menu;

import java.util.ResourceBundle;
import java.util.Scanner;

import core.context.ApplicationContext;

public class Settings implements Menu {
	
	private ApplicationContext context;
	private ResourceBundle rb;
	
	{
		context = ApplicationContext.getInstance();
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}

	String option = rb.getString("settings.options");
	
	
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
		System.out.println(rb.getString("settings.menu.header"));
		
		if(context.getLoggedInUser()==null) {
			System.out.println(rb.getString("no.user.sign"));
			context.getMainMenu().start();
		}
		System.out.println(option);
		Scanner sc = new Scanner (System.in);
		String input = sc.next();
		if(input.equals("1")) {
			System.out.println(rb.getObject("change.password.header"));
			System.out.println(rb.getObject("enter.new.pass.cta"));
			String pass = sc.next();
			context.getLoggedInUser().setPassword(pass);
			System.out.println(rb.getString("change.password.msg"));
			context.getMainMenu().start();
		}
		else if(input.equals("2")) {
			System.out.println(rb.getString("change.email.header"));
			System.out.println(rb.getString("enter.new.email.cta"));
			String email = sc.next();
			context.getLoggedInUser().setEmail(email);
			System.out.println(rb.getString("mail.changed.msg"));
			context.getMainMenu().start();
		}
		else if(input.equals("menu")) {
			context.getMainMenu().start();
		}
		else {
			System.out.println(rb.getString("settings.option.validation.msg"));
			System.out.println(option);
		}
	}

}
