package com.example.myspringbootapp;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
	
	public static final String SUCCESS = "Success";
	private String status;
	private String description;

	public Response(String status, String description) {
		this.status = status;
		this.description = description;
	}


}
