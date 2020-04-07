<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href='https://fonts.googleapis.com/css?family=Roboto'
	rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Roboto Slab'
	rel='stylesheet'>
<link rel="stylesheet" type="text/css" href="css/afshstyle.css">
<title>Post It</title>
</head>
<body>


<%
response.sendRedirect(request.getContextPath() + "/GetTopics");
%>
	<h1>Welcome to Post-It!</h1>
	<div class="nav">
		<ul>
			<li><a href="about.jsp">About</a></li>
			<li><a href="contact.jsp">Contact</a></li>
			<li><a href="signup.jsp">Sign Up</a></li>
		</ul>

	</div>
	
	<form action="ValidateUser" method="post">
		<div class="loginbox" id="loginform">
		<%
		String username = request.getParameter("uname");
		if(username != null){
		%>
	<p class = "signuperror" >Sorry, incorrect username or password </p>
		<%	
		}
		%>
			<h4>User Sign In</h4>
			<p>Username</p>
			<input type="text" placeholder="Enter Username" name="uname">
			<p>Password</p>
			<input type="password" placeholder="Enter Password" name="upass">
			<input type="submit" name="login-submit" value="Login">

		</div>
	</form>
	

</body>
</html>