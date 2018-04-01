<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Data</title>
</head>
<body>
<table cellspacing="6" cellpadding="6" border="2">
<tr>
<th>Emp Id#</th><th>Emp Name#</th><th>Emp Salary#</th><th>Emp Designation</th>
</tr>
<c:forEach items="${empList}" var="employee">
<tr>
<td><c:out value="${employee.empId}"/></td>
<td><c:out value="${employee.empName}"/></td>
<td><c:out value="${employee.empSalary}"/></td>
<td><c:out value="${employee.empDesignation}"/></td>
</tr>

</c:forEach>

</table>
</body>
</html>