<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<html lang="en">
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel = "stylesheet" href = "css/userpage,css">
<!------ Include the above in your HEAD tag ---------->

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="css/materialize.css">
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<title>PostIt</title>
</head>


<body>
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
				<li><a href="GetTopics"> Home </a></li>
				<li><a href="#"> About </a></li>
				<li><a href="#"> Profile </a></li>
		
				<li><a href="#" class="btn-floating indigo darken-4 z-depth-0">
						<i class="material-icons">notifications</i>
				</a></li>
			</ul>
		</div>
	</nav>



    <div class="container main-secction">
    
    <%
	HttpSession sess = request.getSession();
	String uname = (String) sess.getAttribute("username");
	String email = (String) sess.getAttribute("email");
    
    %>
        <div class="row">

            <div class="row user-left-part">
                <div class="col-md-3 col-sm-3 col-xs-12 user-profil-part pull-left">
                    <div class="row ">
                        <div class="col-md-12 col-md-12-sm-12 col-xs-12 user-image text-center">
                            <img src="https://www.jamf.com/jamf-nation/img/default-avatars/generic-user-purple.png" class="rounded-circle">
                        </div>
                        <div class="col-md-12 col-sm-12 col-xs-12 user-detail-section1 text-center">
                            <button id="btn-contact" (click)="clearModal()" data-toggle="modal" data-target="#contact" class="btn btn-success btn-block follow">Contact Me</button> 
                        </div>

                       
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 col-xs-12 pull-right profile-right-section">
                    <div class="row profile-right-section-row">
                        <div class="col-md-12 profile-header">
                            <div class="row">
                                <div class="col-md-8 col-sm-6 col-xs-6 profile-header-section1 pull-left">
                                    <h1><%out.println(uname); %></h1>
                                    <h5>I kool kid</h5>
                                </div>

                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-md-8">
                                        <ul class="nav nav-tabs" role="tablist">
                                                <li class="nav-item">
                                                  <a class="nav-link active" href="#profile" role="tab" data-toggle="tab"><i class="fas fa-user-circle"></i> Profile Information</a>
                                                </li>
                                                       
                                              </ul>
                                              
                                              <!-- Tab panes -->
                                              <div class="tab-content">
                                                <div role="tabpanel" class="tab-pane fade show active" id="profile">
                                                        <div class="row">
                                                                <div class="col-md-2">
                                                                    <label>Username</label>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <p><%out.println(uname); %></p>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-2">
                                                                    <label>Name</label>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <p>Juan Perez</p>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-2">
                                                                    <label>Email</label>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <p><%out.println(email); %></p>
                                                                </div>
                                                            </div>
                                                
                                                            <div class="row">
                                                                <div class="col-md-2">
                                                                    <label>Subs</label>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <p>0</p>
                                                                </div>
                                                            </div>
                                                            
                                                            
                                                            <div class="row">
                                                                <div class="col-md-2">
                                                                    <label>Likes</label>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <p>10</p>
                                                                </div>
                                                            </div>
                                                </div>
                
                                                
                                              </div>
                          
                                </div>
                                <div class="col-md-4 img-main-rightPart">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="row image-right-part">
                                                <div class="col-md-6 pull-left image-right-detail">
                                                </div>
                                            </div>
                                        </div>
                    
                                        <div class="col-md-12 image-right-detail-section2">

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="contact" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="contact">Contactarme</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label for="txtFullname">Nombre completo</label>
                        <input type="text" id="txtFullname" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="txtEmail">Email</label>
                        <input type="text" id="txtEmail" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="txtPhone">Teléfono</label>
                        <input type="text" id="txtPhone" class="form-control">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-primary" (click)="openModal()" data-dismiss="modal">Guardar</button>
                </div>
            </div>
        </div>
    </div>
</body>