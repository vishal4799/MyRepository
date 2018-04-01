<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<springform:form modelAttribute="employee" method="post" action="registerProcess.htm">

<table cellpadding="2" cellspacing="2" border="2">
<tr>
<td>Emp Id:</td>
<td><springform:input path="empId"/></td>
</tr>

<tr>
<td>Emp Name:</td>
<td><springform:input path="empName"/></td>
</tr>

<tr>
<td>Emp Salary:</td>
<td><springform:input path="empSalary"/><springform:errors path="empSalary" cssStyle="color:red"></springform:errors></td>
</tr>

<tr>
<td>Emp Designation:</td>
<td><springform:input path="empDesignation"/><springform:errors path="empDesignation" cssStyle="color:red"></springform:errors></td>
</tr>

<tr>
<td><input type="submit" value="Register"></td>
<td><input type="reset" value="Cancel"></td>
</tr>

</table>
${status}
</springform:form>
</body>
</html>