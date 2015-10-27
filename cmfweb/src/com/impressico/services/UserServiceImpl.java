package com.impressico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.impressico.dao.UserDao;
import com.impressico.dao.UserProfileDao;
import com.impressico.model.User;
import com.impressico.model.UserProfile;

public class UserServiceImpl implements UserService{

	@Autowired UserDao userDao;
	@Autowired UserProfileDao userProfileDao;
	
	@Override
	public User getUserById(long id) throws Exception {
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getUserList() throws Exception {
		return userDao.getUserList();
	}
	
	@Override
	public UserProfile getUserProfileById(long id) throws Exception {
		return userProfileDao.getUserProfileById(id);
	}

	@Override
	public List<UserProfile> getUserProfileList() throws Exception {
		return userProfileDao.getUserProfileList();
	}
	
	@Override
	public String addUser(final User user) throws Exception{
		User userObj=new User(); 
		userObj.setEmail(user.getEmail());
		userObj.setPhone(user.getPhone());
		userObj.setDisplayName(user.getDisplayName());
		userObj.setPassword(user.getPassword());
		return userDao.addUser(userObj);
	}

	@Override
	public String addUserProfile(UserProfile userProfile) throws Exception{
		UserProfile userProfileObj= new UserProfile();
		userProfileObj.setFirstName(userProfile.getFirstName());
		userProfileObj.setLastName(userProfile.getLastName());
		userProfileObj.setCountry(userProfile.getCountry());
		userProfileObj.setAddress(userProfile.getAddress());
		userProfileObj.setCity(userProfile.getCity());
		userProfileObj.setProvince(userProfile.getProvince());
		userProfileObj.setPostcode(userProfile.getPostcode());
		userProfileObj.setAvatar(userProfile.getAvatar());
//		userProfileObj.setUserId(userProfile.getUserId());
		return userProfileDao.addUserProfile(userProfileObj);
	}
	
	@Override
	 public String updateUser(User user) throws Exception{
		User userObj=new User(); 
		userObj.setId(user.getId());
		userObj.setEmail(user.getEmail());
		userObj.setPhone(user.getPhone());
		userObj.setDisplayName(user.getDisplayName());
		userObj.setPassword(user.getPassword());
		System.out.println("***********user detail updated ");
		return userDao.updateUser(userObj);
	 }
	
	@Override
	 public String updateProfile(UserProfile userProfile) throws Exception{
		UserProfile userProfileObj= new UserProfile();
		userProfileObj.setId(userProfile.getId());
		userProfileObj.setFirstName(userProfile.getFirstName());
		userProfileObj.setLastName(userProfile.getLastName());
		userProfileObj.setCountry(userProfile.getCountry());
		userProfileObj.setAddress(userProfile.getAddress());
		userProfileObj.setCity(userProfile.getCity());
		userProfileObj.setProvince(userProfile.getProvince());
		userProfileObj.setPostcode(userProfile.getPostcode());
		userProfileObj.setAvatar(userProfile.getAvatar());
//		userProfileObj.setUserId(userProfile.getUserId());
		System.out.println("***********userProfile detail updated ");
		return userProfileDao.updateProfile(userProfileObj);
	 }
	

	@Override
	public String deleteUser(final User user) throws Exception {
		User userObj= new User();
		userObj.setId(user.getId());
		return userDao.deleteUser(userObj);
	}
	
//	@Override
//	public String deleteUser(long id) throws Exception {
//		return userDao.deleteUser(id);
//	}
	
	@Override
	public String deleteProfile(final UserProfile userProfile) throws Exception {
		UserProfile userProfileObj= new UserProfile();
		userProfileObj.setId(userProfile.getId());
		return userProfileDao.deleteProfile(userProfile);
	}
	
	@Override
	public String deleteUserProfile(final User user) throws Exception {
		User userObj= new User();
		userObj.setId(user.getId());
		return userDao.deleteUserProfile(userObj);
	}

	@Override
	public void doSomeTask() {
		System.out.println("this is the new method");
		System.out.println("call for doing something");
		
	}
}
