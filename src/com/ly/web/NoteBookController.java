package com.ly.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.entity.NoteBook;
import com.ly.entity.Result;
import com.ly.entity.User;
import com.ly.service.NoteBookService;

@Controller
@RequestMapping("/notebook")
public class NoteBookController extends BaseController {

	@Resource
	private NoteBookService noteBookService;
	
	@RequestMapping("/findNormal.do")
	@ResponseBody
	public Result findNormal(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<NoteBook> list = 
			noteBookService.findNormalNoteBook(user.getCn_user_id());
		return new Result(list);
	}
	
	@RequestMapping("/findSpecial.do")
	@ResponseBody
	public Result findSpecial(HttpSession session) {
		User user = (User) session.getAttribute("user");
		Map<String, NoteBook> map = 
			noteBookService.findSpecialNoteBook(user.getCn_user_id());
		return new Result(map);
	}
	
	@RequestMapping("/addNoteBook.do")
	@ResponseBody
	public Result addNoteBook(NoteBook noteBook, HttpSession session) {
		User user = (User) session.getAttribute("user");
		noteBook.setCn_user_id(user.getCn_user_id());
		noteBookService.addNoteBook(noteBook);
		return new Result(noteBook);
	}
	
	@RequestMapping("/updateNoteBookName.do")
	@ResponseBody
	public Result updateNoteBookName(NoteBook noteBook) {
		noteBookService.update(noteBook);
		return new Result();
	}
	
	@RequestMapping("/deleteNoteBook.do")
	@ResponseBody
	public Result deleteNoteBook(String noteBookId) {
		noteBookService.deleteNoteBook(noteBookId);
		return new Result();
	}
	
	@RequestMapping("/findList.do")
	@ResponseBody
	public Result findList(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<NoteBook> list = 
			noteBookService.findNoteBookList(user.getCn_user_id());
		return new Result(list);
	}
	
}
