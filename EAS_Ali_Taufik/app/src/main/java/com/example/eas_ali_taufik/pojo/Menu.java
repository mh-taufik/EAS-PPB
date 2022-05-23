package com.example.eas_ali_taufik.pojo;

import java.util.List;

public class Menu {
	private List<String> images;
	private String menuname;
	private int V;
	private String description;
	private String id;

	public List<String> getImages(){
		return images;
	}

	public String getMenuname(){
		return menuname;
	}

	public int getV(){
		return V;
	}

	public String getDescription(){
		return description;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"images = '" + images + '\'' + 
			",menuname = '" + menuname + '\'' + 
			",__v = '" + V + '\'' + 
			",description = '" + description + '\'' + 
			",_id = '" + id + '\'' + 
			"}";
		}
}