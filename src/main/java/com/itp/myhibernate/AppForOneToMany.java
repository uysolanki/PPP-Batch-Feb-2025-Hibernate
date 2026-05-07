package com.itp.myhibernate;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.myhibernate.entity.Dept;
import com.itp.myhibernate.entity.Employee;

public class AppForOneToMany 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();
 	
    	Session session1=factory.openSession();				//brand new session
    	Transaction tx=session1.beginTransaction();		
    	
    	Employee e1=Employee.builder()
    			.ename("Alice")
    			.salary(800.0)
    			.build();
    	
    	Employee e2=Employee.builder()
    			.ename("Ben")
    			.salary(900.0)
    			.build();
    	
    	Employee e3=Employee.builder()
    			.ename("Chris")
    			.salary(1000.0)
    			.build();
    	
    	
    	Employee e4=Employee.builder()
    			.ename("David")
    			.salary(1100.0)
    			.build();
    	
    	Dept d1=Dept.builder()
    			.dname("IT")
    			.city("Pune")
    			.employees(new ArrayList(Arrays.asList(e1,e2)))
    			.build();
    	
    	Dept d2=Dept.builder()
    			.dname("Sales")
    			.city("Delhi")
    			.employees(new ArrayList(Arrays.asList(e3,e4)))
    			.build();
    	
    	session1.save(d1);
    	session1.save(d2);
    	tx.commit();
    	session1.close();
    	factory.close();
    	}
}
