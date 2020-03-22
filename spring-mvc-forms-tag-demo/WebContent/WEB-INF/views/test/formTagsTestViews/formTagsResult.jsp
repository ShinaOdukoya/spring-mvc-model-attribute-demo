<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<spring:url value="/resources/test-main.css" var="testMainCss"/>
	<link href="${testMainCss}" rel="stylesheet"/>
<title>Form Tags Test Result</title>
</head>
<body>
	<h1>Congratulations! You have registered your organization</h1>
	<h2>Details below...</h2>
	<hr>
	<div align="center">
		<h3>Organization Name: <b>${orgReg.orgName}</b></h3>
		<h3>Country: <b>${orgReg.country}</b></h3>
		<h3>Turnover:
			<c:forEach var="entry" items="${turnOverList}">
				<c:if test="${orgReg.turnOver eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		<h3>Type:
			<c:forEach var="entry" items="${typeList}">
				<c:if test="${orgReg.type eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		<h3>Organization Age:
			<c:forEach var="entry" items="${serviceLengthList}">
				<c:if test="${orgReg.serviceLength eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		<h3>Registered Previously:
			<c:forEach var="entry" items="${registeredPreviouslyList}">
				<c:if test="${orgReg.registeredPreviously eq entry.key}">
					<b>${entry.value}</b>
				</c:if>
			</c:forEach>
		</h3>
		<h3>Optional Services Signed up For:
			<c:forEach var="entry1" items="${subscriptionList}">
				<c:forEach var="entry2" items="${orgReg.optionalServices}">
					<c:if test="${entry2 eq entry1.key}">
						<c:set var="optService" scope="request" value="${optService}${entry.value},"/>
					</c:if>
				</c:forEach>
			</c:forEach>
			<b>${optService.substring(0, optService.length()-2}</b>
		</h3>
		<h3>Like our Website:
			<c:choose>
				<c:when test="${orgReg.like eq 'yes'}"><b>Like</b></c:when>
				<c:otherwise>Do not Like</c:otherwise>
			</c:choose>
		</h3>
	</div>
</body>
</html>