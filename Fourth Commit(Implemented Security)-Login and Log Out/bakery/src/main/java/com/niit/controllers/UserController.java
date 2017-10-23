package com.niit.controllers;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.Dao.UserDAO;
import com.DaoImpl.BreadDAOImpl;
import com.DaoImpl.UserDAOImpl;
import com.model.User;

@Controller
public class UserController {

	@Autowired
	UserDAOImpl userDAOImpl;
	
	@RequestMapping(value ="/InsertUserRegister",method=RequestMethod.POST)
	public ModelAndView insertUserRegister(@ModelAttribute("userRegister") User user, Model m) {
		System.out.println("---UserRegister Inserting---");
		userDAOImpl.insertUpdateUser(user);
		System.out.println("---UserRegister Inserted--");
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping("/login_success")
	public ModelAndView loginSuccess(HttpSession session, Model m) {
		
		String page = null;
		boolean loggedIn = true;
		// Retrieving the username;
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("username", username);
		session.setAttribute("loggedIn", loggedIn);
		
		// Retrieving the role
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		for (GrantedAuthority role : authorities)
		{
			System.out.println("Role:" + role.getAuthority() + "UserName:" + username);
			if (role.getAuthority().equals("Role_Admin"))
			{
				
				page = "UserHome";
			} 
			else
			{
				
				page = "UserHome";
			}
			System.out.println("Login Successfull");
		}
		return new ModelAndView(page,"username",username);
		
	}
	
	@RequestMapping("perform_logout")
	public ModelAndView logout(HttpServletRequest request,HttpSession session)
	{
		System.out.println("Logout page");
		session.invalidate();
		session=request.getSession(true);
		System.out.println("Log Out Successfull");
		return new ModelAndView("home");
	}
	
	
}
