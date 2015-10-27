package com.impressico.dao;

import java.util.List;

import com.impressico.model.User;

public interface UserDao {
	public User getUserById(long id) throws Exception;
	public List<User> getUserList() throws Exception;
	public String addUser(User user) throws Exception;
	public String updateUser(User user) throws Exception;
	public String deleteUser(User user) throws Exception ;
//	public String deleteUser(long id) throws Exception ;
	public String deleteUserProfile(User user) throws Exception;
}
