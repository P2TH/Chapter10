package com.mycompany.Chapter10.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.Chapter10.user.UserDAO;
import com.mycompany.Chapter10.user.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(@ModelAttribute("user") UserVO vo, HttpSession session) {
		
		List<UserVO> user = userDAO.getUser(vo);
		if( user.isEmpty() ) {
			vo.setId("ID를 입력하세요");
			return "login";
		} else {
			session.setAttribute("userID", user.get(0).getId());
			return "redirect:getBoardList.do";
		}
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView() {
		return "login";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession sess) {
		sess.invalidate();
		return "login";
	}

}
