<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet'>
	<link rel="stylesheet" type="text/css" href="css/signupstyle.css">
	<title>Manufacturer's Outpost - Sign up</title>
</head>
<body>
	<div class = logo>
		<a href="index.jsp">  Post It main page</a>
		</div>
		
		<div class ="signupbox"> 
			<h1> Create an account </h1> 
			<%
			String userError = (String) request.getAttribute("userfail");
			String pwdError = (String) request.getAttribute("pwdfail");
			String emptyError = (String) request.getAttribute ("emptyfail");
			String success = (String) request.getAttribute ("succ");
			if(userError != null){
			%>
			<p class = "signuperror" >Username taken </p>
			<%
			}
			else if(pwdError != null){
			%>
				<p class = "signuperror" >Passwords do not match </p>
			<%
			}
			else if(emptyError != null){
			%>
			<p class = "signuperror" >One or more fields are empty </p>
			<%
			}
			else if(success != null){
			%>
			<p class = "signupsuccess" >Signup Success </p>
			<% 
			}
			%>
			
			<form action="SignupUser" method = "get"> 
				<p> Username </p>
				<input type="text" name="uname" placeholder="Enter Username">
				<p> Email </p>
				<input type="text" name="mail" placeholder="Enter Email">
				<p> Password </p> 
				<input type="password" name="pwd" placeholder="Enter Password">
				<p> Confirm Password </p> 
				<input type="password" name="pwd-confirm" placeholder="Enter Password">
				<input type="submit" name="signup-submit" value="Sign Up">
			</form>
		</div>
</body>
</html>




