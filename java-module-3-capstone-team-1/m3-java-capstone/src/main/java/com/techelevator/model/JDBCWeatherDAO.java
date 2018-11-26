package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCWeatherDAO implements WeatherDAO {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public List<Weather> getAllWeather(String parkCode) {

		List<Weather> allWeather = new ArrayList<>();
		String sqlSelectAllWeather = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllWeather, parkCode.toUpperCase());
		while (results.next()) {
			Weather theWeather = mapRowSetToWeather(results);
			allWeather.add(theWeather);
		}
		return allWeather;
	}


	private Weather mapRowSetToWeather(SqlRowSet results) {

		
		Weather theWeather = new Weather();
		theWeather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		theWeather.setParkCode(results.getString("parkcode"));
		theWeather.setForecast(results.getString("forecast"));
		theWeather.setHigh(results.getInt("high"));
		theWeather.setLow(results.getInt("low"));
		theWeather.setAdvisory(theWeather.getForecast());
		theWeather.setCelsiusHigh(theWeather.getCelsiusHigh());
		theWeather.setCelsiusLow(theWeather.getCelsiusLow());
		return theWeather;
	}
	
	public int tempConversion() {
		return 0;
	}

}
