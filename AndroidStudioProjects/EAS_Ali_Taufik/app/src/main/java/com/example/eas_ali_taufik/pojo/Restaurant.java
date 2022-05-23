package com.example.eas_ali_taufik.pojo;

import java.util.List;

public class Restaurant {
	private String image;
	private boolean parkinglot;
	private String imageId;
	private String address;
	private List<Object> foodMenu;
	private int averagecost;
	private int reviews;
	private String phone;
	private int V;
	private String restauranttype;
	private String businessname;
	private String location;
	private String id;
	private String slug;
	private String email;
	private String menu;
	private String website;

	public String getImage(){
		return image;
	}

	public boolean isParkinglot(){
		return parkinglot;
	}

	public String getImageId(){
		return imageId;
	}

	public String getAddress(){
		return address;
	}

	public List<Object> getFoodMenu(){
		return foodMenu;
	}

	public int getAveragecost(){
		return averagecost;
	}

	public int getReviews(){
		return reviews;
	}

	public String getPhone(){
		return phone;
	}

	public int getV(){
		return V;
	}

	public String getRestauranttype(){
		return restauranttype;
	}

	public String getBusinessname(){
		return businessname;
	}

	public String getLocation(){
		return location;
	}

	public String getId(){
		return id;
	}

	public String getSlug(){
		return slug;
	}

	public String getEmail(){
		return email;
	}

	public String getMenu(){
		return menu;
	}

	public String getWebsite(){
		return website;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"image = '" + image + '\'' + 
			",parkinglot = '" + parkinglot + '\'' + 
			",imageId = '" + imageId + '\'' + 
			",address = '" + address + '\'' + 
			",foodMenu = '" + foodMenu + '\'' + 
			",averagecost = '" + averagecost + '\'' + 
			",reviews = '" + reviews + '\'' + 
			",phone = '" + phone + '\'' + 
			",__v = '" + V + '\'' + 
			",restauranttype = '" + restauranttype + '\'' + 
			",businessname = '" + businessname + '\'' + 
			",location = '" + location + '\'' + 
			",_id = '" + id + '\'' + 
			",id = '" + id + '\'' + 
			",slug = '" + slug + '\'' + 
			",email = '" + email + '\'' + 
			",menu = '" + menu + '\'' + 
			",website = '" + website + '\'' + 
			"}";
		}
}