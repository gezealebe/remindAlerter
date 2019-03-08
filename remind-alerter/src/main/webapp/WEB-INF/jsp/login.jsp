<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
 <script type="text/javascript" src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script> 
 <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />
 <link rel="stylesheet" type="text/css" href="resources/css/common.css" />
</head>
<body>
   <div class="container container-custom">
	<spring:url value="/login/user" var="saveURL" />
	  <h2>User Login</h2>
	  <p>Please enter user name and password to login</p>
	  <c:if test="${not empty error }">
	    <div class="alert alert-error"> ${error }</div>
	  </c:if>
	  <form:form modelAttribute="login" method="POST" action="${saveURL }" cssClass="form"> 
	   <div class="form-group">
	    <lable for="userName">User Name</lable>
	    <form:input path="userName" class="form-control" id="userName" />
	   </div>
	   	   <div class="form-group">
	    <lable for="password">Password</lable>
	    <form:input path="password" class="form-control" id="password" type="password" />
	   </div>
	   
	    <br></br>
	   <button type="submit" class="btn btn-primary">Login</button>
	     <h4 class="text-center"><a href="register">Create an account</a></h4>
	  </form:form>
 </div>
    
</body>
</html>