package com.example.eas_ali_taufik.pojo;

import java.util.List;

public class MenuResponse{
	private int totalMenu;
	private List<Menu> result;

	public int getTotalMenu(){
		return totalMenu;
	}

	public List<Menu> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"MenuResponse{" + 
			"total Menu = '" + totalMenu + '\'' + 
			",result = '" + result + '\'' + 
			"}";
		}
}