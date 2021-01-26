package com.kmmall.bean;

public class Atype {
	private int id;
	private String name;
	private int aid;
	public Atype() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Atype(int id, String name, int aid) {
		super();
		this.id = id;
		this.name = name;
		this.aid = aid;
	}
	public Atype(String name, int aid) {
		super();
		this.name = name;
		this.aid = aid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	@Override
	public String toString() {
		return "Atype [id=" + id + ", name=" + name + ", aid=" + aid + "]"+"\n";
	}

	
}