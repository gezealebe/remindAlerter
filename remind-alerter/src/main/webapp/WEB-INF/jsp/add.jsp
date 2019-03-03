<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Contact</title>  
 <script type="text/javascript" src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script> 
 <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />
 <link rel="stylesheet" type="text/css" href="resources/css/common.css" />
</head>
<body>
  <div class="container container-custom">
	<spring:url value="/addreminder" var="saveURL" />
	  <h2>Add a new person for reminder</h2>
	  <form:form modelAttribute="addForm" method="post" action="${saveURL }" cssClass="form"> 
	   <div class="form-group">
	    <lable for="firstName">First Name</lable>
	    <form:input path="firstName" class="form-control" id="firstName" />
	   </div>
	   <div class="form-group">
	    <lable for="lastName">Last Name</lable>
	    <form:input path="lastName" class="form-control" id="lastName" />
	   </div>
	   <div class="form-group">
	    <lable for="birthDate">Birth Date</lable>
	    <form:input path="birthDate" class="form-control" id="birthDate" type="date"/>
	   </div>
	   <div class="form-group">
	    <lable for="anniversary">Anniversary</lable>
	    <form:input path="anniversary" class="form-control" id="birthDate" type="date"/>
	   </div>
	   <div class="form-group">
	    <lable for="anniversary">Phone</lable>
	    <form:input path="anniversary" class="form-control" id="phone" />
	   </div>
	   <div class="form-group">
	    <lable for="remindDate">Remind before Date</lable>
	    <form:input path="remindDate" class="form-control" id="email" type="email"/>
	   </div>	   
	   <div class="form-group">
	    <lable for="reminderTypes">Reminder Type</lable>
	    <form:select path="reminderTypes" class="form-control" >
	       <form:option value="birthDay">Birth Day </form:option> 
	       <form:option value="anniversary">Anniversary </form:option> 
	     </form:select>
	   </div>
	   
	    <br></br>
	   <button type="submit" class="btn btn-primary register-button">Add User</button>
	  </form:form>
 </div>
</body>
</html>