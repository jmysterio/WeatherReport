<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/commonHeader.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>




<h1>${details.parkname}</h1>



<div id="park-detail">

	<c:set var="img" value="${details.parkCode}" />
	<c:set var="imgToLowerCase" value="${fn:toLowerCase(img)}" />
	<img src="img/parks/${imgToLowerCase}.jpg" />

	<ul>
		<li><b>${details.parkname}, ${details.state}</b></li>

		<li><b>Elevation in feet:</b> ${details.elevationInFeet}</li>
		<li><b>Acreage:</b> ${details.acreage}</li>
		<li><b>Miles of trail:</b> ${details.milesOfTrail}</li>
		<li><b>Number of camp sites:</b> ${details.numberOfCampsites}</li>
		<li><b>Climate:</b> ${details.climate}</li>
		<li><b>Year founded:</b> ${details.yearFounded}</li>
		<li><b>Annual Visitors:</b> ${details.annualVisitorCount}</li>
		<li>"${details.inspirationalQuote}"</li>
		<li>~ ${details.inspirationalQuoteSource}</li>
		<li><b>Park Description:</b> ${details.parkDescription}</li>
		<li><b>Entry fee:</b> $${details.entryFee}</li>
		<li><b>Number of Animal Species:</b>
			${details.numberOfAnimalSpecies}</li>

	</ul>

</div>
<div>
<c:url var="detailUrl" value="/parkDetail?parkCode=${details.parkCode}"/>
<form action="${detailUrl}" method="POST">
<input type="radio" name="degrees" value="true" checked/>Fahrenheit
<input type="radio" name="degrees" value="false"/>Celsius
<input type="submit" 				value="Submit"/>



</form>
</div>
<div>

	<c:forEach var="weather" items="${allWeather}" >
	<img src="img/weather/${weather.forecast}.png" />
  ${weather.forecast}
  
  <p>${weather.advisory}</p>
 
  <p>High: ${weather.high} degrees </p>
  <p>Low: ${weather.low} degrees</p>
  

</c:forEach>

</div>



<%@include file="/WEB-INF/jsp/commonFooter.jsp"%>
