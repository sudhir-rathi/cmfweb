package com.impressico.services;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.impressico.model.User;
import com.impressico.model.UserProfile;

@WebService(serviceName = "userServices")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public interface UserService {

	@POST
	@Path("/saveuser")
	public String addUser(final User user) throws Exception;
	
	@POST
	@Path("/saveprofile")
	public String addUserProfile(final UserProfile userProfile) throws Exception;
	
	@PUT
    @Path("/updateuser")
    public String updateUser(final User user) throws Exception ;
	
	@PUT
    @Path("/updateprofile")
    public String updateProfile(final UserProfile userProfile) throws Exception ;
	
	@DELETE
	@Path("/deleteuser")
	public String deleteUser(final User user) throws Exception ;

//	@DELETE
//	@Path("/deleteuser/{id}")
//	public String deleteUser(@PathParam("id") long id) throws Exception ;

	@DELETE
	@Path("/deleteprofile")
	public String deleteProfile(final UserProfile userProfile) throws Exception ;
	
	
	@DELETE
	@Path("/deleteuserprofile")
	public String deleteUserProfile(User user) throws Exception;
	
	
	@GET
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON  , MediaType.APPLICATION_XML})
	@Path("/user/{id}")
	public User getUserById(@PathParam("id") long id) throws Exception;
	
	@GET
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON  , MediaType.APPLICATION_XML})
	@Path("/user")
	public List<User> getUserList() throws Exception;
	
	@GET
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON  , MediaType.APPLICATION_XML})
	@Path("/user/profile/{id}")
	public UserProfile getUserProfileById(@PathParam("id") long id) throws Exception;
	
	@GET
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON  , MediaType.APPLICATION_XML})
	@Path("/user/profile")
	public List<UserProfile> getUserProfileList() throws Exception;
	
	@GET
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON  , MediaType.APPLICATION_XML})
	@Path("/user/doSomeThing")
	public void doSomeTask();
	
}
