<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Register</title>
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

<br> 
<h1> Register  </h1>
<br> <br>

<div class="container " >
<form action ="/register"  method="POST">

 
    <input type="hidden"                          
            name="${_csrf.parameterName}"  
            value="${_csrf.token}"/>  
            
  <div class="form-group">
    <label for="exampleInputEmail1">User name</label>
    <input type="text" class="form-control" placeholder="Enter user name" name ="emailR" required>
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control"  placeholder=" Enter Password" name ="passR" required>
  </div>
  
   <div class="form-group">
    <label for="exampleInputPassword1">Age</label>
    <input type="text" class="form-control"  placeholder=" Enter Age" name  ="ageR" required>
  </div>
  
   <div class="form-group">
    <label for="exampleInputPassword1">Address</label>
    <input type="text" class="form-control"  placeholder=" Enter Address" name  ="addR" required>
  </div>
 
  <button type="submit" class="btn btn-primary">Register </button>
</form>

</div>


<br> <br> <br>









<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>