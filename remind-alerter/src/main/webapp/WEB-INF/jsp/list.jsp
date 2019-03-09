<jsp:include page="header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>List Reminder</title>  
 <script type="text/javascript" src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script> 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" /> 
 <link rel="stylesheet" type="text/css" href="resources/css/common.css" />
 <script type="text/javascript" src="resources/js/reminder.js"></script>
</head>
<body> 
<script>
function deleteReminder(id) { 
  if (confirm("Do you really want to delete the reminder!")) { 
	  var url = "deletereminder/{id}"; 
	    url = url.replace("{id}", id);
	   location.href=url;
  } else { 
	  // do nothing
  } 
}
</script>

<div class="container">
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
		<p class="description_title">
	      Welcome to remindalerter. An Application which will help you manage reminders about different occasions 
	    </p>
   
		<div class="description-title">
		  Below is the list of your current Reminders
		</div>
		
    	   </br>
      <div class="action-list">
	   <button type="button" class="btn btn-success" onclick="location.href='addreminder'">Add new reminder</button>
	   	    <br></br> 
	  </div>

		<form:form method="post" action="/editreminder" modelAttribute="reminder"> 
			<table class="table">			   
  
               <thead>
	                <tr>
	                   <th scope="col"># </th>
	                   <th scope="col">First Name </th>
	                   <th scope="col">last Name </th>
	                   <th scope="col">Birth Date </th>
	                   <th scope="col"> </th>
	                   <th scope="col"> </th>
	                </tr>
                </thead>
                	<tbody>
             	  <c:forEach var="contact" items="${reminder}"  varStatus="loop"> 
				
					  <tr>	 
						<td> ${loop.index + 1 } </td>
							 
						<td> ${contact.firstName} </td>
	                      
						<td> ${contact.lastName} </td>
	 					   
						<td> ${contact.birthDate} </td>		
								 
						<td ><input type="button" onclick="location.href='editreminder/'+ ${contact.id}" class="btn btn-primary" value="Edit Reminder" /></td>
						<td ><input type="button" onclick="deleteReminder(${contact.id})" class="btn btn-danger" value="Delete Reminder" /></td>
				    </tr>					
				  </c:forEach>
				  </tbody>
				
			</table> 
		</form:form>
 	</div>
</body>
</html>