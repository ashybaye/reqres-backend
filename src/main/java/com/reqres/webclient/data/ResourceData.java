package com.reqres.webclient.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResourceData{

	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("year")
	private String year;

	@JsonProperty("color")
	private String color;

	@JsonProperty("pantone_value")
	private String pantoneValue;

	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public String getYear(){
		return year;
	}

	public String getColor(){
		return color;
	}

	public String getPantoneValue(){
		return pantoneValue;
	}	
}