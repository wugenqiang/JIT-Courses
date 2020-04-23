package com.sjtu.service;

import com.sjtu.dao.UserDao;
import com.sjtu.model.User;
import org.acegisecurity.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * 
 * <p>
 * <a href="UserManager.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by
 *         <a href="mailto:dan@getrolling.com">Dan Kibler </a>
 */
public interface UserManager {

	public void setUserDao(UserDao userDao);

	/**
	 * Retrieves a user by userId. An exception is thrown if user not found
	 * 
	 * @param userId
	 * @return User
	 */
	public User getUser(String userId);

	/**
	 * Finds a user by their username.
	 * 
	 * @param username
	 * @return User a populated user object
	 */
	public User getUserByUsername(String username)
			throws UsernameNotFoundException;

	/**
	 * Retrieves a list of users, filtering with parameters on a user object
	 * 
	 * @param user
	 *            parameters to filter on
	 * @return List
	 */
	public List getUsers(User user);

	/**
	 * Saves a user's information
	 * 
	 * @param user
	 *            the user's information
	 * @throws UserExistsException
	 */
	public void saveUser(User user) throws UserExistsException;

	/**
	 * Removes a user from the database by their userId
	 * 
	 * @param userId
	 *            the user's id
	 */
	public void removeUser(String userId);
}
