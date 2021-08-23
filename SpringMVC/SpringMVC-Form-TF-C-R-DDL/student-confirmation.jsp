<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

	<title> Student Confirmation Page </title>

</head>



<body>
	The Student is confirmed: ${student.firstname} ${student.lastname} 
	<br><br>
	The Student contury is: ${student.country}
	<br><br>
	the choosen language is: ${student.favlan }
	<br><br>
	
Operating System
	<ul>
		<c:forEach var="temp" items ="${student.opsy }">
			<li> ${temp} </li>	
		</c:forEach>
	</ul>
	


</body>

</html>