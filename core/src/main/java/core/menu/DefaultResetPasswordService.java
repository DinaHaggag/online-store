package core.menu;

import core.mail.MailSender;
import persistence.entities.User;

public class DefaultResetPasswordService implements ResetPasswordService {

	private MailSender mailSender;
	
	@Override
	public void resetPasswordForUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("Your password has been sent to your email. Check your inbox.");
		mailSender.sendEmail(user.getEmail(), "Please, use this password to login: " + user.getPassword());
	}

}
