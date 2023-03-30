package com.reqres.webclient.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

	@JsonProperty("data")
	private Data data;

	public Data getData(){
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}