package com.itp.myhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	//cfg.configure("hibernate.cfg.xml");
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();
    	    	
//    	System.out.println(factory.isClosed()); //false
    	
    	Session session1=factory.openSession();
    	Transaction tx=session1.beginTransaction();		//used with DML query


    	session1.close();
    	factory.close();
    	}
}
