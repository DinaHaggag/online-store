package core.services;

import java.util.List;

import persistence.entities.DefaultProduct;
import persistence.entities.Product;

public interface ProductManagementService {
	List<DefaultProduct> getProducts();

	Product getProductById(int productIdToAddToCart);
}
