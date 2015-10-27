package com.impressico.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impressico.model.UserProfile;


@Repository("userProfileDao")
public class UserProfileDaoImpl implements UserProfileDao{
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public UserProfile getUserProfileById(long id) throws Exception {
		System.out.println("in ");
		session = sessionFactory.openSession();
		System.out.println("session object"+session);
		UserProfile profile = (UserProfile) session.load(UserProfile.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return profile;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserProfile> getUserProfileList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<UserProfile> userProfileList = session.createCriteria(UserProfile.class)
				.list();
		tx.commit();
		session.close();
		return userProfileList;
	}
	
	@Override
	public String addUserProfile(UserProfile userProfile) throws Exception{
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(userProfile);
		tx.commit();
		session.close();
		return "user profile data save successfuly";
	}
	
	@Override
	public String updateProfile(UserProfile userProfile) throws Exception{
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(userProfile);
		tx.commit();
		session.close();
		return "User Profile Updated successfuly";
	}
	
	@Override
	public String deleteProfile(UserProfile userProfile) throws Exception{
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.delete(userProfile);
		tx.commit();
		session.close();
		return "User Profile deleted successfuly";
	}
	
}
