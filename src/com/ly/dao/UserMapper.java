package com.ly.dao;

import com.ly.entity.User;

@MyBatisRepository
public interface UserMapper {

	User findByName(String userName);
	
	void save(User user);
	
	void update(User user);
	
}
