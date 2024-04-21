package core.services;

import java.util.List;

import persistence.entities.Purchase;

public interface OrderManagementService {
	
	void addOrder(Purchase order);

	List<Purchase> getOrdersByUserId(int userId);
	
	List<Purchase> getOrders();
}
