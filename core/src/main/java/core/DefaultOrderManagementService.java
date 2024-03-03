package core;

import java.util.ArrayList;
import java.util.List;

public class DefaultOrderManagementService implements OrderManagementService  {

//	private ApplicationContext context;
	private static DefaultOrderManagementService instance;
	private List<Order> orders = new ArrayList<Order>();
//	private Checkout checkInstance;
	
	
	
	{
//		context = ApplicationContext.getInstance();
//		checkInstance = Checkout.getInstance();
	}
	
	
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
		List<Order> userOrder=new ArrayList<Order>() ;
		for(Order order : orders) {
			if(order.getCustomerId()==userId) {
				userOrder.add(order);
				return userOrder;
			}
		}
		return null;
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return this.orders;
	}

}
