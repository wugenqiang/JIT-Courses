package com.wgq.dao;

import com.wgq.entity.User;

public interface UserDataBaseDao {
	
	public User queryUser(User user);
	public int registerUser(User user);
}
