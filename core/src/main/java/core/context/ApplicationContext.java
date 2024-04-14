package core.context;

import java.util.List;

import core.menu.MainMenu;
import core.menu.Menu;
import persistence.entities.User;
import persistence.entities.Cart;
import persistence.entities.DefaultCart;

public class ApplicationContext {
	
	private static ApplicationContext instance;
	private Menu mainMenu;
	private User loggedInUser;
	private List<User> logInUsers;
	private Cart sessionCart;
	
	

	public List<User> getLogInUsers() {
		return logInUsers;
	}

	public void setLogInUsers(List<User> logInUsers) {
		this.logInUsers = logInUsers;
	}

	public Menu getMainMenu() {
		mainMenu = new MainMenu();
		return mainMenu;
	}

	public void setMainMenu(Menu mainMenu) {
		this.mainMenu = mainMenu;
	}
	
	public void setLoggedInUser(User user) {
//		if (this.sessionCart != null) {
//			this.sessionCart.clear(); // we have to clear session cart when new user is logged in
//		}
		this.loggedInUser = user;
	}
	
	public User getLoggedInUser() {
		return this.loggedInUser;
	}
	

	public static ApplicationContext getInstance() {
		if (instance == null) {
			instance = new ApplicationContext();
		}
		return instance;
	}
	
	public Cart getSessionCart() {
		if (this.sessionCart == null) {
			this.sessionCart = new DefaultCart();
		}
		return this.sessionCart;
	}
}
