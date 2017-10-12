package com.Dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.model.Bread;
@Repository("BreadDAO")
public interface BreadDAO {
	
	
	public List<Bread> getAllBread();
	public Bread getBread(int ID);
	public void createBread(Bread bread);
	public void updateBread(Bread bread);
	public void deleteBread(Bread bread);
	
   	 
}