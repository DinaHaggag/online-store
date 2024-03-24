package core;


import java.util.ResourceBundle;
import java.util.Scanner;

public class ProductCatalog implements Menu{
	private ApplicationContext context;
	private ProductManagementService productManagementService;
	private ResourceBundle rb;
	
	
	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
		rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
	   
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
		System.out.println(rb.getString("product.catalog.header"));
		pList();
		
		System.out.println(rb.getString("enter.product.id"));
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
						System.out.println("Product "+p.getProductName() +rb.getString("product.added.to.cart"));
					}
					if(context.getLoggedInUser()==null) {
						System.out.println(rb.getString("not.logged.in.msg"));
						context.getMainMenu().start();
					}
					
				}
				System.out.println(rb.getString("enter.product.id"));
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


