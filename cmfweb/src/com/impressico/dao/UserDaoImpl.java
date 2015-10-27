package com.impressico.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impressico.model.User;
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserProfileDao userProfileDao;
	
	Session session = null;
	Transaction tx = null;

	@Override
	public User getUserById(long id) throws Exception {
		System.out.println("in ");
		session = sessionFactory.openSession();
		System.out.println("session object"+session);
		User user = (User) session.load(User.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<User> userList = session.createCriteria(User.class)
				.list();
		tx.commit();
		session.close();
		return userList;
	}
	
	@Override
	public String addUser(User user) throws Exception{
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		System.out.println("********** in dao add user ");
		session.save(user);
		tx.commit();
		session.close();

		return "user data save successfuly";
	}
	
	@Override
	public String updateUser(User user) throws Exception{
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
		return "Updated successfuly";
	}
	
	@Override
	public String deleteUser(User user) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
		return "User deleted successfuly";
		
	}
	
//	@Override
//	public String deleteUser(long id) throws Exception {
//		session = sessionFactory.openSession();
//		tx = session.beginTransaction();
//		User user=(User) session.load(User.class, id);  
//		session.delete(user);
//		tx.commit();
//		session.close();
//		return "User deleted successfuly";
//		
//	}
	
	
	@Override
	public String deleteUserProfile(User user) throws Exception{
		session = sessionFactory.openSession();
		long id=user.getId();
		User userObj=(User) session.get(User.class, id);
	   try{
			if (userObj != null) {
				tx = session.beginTransaction();
		        session.delete(userObj);
		        tx.commit();
		        return "User and associated profile deleted successfuly";
		    }
	   }catch (HibernateException e) {
		   if (tx!=null)
			   tx.rollback();
		   e.printStackTrace();	
	   }
	   finally {
		   session.close();
	   }
		return "User and associated profile not deleted.";
	}
}
