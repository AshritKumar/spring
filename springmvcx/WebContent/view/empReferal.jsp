<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Referal</title>
</head>
<body>

<form:form modelAttribute="employee" action="processReferal">

First Name: <form:input path="firstName"/> <br>
Last Name: <form:input path="lastName"/> <br>
Father Name: <form:input path="fatherName"/> <br> 
Country: <form:select path="country">
	<form:options items="${employee.countries  }"/> <!-- get from the employee object hash map -->
</form:select>
Sex: Male: <form:radiobutton path="sex" value="Male"/>
Female: <form:radiobutton path="sex" value="Female"/>
Other: <form:radiobutton path="sex" value="Other"/>
<form:checkboxes items="${employee.allLanguages }" path=""/>
<input type="submit" value="Refer">


</form:form>

</body>
</html>