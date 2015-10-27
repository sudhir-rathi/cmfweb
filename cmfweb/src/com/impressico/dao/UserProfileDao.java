package com.impressico.dao;

import java.util.List;

import com.impressico.model.UserProfile;


public interface UserProfileDao {
	public UserProfile getUserProfileById(long id) throws Exception;
	public List<UserProfile> getUserProfileList() throws Exception;
	public String addUserProfile(UserProfile userProfile) throws Exception;
	public String updateProfile(UserProfile userProfile) throws Exception;
	public String deleteProfile(UserProfile userProfile) throws Exception ;
}
