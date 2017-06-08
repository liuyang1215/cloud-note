package com.ly.dao;

import java.util.List;
import java.util.Map;

import com.ly.entity.Share;
import com.tarena.dao.MyBatisRepository;

@MyBatisRepository
public interface ShareMapper {

	void save(Share share);

	List<Share> findByPage(Map<String, Object> param);
	
	Share findById(String shareId);
	
}
