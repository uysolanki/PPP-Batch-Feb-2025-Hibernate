package com.itp.myhibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity	//will create a table by the name of the class in the database
        //by default table name == class name
@Table(name="mystudent")
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
	public Student() {
		int x;		//local scope
	} //NoArgsConstructor
	public Student(int rno, String sname, double per) //AllArgsConstructor
	{
		super();
		this.rno = rno;
		this.sname = sname;
		this.per = per;
	}
	public int getRno() {				//Getter
		return rno;
	}
	public void setRno(int rno) {		//Setter
		this.rno = rno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}
	@Override
	public String toString() {
		return "Student [rno=" + rno + ", sname=" + sname + ", per=" + per + "]";
	}
	
	

}


/* A  create table emp(eno int(5) pk, ename v(100)... */

/* B create table emp(
 * eno int(5) pk,
 * ename v(10)
 */
