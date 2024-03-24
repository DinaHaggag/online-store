package core;

import java.util.ResourceBundle;
import java.util.Scanner;

public class ResetMenu implements Menu  {
	private ResourceBundle rb;
	
	{
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}
	
	String email;
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("reset.pass.header");
		
		Scanner scan = new Scanner(System.in);
		System.out.println(rb.getString("enter.your.email.msg"));
	    email = scan.nextLine();
		System.out.println(rb.getString("pass.sent.to.email"));
		
		MainMenu mainMenu = new MainMenu();
		ResetPasswordThread resetPasswordThread = new ResetPasswordThread();
		
		Thread mainMenuThread = new Thread(mainMenu);
		Thread resetThread = new Thread(resetPasswordThread);
		
		resetThread.run();
		mainMenuThread.run();
		
	}
	

}
