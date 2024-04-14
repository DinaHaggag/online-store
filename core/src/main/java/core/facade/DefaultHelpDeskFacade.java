package core.facade;

import java.util.PriorityQueue;
import java.util.Queue;

import persistence.CustomSupportTicketsComparator;
import persistence.SupportTicket;

public class DefaultHelpDeskFacade implements HelpDeskFacade {
	private Queue<SupportTicket> tickets =  new PriorityQueue<>(new CustomSupportTicketsComparator());

	@Override
	public void addNewSupportTicket(SupportTicket supportTicket) {
		tickets.offer(supportTicket);
	}

	@Override
	public SupportTicket getNextSupportTicket() {
		return tickets.poll();
	}

	@Override
	public int getNumberOfTickets() {
		return tickets.size();
	}
}
