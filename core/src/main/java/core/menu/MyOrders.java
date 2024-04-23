package core.menu;

import java.util.List;

import core.context.ApplicationContext;
import core.services.DefaultOrderManagementService;
import core.services.OrderManagementService;
import persistence.entities.Purchase;

public class MyOrders implements Menu {
	private ApplicationContext context;
	private OrderManagementService orderManagementService;
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}
	
	
	@Override
	public void start() {
		
		if(context.getLoggedInUser()==null) {
			System.out.println("Please, log in or create new account to see list of your orders");
			context.getMainMenu().start();
		}
		else {
			printUserOrdersToConsole();
		}
		context.getMainMenu().start();
	}
	
	private void printUserOrdersToConsole() {
		List<Purchase> loggedInUserOrders = orderManagementService
				.getOrdersByUserId(context.getLoggedInUser().getId());
		
		if (loggedInUserOrders == null || loggedInUserOrders.size() == 0) {
			System.out.println(
					"Unfortunately, you don't have any orders yet");
		} else {
			for (Purchase order : loggedInUserOrders) {
				System.out.println("Processing order: ");
				System.out.println(order.toString());
			}
			
		}
	}
}
