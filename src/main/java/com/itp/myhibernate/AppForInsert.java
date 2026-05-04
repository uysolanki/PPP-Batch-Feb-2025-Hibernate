package com.itp.myhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.myhibernate.entity.Student;

public class AppForInsert 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();

    	Session session1=factory.openSession();
    	Transaction tx=session1.beginTransaction();		//used with DML query

    	Student s1=new Student(1,"Alice",78.5);  //insert into student values(1,"Alice",78.5)
    	session1.save(s1);	//
    	tx.commit();
    	
    	session1.close();
    	factory.close();
    	}
}
