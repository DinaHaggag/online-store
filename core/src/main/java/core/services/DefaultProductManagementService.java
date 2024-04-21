package core.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import persistence.entities.DefaultProduct;
import persistence.entities.Product;

public class DefaultProductManagementService implements ProductManagementService {

	private static DefaultProductManagementService instance;
	private static  ResourceBundle rb;
	
private DefaultProductManagementService() {
        
    }

    private static void loadResourceBundle() {
    	if (rb == null) { // Check if resource bundle is already loaded
    		 try {
                 rb = ResourceBundle.getBundle("labels"); // Load resource bundle
             } catch (MissingResourceException e) {
                 // Handle missing resource bundle exception (optional)
                 System.err.println("Resource bundle 'labels.properties' not found!");
             } // Load resource bundle only if needed
        }
    }
    
    static {
        loadResourceBundle();
    }
	
	private static List<DefaultProduct> products = new ArrayList<>(Arrays.asList(
	        new DefaultProduct(1, rb.getString("product.1.productName"),  rb.getString("product.1.categoryName"), 109.99),
	        new DefaultProduct(2, rb.getString("product.2.productName"),  rb.getString("product.2.categoryName"), 179.99),
	        new DefaultProduct(3, rb.getString("product.3.productName"),  rb.getString("product.3.categoryName"), 189.99),
	        new DefaultProduct(4, rb.getString("product.4.productName"),  rb.getString("product.4.categoryName"), 209.09),
	        new DefaultProduct(5, rb.getString("product.5.productName"),  rb.getString("product.5.categoryName"), 989.99),
	        new DefaultProduct(6, rb.getString("product.6.productName"),  rb.getString("product.6.categoryName"), 787.99),
	        new DefaultProduct(7, rb.getString("product.7.productName"),  rb.getString("product.7.categoryName"), 859.99),
	        new DefaultProduct(8, rb.getString("product.8.productName"),  rb.getString("product.8.categoryName"), 402.99),
	        new DefaultProduct(9, rb.getString("product.9.productName"),  rb.getString("product.9.categoryName"), 659.99),
	        new DefaultProduct(10, rb.getString("product.10.productName"), rb.getString("product.10.categoryName"), 523.99)
	));
		
	

    public static ProductManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultProductManagementService();
        }
        return instance;
    }
	
		
	@Override
	public List<DefaultProduct> getProducts() {
		return products;
	}

	@Override
	public Product getProductById(int productIdToAddToCart) {
		
		return null;
	}

}
