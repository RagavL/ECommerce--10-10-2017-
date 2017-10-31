package com.niit.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.Dao.UserDAO;
import com.DaoImpl.BreadDAOImpl;
import com.DaoImpl.UserDAOImpl;
import com.model.Bread;
import com.model.User;

@Controller
public class UserController {

	@Autowired
	UserDAOImpl userDAOImpl;
	
	@RequestMapping("/checkout")
	   public String gotoCheckout() {
	         return "checkout";
	   }


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
	
	@RequestMapping(value="/myprofile")
	public ModelAndView getUser(@ModelAttribute("user")User user,HttpSession session,Model m){
		String username=(String)session.getAttribute("username");
		System.out.println(username);
		User u=userDAOImpl.getUserName(username);
		return new ModelAndView("UserProfile","user",u);
		
	}
	
	@RequestMapping(value="/perform_logout")
	public ModelAndView logout(HttpServletRequest request,HttpSession session)
	{
		System.out.println("Logout page");
		session.invalidate();
		//session=request.getSession(true);
		System.out.println("Log Out Successfull");
		
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(value="editsaveuser",method=RequestMethod.POST)  
    public ModelAndView editsaveuser(@ModelAttribute("user") User user,HttpSession session,Model m){  
    	  
		String username=(String)session.getAttribute("username");
		User u=userDAOImpl.getUserName(username);
		user.setId(u.getId());
		user.setUsername(u.getUsername());
		userDAOImpl.updateuser(user);
		
    	User u1=userDAOImpl.getUserName(username);
    	System.out.println(u.getCustomername());
		 ModelAndView mv=new ModelAndView("UserProfile","user",u1);
		 return mv;
    	
    }  
	

	@RequestMapping(value ="/exist/{name}", method = RequestMethod.GET)
	@ResponseBody
	public void checkUsername(@PathVariable("name") String uname, HttpServletResponse response , HttpServletRequest request) throws IOException {
        
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    User usr =  userDAOImpl.getUserName(uname);	
	    //System.out.print(usr.getUsername());
	    
	    int flg=0;
	    try {

	         usr.getUsername();       	               
	            
	       

	    } catch (NullPointerException ex) {

	    	out.println("<font color=green><b>"+uname+"</b> is avaliable");
	    	flg=1;
	    	//out.println("Error ->" + ex.getMessage());

	    } finally {
	    	if(flg==0)
	    	{
	    	out.println("<font color=red><b>"+uname+"</b> is already in use</font>");
	    	}
	        out.close();
	    }

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
	
	
	
	
}
