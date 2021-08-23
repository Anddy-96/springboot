<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title> Student Registration Form </title>

</head>


<body>
	<form:form action="processForm" modelAttribute="student">
	First Name: <form:input path="firstname"/>
	<br><br>	
	Last Name: <form:input path="lastname"/>
	<br><br>
	Country: <form:select path="country">
				<form:options items = "${student.options }"/>
	</form:select>
	<br><br>
	
	Suitable Language: 
		JAVA<form:radiobutton path="favlan" value ="Java"/>
		C++<form:radiobutton path="favlan" value ="C++"/>
		PHP<form:radiobutton path="favlan" value ="PHP"/>
		C<form:radiobutton path="favlan" value ="C"/>
		
	<br><br>
	Known Operating System:
	Windows <form:checkbox path="opsy" value = "Windows"/>
	Linux <form:checkbox path="opsy" value = "Linux"/>
	MAC OS <form:checkbox path="opsy" value = "Mac OS"/>
	
	
	
	<br><br>
	<input type="submit" value ="Submit"/>
	
	
	
	
	</form:form>


</body>

</html>