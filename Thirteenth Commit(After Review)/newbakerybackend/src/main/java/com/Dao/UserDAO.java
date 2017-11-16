package com.Dao;
import java.util.List;
import org.springframework.stereotype.Repository;


import com.model.*;
@Repository("UserDAO")
public interface UserDAO {

	public  List<User> getAllUser();
	public void insertUpdateUser(User user);
	public User getUserName(String Name);
	public void updateuser(User user);
}
