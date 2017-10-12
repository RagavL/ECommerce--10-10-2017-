package com.Dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.model.Cakes;
@Repository("CakesDAO")
public interface CakesDAO {
	
	
	public List<Cakes> getAllCakes();
	
   	 
}