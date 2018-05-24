<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demonstration</title>
</head>
<body>
<span id="error" style="color:red"></span>
<form action="/login" method="post">
Username: <input type="text" name="username" required/>
Password: <input type="password" name="password" required/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input type="submit"  value="Submit"/>
</form>

<script>
if(window.location.href.includes('?error'))
	document.getElementById("error").innerHTML="Invalid Credentials";
</script>
</body>
</html>