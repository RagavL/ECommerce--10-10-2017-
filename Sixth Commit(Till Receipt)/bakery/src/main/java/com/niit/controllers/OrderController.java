package com.niit.controllers;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	BreadDAOImpl breadDAO;
	
	@Autowired
	CakesDAOImpl cakesDAO;
	
	@Autowired
	PastriesDAOImpl pastrieDAO;
	
	@RequestMapping("/placeorder/{sum}")
	public String orderConfirm(@PathVariable("sum")int sum,HttpSession session,Model m)
	{
		System.out.println(sum);
		String username=(String)session.getAttribute("username");
		List<Cart> list=cartDAO.retrive(username);
		User user = userDAO.getUserName(username);
		int grandtotal=sum;
		m.addAttribute("user", user);
		m.addAttribute("grandtotal", grandtotal);
		m.addAttribute("cartitems", list);
		return "receipt";
		
	}
	
	
}
