package com.Dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.model.Product;
@Repository("ProductDAO")
public interface ProductDAO {
	
	public List<Product> getAllProduct();
	public Product getProductbyID(int ID);
	public Product getProductbyName(String Name);
	public List<Product> getProductbyCatID(int catid);
	public void createProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);
	public Product setData(int pid,String Pname,String Desc,float pprice,float qty);

}
