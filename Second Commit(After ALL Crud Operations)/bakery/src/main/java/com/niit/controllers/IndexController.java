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
   @RequestMapping("/searchbread")
   public ModelAndView gotosearchBread() {
	   ModelAndView mv=new ModelAndView("searchbread","bread",new Bread());
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