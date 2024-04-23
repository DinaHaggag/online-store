package core.menu;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

import core.context.ApplicationContext;
import core.services.DefaultOrderManagementService;
import core.services.OrderManagementService;
import persistence.entities.DefaultPurchase;
import persistence.entities.Purchase;

public class Checkout implements Menu {

	private static Checkout instance;
	private ApplicationContext context;
	private OrderManagementService orderManagementService ;
    private static  ResourceBundle rb;
	
	
	public static Checkout getInstance() {
		if (instance == null) {
			instance = new Checkout();
		}
		return instance;
	}
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	}
	
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println(rb.getString("checkout.menu.header"));
		System.out.println(rb.getString("enter.credit.card.number.cta"));
		Scanner sc = new Scanner(System.in);
		CharSequence creditCard; 
		
		do {
			creditCard= sc.next();
			if(Pattern.matches("\\d{16}",creditCard)) {
				System.out.println(rb.getString("thank.you.msg"));

				orderManagementService.addOrder(createOrder(creditCard));
				
				context.getSessionCart().getProducts().clear();
				
				context.getMainMenu().start();
			}
			else {
			
				System.out.println(rb.getString("invalid.credit"));
			}
		} while(!Pattern.matches("\\d{16}",creditCard));
		
	}
	
	

	private Purchase createOrder(CharSequence creditCard) {
		Purchase order = new DefaultPurchase();
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
