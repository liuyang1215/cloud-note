package com.ly.dao;

import java.util.List;
import java.util.Map;

import com.ly.entity.Activity;
import com.ly.entity.NoteActivity;


@MyBatisRepository
public interface ActivityMapper {

	List<Activity> findAll();

	List<NoteActivity> findNoteActivityByPage(Map<String, Object> param);
	
	NoteActivity findNoteActivityById(String id);
	
	void saveNoteActivity(NoteActivity noteActivity);
	
	void updateNoteActivity(NoteActivity noteActivity);
	
}
