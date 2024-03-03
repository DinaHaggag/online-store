package core;

import java.util.Scanner;
import java.util.regex.Pattern;

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
		System.out.println("Enter your credit card number without spaces and press enter if you confirm purchase");
		Scanner sc = new Scanner(System.in);
		CharSequence creditCard = sc.next();
		if(Pattern.matches("\\d{16}",creditCard)) {
			System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email");

			orderManagementService.addOrder(createOrder(creditCard));
			
			context.getSessionCart().getProducts().clear();
			
			context.getMainMenu().start();
		}
		System.out.println("You entered invalid credit card number. Valid credit card should contain 16 digits. Please, try one more time");
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
