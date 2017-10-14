package com.niit.controllers;
import java.util.List;
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
		return new ModelAndView("redirect:/index");
	}
}
