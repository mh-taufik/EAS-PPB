package com.example.eas_ali_taufik.pojo;

import java.util.List;

public class RestaurantResponse {
	private int totalRestaurants;
	private List<Restaurant> result;

	public int getTotalRestaurants(){
		return totalRestaurants;
	}

	public List<Restaurant> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"total Restaurants = '" + totalRestaurants + '\'' + 
			",result = '" + result + '\'' + 
			"}";
		}
}