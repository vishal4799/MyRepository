package com.bmc.works.HibernateExample;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bmc.utility.HibernateUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory=HibernateUtils.getSessionFactory();
    }
}
