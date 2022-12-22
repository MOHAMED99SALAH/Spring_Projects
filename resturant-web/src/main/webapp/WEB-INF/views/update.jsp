<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>serve</title>

<style>
h6 {
  
padding: 10px 20px 10px 10px ;
}
</style>
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
    <h1 class="display-4"> Our Resturants</h1>
    <p class="lead">We have many services and facilities ,,,,, explore us </p>
  </div>
</div>


<h6><h1> ${reserve.resturantName} Resturant    </h1> </h6>
<br>




<div class="container">

<form action ="/update"  method="POST">
<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>

<input type="hidden"  name="ID" value="${reserve.id}"/>

      <input type="hidden"   name ="CustN"  value="${reserve.customerName}">
    
   <input type="hidden" class="form-control"  placeholder="Resturant Name"  name ="ResN" value=${reserve.resturantName }>
 

  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Number of Tables</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  placeholder="number of tables"  name ="tableNN"  value=${reserve.nOFtables } required>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Number of Chairs</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="number of chairs" name ="chairNN"   value=${reserve.nOFchairs } required>
    </div>
  </div>

<div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Date</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="date" name ="datee"  value=${reserve.date } required>
    </div>
  </div>
<div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Time of  Reservation</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="time " name ="timee"   value=${reserve.time } required>
    </div>
  </div>

 
 <div class="form-group row">
    <div class="col-sm-2 col-form-label" >
      <button type="submit" class="btn btn-success">Update</button>
    </div>
  </div>
 
</form>

</div>






<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>