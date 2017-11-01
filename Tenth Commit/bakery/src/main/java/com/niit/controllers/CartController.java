package com.niit.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.Dao.BreadDAO;
import com.DaoImpl.*;
import com.model.*;

@Controller
public class CartController {
	
	@Autowired
	CartDAOImpl cartDAOImpl;
	@Autowired
	BreadDAOImpl breadDAOImpl;
	@Autowired
	PastriesDAOImpl pastriesDAOImpl;
	@Autowired
	CakesDAOImpl cakesDAOImpl;
	
	@RequestMapping(value="/addcartbread/{name}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("name") String sname,HttpSession session,Model m){  
		Cart cart=new Cart();
		String username=(String)session.getAttribute("username");
		cart.setCartid(1001);
		cart.setStatus("N");
		cart.setUsername(username);
		System.out.println(sname);
		String n=sname;
		 Cakes c = new Cakes();
		 Bread b = new Bread();
		 Pastries p = new Pastries();
		 int flag=1;
		 int flag1=1;
		 b = breadDAOImpl.getBreadName(n);
		try{
			b.getNAME();
		}
		catch(NullPointerException e){
			
          	System.out.println("Not Found in Bread");
          	c = cakesDAOImpl.getCakesName(n);
          	try{
          	 c.getNAME();	
          	}
          	catch(NullPointerException f){
          		System.out.println("Not Found in Cakes Table");
    			p = pastriesDAOImpl.getPastriesName(n);
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
    			                            		  b = breadDAOImpl.setData(p.getID(), p.getNAME(), p.getDESCRIPTION(), p.getPRICE());
    			                          			  flag=0;
    			                            	  }
    			                            	  
    			                            	  if(flag1==0)
    			                            	  {
    			                            		  b=breadDAOImpl.setData(0, "NOT FOUND", "NOT FOUND",0);
    			                            		  flag=0;
    			                            	  }
    			                               }
    			                               
    			
          	}
          	finally{
          		if(flag==1)
          		{
          			b =breadDAOImpl.setData(c.getID(), c.getNAME(), c.getDESCRIPTION(), c.getPRICE());
          		}
          	}
          	

		}
				
		 		
		//return new ModelAndView("showbread","bread",b);
	
   
		cart.setProid(b.getID());
		cart.setProdname(b.getNAME());
		cart.setPrice(b.getPRICE());
		cart.setQuantity(1);
		List<Cart>list=cartDAOImpl.retrive(username);
		m.addAttribute("cartitems", list);
		cartDAOImpl.insertCart(cart);
		return new ModelAndView("redirect:/mycart");
    } 
	
	@RequestMapping(value="/deleteCartItem/{citemid}",method=RequestMethod.GET)
	public ModelAndView deleteCartItem(@PathVariable("citemid")int citemid,HttpSession session,Model m)
	{
		
		Cart cart=(Cart)cartDAOImpl.getCart(citemid);
		cartDAOImpl.removeCart(cart);
		String username=(String)session.getAttribute("username");
		return new ModelAndView("redirect:/mycart");
		
	}
	
	@RequestMapping(value="/mycart",method=RequestMethod.GET)
	public ModelAndView viewmycart(HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		List<Cart>list=cartDAOImpl.retrive(username);
		int n= list.size();
		return new ModelAndView("cart","cartitems",list);
		
	}
	
	@RequestMapping(value ="/addquty/{val}/{pname}/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void checkUsername(@PathVariable("val") int val,@PathVariable("pname") String pname,@PathVariable("id") int id, HttpServletResponse response ,HttpSession session,HttpServletRequest request) throws IOException {
        
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    String username=(String)session.getAttribute("username");
	    System.out.println(val);
	    System.out.println(pname);
	    cartDAOImpl.setQuantity(username, pname, val, id);
	    System.out.println("SUCESSFULLY SET");

	}

}
