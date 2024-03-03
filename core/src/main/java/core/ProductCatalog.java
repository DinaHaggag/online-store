package core;


import java.util.Scanner;

public class ProductCatalog implements Menu{
	private ApplicationContext context;
	private ProductManagementService productManagementService;
	
	
	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
	   
	}
	
	public void pList() {
		for(Product p : productManagementService.getProducts()) {
			System.out.print(p.getId()+" "+p.getProductName()+" "
		                +p.getCategoryName()+" "+p.getPrice());
			System.out.println();
		}
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		pList();
		
		System.out.println("Enter product id to add it to the cart or ‘menu’ if you want to navigate back to the main menu’");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
//		if(input.equals("checkout")&& cartList.getProducts()==null) {
//			 System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout");
//		 }
		
		while (input != "menu") {
			if(input.equals("menu")) {
				context.getMainMenu().start();
			}
			else {
				
				for(Product p : productManagementService.getProducts()) {
					if(Integer.valueOf(input) == p.getId()&&context.getLoggedInUser()!=null) {
						context.getSessionCart().addProduct(p);
						System.out.println("Product "+p.getProductName() +"has been added to your cart.");
					}
					if(context.getLoggedInUser()==null) {
						System.out.println("You are not logged in. Please, sign in or create new account");
						context.getMainMenu().start();
					}
					
				}
				System.out.println("Please, enter product ID if you want to add product to cart. Or enter ‘checkout’ if you want to proceed with checkout. Or enter ‘menu’ if you want to navigate back to the main menu");
				pList();
				input = sc.next();
				
				 if(input.equals("checkout") && context.getSessionCart().getProducts()!=null) {
					 Checkout checkout = new Checkout();
					 checkout.start();
				 }
			}
		}
		
	}
}


