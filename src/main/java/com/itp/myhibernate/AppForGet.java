package com.itp.myhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.myhibernate.entity.Student;

public class AppForGet 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();
 	
    	Session session1=factory.openSession();				//brand new session
    	Transaction tx=session1.beginTransaction();		
    	
    	Student stud1 =session1.get(Student.class, 1);			//will it query the DB? Yes
    															//proof : Select will displayed on the console
    	System.out.println(stud1);	
    	Student stud2 =session1.get(Student.class, 1);			//will it query the DB? No
    	System.out.println(stud2);								//bcoz it is already present in session 1 cache
    	
    	System.out.println(stud1==stud2);						//ref comparison : true
    	
    	Student stud3 =session1.get(Student.class, 5);			//null
    	System.out.println(stud3);
    	session1.close();
    	factory.close();
    	}
}
