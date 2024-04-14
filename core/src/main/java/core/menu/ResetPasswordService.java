package core.menu;

import persistence.entities.User;

public interface ResetPasswordService {
	void resetPasswordForUser(User user);
}
