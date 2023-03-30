package com.reqres.webclient.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Resource {

	@JsonProperty("data")
	private ResourceData data;

	public ResourceData getData(){
		return data;
	}

	public void setData(ResourceData data) {
		this.data = data;
	}
}