<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>reservations</title>
</head>
<body>



<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" href="/">Home</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/login">Log in</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="/logout">Log out</a>
  </li>
</ul>


<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">  Our Resturants</h1>
    <p class="lead">We have many services and facilities ,,,,, explore us </p>
  </div>
</div>



<h1>My Reservations</h1>

 

<br><br>

<div class="container">


<table class="table table-striped" border="1">
  <thead>
    <tr>
	    <th scope="col">Id</th>
			 <th scope="col">Customer_Name</th>
			 <th scope="col">Resturant_Name</th>
			 <th scope="col">Number of Tables</th>
			 <th scope="col">Number of Chairs</th>
			 <th scope="col">Date</th>
			 <th scope="col">Time</th>
			 <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  
  	<c:forEach var="reservation" items="${reservations}">
			<tr>
				<th scope="row"> ${reservation.id}</th>
				<td>${reservation.customerName}</td>
				<td>${reservation.resturantName}</td>
				<td>${reservation.nOFtables}</td>
				<td>${reservation.nOFchairs}</td>
				<td>${reservation.date}</td>
				<td>${reservation.time}</td>
				<td><a href="update?id=<c:out value='${reservation.id}'/>"  class=" btn btn-success">Update</a> | <a
					href="delete?id=<c:out value='${reservation.id}'/>" class ="btn btn-danger">Delete</a></td>
			</tr>
		</c:forEach>
  
  
  
   </tbody>
</table>



</div>











<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>