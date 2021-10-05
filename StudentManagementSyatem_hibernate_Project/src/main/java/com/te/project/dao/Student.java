package com.te.project.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="studentdata")
public class Student implements Serializable{
	@Id
	private int rollno;
	private String name;
	private String phoneno;
	private String standard;
	
	

}
