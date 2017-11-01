package com.Dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.model.Cakes;
import com.model.Pastries;
@Repository("PastriesDAO")
public interface PastriesDAO {
	
	
	public List<Pastries> getAllPastries();
	public Pastries getPastries(int ID);
	public Pastries getPastriesName(String Name);
	public void createPastries(Pastries pastries);
	public void updatePastries(Pastries pastries);
	public void deletePastries(Pastries pastries);
	
   	 
}