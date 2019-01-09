<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring get Data</title>
</head>
<body>
<p> Test Data:
<% request.getParameter("data");
String t = (String)request.getAttribute("Test");
out.println(t+" *******");
%><br>
</p>
<p>
Param Data: ${ param.data} <br>
From Data ${testData } <br>
</p>
<!-- ${Test } -->
<br>
<p> data from the Annotated Form :
${ annotateData}
</p>
<a href="http://localhost:8070/springmvcx/menu">back to menu</a>
</body>
</html>