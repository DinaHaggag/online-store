package core.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import persistence.entities.Product;

public class DefaultOrder implements Order {
	
	private CharSequence creditCardNumber;
	private List<Product> products;
	private int customerId;

	
	@Override
	public boolean isCreditCardNumberValid(CharSequence userInput) {
		
		if(Pattern.matches("\\d{16}",userInput)) {
			return true;
		}
		return false;
	}


	@Override
	public void setCreditCardNumber(CharSequence creditCardNumber) {
	
		if (creditCardNumber == null) {
			return;
		}
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public void setProducts(List<Product> products) {
		this.products = new ArrayList<>(products);
	}

	@Override
	public void setCustomerId(int customerId) {
		
		this.customerId = customerId;
	}

	@Override
	public int getCustomerId() {
		
		return this.customerId;
	}
	
	@Override
	public String toString() {
		return "Order: customer id - " + this.customerId + "\t" +
					"credit card number - " + this.creditCardNumber + "\t" + 
					"products - " + this.products.toString();
	}


}
