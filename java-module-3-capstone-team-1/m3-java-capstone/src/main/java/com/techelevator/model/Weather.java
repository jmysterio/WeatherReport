package com.techelevator.model;

public class Weather {

	private String parkCode;
	private int fiveDayForecastValue;
	private int low;
	private int high;
	private String forecast;
	private String advisory = "no advisory";
	private int celsiusHigh;
	private int celsiusLow;
	public Weather() {

	}

//	public Weather(String parkCode, int fiveDayForecastValue, int low, int high, String forecast) {
//		this.parkCode = parkCode;
//		this.fiveDayForecastValue = fiveDayForecastValue;
//		this.low = low;
//		this.high = high;
//		this.forecast = forecast;
//		this.advisory = chooseAdvisory(forecast);
//	}

	private String chooseAdvisory(String forecast) {
		String advisory = "Do What You Want 'merica!";
		switch (forecast) {
		case "snow":
			advisory = "Make sure you pack your snowshoes! ";
			break;
		case "rain":
			advisory = "Make sure to pack rain gear and waterproof shoes! ";
			break;
		case "thunderstorms":
			advisory = "Thunderstorms expected. Seek shelter and avoid hiking on exposed ridges. ";
			break;
		case "sunny":
			advisory = "Make sure to pack your sunblock! ";
			// break;
			if (high >= 75) {
				advisory += "Bring an extra gallon of water. ";
			}
			if (high - low >= 20) {
				advisory += "Bring breathable layers. ";
			}
			if (low < 20) {
				advisory += "Frigid temperatures expected. Bring extra layers. ";
			}
		}
		return advisory;
	}

//	public int getCelsiusHigh(int high) {
//double dHigh = (double) high;
//		celsiusHigh = (int) (((dHigh - 32) * 5.0) / 9.0);
//		int answer = (int)celsiusHigh;
//		return answer;
//
//	}
//
//	
//
//	public int getCelsiusLow(int low) {
//		double dLow = (double) low;
//		celsiusLow = (int) (((dLow - 32) * 5.0) / 9.0);
//		int answer = (int)celsiusLow;
//		return answer;
//
//	}
	
	public static int convertToCelsius(int temp) {
		
		return (int)((temp- 32) * (5.0 / 9.0));
	}
	
	//GETS AND SETS

//	public int getCelsius() {
//		return celsius;
//	}
//
//	public void setCelsius(int celsius) {
//		this.celsius = celsius;
//	}
	public void setCelsiusLow(int low) {
		this.celsiusLow = celsiusLow;
	}
	
	public int getCelsiusHigh() {
		return celsiusHigh;
	}

	public void setCelsiusHigh(int high) {
		this.celsiusHigh = celsiusHigh;
	}

	public int getCelsiusLow() {
		return celsiusLow;
	}
	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}

	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public String getAdvisory() {
		return advisory;
	}

	public void setAdvisory(String forecast) {
		this.advisory = chooseAdvisory(forecast);
	}

}
