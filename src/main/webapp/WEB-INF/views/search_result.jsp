<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Result</title>
</head>
<body>
	<h2>Search Result</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>City</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>	
			<%
				ResultSet set= (ResultSet)request.getAttribute("result");// return type of getAttribute is object so, typecasting is done
				while(set.next()){
			%>		
			
		<tr>
			<td><%=set.getString(1)%> </td>
			<td><%=set.getString(2)%> </td>
			<td><%=set.getString(3)%> </td>
			<td><%=set.getString(4)%> </td>
			<td><a href="delete?emailId=<%=set.getString(3) %>">delete</a></td>
			<td><a href="update?emailId=<%=set.getString(3) %>&mobile=<%=set.getString(4) %>">update</a></td>
		</tr>
			
			<%}%>			
			
		
	</table>
</body>
</html>