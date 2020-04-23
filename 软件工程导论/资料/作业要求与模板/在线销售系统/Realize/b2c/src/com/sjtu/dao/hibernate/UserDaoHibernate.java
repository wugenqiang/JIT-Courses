package com.sjtu.dao.hibernate;

import com.sjtu.dao.UserDao;
import com.sjtu.model.User;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.springframework.orm.ObjectRetrievalFailureException;

import java.util.List;

/**
 * This class interacts with Spring's HibernateTemplate to save/delete and
 * retrieve User objects.
 * 
 * <p>
 * <a href="UserDaoHibernate.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by
 *         <a href="mailto:dan@getrolling.com">Dan Kibler</a> Extended to
 *         implement Acegi UserDetailsService interface by David Carter
 *         david@carter.net
 */
public class UserDaoHibernate extends BaseDaoHibernate implements UserDao,
		UserDetailsService {
	/**
	 * @see com.sjtu.dao.UserDao#getUser(Long)
	 */
	public User getUser(Long userId) {
		User user = (User) getHibernateTemplate().get(User.class, userId);

		if (user == null) {
			log.warn("uh oh, user '" + userId + "' not found...");
			throw new ObjectRetrievalFailureException(User.class, userId);
		}

		return user;
	}

	/**
	 * @see com.sjtu.dao.UserDao#getUsers(com.sjtu.model.User)
	 */
	public List getUsers(User user) {
		return getHibernateTemplate().find(
				"from User u order by upper(u.username)");
	}

	/**
	 * @see com.sjtu.dao.UserDao#saveUser(com.sjtu.model.User)
	 */
	public void saveUser(final User user) {
		if (log.isDebugEnabled()) {
			log.debug("user's id: " + user.getId());
		}

		getHibernateTemplate().saveOrUpdate(user);
		// necessary to throw a DataIntegrityViolation and catch it in
		// UserManager
		getHibernateTemplate().flush();
	}

	/**
	 * @see com.sjtu.dao.UserDao#removeUser(Long)
	 */
	public void removeUser(Long userId) {
		getHibernateTemplate().delete(getUser(userId));
	}

	/**
	 * @see org.acegisecurity.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		List users = getHibernateTemplate().find("from User where username=?",
				username);
		if (users == null || users.isEmpty()) {
			throw new UsernameNotFoundException("user '" + username
					+ "' not found...");
		} else {
			return (UserDetails) users.get(0);
		}
	}
}
