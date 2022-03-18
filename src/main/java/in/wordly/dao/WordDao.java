package in.wordly.dao;

import java.util.*;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.wordly.model.UserModel;
import in.wordly.model.WordModel;

@Repository
public class WordDao {

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDao userDao;
	
	@Transactional
	public boolean save(WordModel word) {
		boolean flag = false;
		try {
			sessionFactory.getCurrentSession().save(word);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Transactional
	public List<WordModel> getWordByUser(int user_id){
		List<WordModel> list = null;
		
		try {
			Query<WordModel> q = sessionFactory.getCurrentSession().createQuery("from WordModel where user_id = :user_id order by id desc");
			q.setParameter("user_id", user_id);
			list = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	@Transactional
	public boolean update(WordModel word) {
		boolean flag = false;
		try {
			sessionFactory.getCurrentSession().update(word);
			
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	@Transactional
	public WordModel getWordById(int word_id){
		WordModel word = null;
		
		try {
			word = sessionFactory.getCurrentSession().get(WordModel.class, word_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return word;
	}
	
	@Transactional
	public List<WordModel> getFilterWord(String word)
	{
		String pattern = "%" + word + "%";
		List<WordModel> list = null;
		
		
		try {
			Query<WordModel> q = sessionFactory.getCurrentSession().createQuery("from WordModel where word like :pattern");
			q.setParameter("pattern", pattern);
			list = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Transactional
	public boolean deleteWord(int id) { //, UserModel user
		boolean flag = false;
		try {
			WordModel word = sessionFactory.getCurrentSession().load(WordModel.class, id);
			userDao.handleWordCount(word.getUser(), true);
			sessionFactory.getCurrentSession().delete(word);
			
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
}
