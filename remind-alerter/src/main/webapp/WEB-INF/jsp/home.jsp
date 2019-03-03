<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
 <script type="text/javascript" src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script> 
 <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />
 <link rel="stylesheet" type="text/css" href="resources/css/common.css" />
</head>
<body>
 <div class="container container-custom"> 
    <h2>
      Welcome to remindalerter Main page
    </h2>
   <p> This site is used to setup a reminder alert to a different occassion. It will allow you to create edit and delete different reminders.
   </p>
   </br>
   <p> Please select one of the following action</p>
   
    	   </br>
      <div class="action-list">
	   <button type="button" class="btn btn-primary" onclick="location.href='addreminder'">Add new reminder</button>
	   	    <br></br>
	   <button type="button" class="btn btn-primary" onclick="location.href='editreminder'">Edit a reminder</button>
	   	    <br></br>
	   <button type="button" class="btn btn-primary" onclick="location.href='deletereminder'">Delete a reminder</button>
	  </div>
 </div>
</body>
</html>