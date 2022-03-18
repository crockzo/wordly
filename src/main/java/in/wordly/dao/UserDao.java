package in.wordly.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.wordly.model.UserModel;

@Repository
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	1. save a user
	2. update a user
	3. get user details
	4. check password
	5. change password
	
*/
	@Transactional
	public String save(UserModel user) {
		try {
			if(!isEmailAvailable(user.getEmail())) {
				return "Email address is not available";
			}
				
			if(!isUsernameAvailable(user.getUsername())){
				return  "Username is not available";
			}
			
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	
	
	@Transactional
	public void update(UserModel user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	public UserModel get(int id) {
		UserModel user = null;
		try {
			user = sessionFactory.getCurrentSession().get(UserModel.class, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
	
	@Transactional
	private boolean isEmailAvailable(String email) {
		boolean flag = false;
		try {
			Query<UserModel> q = sessionFactory.getCurrentSession().createQuery("from UserModel where email = :email");
			q.setParameter("email", email);
			int size = q.getResultList().size();
			if(size == 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	@Transactional
	private boolean isUsernameAvailable(String username) {
		boolean flag = false;
		try {
			Query<UserModel> q = sessionFactory.getCurrentSession().createQuery("from UserModel where username = :username");
			q.setParameter("username", username);
			int size = q.getResultList().size();
			if(size == 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	@Transactional
	public UserModel login(String username, String password) {
		UserModel user = null;
		try {
			Query<UserModel> q = sessionFactory.getCurrentSession().createQuery("from UserModel where username = :username and password = :password");
			q.setParameter("username", username);
			q.setParameter("password", password);
			int size = q.getResultList().size();
			if(size == 0) {
				return user;
			}
			
			user = q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	@Transactional
	public void handleWordCount(UserModel user, boolean isDelete) {
		
		int wordCount = user.getWordCount();
		if(isDelete) {
			user.setWordCount(wordCount-1);
		}else {
			user.setWordCount(wordCount+1);
		}
		
		
		/*
		 * try { sessionFactory.getCurrentSession().update(user); } catch (Exception e)
		 * { e.printStackTrace(); }
		 */
		
		update(user);
		
	}
	
	
	
	@Transactional
	public String updateUser(UserModel user, String name, String username, String email, String password) {
		
		if(!name.equals(user.getName())) {
			user.setName(name);
		}
		
		
		if(!username.equals(user.getUsername())) {
			boolean isPossible = isUsernameAvailable(username);
			if(isPossible) {
				user.setUsername(username);
			}else {
				return "Username is not available";
			}
		}
		
		if(!email.equals(user.getEmail())) {
			boolean isPossible = isEmailAvailable(email);
			if(isPossible) {
				user.setEmail(email);
			}else {
				return "Email address is not available";
			}
		}
		
		if(!password.equals("")) {
			user.setPassword(password);
		}
		
		
		update(user);
		
		return "Successfull";
	}
	
	
}
