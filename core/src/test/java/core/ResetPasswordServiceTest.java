package core;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import core.mail.MailSender;
import core.menu.DefaultResetPasswordService;
import core.menu.ResetPasswordService;
import persistence.entities.DefaultUser;
import persistence.entities.User;


public class ResetPasswordServiceTest {
	
	@Mock
	private MailSender mailSenderMock ;
	
	@InjectMocks
	private ResetPasswordService resetPasswordService = new DefaultResetPasswordService();

	
	@Captor
	private ArgumentCaptor<String> captor;
	
	
	@Test
	public void shouldSendToUserEmail() {
		User user = new DefaultUser();
		String userEmail = "testemail@email.com";
		user.setEmail(userEmail);

		resetPasswordService.resetPasswordForUser(user);

		verify(mailSenderMock).sendEmail(captor.capture(), anyString());
		assertEquals(captor.getValue(), userEmail);
	}


	@Test
	public void shouldSendPasswordInfo() {
		User user = new DefaultUser();
		String userPass = "pass";
		user.setPassword(userPass);

		resetPasswordService.resetPasswordForUser(user);

		verify(mailSenderMock).sendEmail((String) any(), captor.capture());
		assertTrue(captor.getValue().split(":")[1].trim().equals(userPass));
		
		
	}
	
}
