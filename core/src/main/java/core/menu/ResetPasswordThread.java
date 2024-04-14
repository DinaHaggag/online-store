package core.menu;

import core.services.DefaultUserManagementService;
import core.services.UserManagementService;
import persistence.entities.User;

public class ResetPasswordThread implements Runnable{

	private UserManagementService userService = new DefaultUserManagementService();
	private ResetMenu resetMenu = new ResetMenu();
	private ResetPasswordService resetPass = new DefaultResetPasswordService();
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	    User user = userService.getUserByEmail(resetMenu.email);
		resetPass.resetPasswordForUser(user);
		System.out.println("end");
		
	}
}

