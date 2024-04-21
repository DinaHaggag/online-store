package persistence.entities;

import java.io.Serializable;
import java.util.List;

public interface Purchase extends Serializable{
	boolean isCreditCardNumberValid(CharSequence userInput);
	 void setCreditCardNumber(CharSequence creditCard);
	 void setProducts(List<Product> products);
	 void setCustomerId(int customerId);
	 int getCustomerId();
	List<Product> getProducts();
}
