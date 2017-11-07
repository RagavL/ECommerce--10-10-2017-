package com.niit.controllers;
import java.util.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.Dao.*;
import com.DaoImpl.*;
import com.model.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
public class IndexController {
   
   @Autowired
   CategoryDAOImpl categoryDAOImpl;
   @Autowired
   ProductDAOImpl productDAOImpl;
   
   @RequestMapping("/")
   public String index() {
         return "index";
   }
     
   @RequestMapping("/home")
   public String gotoHome() {
         return "home";
   }
   
   
   @RequestMapping("/aboutus")
   public String gotoAboutus() {
         return "aboutus";
   }
      
   @RequestMapping("/newproduct")
   public ModelAndView gotonewproduct(Model m) {
	    m.addAttribute("catlist",this.getCatList());
	    int n = productDAOImpl.getMaxPID()+1;
	    m.addAttribute("n", n);
		ModelAndView mv=new ModelAndView("newproduct","product",new Product());
        return mv;
   }
   
   public LinkedHashMap<Integer, String> getCatList() {
		List<Category> list = categoryDAOImpl.getAllCategory();
        LinkedHashMap<Integer, String> catlist = new LinkedHashMap<Integer, String>();
        for (Category cat : list)
        {
			catlist.put(cat.getCatid(), cat.getCatname());
		}

		return catlist;
	}

   
   @RequestMapping("/newcakes")
   public ModelAndView gotonewcakes() {
        ModelAndView mv=new ModelAndView("newcakes","cakes",new Cakes());
        return mv;
   }
   
   @RequestMapping("/newpastries")
   public ModelAndView gotonewpastries() {
        ModelAndView mv=new ModelAndView("newpastries","pastries",new Pastries());
        return mv;
   }
  
   @RequestMapping("/register")
   public String gotoRegister() {
         return "register";
   }
   
   @RequestMapping("/loginf")
   public String gotoLoginf() {
         return "loginf";
   }
   
   @RequestMapping("/login")
   public String gotoLogin() {
         return "login";
   }
     
   @RequestMapping(value="searchbyAll",method=RequestMethod.POST)
	public ModelAndView searchall(@ModelAttribute("product")Product product,Model m) {
		System.out.println(product.getPname());
		String n=product.getPname();
		int flag=1;
		 Product p = productDAOImpl.getProductbyName(n);
		 System.out.println("Hello");
		  try{
		
			p.getPname();
		}
		catch(NullPointerException z){
			            System.out.println(flag);
			        	System.out.println("Not Found in Product Table");
          	            flag=0;
          	          	
		  }
          	
          	finally{
          		System.out.println(flag);
          		if(flag==0)
          		{
          			
          			p = productDAOImpl.setData(0, "NOT FOUND", "NOT FOUND", 0, 0);
          		}
          	}
          	

		
				
		 System.out.println("out");		
		return new ModelAndView("showbread","bread",p);
	}// end of search all
   
   
      
}