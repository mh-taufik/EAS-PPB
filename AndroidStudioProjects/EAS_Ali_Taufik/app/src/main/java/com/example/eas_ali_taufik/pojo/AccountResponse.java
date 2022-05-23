package com.example.eas_ali_taufik.pojo;

public class AccountResponse{
	private String status;
	private String token;

	public String getStatus(){
		return status;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"AccountResponse{" + 
			"status = '" + status + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}
