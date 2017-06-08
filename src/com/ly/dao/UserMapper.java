package com.ly.dao;

import com.ly.entity.User;
import com.tarena.dao.MyBatisRepository;

@MyBatisRepository
public interface UserMapper {

	User findByName(String userName);
	
	void save(User user);
	
	void update(User user);
	
}
