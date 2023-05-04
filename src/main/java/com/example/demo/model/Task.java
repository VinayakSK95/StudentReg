package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String work;
	int status;
	Date date;
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(int id, String work, int status, Date date) {
		super();
		this.id = id;
		this.work = work;
		this.status = status;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", work=" + work + ", status=" + status + ", date=" + date + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
