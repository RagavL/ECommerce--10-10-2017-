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
import com.Dao.PastriesDAO;
import com.DaoImpl.BreadDAOImpl;
import com.DaoImpl.PastriesDAOImpl;
import com.model.Cakes;
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
	
	
	@RequestMapping(value="insertpastries",method=RequestMethod.POST)
	public String createPastries(@ModelAttribute("pastries")Pastries pastries,Model m) {
		pastriesDAOImpl.createPastries(pastries);
		return "redirect:/pastries";
	}	
	
	@RequestMapping(value="searchbyPastriesName",method=RequestMethod.POST)
	public ModelAndView searchbreadName(@ModelAttribute("pastries")Pastries pastries,Model m) {
		Pastries p=pastriesDAOImpl.getPastriesName(pastries.getNAME());
		System.out.println(p.getNAME());
		return new ModelAndView("showpastries","cakes",p);
	}
	
	@RequestMapping(value="/editpastriesid/{id}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable int id){  
        Pastries p=pastriesDAOImpl.getPastries(id);  
        System.out.println("====================================> bread namer : "+p.getNAME());
        return new ModelAndView("editpastries","pastries",p);  
    }  
	
    /* It updates model object. */  
    @RequestMapping(value="editsavepastries",method=RequestMethod.POST)  
    public ModelAndView editsavecakes(@ModelAttribute("cakes")Pastries pastries,Model m){  
    	System.out.println("---------------------->bread name after editing"+pastries.getNAME());
    	  
    	pastriesDAOImpl.updatePastries(pastries);
    	 List<Pastries>cakeslist=pastriesDAOImpl.getAllPastries();
		 ModelAndView mv=new ModelAndView("pastries","allpastries",cakeslist);
		 return mv;
    	
    }  
    
    @RequestMapping(value="/deletepastries/{id}")
	public ModelAndView deltepastries(@PathVariable int id) {
		 Pastries p=pastriesDAOImpl.getPastries(id);
		pastriesDAOImpl.deletePastries(p);
		return new ModelAndView("redirect:/pastries");
	}
	
	
}
