package com.niit.controllers;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.Dao.BreadDAO;
import com.DaoImpl.BreadDAOImpl;
import com.DaoImpl.CakesDAOImpl;
import com.DaoImpl.PastriesDAOImpl;
import com.model.Bread;
import com.model.Cakes;
import com.model.Pastries;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
public class IndexController {
   @Autowired
   BreadDAOImpl breadDAOImpl1;
   @Autowired
   CakesDAOImpl cakesDAOImpl1;
   @Autowired
   PastriesDAOImpl pastriesDAOImpl1;
   
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
      
   @RequestMapping("/newbread")
   public ModelAndView gotonewbread() {
        ModelAndView mv=new ModelAndView("newbread","bread",new Bread());
        return mv;
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
   
   @RequestMapping("/login")
   public String gotoLogin() {
         return "login";
   }
   @RequestMapping(value="searchbyAll",method=RequestMethod.POST)
	public ModelAndView searchall(@ModelAttribute("bread")Bread bread,Cakes cake,Pastries pastries,Model m) {
		System.out.println(bread.getNAME());
		String n=bread.getNAME();
		Cakes c = new Cakes();
		 Bread b = new Bread();
		 Pastries p = new Pastries();
		 int flag=1;
		 int flag1=1;
		 b = breadDAOImpl1.getBreadName(n);
		 
		 
		try{
			b.getNAME();
		}
		catch(NullPointerException e){
			
          	System.out.println("Not Found in Bread");
          	c = cakesDAOImpl1.getCakesName(n);
          	try{
          	 c.getNAME();	
          	}
          	catch(NullPointerException f){
          		System.out.println("Not Found in Cakes Table");
    			p = pastriesDAOImpl1.getPastriesName(n);
    			                               try{
    			                            	   p.getNAME();
    			                               }
    			                               catch(NullPointerException h)
    			                               {
    			                            	   System.out.println("Not Found Anywhere");
    			                            	                   	   flag1=0;
    			                               }
    			                               finally{
    			                            	  if(flag1==1) 
    			                            	  {
    			                            		  b = breadDAOImpl1.setData(p.getID(), p.getNAME(), p.getDESCRIPTION(), p.getPRICE());
    			                          			  flag=0;
    			                            	  }
    			                            	  
    			                            	  if(flag1==0)
    			                            	  {
    			                            		  b=breadDAOImpl1.setData(0, "NOT FOUND", "NOT FOUND",0);
    			                            		  flag=0;
    			                            	  }
    			                               }
    			                               
    			
          	}
          	finally{
          		if(flag==1)
          		{
          			b =breadDAOImpl1.setData(c.getID(), c.getNAME(), c.getDESCRIPTION(), c.getPRICE());
          		}
          	}
          	

		}
				
		 		
		return new ModelAndView("showbread","bread",b);
	}// end of search all
   
   
      
}