package com.niit.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.Dao.CakesDAO;
import com.DaoImpl.CakesDAOImpl;
import com.model.Bread;
import com.model.Cakes;

@Controller
public class CakesController {
	@Autowired
	CakesDAOImpl cakesDAOImpl;

	@RequestMapping("/cakes")
	public ModelAndView getAllCake()
	{
		 List<Cakes>ll=cakesDAOImpl.getAllCakes();
		 ModelAndView ss=new ModelAndView("cakes","allcakes",ll);
		 return ss;
	}
	
	@RequestMapping(value="insertcake",method=RequestMethod.POST)
	public String createBread(@ModelAttribute("cakes")Cakes cakes,Model m) {
		cakesDAOImpl.createCakes(cakes);
		return "redirect:/cakes";
	}	
	
	/*@RequestMapping(value="searchbyIDcakes",method=RequestMethod.POST)
	public ModelAndView searchbreadID(@ModelAttribute("cakes")Cakes cakes,Model m) {
		Cakes c=cakesDAOImpl.getCakes(cakes.getID());
		return new ModelAndView("editbread","bread",b);
	}*/	
	
	@RequestMapping(value="searchbyCakeName",method=RequestMethod.POST)
	public ModelAndView searchbreadName(@ModelAttribute("cakes")Cakes cakes,Model m) {
		Cakes cake=cakesDAOImpl.getCakesName(cakes.getNAME());
		System.out.println(cakes.getNAME());
		return new ModelAndView("showcakes","cakes",cake);
	}
	
	
	
	@RequestMapping(value="/editcakesid/{id}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id){  
        Cakes c=cakesDAOImpl.getCakes(id);  
        System.out.println("====================================> bread namer : "+c.getNAME());
        return new ModelAndView("editcakesid","cakes",c);  
    }  
	
    /* It updates model object. */  
    @RequestMapping(value="editsavecakes",method=RequestMethod.POST)  
    public ModelAndView editsavecakes(@ModelAttribute("cakes")Cakes cakes,Model m){  
    	System.out.println("---------------------->bread name after editing"+cakes.getNAME());
    	  
    	cakesDAOImpl.updateCakes(cakes);
    	 List<Cakes>cakeslist=cakesDAOImpl.getAllCakes();
		 ModelAndView mv=new ModelAndView("cakes","allcakes",cakeslist);
		 return mv;
    	
    }  
	
	@RequestMapping(value="/deletecakes/{id}")
	public ModelAndView deltebread(@PathVariable int id) {
		 Cakes c=cakesDAOImpl.getCakes(id);
		cakesDAOImpl.deleteCakes(c);
		return new ModelAndView("redirect:/cakes");
	}
	
}
