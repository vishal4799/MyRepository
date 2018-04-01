package com.bmc.utility;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory createSessionFactory(){
		
		AnnotationConfiguration configuration=new AnnotationConfiguration();
		configuration.configure();
		sessionFactory=configuration.buildSessionFactory();
		
		return sessionFactory;
		
	}
	
	public static void closeSessionFactory(){
		sessionFactory.close();
	}

}
