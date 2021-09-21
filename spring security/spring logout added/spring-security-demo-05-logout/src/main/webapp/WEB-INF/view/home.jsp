<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>

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
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
	
</body>



</html>