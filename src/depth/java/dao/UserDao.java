package depth.java.dao;

import java.util.List;

import depth.java.DataStore;
import depth.java.entities.User;

public class UserDao {
	public List<User> getUsers() {
		return DataStore.getUsers();
	}
}
