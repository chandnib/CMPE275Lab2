<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head><title>Save User Data</title></head>
<body>
  <h3>Save User Data</h3>
  <form:form action="save" method="post">
      First Name:<input type="text" name="firstName"> <br/>
      Last Name:<input type="text" name="lastName"> <br/>
      Email:<input type="text" name="email"> <br/>
      Address :<input type="text" name="address"/><br/>
      Organization :<input type="text" name="organization"/><br/>
      About :<input type="text" name="aboutme"/><br/>
      <input type="submit" value="Submit"/>
  </form:form>
</body>
</html> 