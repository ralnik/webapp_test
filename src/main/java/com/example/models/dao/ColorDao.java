package com.example.models.dao;

import java.util.List;

import com.example.models.entities.Colors;

public interface ColorDao {
	List<Colors> getColors();
	
	String getInfo(String param);
}
