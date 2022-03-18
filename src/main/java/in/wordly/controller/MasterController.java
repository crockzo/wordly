package in.wordly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.wordly.dao.UserDao;
import in.wordly.dao.WordDao;
import in.wordly.model.UserModel;
import in.wordly.model.WordModel;

@Controller
public class MasterController {

	
	@Autowired
	WordDao wordDao;
	
	@Autowired
	UserDao userDao;
	
	
	/*
	 * @RequestMapping(value = {"/"}) public ModelAndView landingPage() {
	 * ModelAndView mv = new ModelAndView("landingpage"); return mv; }
	 */
	
	@RequestMapping(value = { "/register"})
	public ModelAndView registrationForm() {
		ModelAndView mv = new ModelAndView("registerform");
		mv.addObject("status", "");
		return mv;
	}
	
	@RequestMapping(value = {"/", "/login"})
	public ModelAndView loginForm() {
		ModelAndView mv = new ModelAndView("loginform");
		return mv;
	}
	
	
	@RequestMapping(value = {"/wordform"})
	public ModelAndView wordForm() {
		ModelAndView mv = new ModelAndView("wordform");
		return mv;
	}
	
	@RequestMapping(value = {"/updatewordform"})
	public ModelAndView updateWord(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("wordform");
		WordModel word = wordDao.getWordById(id);
		mv.addObject("word", word);
		return mv;
	}
	
	@RequestMapping(value = {"profile"})
	public ModelAndView showProfile(HttpSession session) {
		ModelAndView mv = new ModelAndView("profile");
		UserModel user = (UserModel)session.getAttribute("user");
		user = userDao.get(user.getId());
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping(value = {"profileupdateform"})
	public ModelAndView updateProfile(HttpSession session) {
		ModelAndView mv = new ModelAndView("profileupdateform");
		UserModel user = (UserModel)session.getAttribute("user");
		user = userDao.get(user.getId());
		mv.addObject("user", user);
		mv.addObject("status", "");
		return mv;
	}
}
