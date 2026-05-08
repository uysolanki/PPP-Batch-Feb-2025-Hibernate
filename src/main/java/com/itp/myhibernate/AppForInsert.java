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

    	Student s1=new Student();  //insert into student values(1,"Alice",78.5)
    	s1.setPer(88.5);
    	s1.setSname("Frank");
    	
    	Student s2=new Student();  //insert into student values(1,"Alice",78.5)
    	s2.setPer(98.5);
    	s2.setSname("David");
    	
    	Student s3=new Student();  //insert into student values(1,"Alice",78.5)
    	s3.setPer(78.5);
    	s3.setSname("Ben");
    	
    	Student s4=new Student();  //insert into student values(1,"Alice",78.5)
    	s4.setPer(68.5);
    	s4.setSname("George");
    	session1.save(s1);	//
    	session1.save(s2);	
    	session1.save(s3);	
    	session1.save(s4);	
    	tx.commit();
    	
    	session1.close();
    	factory.close();
    	}
}
