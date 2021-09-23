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
		
			<security:authorize access="hasRole('Manager')">
				<!-- ADD A LINK TO LEADERS -->
				
				<p>
					<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting </a>
					(Only for Managers)
				
				</p>
			</security:authorize>
			
			<security:authorize access="hasRole('ADMIN')">
				<!-- ADD A LINK TO ADMIN -->
				<p>
					<a href="${pageContext.request.contextPath}/systems">ADMIN Meeting </a>
					(Only for Admin)
				
				</p>
			</security:authorize>
			
		<hr>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
	
</body>



</html>