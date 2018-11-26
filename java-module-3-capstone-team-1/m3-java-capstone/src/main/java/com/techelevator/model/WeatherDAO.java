package com.techelevator.model;

import java.util.List;

public interface WeatherDAO {
	

	List<Weather> getAllWeather(String parkCode);
	
	public int tempConversion();
}

