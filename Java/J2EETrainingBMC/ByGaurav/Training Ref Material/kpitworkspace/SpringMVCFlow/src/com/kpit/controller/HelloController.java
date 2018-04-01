package com.kpit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	//handler methods
	@RequestMapping(value="hello.htm",method=RequestMethod.GET)
	public ModelAndView handlerMethod(HttpServletRequest request,HttpServletResponse response){
		
		String username=request.getParameter("username");
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("username",username);
		mv.setViewName("/Hello.jsp");
		return mv;
		
		
	}

}
