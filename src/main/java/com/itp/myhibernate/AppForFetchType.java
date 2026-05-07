package com.itp.myhibernate;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.myhibernate.entity.Dept;
import com.itp.myhibernate.entity.Employee;

public class AppForFetchType 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();
 	
    	Session session1=factory.openSession();				//brand new session
    	
    	Dept dept1 =session1.get(Dept.class, 1);			//select query 1 to fetch only dept records
    	System.out.println(dept1);
    	
    	System.out.println("Count of Employees in IT Dept " + dept1.getEmployees().size());  //select query again to fetch child records
    	session1.close();
    	factory.close();
    	}
}
