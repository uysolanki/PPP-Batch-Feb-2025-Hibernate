package com.itp.myhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.itp.myhibernate.entity.ChiefMinister;
import com.itp.myhibernate.entity.State;
import com.itp.myhibernate.entity.Student;

public class AppForOneToOne 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();
 	
    	Session session1=factory.openSession();				//brand new session
    	Transaction tx=session1.beginTransaction();		
    	
    	ChiefMinister cm1=ChiefMinister.builder()
    			.cmname("Fadnavis")
    			.age(55)
    			.build();
    	
    	ChiefMinister cm2=ChiefMinister.builder()
    			.cmname("Sharma")
    			.age(60)
    			.build();
    	
    	ChiefMinister cm3=ChiefMinister.builder()
    			.cmname("Patel")
    			.age(65)
    			.build();
    	
    	State state1=State.builder()
    			.sname("Maharashtra")
    			.capital("Mumbai")
    			.chiefMinister(cm1)
    			.build();
    	

    	State state2=State.builder()
    			.sname("Rajasthan")
    			.capital("Jaipur")
    			.chiefMinister(cm2)
    			.build();
    	

    	State state3=State.builder()
    			.sname("Gujarat")
    			.capital("Ahmedabad")
    			.chiefMinister(cm3)
    			.build();
    	
    	session1.save(state1);
    	session1.save(state2);
    	session1.save(state3);
    	tx.commit();
    	session1.close();
    	factory.close();
    	}
}
