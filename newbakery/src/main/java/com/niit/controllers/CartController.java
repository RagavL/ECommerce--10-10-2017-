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
import com.Dao.*;
import com.DaoImpl.*;
import com.model.*;

@Controller
public class CartController {
	
	@Autowired
	CartDAOImpl cartDAOImpl;
	
	@Autowired
	ProductDAOImpl productDAOImpl;
	
	@Autowired
	UserDAOImpl userDAOImpl;
	
	
	@RequestMapping(value="/addcartproduct/{name}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("name") String sname,HttpSession session,Model m){  
		Cart cart=new Cart();
		String username=(String)session.getAttribute("username");
		User u = userDAOImpl.getUserName(username);
		cart.setCartid(u.getId());
		cart.setStatus("N");
		cart.setUsername(username);
		System.out.println(sname);
		String n=sname;
		 Product p = new Product();
		 int flag=1;
			 
		 p = productDAOImpl.getProductbyName(n);
		  try
		{
			p.getPname();
		}
		catch(NullPointerException e){
			
         	System.out.println("Not Found in Product Table");
         	flag=0;
         	
         	
		  }
         	
         	finally{
         		if(flag==0)
         		{
         			p.setCatid(0);
         			p.setDescription("NOT FOUND");
         			p.setPid(0);
         		    p.setPname("NOT FOUND");
         		    p.setPprice(0);
         		    p.setQuantity(0);
         		}
         	}
		    
		  cart.setProid(p.getPid());
			cart.setProdname(p.getPname());
			cart.setPrice(p.getPprice());
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
		if(n==0)
			m.addAttribute("n",n);
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
