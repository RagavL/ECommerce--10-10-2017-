package com.niit.controllers;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.Dao.*;
import com.DaoImpl.*;
import com.model.*;

@Controller
public class OrderController {

	@Autowired
	OrderDAOImpl orderDAO;
	
	@Autowired
	UserDAOImpl userDAO;
	
	@Autowired
	CartDAOImpl cartDAO;
	
	
	
	@Autowired
	private JavaMailSender mailSender; 
	
 
	
	@RequestMapping("/placeorder/{sum}")
	public String orderConfirm(@PathVariable("sum")int sum,HttpSession session,Model m)
	{
		
		String username=(String)session.getAttribute("username");
		List<Cart> list=cartDAO.retrive(username);
		Cart ncar =list.get(0);
		User user = userDAO.getUserName(username);
		int grandtotal=sum;
		OrderDetails norder = new OrderDetails();
		norder.setSum(grandtotal);
		norder.setCartit(ncar.getCartid());
		norder.setUsername(username);
		orderDAO.insertOrder(norder);
		m.addAttribute("user", user);
		m.addAttribute("grandtotal", grandtotal);
		m.addAttribute("cartitems", list);
		return "checkout";
		
	}
	
	@RequestMapping("/placeorder/{sum}/receipt")
	public String Receipt(@PathVariable("sum")int sum,HttpSession session,Model m,HttpServletRequest request)
	{
		String username=(String)session.getAttribute("username");
		List<Cart> list=cartDAO.retrive(username);
		Cart ncar =list.get(0);
		User user = userDAO.getUserName(username);
		int grandtotal=sum;
		SimpleMailMessage email = new SimpleMailMessage(); 
		User usr =userDAO.getUserName(username);
		 SimpleMailMessage semail = new SimpleMailMessage(); 
         semail.setTo(usr.getEmail()); 
         semail.setSubject("Thank You for Placing an Order With Us"); 
         semail.setText("Greeting from eBakery!<br>"
         		+ "Thank You for Placing an Order With Us!");
         mailSender.send(semail); 
         System.out.println("Success");
	     m.addAttribute("user", user);
		 m.addAttribute("grandtotal", grandtotal);
		 m.addAttribute("cartitems", list);
		 cartDAO.deletecitems(username);
		 return "receipt";
		
	}
	
	@RequestMapping(value="/placeorder/{grandtotal}/receipt/home")
	   public ModelAndView gotonHome(@PathVariable("grandtotal") int id) {
		     System.out.println("inside");
		     return new ModelAndView("home");
	   }
	
	
}
