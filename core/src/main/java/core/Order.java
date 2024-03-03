package core;

import java.util.List;

public interface Order {
	 boolean isCreditCardNumberValid(CharSequence userInput);
	 void setCreditCardNumber(CharSequence creditCard);
	 void setProducts(List<Product> products);
	 void setCustomerId(int customerId);
	 int getCustomerId();
}
