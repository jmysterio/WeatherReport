package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {
			Park aPark = mapRowSetToPark(results);
			allParks.add(aPark);
		}
		return allParks;
	}

	@Override
	public Park getAPark(String parkCode) {
		String sqlSelectAParks = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAParks, parkCode.toUpperCase());
		Park aPark = null;
		while (results.next()) {
			aPark = mapRowSetToPark(results);
		}
		return aPark;
	}

	private Park mapRowSetToPark(SqlRowSet results) {
		Park aPark = new Park();
		aPark.setParkCode(results.getString("parkcode"));
		aPark.setParkname(results.getString("parkname"));
		aPark.setState(results.getString("state"));
		aPark.setAcreage(results.getInt("acreage"));
		aPark.setElevationInFeet(results.getInt("elevationinfeet"));
		aPark.setMilesOfTrail(results.getDouble("milesoftrail"));
		aPark.setNumberOfCampsites(results.getInt("numberofcampsites"));
		aPark.setClimate(results.getString("climate"));
		aPark.setYearFounded(results.getInt("yearfounded"));
		aPark.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		aPark.setInspirationalQuote(results.getString("inspirationalquote"));
		aPark.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		aPark.setParkDescription(results.getString("parkdescription"));
		aPark.setEntryFee(results.getInt("entryfee"));
		aPark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		return aPark;
	}

}
