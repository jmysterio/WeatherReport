<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="pageTitle" value="Parks Homepage" />
<%@include file="/WEB-INF/jsp/commonHeader.jsp"%>


<c:url value="/homePage" var="homePage" />

<div id="main-content">

	<form method="GET" action="${parkDetailUrl}">

		<ul>
			<li><a href="homePage">Home</a></li>
			<li><a href="survey">Survey</a></li>
			
		</ul>
	</nav>

	<h1>National Parks Weather Service</h1>

	<c:forEach items="${parks}" var="aPark">
		<div id="park">
			<c:set var="img" value="${aPark.parkCode}" />
			<c:set var="imgToLowerCase" value="${fn:toLowerCase(img)}" />
			<c:url var="parkDetailUrl" value="/parkDetail">
			<c:param name="parkCode" value="${aPark.parkCode}"/>
			</c:url>
		<a href="${parkDetailUrl}"><img class ="parkImg" src="img/parks/${imgToLowerCase}.jpg"/></a>

			<ul>

				<li><b>${aPark.parkname}, ${aPark.state}</b></li>

				<li>${aPark.inspirationalQuote}</li>
			</ul>
		</div>
	</c:forEach>
	</form>
</div>


<%@include file="/WEB-INF/jsp/commonFooter.jsp"%>

