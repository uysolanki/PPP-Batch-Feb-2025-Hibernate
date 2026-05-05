package com.itp.myhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.myhibernate.entity.Student;

public class AppForBuilder 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();

    	Session session1=factory.openSession();
    	Transaction tx=session1.beginTransaction();		//used with DML query

    	Student s1= Student.builder()
    			.sname("Raj")
    			.per(98.7)
    			.build();
    	
    	session1.save(s1);	//
    	tx.commit();
    	
    	session1.close();
    	factory.close();
    	}
}
