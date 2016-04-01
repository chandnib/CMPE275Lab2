<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Create Profile</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-2.2.2.js"
	integrity="sha256-4/zUCqiq0kqxhZIyp4G0Gk+AOtCJsY1TA00k5ClsZYE="
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
</head>
<body bgcolor="#E6E6FA">
	<div class="container-fluid"></div>
	<div class="row">
		<div class="col-xs-3"></div>
		<div class="col-xs-6">
			<h2 style="text-align: center;">Create New Profile</h2>

			<form action="profile/save" method="post">
				<div class="form-group">
					<label for="exampleInputName1">First Name</label> <input
						type="text" class="form-control" name="firstName"
						placeholder="First Name">
				</div>
				<div class="form-group">
					<label for="exampleInputName2">Last Name</label> <input type="text"
						class="form-control" name="lastName" placeholder="Last Name">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail12">Email</label> <input type="email"
						class="form-control" name="email" placeholder="Email">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail12">Address</label> <input type="text"
						class="form-control" name="address" placeholder="Address">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail12">Organization</label> <input
						type="text" class="form-control" name="organization"
						placeholder="organization">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail12">About Me</label> <input
						type="text" class="form-control" name="aboutme"
						placeholder="aboutme">
				</div>
				<button type="submit" class="btn btn-primary btn-lg btn-block">Submit</button>
			</form>
		</div>
		<div class="col-xs-3"></div>
	</div>
</body>
</html>