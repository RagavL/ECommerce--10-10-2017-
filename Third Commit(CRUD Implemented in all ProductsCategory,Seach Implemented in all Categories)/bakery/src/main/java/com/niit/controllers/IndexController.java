package com.niit.controllers;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.Dao.BreadDAO;
import com.DaoImpl.BreadDAOImpl;
import com.model.Bread;
import com.model.Cakes;
import com.model.Pastries;
import org.springframework.ui.ModelMap;

@Controller
public class IndexController {
   @RequestMapping("/")
   public String index() {
         return "index";
   }
   
   @RequestMapping("/home")
   public String gotoHome() {
         return "home";
   }
   
   @RequestMapping("/aboutus")
   public String gotoAboutus() {
         return "aboutus";
   }
      
   @RequestMapping("/newbread")
   public ModelAndView gotonewbread() {
        ModelAndView mv=new ModelAndView("newbread","bread",new Bread());
        return mv;
   }
   
   @RequestMapping("/newcakes")
   public ModelAndView gotonewcakes() {
        ModelAndView mv=new ModelAndView("newcakes","cakes",new Cakes());
        return mv;
   }
   
   @RequestMapping("/newpastries")
   public ModelAndView gotonewpastries() {
        ModelAndView mv=new ModelAndView("newpastries","pastries",new Pastries());
        return mv;
   }
  
   @RequestMapping("/register")
   public String gotoRegister() {
         return "register";
   }
   
   @RequestMapping("/login")
   public String gotoLogin() {
         return "login";
   }
      
}