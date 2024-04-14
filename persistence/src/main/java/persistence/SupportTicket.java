package persistence;

import persistence.entities.Priority;

public interface SupportTicket {
	
	Priority getPriority();
	int getSequentialNumber();
	RequestType getRequestType();
	
	
}
