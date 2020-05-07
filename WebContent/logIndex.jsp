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
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<title>PostIt</title>
</head>

<body>
	<script src="mainAppController.js"></script>
	<style>
nav .badge {
	position: relative;
	top: 20px;
	right: 20px;
}
</style>

	<nav class="nav-wrapper indigo">
		<div class="container">
			<a href="#" class="brand-logo"> Post-It</a> <a href="#"
				class="sidenav-trigger" data-target="mobile-links"> <i
				class="material-icons">menu</i>
			</a>
			<ul class="right hide-on-med-and-down">
				<li><a href="#"> Home </a></li>
				<li><a href="#"> About </a></li>
				<li><a href="#"> Contact </a></li>
				<li><a href="userpage.html" class="modal-trigger"> Account </a></li>
				<li><a href="#" class="btn-floating indigo darken-4 z-depth-0">
						<i class="material-icons">notifications</i>
				</a></li>
			</ul>
		</div>
	</nav>

	<ul class="sidenav" id="mobile-links">
		<li><a href="#"> Home </a></li>
		<li><a href="#"> About </a></li>
		<li><a href="#"> Contact </a></li>
		<li><a href="#login-modal" class="modal-trigger"> Login </a></li>
	</ul>

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
</style>

	<div class="row">

		<div class="col s12 m6 l3">
			<div class="card" id="card-one">
				<div class="card-image" id="card-one-image-frame">
					<img id="card-one-image-frame-image">
					<div id="card-one-upvote-count"></div>
					<a href="#" id="card-one-upvote-button"><i
						class="material-icons" id="card-one-upvote-button-icon"></i></a> <a
						href="#" id="card-one-downvote-button"><i
						class="material-icons" id="card-one-downvote-button-icon"></i></a> <a
						href="#" id="card-one-favorite-button"><i
						class="material-icons" id="card-one-favorite-button-icon"></i></a>
				</div>
				<div class="card-content" id="card-one-content">
					<span class="card-title truncate" id="card-one-title"></span> <span
						class="truncate" id="card-one-shortened-text"></span>
				</div>
				<div class="card-action">
					<div class="row">
						<div class="col s12 m6 l3">
							<a href="#card-one-modal" class="modal-trigger"
								id="card-one-action-view-full-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-one-action-share-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-one-action-give-award"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal" id="card-one-modal">
			<div class="modal-content" id="card-one-modal-full-post"></div>
		</div>

		<div class="col s12 m6 l3">
			<div class="card" id="card-two">
				<div class="card-image" id="card-two-image-frame">
					<img id="card-two-image-frame-image">
					<div id="card-two-upvote-count"></div>
					<a href="#" id="card-two-upvote-button"><i
						class="material-icons" id="card-two-upvote-button-icon"></i></a> <a
						href="#" id="card-two-downvote-button"><i
						class="material-icons" id="card-two-downvote-button-icon"></i></a> <a
						href="#" id="card-two-favorite-button"><i
						class="material-icons" id="card-two-favorite-button-icon"></i></a>
				</div>
				<div class="card-content" id="card-two-content">
					<span class="card-title truncate" id="card-two-title"></span> <span
						class="truncate" id="card-two-shortened-text"></span>
				</div>
				<div class="card-action">
					<div class="row">
						<div class="col s12 m6 l3">
							<a href="#card-two-modal" class="modal-trigger"
								id="card-two-action-view-full-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-two-action-share-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-two-action-give-award"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal" id="card-two-modal">
			<div class="modal-content" id="card-two-modal-full-post"></div>
		</div>

		<div class="col s12 m6 l3">
			<div class="card" id="card-three">
				<div class="card-image" id="card-three-image-frame">
					<img id="card-three-image-frame-image">
					<div id="card-three-upvote-count"></div>
					<a href="#" id="card-three-upvote-button"><i
						class="material-icons" id="card-three-upvote-button-icon"></i></a> <a
						href="#" id="card-three-downvote-button"><i
						class="material-icons" id="card-three-downvote-button-icon"></i></a> <a
						href="#" id="card-three-favorite-button"><i
						class="material-icons" id="card-three-favorite-button-icon"></i></a>
				</div>
				<div class="card-content" id="card-three-content">
					<span class="card-title truncate" id="card-three-title"></span> <span
						class="truncate" id="card-three-shortened-text"></span>
				</div>
				<div class="card-action">
					<div class="row">
						<div class="col s12 m6 l3">
							<a href="#card-three-modal" class="modal-trigger"
								id="card-three-action-view-full-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-three-action-share-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-three-action-give-award"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal" id="card-three-modal">
			<div class="modal-content" id="card-three-modal-full-post"></div>
		</div>

		<div class="col s12 m6 l3">
			<div class="card" id="card-four">
				<div class="card-image" id="card-four-image-frame">
					<img id="card-four-image-frame-image">
					<div id="card-four-upvote-count"></div>
					<a href="#" id="card-four-upvote-button"><i
						class="material-icons" id="card-four-upvote-button-icon"></i></a> <a
						href="#" id="card-four-downvote-button"><i
						class="material-icons" id="card-four-downvote-button-icon"></i></a> <a
						href="#" id="card-four-favorite-button"><i
						class="material-icons" id="card-four-favorite-button-icon"></i></a>
				</div>
				<div class="card-content" id="card-four-content">
					<span class="card-title truncate" id="card-four-title"></span> <span
						class="truncate" id="card-four-shortened-text"></span>
				</div>
				<div class="card-action">
					<div class="row">
						<div class="col s12 m6 l3">
							<a href="#card-four-modal" class="modal-trigger"
								id="card-four-action-view-full-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-four-action-share-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-four-action-give-award"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal" id="card-four-modal">
			<div class="modal-content" id="card-four-modal-full-post"></div>
		</div>

		<div class="col s12 m6 l3">
			<div class="card" id="card-five">
				<div class="card-image" id="card-five-image-frame">
					<img id="card-five-image-frame-image">
					<div id="card-five-upvote-count"></div>
					<a href="#" id="card-five-upvote-button"><i
						class="material-icons" id="card-five-upvote-button-icon"></i></a> <a
						href="#" id="card-five-downvote-button"><i
						class="material-icons" id="card-five-downvote-button-icon"></i></a> <a
						href="#" id="card-five-favorite-button"><i
						class="material-icons" id="card-five-favorite-button-icon"></i></a>
				</div>
				<div class="card-content" id="card-five-content">
					<span class="card-title truncate" id="card-five-title"></span> <span
						class="truncate" id="card-five-shortened-text"></span>
				</div>
				<div class="card-action">
					<div class="row">
						<div class="col s12 m6 l3">
							<a href="#card-five-modal" class="modal-trigger"
								id="card-five-action-view-full-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-five-action-share-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-five-action-give-award"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal" id="card-five-modal">
			<div class="modal-content" id="card-five-modal-full-post"></div>
		</div>

		<div class="col s12 m6 l3">
			<div class="card" id="card-six">
				<div class="card-image" id="card-six-image-frame">
					<img id="card-six-image-frame-image">
					<div id="card-six-upvote-count"></div>
					<a href="#" id="card-six-upvote-button"><i
						class="material-icons" id="card-six-upvote-button-icon"></i></a> <a
						href="#" id="card-six-downvote-button"><i
						class="material-icons" id="card-six-downvote-button-icon"></i></a> <a
						href="#" id="card-six-favorite-button"><i
						class="material-icons" id="card-six-favorite-button-icon"></i></a>
				</div>
				<div class="card-content" id="card-six-content">
					<span class="card-title truncate" id="card-six-title"></span> <span
						class="truncate" id="card-six-shortened-text"></span>
				</div>
				<div class="card-action">
					<div class="row">
						<div class="col s12 m6 l3">
							<a href="#card-six-modal" class="modal-trigger"
								id="card-six-action-view-full-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-six-action-share-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-six-action-give-award"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal" id="card-six-modal">
			<div class="modal-content" id="card-six-modal-full-post"></div>
		</div>

		<div class="col s12 m6 l3">
			<div class="card" id="card-seven">
				<div class="card-image" id="card-seven-image-frame">
					<img id="card-seven-image-frame-image">
					<div id="card-seven-upvote-count"></div>
					<a href="#" id="card-seven-upvote-button"><i
						class="material-icons" id="card-seven-upvote-button-icon"></i></a> <a
						href="#" id="card-seven-downvote-button"><i
						class="material-icons" id="card-seven-downvote-button-icon"></i></a> <a
						href="#" id="card-seven-favorite-button"><i
						class="material-icons" id="card-seven-favorite-button-icon"></i></a>
				</div>
				<div class="card-content" id="card-seven-content">
					<span class="card-title truncate" id="card-seven-title"></span> <span
						class="truncate" id="card-seven-shortened-text"></span>
				</div>
				<div class="card-action">
					<div class="row">
						<div class="col s12 m6 l3">
							<a href="#card-seven-modal" class="modal-trigger"
								id="card-seven-action-view-full-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-seven-action-share-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-seven-action-give-award"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal" id="card-seven-modal">
			<div class="modal-content" id="card-seven-modal-full-post"></div>
		</div>

		<div class="col s12 m6 l3">
			<div class="card" id="card-eight">
				<div class="card-image" id="card-eight-image-frame">
					<img id="card-eight-image-frame-image">
					<div id="card-eight-upvote-count"></div>
					<a href="#" id="card-eight-upvote-button"><i
						class="material-icons" id="card-eight-upvote-button-icon"></i></a> <a
						href="#" id="card-eight-downvote-button"><i
						class="material-icons" id="card-eight-downvote-button-icon"></i></a> <a
						href="#" id="card-eight-favorite-button"><i
						class="material-icons" id="card-eight-favorite-button-icon"></i></a>
				</div>
				<div class="card-content" id="card-eight-content">
					<span class="card-title truncate" id="card-eight-title"></span> <span
						class="truncate" id="card-eight-shortened-text"></span>
				</div>
				<div class="card-action">
					<div class="row">
						<div class="col s12 m6 l3">
							<a href="#card-eight-modal" class="modal-trigger"
								id="card-eight-action-view-full-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-eight-action-share-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-eight-action-give-award"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal" id="card-eight-modal">
			<div class="modal-content" id="card-eight-modal-full-post"></div>
		</div>

		<div class="col s12 m6 l3">
			<div class="card" id="card-nine">
				<div class="card-image" id="card-nine-image-frame">
					<img id="card-nine-image-frame-image">
					<div id="card-nine-upvote-count"></div>
					<a href="#" id="card-nine-upvote-button"><i
						class="material-icons" id="card-nine-upvote-button-icon"></i></a> <a
						href="#" id="card-nine-downvote-button"><i
						class="material-icons" id="card-nine-downvote-button-icon"></i></a> <a
						href="#" id="card-nine-favorite-button"><i
						class="material-icons" id="card-nine-favorite-button-icon"></i></a>
				</div>
				<div class="card-content" id="card-nine-content">
					<span class="card-title truncate" id="card-nine-title"></span> <span
						class="truncate" id="card-nine-shortened-text"></span>
				</div>
				<div class="card-action">
					<div class="row">
						<div class="col s12 m6 l3">
							<a href="#card-nine-modal" class="modal-trigger"
								id="card-nine-action-view-full-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-nine-action-share-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-nine-action-give-award"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal" id="card-nine-modal">
			<div class="modal-content" id="card-nine-modal-full-post"></div>
		</div>

		<div class="col s12 m6 l3">
			<div class="card" id="card-ten">
				<div class="card-image" id="card-ten-image-frame">
					<img id="card-ten-image-frame-image">
					<div id="card-ten-upvote-count"></div>
					<a href="#" id="card-ten-upvote-button"><i
						class="material-icons" id="card-ten-upvote-button-icon"></i></a> <a
						href="#" id="card-ten-downvote-button"><i
						class="material-icons" id="card-ten-downvote-button-icon"></i></a> <a
						href="#" id="card-ten-favorite-button"><i
						class="material-icons" id="card-ten-favorite-button-icon"></i></a>
				</div>
				<div class="card-content" id="card-ten-content">
					<span class="card-title truncate" id="card-ten-title"></span> <span
						class="truncate" id="card-ten-shortened-text"></span>
				</div>
				<div class="card-action">
					<div class="row">
						<div class="col s12 m6 l3">
							<a href="#card-ten-modal" class="modal-trigger"
								id="card-ten-action-view-full-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-ten-action-share-post"></a>
						</div>
						<div class="col s12 m6 l3">
							<a href="#" id="card-ten-action-give-award"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal" id="card-ten-modal">
			<div class="modal-content" id="card-ten-modal-full-post"></div>
		</div>

	</div>

	<ul class="pagination center-align">
		<li class="disabled"><a href=#!><i class="material-icons">chevron_left</i></a></li>
		<li class="active"><a href=#!>1</a></li>
		<li class="waves-effect"><a href=#!>2</a></li>
		<li class="waves-effect"><a href=#!>3</a></li>
		<li class="waves-effect"><a href=#!>4</a></li>
		<li class="waves-effect"><a href=#!>5</a></li>
		<li class="waves-effect"><a href=#!>6</a></li>
		<li class="waves-effect"><a href=#!><i class="material-icons">chevron_right</i></a></li>
	</ul>

	<script src="js/populatingPostsScript.js"></script>
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