package com.Dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.model.Bread;
import com.model.Cakes;
@Repository("CakesDAO")
public interface CakesDAO {
	
	
	public List<Cakes> getAllCakes();
	public Cakes getCakes(int ID);
	public Cakes getCakesName(String Name);
	public void createCakes(Cakes cakes);
	public void updateCakes(Cakes cakes);
	public void deleteCakes(Cakes cakes);
	
   	 
}