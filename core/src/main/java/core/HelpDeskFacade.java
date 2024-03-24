package core;

public interface HelpDeskFacade {
	
	void addNewSupportTicket(SupportTicket supportTicket);
	SupportTicket getNextSupportTicket();
	int getNumberOfTickets();

}
