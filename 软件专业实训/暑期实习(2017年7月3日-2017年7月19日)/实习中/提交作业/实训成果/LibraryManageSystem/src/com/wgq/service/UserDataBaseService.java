package com.wgq.service;

import com.wgq.entity.User;

public interface UserDataBaseService {
	
	public User queryUser(User user);
	public int registerUser(User user);

}
