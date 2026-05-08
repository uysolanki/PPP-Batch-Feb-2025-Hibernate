package com.itp.myhibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppForHQL 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure();
    	SessionFactory factory=cfg.buildSessionFactory();
 	
    	Session session1=factory.openSession();				//brand new session
    	Transaction tx=session1.beginTransaction();		
    	

//    	Query q1=session1.createQuery("From Student where rno=1");  //classname
//		q1.setCacheable(true);										//hard coded rno
//		Student s1=(Student)q1.uniqueResult();
//		System.out.println(s1);

//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter rno");			//3
//		int rn=sc.nextInt();
//		
//		Query q2=session1.createQuery("From Student where rno= :k");
//		q2.setParameter("k",rn);
//		Student s2=(Student)q2.uniqueResult();
//		System.out.println(s2);

    	Query q3=session1.createQuery("select rno,sname,per from Student where per>80");  //classname
		List<Object[]> rows = (List<Object[]> ) q3.list();
		for(Object[] row : rows)
		{
			System.out.println(row[0] + " "+ row[1] + " " + row[2]);
		}
		
    	session1.close();
    	factory.close();
    	}
}
