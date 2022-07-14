package java.depth.managers;

import java.depth.entities.User;

public class UserService {
	private static UserService instance = new UserService();

	private UserService() {}

	public static UserService getInstance() {
		return instance;
	}

	public User createUser(long id, String email, String password, String firstName, String lastName, int gender,
			String userType) {
		User user = new User();
		
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);		
		user.setUserType(userType);
		
		return user;
	}
}
