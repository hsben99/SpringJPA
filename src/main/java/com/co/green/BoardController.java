package com.co.green;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.BService;
import vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BService service;

	@RequestMapping(value = "/blist")
	public ModelAndView blist(ModelAndView mv, HttpServletRequest request) {
		// redirect로 온경우 메시지 처리
		if (request.getParameter("message") != null) {
			mv.addObject("message", request.getParameter("message"));
		}

		List<BoardVO> list = new ArrayList<BoardVO>();
		list = service.selectList();
		if (list != null) {
			mv.addObject("list", list);
		} else {
			mv.addObject("message", "출력할 자료가 없네용?ㅎㅎ");
		}
		mv.setViewName("board/boardList");
		return mv;
	}// blist

}
