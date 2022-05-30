package com.example.eas_ali_taufik.pojo;

public class Source{
	private String name;
	private String id;

	public String getName(){
		return name;
	}

	public String getId(){
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
