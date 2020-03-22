<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<spring:url value="/resources/test-main.css" var="testMainCss"/>
	<link href="${testMainCss}" rel="stylesheet"/>
<title>Test Bed</title>
</head>
<body>
	<div align="center">
		<h1>Welcome to form Tags Test Bed</h1>
		<hr>
		<h3>Register your organization with us</h3>
		<form:form action="registerOrg" modelAttribute="orgRegistration">
			<table>
				<tr>
					<td><form:label path="orgName">Name of organization</form:label></td>
					<td><form:input path="orgName" placeholder="Enter organization name"/></td>
				</tr>
				<tr>
					<td><form:label path="country">Country</form:label></td>
					<td>
						<form:select path="country">
							<form:option value="NONE">-----SELECT-----</form:option>
							<form:option value="Australia">Australia</form:option>
							<form:option value="Canada">Canada</form:option>
							<form:option value="India">India</form:option>
							<form:option value="USA">USA</form:option>
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="turnOver">Turnover</form:label></td>
					<td><form:select path="turnOver" items="${turnOverList}"/></td>
				</tr>
				<tr>
					<td><form:label path="type">Type</form:label></td>
					<td>
						<form:select path="type"> 
							<form:option value="NONE">-----SELECT-----</form:option>
							<form:options items="${typeList}"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="serviceLength">Organization Age</form:label></td>
					<td><form:select path="serviceLength" items="${serviceLengthList}"/></td>
				</tr>
				<tr>
					<td><form:label path="registeredPreviously">Registered Previously?</form:label></td>
					<td><form:checkbox path="registeredPreviously" items="${registeredPreviouslyList}"/></td>
				</tr>
				<tr>
					<td><form:label path="optionalServices">Optional Services Subscription:</form:label></td>
					<td>
						<form:checkbox path="optionalServices" value="emailService"/> ${subscriptionList.emailService}
						<form:checkbox path="optionalServices" value="promotionalService"/> ${subscriptionList.promotionalService}
						<form:checkbox path="optionalServices" value="newsLetterServices"/> ${subscriptionList.newsLetterServices}
					</td>
				</tr>
				<tr>
					<td><form:label path="like">Like our website?</form:label></td>
					<td><form:checkbox path="like" value="yes"/>Like</td>
				</tr>
				<tr>
					<td>
					<td align="center"><input type="submit" value="Submit"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>