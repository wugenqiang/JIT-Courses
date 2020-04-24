package com.wgq.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wgq.dao.UserDataBaseDao;
import com.wgq.entity.User;
import com.wgq.service.UserDataBaseService;

@Service
public class UserDataBaseServiceImpl implements UserDataBaseService {

	@Resource
	private UserDataBaseDao dao;
	@Override
	public User queryUser(User user) {
		
		return dao.queryUser(user);
	}
	@Override
	public int registerUser(User user){
		return dao.registerUser(user);
	}
}