package in.wordly.controller;


import javax.servlet.http.HttpServletResponse;
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
public class WordController {
	
	@Autowired
	WordDao wordDao;
	
	@Autowired
	UserDao userDao;
	
	
	@RequestMapping(value = {"/wordsave"})
	public void saveOrUpdateWord(@ModelAttribute("word") WordModel word, HttpSession session, HttpServletResponse response) {
		UserModel Tempuser = (UserModel)session.getAttribute("user");
		int id = Tempuser.getId();
		UserModel user = userDao.get(id);
		
		if(word.getId()== 0) {
			userDao.handleWordCount(user, false);
			word.setUser(user);
			wordDao.save(word);
			//session.setAttribute("user", user);
		}else {
			word.setUser(user);
			wordDao.update(word);
		}
		
		
		
		try {
			response.sendRedirect("displayword");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = {"/displayword"})
	public ModelAndView wordListDisplay(HttpSession session) {
		ModelAndView mv = new ModelAndView("displayword");
		UserModel user = (UserModel)session.getAttribute("user");
		mv.addObject("word", wordDao.getWordByUser(user.getId()));
		return mv;
	}
	
	@RequestMapping(value = {"/filterword"})
	public ModelAndView filterWord(String word) {
		ModelAndView mv = new ModelAndView("displayword");
		mv.addObject("word", wordDao.getFilterWord(word));
		return mv;
	}
	
	
	@RequestMapping(value = {"/deleteword"})
	public void deleteWord(@RequestParam("word_id") int word_id, HttpSession session, HttpServletResponse response) {
		wordDao.deleteWord(word_id);
		try {
			response.sendRedirect("displayword");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//session.setAttribute("user", user);
	}
	
	
	
}
