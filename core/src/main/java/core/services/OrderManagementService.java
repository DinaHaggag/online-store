package core.services;

import java.util.List;

import core.menu.Order;

public interface OrderManagementService {
	
	void addOrder(Order order);

	List<Order> getOrdersByUserId(int userId);
	
	List<Order> getOrders();
}
