package com.ly.dao;

import java.util.List;

import com.ly.entity.NoteBookType;
import com.tarena.dao.MyBatisRepository;

@MyBatisRepository
public interface NoteBookTypeMapper {

	List<NoteBookType> findSpecialType();
	
	List<NoteBookType> findAllType();
	
}
