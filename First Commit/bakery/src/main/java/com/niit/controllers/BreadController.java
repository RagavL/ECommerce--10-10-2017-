package com.niit.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.BreadDAO;
import com.DaoImpl.BreadDAOImpl;
import com.model.Bread;

@Controller
public class BreadController {

	@Autowired
	BreadDAOImpl breadDAOImpl;

	@RequestMapping("/bread")
	public ModelAndView getAllUsers()
	{
		 List<Bread>ll=breadDAOImpl.getAllBread();
		 ModelAndView ss=new ModelAndView("bread","allbread",ll);
		 return ss;
	}
	
}
