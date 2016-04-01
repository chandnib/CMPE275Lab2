<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
</head>
<script src="https://code.jquery.com/jquery-2.2.2.js"
	integrity="sha256-4/zUCqiq0kqxhZIyp4G0Gk+AOtCJsY1TA00k5ClsZYE="
	crossorigin="anonymous"></script>
<body bgcolor="#E6E6FA">

	<center>
		<br /> <br /> <br /> <br />
		<h2>My Profile</h2>
		<form:form modelAttribute="profile" method="delete">
			<table cellpadding="8">
				<tr>
					<td><strong>ID</strong></td>
					<td><form:input path="id" value="${profile.id}"
							readonly="true" /></td>
				</tr>
				<tr>
					<td><strong>FirstName</strong></td>
					<td><form:input path="first_name"
							value="${profile.first_name}" /></td>
				</tr>
				<tr>
					<td><strong>LastName</strong></td>
					<td><form:input path="last_name" value="${profile.last_name}" /></td>
				</tr>
				<tr>
					<td><strong>Email</strong></td>
					<td><form:input path="email" value="${profile.email}" /></td>
				</tr>
				<tr>
					<td><strong>Address</strong></td>
					<td><form:input path="address" value="${profile.address}" /></td>
				</tr>
				<tr>
					<td><strong>Organization</strong></td>
					<td><form:input path="organization"
							value="${profile.organization}" /></td>
				</tr>
				<tr>
					<td><strong>About Myself</strong></td>
					<td><form:input path="about_me" value="${profile.about_me}" /></td>
				</tr>
				<tr>
					<td><input type="submit" name="Delete" value="Delete" /></td>
					<td><spring:url value="/profile/${profile.id}" var="updateUrl" />
						<button type="button" id="update">Update</button></td>
				</tr>
			</table>
	</center>
	</form:form>
	<script type="text/javascript">
		/* $(document).ready(function() {
			$('#update').click(function() {
				$.ajax({
					type : "POST",
					dataType : "json",
					url : "${updateUrl}/",
				    success: function (data) {
					        console.log(data);
				     },
					error : function (data) {
				        console.log(data);
				     }
				});
			});
		}); */

		$(document).ready(function() {
			$("#update").click(function() {
				$.post("${updateUrl}/", {
					first_name : $('#first_name').val(),
					last_name : $('#last_name').val(),
					email : $('#email').val(),
					address : $('#address').val(),
					organization : $('#organization').val(),
					about_me : $('#about_me').val()
				}, function(data, status) {
					$('#first_name').val(data.first_name);
					$('#last_name').val(data.last_name);
					$('#email').val(data.email);
					$('#address').val(data.address);
					$('#organization').val(data.organization);
				});
			});
		});
	</script>
</body>
</html>