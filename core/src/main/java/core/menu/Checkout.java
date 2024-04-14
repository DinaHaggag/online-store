package core.menu;

import java.util.Scanner;
import java.util.regex.Pattern;

import core.context.ApplicationContext;
import core.services.DefaultOrderManagementService;
import core.services.OrderManagementService;

public class Checkout implements Menu {

	private static Checkout instance;
	private ApplicationContext context;
	private OrderManagementService orderManagementService ;
	
	
	public static Checkout getInstance() {
		if (instance == null) {
			instance = new Checkout();
		}
		return instance;
	}
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}
	
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("checkout.menu.header");
		System.out.println("enter.credit.card.number.cta");
		Scanner sc = new Scanner(System.in);
		CharSequence creditCard = sc.next();
		if(Pattern.matches("\\d{16}",creditCard)) {
			System.out.println("thank.you.msg");

			orderManagementService.addOrder(createOrder(creditCard));
			
			context.getSessionCart().getProducts().clear();
			
			context.getMainMenu().start();
		}
		System.out.println("invalid.credit");
	}
	

	private Order createOrder(CharSequence creditCard) {
		Order order = new DefaultOrder();
		if (!order.isCreditCardNumberValid(creditCard)) {
			return null;
		}
		
		order.setCreditCardNumber(creditCard);
		order.setProducts(context.getSessionCart().getProducts());
		order.setCustomerId(context.getLoggedInUser().getId());
		orderManagementService.addOrder(order);
		return order;
	}

}
