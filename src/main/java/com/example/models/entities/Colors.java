package com.example.models.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class Colors implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String color_number;
	private String name;
}
