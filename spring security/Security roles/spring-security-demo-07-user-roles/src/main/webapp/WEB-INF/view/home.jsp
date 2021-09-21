<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri = "http://www.springframework.org/security/tags" %>
<html>
<head>

<title> Welcome to the new page</title>

</head>


<body>

	<h2> my home page</h2>
	<hr>
	<p>
	Warm welcome 
	</p>
		<hr>
			<p>
				
				User: <security:authentication property="principal.username"/>
				<br><br>
				Roles: <security:authentication property="principal.authorities"/>
				
			</p>
			
			
		<hr>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
	
</body>



</html>