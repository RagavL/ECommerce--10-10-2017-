package com.Dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.model.Pastries;
@Repository("PastriesDAO")
public interface PastriesDAO {
	
	
	public List<Pastries> getAllPastries();
	
   	 
}