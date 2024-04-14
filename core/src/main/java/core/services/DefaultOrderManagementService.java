package core.services;

import java.util.ArrayList;
import java.util.List;

import core.menu.Order;

public class DefaultOrderManagementService implements OrderManagementService  {

	private static DefaultOrderManagementService instance;
	private List<Order> orders = new ArrayList<Order>();


	
	
	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}
	
	
	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		orders.add(order);
	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Order> userOrders=new ArrayList<Order>() ;
		for(Order order : orders) {
			if(order.getCustomerId()==userId) {
				userOrders.add(order);
			}
		}
		return userOrders;
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return this.orders;
	}

}
