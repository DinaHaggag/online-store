package persistence.entities;

import java.util.ArrayList;
import java.util.List;

public class DefaultCart implements Cart {
	private List<Product> products = new ArrayList<Product>();
//	private static DefaultCart instance;
	
//	public static Cart getInstance() {
//		if (instance == null) {
//			instance = new DefaultCart();
//		}
//		return instance;
//	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return products.isEmpty();
	}

	@Override
	public void addProduct(Product productById) {
		// TODO Auto-generated method stub
		if (productById == null) {
			return;
		}
		products.add(productById);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return this.products;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		products.clear();
	}

}
