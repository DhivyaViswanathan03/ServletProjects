<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Record</title>
</head>
<body bgcolor="lightblue" >

<c:choose>

<c:when test="${student ne null || !empty student }">
<br/>
<br/>
<br/>
<table border='1' align='center'>

<tr>
<th>SID</th>
<th>SNAME</th>
<th>SGAE</th>
<th>SADDRESS</th>
</tr>
<tr>
<td>${student.id}</td>
<td>${student.name}</td>
<td>${student.age}</td>
<td>${student.address}</td>
</tr>
</table>
</c:when>
<c:otherwise>
<h1 style='color:red; text-align:center;'> RECORD NOT FOUND</h1>
</c:otherwise>
</c:choose>

</body>
</html>