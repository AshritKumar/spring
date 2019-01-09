<%@page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Set"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Main Menu</title>
</head>
<body>
	<form:form method="POST" action="${pageContext.request.contextPath }/logout">
		<input type="submit" value="logout">
	</form:form>
	Spring Framework
	<form action="smvc/sendData">
		Controller: <input type="text" name="data"/>
		<input type="submit">
	</form> <br>
	
	<form action="smvc/sendDataWithAnnotation">
		Annotated Controller : <input type="text" name="data"/>
		<input type="submit">
	</form>
	<a href="emp/referEmp">Employee Referal</a>
	<hr>
	Security details
	<hr> 
	User Name: <security:authentication property="principal.username"/> <br>
	Roles: <security:authentication property="principal.authorities"/> <!-- for roles -->
	<%-- <%
	 UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().
	   getAuthentication().getPrincipal();
	   System.out.println(userDetails.getPassword());
	   System.out.println(userDetails.getUsername());
	   System.out.println(userDetails.isEnabled());
	%> --%>
	<a href="adminAction">Admin Links (Only for Admins)</a> <br>
	<a href="empAction">Employee Links (Only for employees)</a> <br>
	<a href="managerAction">Manager Links (For employee and managers)</a> <br>
</body>
</html>