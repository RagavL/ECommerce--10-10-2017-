package com.Dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.model.*;
@Repository("OrderDAO")
public interface OrderDAO {
	public void insertOrder(OrderDetails order);
	public List<OrderDetails> retrieveOrders(String username);
	

}
