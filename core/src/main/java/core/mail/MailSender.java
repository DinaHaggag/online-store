package core.mail;

public interface MailSender {
	void sendEmail(String sendTo, String messageToSend);
}
