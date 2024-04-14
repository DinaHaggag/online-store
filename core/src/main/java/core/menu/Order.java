package core.menu;

import java.util.List;

import persistence.entities.Product;

public interface Order {
	 boolean isCreditCardNumberValid(CharSequence userInput);
	 void setCreditCardNumber(CharSequence creditCard);
	 void setProducts(List<Product> products);
	 void setCustomerId(int customerId);
	 int getCustomerId();
}
