package core.menu;

import java.util.List;
import java.util.ResourceBundle;

import core.context.ApplicationContext;
import core.services.DefaultOrderManagementService;
import core.services.OrderManagementService;
import persistence.entities.Purchase;

public class MyOrders implements Menu {
	private ApplicationContext context;
	private OrderManagementService orderManagementService;
	private ResourceBundle rb;
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}
	
	
	@Override
	public void start() {
		
		if(context.getLoggedInUser()==null) {
			System.out.println(rb.getString("user.not.login.err"));
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
			System.out.println(rb.getString("no.order.yet"));
		} else {
			for (Purchase order : loggedInUserOrders) {
				System.out.println(order.toString());
			}
			
		}
	}
}
