<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Reminder</title>  
 <script type="text/javascript" src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script> 
 <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />
 <link rel="stylesheet" type="text/css" href="resources/css/common.css" />
</head>
<body>
  <div class="container container-custom">
	<spring:url value="/addreminder" var="saveURL" />
	  <h2>Delete Reminder Page</h2>
 
 </div>
</body>
</html>