<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<!-- font awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
<style>
.halfway-fab-one-step-to-the-left {
	position: absolute;
	right: 72px;
	bottom: -20px;
}

.halfway-fab-two-steps-to-the-left {
	position: absolute;
	right: 120px;
	bottom: -20px;
}

.halfway-fab-three-steps-to-the-left {
	position: absolute;
	right: 168px;
	bottom: -20px;
}

.big-nice-allignments {
	position: absolute;
	right: 20px;
	bottom: 30px;
}

.big-nice-allignments-delete {
	position: absolute;
	right: 30px;
	bottom: -8px;
}

.big-nice-allignments-edit {
	position: absolute;
	right: 290px;
	bottom: 30px;
}
</style>

<title>Thread Show</title>
<body>

	<nav class="nav-wrapper indigo">
		<div class="container">
			<a href="#" class="brand-logo"> Post-It</a> <a href="#"
				class="sidenav-trigger" data-target="mobile-links"> <i
				class="material-icons">menu</i>
			</a>
			<ul class="right hide-on-med-and-down">
				<li><a href="GetTopics"> Home </a></li>
				<li><a href="#"> About </a></li>
				<li><a href="#"> Contact </a></li>
				<li><a href="#"> Login </a></li>
				<li><a href="#" class="btn-floating indigo darken-4 z-depth-0">
						<i class="material-icons">notifications</i>
				</a></li>
			</ul>
		</div>
	</nav>

	<div class="modal" id="login-modal">
		<div class="modal-content" id="login-modal-content">
			<div class="row">


				<div class="col s12 m12 l6">
					<form action="ValidateUser">
						<div class="input-field">
							<input id="login-username-field" type="text" class="validate">
							<label for="login-username-field">Username</label>
						</div>
						<div class="input-field">
							<input id="login-password-field" type="password" class="validate">
							<label for="login-password-field">Password</label>
						</div>
						<a href="#" class="btn orange">Login</a>
					</form>
				</div>


				<div class="col s12 m12 l6">
					<div class="card">
						<div class="card-content">
							<form action="">
								<h4>New User?</h4>

								<div class="input-field">
									<input id="register-email-field" type="email" class="validate">
									<label for="register-email-field">Email</label>
								</div>

								<div class="input-field">
									<input id="register-username-field" type="text"
										class="validate"> <label for="register-username-field">Username</label>
								</div>
								<div class="input-field">
									<input id="register-password-field" type="password"
										class="validate"> <label for="register-password-field">Password</label>
								</div>
								<div class="input-field">
									<input id="register-password-confirm-field" type="password"
										class="validate"> <label
										for="register-password-confirm-field">Confirm Password</label>
								</div>
								<a href="#" class="btn orange">Register</a>
							</form>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>


	<div class="modal" id="Post-modal">
		<div class="modal-content" id="login-modal-content">
			<div class="row">


				<div class="col s12 m12 l6">
					<div class="card">
						<div class="card-content">
							<form action="NewPostController" method=post>
								<h4>New Post?</h4>

								<div class="input-field">
									<input id="register-email-field" type="text" class="validate"
										name="title"> <label for="register-email-field">Title</label>
								</div>

								<div class="input-field">
									<input id="register-username-field" type="text"
										class="validate" name="content"> <label
										for="register-username-field">Text</label>
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
		<li><a href="#login-modal" class="modal-trigger"> New Post </a></li>

	</ul>

	<%
		//Getting post info
		String postInfo = (String) request.getAttribute("postinfo");
		String[] splitPostInfo = postInfo.split("\\|");
		String postTitle = splitPostInfo[0];
		String postDesc = splitPostInfo[1];
		String postUsername = splitPostInfo[2];
		System.out.println("POST INFO IN THREAD:" + postInfo);
	%>
	<div class="row valign-wrapper">
		<div class="col s12 m8 offset-m2 valign">
			<div class="Heading">
				<div class="card blue-grey darken-1">
					<!--THIS DIV SECTION IS WHERE THE THREAD STARTS-->
					<div class="card-image">
						<!--THREAD IMAGE-->
						<img id="thread_image">
						<!--THREAD TITLE-->
						<span class="card-title " id="thread_title"></span>
						<!--THREAD BUTTONS LIKE/DISLIKE-->
						<a
							class=" btn-floating halfway-fab-one-step-to-the-left waves-effect btn-small waves-light red"
							href="#"><i class="material-icons">thumb_up</i></a> <a
							class=" btn-floating halfway-fab-two-steps-to-the-left waves-effect btn-small waves-light red"
							href="#"><i class="material-icons">thumb_down</i></a>
					</div>

					<div class="card-content white-text">
						<!--THREAD TEXT-->
						<p>
							<%
								out.println(postDesc);
							%>
						</p>
					</div>
					<div class="card-action">
						<ul class="collection">
							<!--BELOW IS AUTHOR INFORMATION-->
							<li class="collection-item avatar"><i
								class="material-icons circle" id="author-icon"></i> <span
								class="title"> <%
 	out.println(postUsername + ":     " + postTitle);
 %>
							</span> <a href="#!" class="secondary-content"><i
									class="material-icons">grade</i></a></li>
						</ul>
					</div>
				</div>
			</div>


			<!-- THIS IS WHERE THE COMMENTS ARE STORED-->

			<%
				String comments = (String) request.getAttribute("comments");
				if (!comments.isEmpty()) {
			%>
			<div class="Comment">
				<ul class="collection">

					<%
						//Getting comment info
							String commentInfo = "";
							String[] split = comments.split("\\*");
							for (int i = 0; i < split.length; i++) {
								commentInfo = split[i];
								System.out.println(split[0]);
								String[] eachCommentData = split[i].split("\\|");
								String reply = eachCommentData[0];
								String commentDescription = eachCommentData[1];
								String commentUUID = eachCommentData[2];
								String commentParentUUID = eachCommentData[3];
								String votes = eachCommentData[4];
								String commentUsername = eachCommentData[5];
					%>
					<div class="card  blue-grey lighten-5">
						<div class="card-content">
							<li id="comment-0"><i class="material-icons circle"
								id="comment-0-icon"></i> <span class="title"> <%
 	out.println(commentUsername);
 %>
							</span>
								<p>

									<%
										out.println(commentDescription);

												//if(reply.compareTo("REPLY") == 0)
									%>
								</p>
								<div class="container">
									<a href="#reply-modal" class="modal-trigger"
										data-target="reply-modal"> <i
										class="big-nice-allignments btn waves-effect waves-light">
											Reply </i>
									</a>
								</div>

								<div class="modal" id="reply-modal">
									<div class="modal-content" id="reply-modal-content">
										<div class="row">

											<div class="col s12 m12 l6">
												<form action="CommentControllerCommand" method="POST">
													<div class="row">
														<div class="input-field col s10">
															<i class="material-icons prefix">mode_edit</i>
															<textarea id="icon_prefix3" class="materialize-textarea"
																name="comment"></textarea>
															<label for="icon_prefix3"></label>
														</div>
													</div>
													<div class="card-action">
														<input type="hidden" name="event_type" value="REPLY" /> <input
															type="hidden" name="uuid" value=<%=commentUUID%> /> <input
															type="hidden" name="postUUID" value=<%=commentParentUUID%> />
														<button class="btn waves-effect waves-light" type="submit"
															name="action">
															Submit <i class="material-icons right">send</i>
														</button>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div> <%
 	HttpSession sess = request.getSession();
 			String postUUID = (String) sess.getAttribute("postUUID");
 			String uname = (String) sess.getAttribute("username");
 			if (commentUsername.compareTo(uname) == 0) {
 %>

								<div class="container">
									<form action="CommentControllerCommand" method="POST">
										<div class="card-action">
											<input type="hidden" name="event_type" value="DELETE" /> <input
												type="hidden" name="uuid" value=<%=commentUUID%> /> <input
												type="hidden" name="content" value=<%=commentDescription%> /><label
												for="icon_prefix3"></label> <input type="hidden"
												name="postUUID" value=<%=postUUID%> />
											<button
												class="big-nice-allignments-delete btn waves-effect waves-light"
												type="submit" name="action">Delete</button>
										</div>
									</form>
								</div>

								<div class="container">
									<a href="#edit-modal" class="modal-trigger"
										data-target="edit-modal"> <i
										class="big-nice-allignments-edit btn waves-effect waves-light">
											Edit </i>
									</a>
								</div>

								<div class="modal" id="edit-modal">
									<div class="modal-content" id="edit-modal-content">
										<div class="row">

											<div class="col s12 m12 l6">
												<form action="CommentControllerCommand" method="POST">
													<div class="row">
														<div class="input-field col s10">
															<i class="material-icons prefix">mode_edit</i>
															<textarea id="icon_prefix3" class="materialize-textarea"
																name="comment"></textarea>
															<label for="icon_prefix3"></label> <input type="hidden"
																name="postUUID" value=<%=postUUID%> />
														</div>
													</div>
													<div class="card-action">
														<input type="hidden" name="event_type" value="EDIT" /> <input
															type="hidden" name="uuid" value=<%=commentUUID%> />
														<button class="btn waves-effect waves-light" type="submit"
															name="action">
															Submit <i class="material-icons right">send</i>
														</button>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div> <%
 	}
 %>
							<li id="comment-0-show" class="hide">
								<div class="row">
									<div class="input-field col s10">
										<i class="material-icons prefix">mode_edit</i>
										<textarea id="icon_prefix0" class="materialize-textarea"></textarea>
										<label for="icon_prefix0"></label>
									</div>
								</div>
							</li>
						</div>
					</div>

					<%
						}
					%>

				</ul>
			</div>
			<%
				}
			%>

			<!--THIS IS WHERE COMMENT ON THREAD IS-->
			<%
				HttpSession sess = request.getSession();
				String postUUID = (String) sess.getAttribute("postUUID");
				if (sess.getAttribute("username") != null) {
			%>
			<form action="CommentControllerCommand" method="post">
				<div class="card blue-grey lighten-5">
					<div class="card-content">
						<ul class="collection">
							<li class="collection-item avatar black-text"><i
								class="material-icons circle red" id="icon"></i> <span
								class="title" id="username"> <%
 	out.print(sess.getAttribute("username"));
 %></span> <a href="#!" class="secondary-content"><i class="material-icons">grade</i></a>
							</li>
							<li class="collection-item avatar black-text">
								<div class="row">
									<div class="input-field col s10">
										<i class="material-icons prefix">mode_edit</i>
										<textarea id="icon_prefix3" class="materialize-textarea"
											name="comment"></textarea>
										<label for="icon_prefix3"></label> <input type="hidden"
											name="postUUID" value=<%=postUUID%> />
									</div>
								</div>
							</li>
						</ul>
					</div>

					<div class="card-action">
						<input type="hidden" name="event_type" value="CREATE" />
						<button class="btn waves-effect waves-light" type="submit"
							name="action">
							Submit <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
			</form>
			<%
				}
			%>


		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

	<script>
		$(document).ready(function() {
			$('.sidenav').sidenav();
			$('.modal').modal();
		})
	</script>

</body>
</html>