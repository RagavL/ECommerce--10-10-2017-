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
import com.Dao.BreadDAO;
import com.DaoImpl.BreadDAOImpl;
import com.model.Bread;

@Controller
public class BreadController {

	@Autowired
	BreadDAOImpl breadDAOImpl;

	@RequestMapping("/bread")
	public ModelAndView getAllBread()
	{
		 List<Bread>breadlist=breadDAOImpl.getAllBread();
		 System.out.println(breadlist);
		 ModelAndView ss=new ModelAndView("bread","allbread",breadlist);
		 return ss;
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String createBread(@ModelAttribute("bread")Bread bread,Model m) {
		breadDAOImpl.createBread(bread);
		return "redirect:/bread";
	}	
	
	@RequestMapping(value="searchbyID",method=RequestMethod.POST)
	public ModelAndView searchbreadID(@ModelAttribute("bread")Bread bread,Model m) {
		Bread b=breadDAOImpl.getBread(bread.getID());
		return new ModelAndView("editbread","bread",b);
	}	
	
	@RequestMapping(value="searchbyName",method=RequestMethod.POST)
	public ModelAndView searchbreadName(@ModelAttribute("bread")Bread bread,Model m) {
		Bread b=breadDAOImpl.getBreadName(bread.getNAME());
		return new ModelAndView("showbread","bread",b);
	}
	
	
	@RequestMapping(value="/editbreadid/{id}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id){  
        Bread b=breadDAOImpl.getBread(id);  
        System.out.println("====================================> bread namer : "+b.getNAME());
        return new ModelAndView("editbread","bread",b);  
    }  
	
    /* It updates model object. */  
    @RequestMapping(value="editsave",method=RequestMethod.POST)  
    public ModelAndView editsavebread(@ModelAttribute("bread") Bread bread,Model m){  
    	System.out.println("---------------------->bread name after editing"+bread.getNAME());
    	  
    	breadDAOImpl.updateBread(bread);
    	 List<Bread>ll=breadDAOImpl.getAllBread();
		 ModelAndView mv=new ModelAndView("bread","allbread",ll);
		 return mv;
    	
    }  
	
	@RequestMapping(value="/deletebread/{id}")
	public ModelAndView deltebread(@PathVariable int id) {
		 Bread b=breadDAOImpl.getBread(id);
		breadDAOImpl.deleteBread(b);
		return new ModelAndView("redirect:/bread");
	}	
	
	

}
