<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java EE - Demo 07</title>
<link rel="stylesheet" type="text/css" href="styles/common.css">
</head>
<body>
	<h1>Java EE</h1>
	<h2>DEMO 07 - DATABASE ACCESS</h2>

	<div id="contentbox">
		<h3>Content</h3>
		<ul>
			<li>DAO</li>
			<li>Properties file</li>
			<li>Singleton</li>
			<li>JSTL for-each</li>
		</ul>
		<h3>Functionality</h3>
		<p>The servlet will request the DAO-class to retrieve all of the
			persons from the database. DAO will read the database using a</p>
		<p>helper class that will read the properties file for the
			database access configuration and executes the search. The servlet</p>
		<p>will save the result list into a request attribute and
			redirects the request to a jsp page for the formatting (renders a jsp
			page).</p>
		<p>The jsp-page will use the JSTL-library for the list printing
			(for-each).</p>
		<h3>Link</h3>
		<p>
			<a href="persons">persons</a>
		</p>
	</div>
</body>
</html>