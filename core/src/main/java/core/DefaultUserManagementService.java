package core;

import java.util.ArrayList;
import java.util.List;

public class DefaultUserManagementService implements UserManagementService  {
	private ApplicationContext context;
	
	List<User> userList = new ArrayList<User>();
	
	{
		context = ApplicationContext.getInstance();
	}
	
	private static DefaultUserManagementService instance;
	
	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}


	@Override
	public User getUserByEmail(String userEmail) {
		if(this.getUsers()==null) {
			return null;
		}
		else {
			for(User u  : this.getUsers()) {
				if(u.getEmail().equalsIgnoreCase(userEmail)) {
					return u;
				}
			}
		}
		
		return null;
	}

	@Override
	public String registerUser(User user) {
		if(user.getEmail().isEmpty()) {
			return "You have to input email to register. Please, try one more time";
		}
		else {
			if( this.getUsers()==null) {
				context.setLoggedInUser(user);
				
				userList.add(user);
				context.setLogInUsers(userList);
				return "Congratulation you are regestared";
			}
			else {
				for(User u  : this.getUsers()) {
					if(u.getEmail().equalsIgnoreCase(user.getEmail())) {
							return "This email is already used by another user. Please, use another email";
					}
					
					context.setLoggedInUser(user);
					
					userList.add(user);
					context.setLogInUsers(userList);
					return "Congratulation you are regestared";
					}
				return " ";
				}
			
		}
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return context.getLogInUsers();
	}


	
}
