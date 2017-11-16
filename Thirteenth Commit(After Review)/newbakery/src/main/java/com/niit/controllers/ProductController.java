package com.niit.controllers;
import org.h2.util.New;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.Dao.*;
import com.DaoImpl.*;
import com.model.*;
@Controller
public class ProductController {

	@Autowired
	ProductDAOImpl productDAOImpl;
	
	@Autowired
	CategoryDAOImpl categoryDAOImpl;
	
	@RequestMapping("/bread")
	public ModelAndView getAllBread()
	{
		 List<Product>plist=productDAOImpl.getProductbyCatID(1);
		  ModelAndView ss=new ModelAndView("bread","prod",plist);
		  return ss;
	}
	
	@RequestMapping("/cakes")
	public ModelAndView getAllCakes()
	{
		 List<Product>plist=productDAOImpl.getProductbyCatID(2);
		  ModelAndView ss=new ModelAndView("bread","prod",plist);
		  return ss;
	}
	
	@RequestMapping("/pastries")
	public ModelAndView getAllPastries()
	{
		 List<Product>plist=productDAOImpl.getProductbyCatID(3);
		  ModelAndView ss=new ModelAndView("bread","prod",plist);
		  return ss;
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String createBread(@ModelAttribute("product")Product product,Model m) {
		productDAOImpl.createProduct(product);
		
		
		return "redirect:/home";
	}
	
		
	public LinkedHashMap<Integer, String> getCatList() {
		List<Category> list = categoryDAOImpl.getAllCategory();
        LinkedHashMap<Integer,String> catlist = new LinkedHashMap<Integer, String>();
        for (Category cat : list)
        {
			catlist.put(cat.getCatid(), cat.getCatname());
		}

		return catlist;
	}
	
	@RequestMapping(value="/editproductid/{id}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id,Model m){  
        Product p = productDAOImpl.getProductbyID(id);  
        System.out.println("====================================> bread namer : "+p.getPname());
        m.addAttribute("catlist",this.getCatList());
        return new ModelAndView("editbread","product",p);  
    }  
	
    /* It updates model object. */  
    @RequestMapping(value="editsave",method=RequestMethod.POST)  
    public ModelAndView editsavebread(@ModelAttribute("product") Product product,Model m){  
    	System.out.println("---------------------->bread name after editing"+product.getPname());
    	  	productDAOImpl.updateProduct(product);
    	 List<Product>ll=productDAOImpl.getAllProduct();
		 ModelAndView mv=new ModelAndView("bread","allbread",ll);
		 return mv;
    	
    } 
    
    @RequestMapping(value="/deleteproduct/{id}")
	public ModelAndView deltebread(@PathVariable int id) {
		 Product p=productDAOImpl.getProductbyID(id);
		productDAOImpl.deleteProduct(p);
		return new ModelAndView("redirect:/home");
	}	
    
    @RequestMapping("/adminproduct")
    public ModelAndView gotonewadminproduct(Model m) {
 	    m.addAttribute("catlist",this.getCatList());
 	    List<Product>list = productDAOImpl.getAllProduct();
 	    ModelAndView mv=new ModelAndView("adminproduct","prod",list);
         return mv;
    }
    
	
	
	
	
}
