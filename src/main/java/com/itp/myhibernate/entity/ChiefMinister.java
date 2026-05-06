package com.itp.myhibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class ChiefMinister {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cmno;
	private String cmname;
	private int age;
}
