package com.ly.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.common.BaseReader;
import com.ly.entity.Activity;
import com.ly.entity.NoteActivity;
import com.ly.entity.Result;
import com.ly.entity.User;
import com.ly.service.ActivityService;

@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Resource
	private ActivityService activityService;

	@RequestMapping("/findActivity.do")
	@ResponseBody
	public Result findActivity() {
		List<Activity> list = activityService.findAllActivity();
		return new Result(list);
	}
	
	@RequestMapping("/findNoteActivity.do")
	@ResponseBody
	public Result findNoteActivity(String activityId, int currentPage) {
		List<NoteActivity> list = activityService.findNoteActivity(
				activityId, currentPage, BaseReader.getPageSize());
		return new Result(list);
	}
	
	@RequestMapping("/findNoteActivityDetail.do")
	@ResponseBody
	public Result findNoteActivityDetail(String noteActivityId) {
		NoteActivity noteActivity = activityService.findNoteActivity(noteActivityId);
		return new Result(noteActivity);
	}
	
	@RequestMapping("/addNoteActivity.do")
	@ResponseBody
	public Result addNoteActivity(String activityId, String noteId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		NoteActivity noteActivity = 
			activityService.addNoteActivity(activityId, noteId, user.getCn_user_id());
		return new Result(noteActivity);
	}
	
	@RequestMapping("/upNoteActivity.do")
	@ResponseBody
	public Result upNoteActivity(String noteActivityId) {
		activityService.updateForUp(noteActivityId);
		return new Result();
	}
	
	@RequestMapping("/downNoteActivity.do")
	@ResponseBody
	public Result downNoteActivity(String noteActivityId) {
		activityService.updateForDown(noteActivityId);
		return new Result();
	}

}
