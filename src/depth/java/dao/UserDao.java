package depth.java.dao;

import depth.java.DataStore;
import depth.java.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
