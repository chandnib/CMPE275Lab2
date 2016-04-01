<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
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
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-3"></div>
			<div class="col-xs-6">
				<h2 style="text-align: center;">User Profile</h2>
				<form:form modelAttribute="profile" method="delete">
					<div class="form-group">
						<label for="exampleInputName1">Id</label> <input type="text"
							class="form-control" id="id" path="id" value="${profile.id}"
							readonly="true">
					</div>
					<div class="form-group">
						<label for="exampleInputName1">First Name</label> <input
							type="text" class="form-control" id="first_name" path="first_name"
							value="${profile.first_name}">
					</div>
					<div class="form-group">
						<label for="exampleInputName2">Last Name</label> <input
							type="text" class="form-control" id="last_name" path="last_name"
							value="${profile.last_name}">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail12">Email</label> <input type="email"
							class="form-control" id="email" path="email" value="${profile.email}">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail12">Address</label> <input
							type="text" class="form-control" id="address" path="address"
							value="${profile.address}">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail12">Organization</label> <input
							type="text" class="form-control" id="organization" path="organization"
							value="${profile.organization}">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail12">About Me</label> <input
							type="text" class="form-control" id="about_me" path="about_me"
							value="${profile.about_me}">
					</div>
					<button type="submit" class="btn btn-danger btn-lg btn-block"
						name="Delete" value="Delete">Delete</button>
					<spring:url value="/profile/${profile.id}" var="updateUrl" />
				</form:form>
				<script type="text/javascript">
					$(document).ready(function() {
						$("#update").click(function() {
							console.log($('#first_name').val());
							$.post("${profile.id}", {
								first_name : $('#first_name').val(),
								last_name : $('#last_name').val(),
								email : $('#email').val(),
								address : $('#address').val(),
								organization : $('#organization').val(),
								about_me : $('#about_me').val()
							}, function(data, status) {
								if(data){
									$('#first_name').val(data.first_name);
									$('#last_name').val(data.last_name);
									$('#email').val(data.email);
									$('#address').val(data.address);
									$('#organization').val(data.organization);
									$('#about_me').val(data.about_me);
									location.reload();
								}
							});
						});
					});
				</script>
				<button type="button" class="btn btn-primary btn-lg btn-block"
					id="update">Update</button>
			</div>
			<div class="col-xs-3"></div>
		</div>
	</div>
</body>
</html>