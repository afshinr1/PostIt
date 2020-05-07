<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link rel = "stylesheet" href = "afshstyle.css">	
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<title>Topics</title>
</head>


<body>

	<nav class="nav-wrapper indigo">
		<div class="container">
			<a href="#" class="brand-logo"> Post-It</a> <a href="#"
				class="sidenav-trigger" data-target="mobile-links"> <i
				class="material-icons">menu</i>
			</a>
			<ul class="right hide-on-med-and-down">
				<li><a href="GetTopics"> Home </a></li>
				
				<%
	String ses=(String) session.getAttribute("username");
	if (ses==null)// if not logged
	{
%>
				<li><a href="#about-modal" class="modal-trigger"> About </a></li>
				<li><a href="#contact-modal" class="modal-trigger"> Contact </a></li>
				<li class ="hide" id = "logProfile"><a href="userpage.jsp"> Profile </a></li>
			 	<li  id = "logLogin"><a href="#login-modal" class="modal-trigger"> Login </a></li> 
				<li><a href="#Topic-modal" id = "logTopic"class="hide"> New Topic </a></li>
			
			<%}else// if logged 
				{%>
				<li><a href="#about-modal" class="modal-trigger"> About </a></li>
				<li><a href="#contact-modal" class="modal-trigger"> Contact </a></li>
				<li class ="" id = "logProfile"><a href="userpage.jsp"> Profile </a></li>
				<li class ="" id = "logProfile"><a href="Logout"> Logout </a></li>
				<li><a href="#Topic-modal" id = "logTopic"class="modal-trigger"> New Topic </a></li>
				<%} %>
				<li><a href="#" class="btn-floating indigo darken-4 z-depth-0">
						<i class="material-icons">notifications</i>
				</a></li>
			</ul>
		</div>
	</nav>
	
	<div class="modal" id="about-modal">
	<div class='modal-header'>
      <h3 align = center class='col-10 modal-title'>About</h3> </div>
		<div class="modal-content" id="about-modal-content" align = center >
			<img src=img/Logo.JPG>
			<p >Welcome to Post-It! Find topics in which you are interested and POST all about it!</p>
			<p> Create a new topic and have others join you!!</p>
			

		</div>
	</div>

<div class="modal" id="contact-modal">
	<div class='modal-header'>
      <h3 align = center class='col-10 modal-title'>Contact</h3> </div>
		<div class="modal-content" id="contact-modal-content" align = center >
			<img src=img/Logo.JPG>
			<p >Need help? Have questions? Contact us!</p>
			<p> Emails: jiagang.chang1@ucalgary.ca . muzhda.hussain@ucalgary.ca . sean.kenny1@ucalgary.ca . jase.pasay@ucalgary.ca . afshin.rahman@ucalgary.ca . ummeyzarin.tashnim@ucalgary.ca</p>
			

		</div>
	</div>
	
	
<!--  	 <form action="Logout" method="post">
		 <div>
		 
		 <% if (ses==null){ %>
			 <input type="submit" id="logLogout" class ="hide" name="logout-submit" value ="Logout"><br><br>
			 <%}else{ %>
			  <input type="submit" id="logLogout" class ="" name="logout-submit" value ="Logout"><br><br>
			 <%} %>
		 </div>
	</form> 
	-->
		<div class="modal" id="login-modal">
		<div class="modal-content" id="login-modal-content">
			<div class="row">

				<!--  new LOGIN MODULE -->	
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
			<%
			String username1 = request.getParameter("uname1");
			if(username1 != null){
			%>
			<p class = "signuperror1" >Sorry, incorrect username or password </p>
			<%	
			}
			%>
			
				<div class="col s12 m12 l6">
					<form action="ValidateUser" method="post">
						<div class="input-field">
							<input id="login-username-field" name = "uname1" type="text" class="validate">
							<label for="login-username-field">Username</label>
						</div>
						<div class="input-field">
							<input id="login-password-field" name ="upass" type="password" class="validate">
							<label for="login-password-field">Password</label>
						</div>
						<input type="submit" name="login-submit" value="Login"><!-- This wasn't in the form spend an hours debugging this :( -->
					</form>

				</div>


				<div class="col s12 m12 l6">
					<div class="card">
						<div class="card-content">
							<form action="SignupUser" method = "get">
								<h4>New User?</h4>

								<div class="input-field">
									<input id="register-email-field" name = "mail" type="email" class="validate">
									<label for="register-email-field">Email</label>
								</div>

								<div class="input-field">
									<input id="register-username-field" name = "uname" type="text"
										class="validate"> <label for="register-username-field">Username</label>
								</div>
								<div class="input-field">
									<input id="register-password-field" name = "pwd" type="password"
										class="validate"> <label for="register-password-field">Password</label>
								</div>
								<div class="input-field">
									<input id="register-password-confirm-field" name = "pwd-confirm" type="password"
										class="validate"> <label
										for="register-password-confirm-field">Confirm Password</label>
								</div>
								<input type="submit" name="signup-submit" value="Sign Up">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--  END OF THE NEW LOGIN MODULE -->
	
<form action = "SearchTopicController" method="GET">
<div class="topnav">
  <input type="text" placeholder="Please enter a topic name to search for....." name = "topicName">
<input type="submit" class="btn" value="Search"></div>
</form>	

	<div class="modal" id="Topic-modal">
		<div class="modal-content" id="login-modal-content">
			<div class="row">


				<div class="col s12 m12 l6">
					<div class="card">
						<div class="card-content">
							<form action="NewTopicController" method=post>
								<h4>New Topic?</h4>

								<div class="input-field">
									<input id="register-email-field" type="text" class="validate"
										name="title"> <label for="register-email-field">Title</label>
								</div>

								<input type="submit" class="btn orange" value="Share">
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<ul class="sidenav" id="mobile-links">
		<li><a href="GetTopics"> Home </a></li>
		<li><a href="#"> About </a></li>
		<li><a href="#"> Contact </a></li>
		<li><a href="#login-modal" class="modal-trigger"> Login </a></li>
		<li><a href="#Topic-modal" class="modal-trigger"> New Topic </a></li>
		
	</ul>
	<%
				String topics = (String) request.getAttribute("topics");
			if(!topics.isEmpty()){									
			
	%>

	<div class="container">
		<ul class="collection">
		
			
			<% 										
				String[] topic = topics.split("\\*");

				for (int i = 0; i < topic.length; i++) {

					String[] topicData = topic[i].split("\\|");
					String topic_name = topicData[0];
					String topic_id = topicData[1];
					String num_members = topicData[2];
			%>

			<li class="collection-item avatar" id="topic-one-card"><i
				class="material-icons circle" id="topic-one-card-icon">folder</i> <span
				class="title" id="topic-one-card-title"> <%
 	out.println(topic_name);
 %>
			</span>
				<p id="topic-one-card-member-count"> <% out.println("Number of members: " + num_members); %></p>

				<div class="secondary-content">
					<!--
					<form action="TopicController" method="GET">
						<input type="hidden" name="topicid" value=<%=topic_id%> /> <input
							type="submit" class="btn" value="Visit">
					</form>
					<form action="SubscribeController" method="GET">
						<input type="hidden" name="topicid" value=<%=topic_id%> /> <input
							
								 <% if (ses==null){ %>
									type="submit" id = "logButton" class="hide" value="Join">
								 <%
									 }else{ %>
									type="submit" id = "logButton" class="btn" value="Join">
								 <%} %>
					</form>
					-->
					<a onclick="submitform('<%="visitform,".concat("ID=").concat(topic_id) %>')" class="btn" id="topic-one-card-visit-button">Visit</a>
					<a onclick="submitform('<%="joinform,".concat("ID=").concat(topic_id) %>')" 
						<% if (ses==null){ %>
							class="hide" id="topic-one-card-join-button">Join
						<%}else{ %>	
							class="btn" id="topic-one-card-join-button">Join
						<%} %>
					</a>
					<form action="TopicController" method="GET" id = <%= "visitform,".concat("ID=").concat(topic_id) %> >
						<input type="hidden" name="topicid" value=<%=topic_id%> /> 
					</form>
					<form action="SubscribeController" method="GET" id = <%="joinform".concat(",ID=").concat(topic_id) %>>
						<input type="hidden" name="topicid" value=<%=topic_id%> /> 
					</form>
				</div></li>

			<%
				}
			%>
		</ul>
	</div>
<%
}
			
			else{			
%>
<p>No topics found!</p>
<%} %>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>


	<script type = "text/javascript">
		$(document).ready(function() {
			$('.sidenav').sidenav();
			$('.modal').modal();
		})
		
	</script>
	
	<script>
	function submitform(formIDToSubmit)
	{
		console.log(formIDToSubmit);
		document.getElementById(formIDToSubmit).submit();
	}
	</script>
	
</body>
</html>