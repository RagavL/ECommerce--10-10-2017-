package com.niit.controllers;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;
import com.Dao.BreadDAO;
import com.DaoImpl.BreadDAOImpl;
import com.DaoImpl.CartDAOImpl;
import com.model.*;

@Controller
public class CartController {
	
	@Autowired
	CartDAOImpl cartDAOImpl;
	@Autowired
	BreadDAOImpl breadDAOImpl;
	
	@RequestMapping(value="/addcartbread/{id}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id,HttpSession session,Model m){  
		Cart cart=new Cart();
		String username=(String)session.getAttribute("username");
		cart.setCartid(1001);
		cart.setProid(id);
		cart.setStatus("N");
		cart.setUsername(username); 
		Bread product=breadDAOImpl.getBread(id);
		cart.setProdname(product.getNAME());
		cart.setPrice(product.getPRICE());
		cartDAOImpl.insertCart(cart);
		List<Cart> list=cartDAOImpl.retrive(username);
		m.addAttribute("cartitems", list);
		return new ModelAndView("cart","cart",list);
    } 
	
	@RequestMapping(value="/deleteCartItem/{citemid}",method=RequestMethod.GET)
	public ModelAndView deleteCartItem(@PathVariable("citemid")int citemid,HttpSession session,Model m)
	{
		System.out.println("hello");
		Cart cart=(Cart)cartDAOImpl.getCart(citemid);
		cartDAOImpl.removeCart(cart);
		String username=(String)session.getAttribute("username");
		List<Cart> list=cartDAOImpl.retrive(username);
		return new ModelAndView("cart","cartitems",list);
		
	}
	
	@RequestMapping(value="/mycart",method=RequestMethod.GET)
	public ModelAndView viewmycart(HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		List<Cart>list=cartDAOImpl.retrive(username);
		return new ModelAndView("cart","cartitems",list);
		
	}

}
