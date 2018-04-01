package com.kpit.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.kpit.controller.HelloController;

public class TestHelloController {
	
	private HelloController controller;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void setUp() throws Exception {
		//because HelloController is POJO
		//not possible in case of Servlet
		controller=new HelloController();
		request=new MockHttpServletRequest();
		response=new MockHttpServletResponse();
	}

	@After
	public void tearDown() throws Exception {
		controller=null;
		request=null;
		response=null;
	}

	@Test
	public void testHandlerMethod() {
		
		request.setParameter("username", "amit");
		ModelAndView mv=controller.handlerMethod(request, response);
		assertEquals("/Hello.jsp",mv.getViewName());
		
	}

}
