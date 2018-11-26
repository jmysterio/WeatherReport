package com.techelevator.model;

import java.util.List;

public interface ParkDAO {
	public List<Park> getAllParks();
//	public void save(Park aPark);
	public Park getAPark(String parkCode);
}
