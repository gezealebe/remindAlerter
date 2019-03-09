<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>  
 <script type="text/javascript" src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script> 
 <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />
 <link rel="stylesheet" type="text/css" href="resources/css/common.css" /> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
  <div class="container container-custom">
	<spring:url value="/register/user" var="saveURL" />
	  <h2>User Registration Form</h2>	  	   
	  <c:if test="${not empty param.error}">
	    <div class="alert alert-error"> ${error}</div>
	  </c:if>
	  <form:form modelAttribute="userForm" method="post" action="${saveURL }" cssClass="form">
	   <form:hidden path="id"/>
	   <div class="form-group">
	    <lable for="userName">User Name</lable>
	    <form:input path="userName" class="form-control" id="userName" required="true" />
	    <form:errors path="userName" />
	   </div>
	   <div class="form-group">
	    <lable for="firstName">First Name</lable>
	    <form:input path="firstName" class="form-control" id="firstName" />
	   </div>
	   <div class="form-group">
	    <lable for="lastName">Last Name</lable>
	    <form:input path="lastName" class="form-control" id="lastName" />
	   </div>
	   <div class="form-group">
	    <lable for="phone">Phone</lable>
	    <form:input path="phone" class="form-control" id="phone" />
	   </div>
	   <div class="form-group">
	    <lable for="birthDate">Birth Date</lable>
	    <form:input path="birthDate" class="form-control" id="birthDate" type="date"/>
	   </div>
	   <div class="form-group">
	    <lable for="email">Email</lable>
	    <form:input path="email" class="form-control" id="email" type="email" required="true" />
	   </div>	   
	   <div class="form-group">
	    <lable for="password">Password</lable>
	    <form:input path="password" class="form-control" id="password" type="password" required="true"  />
	   </div>
	   
	    <br></br>
	   <button type="submit" class="btn btn-primary register-button">Register</button>
	  </form:form>
 </div>
</body>
</html>