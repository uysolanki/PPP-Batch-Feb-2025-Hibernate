package com.itp.myhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.myhibernate.entity.ChiefMinister;
import com.itp.myhibernate.entity.State;
import com.itp.myhibernate.entity.Student;

public class AppForOneToOneDelete 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();
 	
    	Session session1=factory.openSession();				//brand new session
    	Transaction tx=session1.beginTransaction();		
    	
//    	State st1=session1.get(State.class, 1);
//    	session1.delete(st1);
    	
    	ChiefMinister cm=session1.get(ChiefMinister.class, 2);
    	session1.delete(cm);
    	tx.commit();
    	session1.close();
    	factory.close();
    	}
}
