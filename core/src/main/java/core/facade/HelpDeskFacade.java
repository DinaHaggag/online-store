package core.facade;

import persistence.SupportTicket;

public interface HelpDeskFacade {
	
	void addNewSupportTicket(SupportTicket supportTicket);
	SupportTicket getNextSupportTicket();
	int getNumberOfTickets();

}
