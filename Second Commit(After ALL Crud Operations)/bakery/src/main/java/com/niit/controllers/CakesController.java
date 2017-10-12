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
import com.Dao.CakesDAO;
import com.DaoImpl.CakesDAOImpl;
import com.model.Cakes;

@Controller
public class CakesController {
	@Autowired
	CakesDAOImpl cakesDAOImpl;

	@RequestMapping("/cakes")
	public ModelAndView getAllUsers()
	{
		 List<Cakes>ll=cakesDAOImpl.getAllCakes();
		 ModelAndView ss=new ModelAndView("cakes","allcakes",ll);
		 return ss;
	}

}
