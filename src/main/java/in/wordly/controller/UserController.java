package in.wordly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.wordly.dao.UserDao;
import in.wordly.model.UserModel;

@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	
	@RequestMapping(value = {"/RegisterUser"})
	public ModelAndView saveUser(@ModelAttribute("user") UserModel user) {
		String status = "";
		status = userDao.save(user);
		
		ModelAndView mv ;
		if(status.equals("success")) {
			mv = new ModelAndView("loginform"); 
		}else {
			mv = new ModelAndView("registerform");
			mv.addObject("status", status);
		}
				
		return mv;
	}
	
	
	@RequestMapping(value = {"/LoginUser"})
	public ModelAndView loginUser(String username, String password, HttpSession session) {
		ModelAndView mv;
		UserModel user = userDao.login(username, password);
		if(user == null) {
			mv = new ModelAndView("loginform");
		}else {
			mv = new ModelAndView("wordform");
			session.setAttribute("user", user);
			mv.addObject("user", user);
		}
		
		return mv;
	}
	
	
	@RequestMapping(value = {"/logout"})
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView("loginform");
		mv.addObject("user", null);
		session.setAttribute("user", null);
		return mv;
	}
	
	
	
	@RequestMapping(value = {"updateuser"})
	public ModelAndView updateProfile(String name, String username, String email, String password, HttpSession session) {
		ModelAndView mv = null;
		
		UserModel user = (UserModel)session.getAttribute("user");
		
		String status = userDao.updateUser(user, name, username, email, password);
		
		if(!status.equals("Successfull")) {
			mv = new ModelAndView("profileupdateform");
			mv.addObject("status", status);
		}else {
			mv = new ModelAndView("profile");
			mv.addObject("status","");
			//session.setAttribute("user", user);
		}
		
		mv.addObject("user", user);
		return mv;
	}
	
}
