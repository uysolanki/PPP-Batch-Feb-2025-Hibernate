package com.itp.myhibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity	//will create a table by the name of the class in the database
public class Student {
	
	@Id
	private int rno;
	private String sname;
	private double per;
	
	public Student() {} //NoArgsConstructor
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
