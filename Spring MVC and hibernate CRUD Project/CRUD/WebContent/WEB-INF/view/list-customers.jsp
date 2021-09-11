<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>

	<title> List Customers</title>

<!-- reference to the style sheet css -->

	<link type = "text/css"
			rel="stylesheet"
			href = "${pageContext.request.contextPath}/resources/css/style.css"/>
			
</head>
<body>
	<div id = "wrapper">
		<div id = "header">
			<h2>CRM - APPLICATION</h2>
		</div>
	</div>
	
	<div id = "container">
		<div id = "content">
		
		<!-- adding button for adding customer -->
		
		<input type="button" value="Add Customer"
		onclick="window.location.href = 'showFormForAdd'; return false;"
		class="add-button"/>
		
		<!--  add code for search box -->
		<form:form action="search" method="GET">
			Search Customer: <input type="text" name="theSearchName"/>
			<input type="submit" value="Search" class="add-button">
		 	
		</form:form>
		<input type="submit" value="Show All" onclick="window.location.href = 'list'; return false;" class="add-button"/ >
		
		
		<!-- add our HTML table -->
		
		<table>
			<tr>
				<th> First Name</th>
				<th> Last Name</th>
				<th> Email</th>
				<th> Action </th>
			</tr>
			
			<!-- loop and print out customer -->
			<c:forEach var = "tempCustomer" items = "${customers}">
			
			<!--  construct an update link with customer id -->
			<c:url var="updatelink" value = "/customer/showFormForUpdate">
				<c:param name="customerID" value="${tempCustomer.id }"></c:param>
			
			</c:url>
			
			
			<!--  construct an delete link with customer id -->
			<c:url var="deletelink" value = "/customer/delete">
				<c:param name="customerID" value="${tempCustomer.id }"></c:param>
			
			</c:url>
			
			 	<tr>
			 	
			 		<td> ${tempCustomer.firstName}</td>
			 		
			 		<td> ${tempCustomer.lastName}</td>
			 		
			 		<td> ${tempCustomer.email}</td>
					
					<td> 
						<a href="${updatelink}">Update</a>
						|
						<a href="${deletelink}"
							onclick="if (!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
					</td>			 	
			 	</tr>
			
			
			</c:forEach>
			
			
		</table>
		
		</div>
	
	</div>

	

</body>


</html>