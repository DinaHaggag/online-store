package core.services;

import java.util.List;

import persistence.entities.User;

public interface UserManagementService {
	String registerUser(User user);
	List<User> getUsers();
	User getUserByEmail(String userEmail);
}
