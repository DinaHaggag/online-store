package core;

public interface MailSender {
	void sendEmail(String sendTo, String messageToSend);
}
