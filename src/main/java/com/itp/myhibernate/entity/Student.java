package com.itp.myhibernate.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity	//will create a table by the name of the class in the database
        //by default table name == class name
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Builder
@Table(name="mystudent")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="rollnumber")			//scope? local/Instance/class
	private int rno;				//instance
	private String sname;			//instance
	private double per;				//instance
	
	@Transient
	private int temp;				//instance - it will be excluded in the db table
	
	static String schoolName="Kendra Vidhyalay";		//class
	
	

}


/* A  create table emp(eno int(5) pk, ename v(100)... */

/* B create table emp(
 * eno int(5) pk,
 * ename v(10)
 * 
 * lombok
 */
