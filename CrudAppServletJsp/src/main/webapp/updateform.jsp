<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${student ne null || !empty student }">

<form method='get' action='./controller/updateRecord'>
<table align='center'>
<tr>
<th>SID</th>
<td><input type='text' name='sid' value='${student.id}' readonly="readonly"/></td>
</tr>
<tr>
<th>SNAME</th>
<td><input type='text' name='sname' value='${student.name}' /></td>
</tr>
<tr>
<th>SAGE</th>
<td><input type='text' name='sage' value='${student.age}' /></td>
</tr>
<tr>
<th>SADDRESS</th>
<td><input type='text' name='saddr' value='${student.address}' /></td>
</tr>
<tr>
<th></th>
<td><input type='submit' value='update' /></td>
</tr>
</table>
</form>
</c:when>

<c:otherwise>
<h1 style='color:red; text-align:center;'>RECORD NOT FOUND FOR GIVEN ID</h1>
</c:otherwise>

</c:choose>

</body>
</html>