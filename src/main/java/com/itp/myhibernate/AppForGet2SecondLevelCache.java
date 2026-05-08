package com.itp.myhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.myhibernate.entity.Student;

public class AppForGet2SecondLevelCache 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();
 	
    	Session session1=factory.openSession();				//brand new session
    	Session session2=factory.openSession();	
    	
    	Student stud1 =session1.get(Student.class, 1);		//DB Query : Yes															
    	System.out.println(stud1);	
    	Student stud2 =session1.get(Student.class, 1);		//DM Query : No		
    	System.out.println(stud2);								
    	
    	System.out.println(stud1==stud2);					//True					
    	
    	Student stud3 = session2.get(Student.class, 1);		//DB Query : No	
    	System.out.println(stud1==stud3);	//deep copy		//False
    	Student stud4 =session2.get(Student.class, 1);		//True
    	System.out.println(stud4==stud3);
    	session1.close();
    	session2.close();
    	factory.close();
    	}
}
