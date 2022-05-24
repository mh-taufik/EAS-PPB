package com.example.eas_ali_taufik.pojo;

public class Source{
	private String name;
	private int id;

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Source{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
