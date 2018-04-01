<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table cellpadding="2" cellspacing="2" border="2">

<tr>
<th>EMP ID#</th><th>EMP NAME#</th><th>EMP SALARY#</th><th>EMP DESIGNATION#</th>
</tr>

<c:forEach items="${empList}" var="employee" >
<tr>
<td>${employee.empId}</td>
<td>${employee.empName}</td>
<td>${employee.empSalary}</td>
<td>${employee.empDesignation}</td>
</tr>

</c:forEach>

</table>

</body>
</html>