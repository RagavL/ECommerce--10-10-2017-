package com.Dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.model.User;
@Repository("UserDAO")
public interface UserDAO {

	public  List<User> getAllUser();
	public void insertUpdateUser(User user);
}
