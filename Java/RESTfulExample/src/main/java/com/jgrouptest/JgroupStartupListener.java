package com.jgrouptest;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JgroupStartupListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		JgroupTask j = new JgroupTask();
		try {
			j.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
    
}