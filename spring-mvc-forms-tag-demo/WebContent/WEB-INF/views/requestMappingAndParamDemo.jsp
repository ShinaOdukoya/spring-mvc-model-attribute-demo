<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>@requestMapping and @RequestParam test bed</title>
	<style>
		input[type=text]{
			padding: 10px;
			margin: 10px;
			font-size: 20px
		}
		
		input[type=submit]{
			border: none;
			background-color: #4CAF50;
			color: white;
			padding: 16px;
			margin: 16px;
			cursor: pointer;
			font-size: 20px
		}
		
		h2{
			color: #08298A;
			text-align: center
		}
	</style>
</head>
<body>
	<div align="left">
		<h2 align="center">Hello, welcome to the RequestMapping & RequestParam Test Bed</h2>
		<hr/>
		<form action="test1">
			<h3>test 1: Testing @RequestParam without explicit attributes</h3>
			<label id="organization-name">Organization Name</label>
			<input type="text" name="orgname" placeholder="Enter organization name" size="40">
			<input type="submit" value="submit"/>
		</form>
		<br><br>
		<form action="test2">
			<h3>test 2: Testing @RequestMapping 'method' attribute</h3>
			<label id="organization-name">Organization Name</label>
			<input type="text" name="orgname" placeholder="Enter organization name" size="40">
			<input type="submit" value="submit"/>
		</form>
		<br><br>
		<form action="test3">
			<h3>test 3: Testing @RequestMapping fallback feature</h3>
			<input type="submit" value="submit"/>
		</form>
		<br><br>
		<form action="test4">
			<h3>test 4: Testing @RequestParam 'defaultValue' attribute</h3>
			<label id="organization-name">Organization Name</label>
			<input type="text" name="orgname" placeholder="Enter organization name" size="40">
			<input type="submit" value="submit"/>
		</form>
		<br><br>
		<form action="test5">
			<h3>test 5: Testing @RequestParam without the 'name' or 'value' attributes</h3>
			<label id="organization-name">Organization Name</label>
			<input type="text" name="orgname" placeholder="Enter organization name" size="40">
			<input type="submit" value="submit"/>
		</form>
	</div>
</body>
</html>