package com.niit.controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Dao.BreadDAO;
import com.DaoImpl.BreadDAOImpl;

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
   
   @RequestMapping("/cakes")
   public String gotoCakes() {
         return "cakes";
   }
   //@RequestMapping("/bread")
   //public String gotoBread() {
     //    return "bread";
  //}
   
   @RequestMapping("/pastries")
   public String gotopastries() {
         return "pastries";
   }
   @RequestMapping("/pies")
   public String gotoPies() {
         return "pies";
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