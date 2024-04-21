package core.services;

import java.util.ArrayList;

import java.util.List;
import persistence.entities.Purchase;

public class DefaultOrderManagementService implements OrderManagementService  {

	private static DefaultOrderManagementService instance;
	private List<Purchase> orders = new ArrayList<Purchase>();


	
	
	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}
	
	
	@Override
	public void addOrder(Purchase order) {
		// TODO Auto-generated method stub
		orders.add(order);
	}

	@Override
	public List<Purchase> getOrdersByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Purchase> userOrders=new ArrayList<Purchase>() ;
		for(Purchase order : orders) {
			if(order.getCustomerId()==userId) {
				userOrders.add(order);
			}
		}
		return userOrders;
	}

	@Override
	public List<Purchase> getOrders() {
		
		return this.orders;
	}

}
