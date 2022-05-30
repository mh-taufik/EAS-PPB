package com.example.eas_ali_taufik.pojo;

import java.util.List;

public class NewsResponse{
	private int totalResults;
	private List<News> articles;
	private String status;

	public int getTotalResults(){
		return totalResults;
	}

	public List<News> getArticles(){
		return articles;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"NewsResponse{" + 
			"totalResults = '" + totalResults + '\'' + 
			",articles = '" + articles + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}