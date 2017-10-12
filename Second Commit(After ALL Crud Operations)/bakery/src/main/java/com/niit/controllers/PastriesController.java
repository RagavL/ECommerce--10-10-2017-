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
import com.Dao.PastriesDAO;
import com.DaoImpl.BreadDAOImpl;
import com.DaoImpl.PastriesDAOImpl;
import com.model.Pastries;

@Controller
public class PastriesController {

	@Autowired
	PastriesDAOImpl pastriesDAOImpl;

	@RequestMapping("/pastries")
	public ModelAndView getAllUsers()
	{
		 List<Pastries>ll=pastriesDAOImpl.getAllPastries();
		 ModelAndView ss=new ModelAndView("pastries","allpastries",ll);
		 return ss;
	}
}
