package com.itp.myhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.myhibernate.entity.Student;

public class AppForLoad 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();
 	
    	Session session1=factory.openSession();				//brand new session
    	
    	
    	Student stud1 =session1.load(Student.class, 1);	//will it query the DB? No
    	System.out.println("Hi");						//proof : No Select will displayed on the console
    	
    	System.out.println(stud1.getRno());	//5			//will it query the DB? No
    	System.out.println("Bye");						// bcoz Id attribute is allready present in the proxy
    	
    	
    	System.out.println(stud1.getSname());			//will it query the DB? Yes
    													// bcoz non Id attribute is not present in the proxy
    													//ObjectNotFoundException
    	
    	Student stud2 =session1.load(Student.class, 1); //will it query the DB? No
    	System.out.println(stud2.getSname());
    	
    	System.out.println(stud1==stud2);  //true
    	session1.close();
    	factory.close();
    	}
}
