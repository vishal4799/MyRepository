<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springhtml" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="springcore" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<springhtml:form modelAttribute="employee" method="post" action="registerProcess.htm">
<table cellspacing="8" cellpadding="8" border="2">
<tr>
<td><springhtml:label path="empId">Emp Id:</springhtml:label></td>
<td><springhtml:input path="empId" size="40" readonly="true"></springhtml:input></td>
</tr>
<tr>
<td><springhtml:label path="empName">Emp Name:</springhtml:label></td>
<td><springhtml:input path="empName" size="40"></springhtml:input></td>
</tr>
<tr>
<td><springhtml:label path="empSalary" >Emp Salary:</springhtml:label></td>
<td><springhtml:input path="empSalary" size="40"></springhtml:input>
<springhtml:errors path="empSalary" cssStyle="color:red"></springhtml:errors>
</td>
</tr>

<tr>
<td><springhtml:label path="empDesignation" >Emp Designation:</springhtml:label></td>
<td><springhtml:input path="empDesignation" size="40"></springhtml:input>
<springhtml:errors path="empDesignation" cssStyle="color:red"></springhtml:errors>
</td>
</tr>

<tr>
<td><springhtml:label path="locationName">Location:</springhtml:label></td>
<td>
<springhtml:select path="locationName">
<springhtml:options items="${locationList}"/>
</springhtml:select>
</td>
</tr>
<tr>


<td><input type="submit" value="<springcore:message code="registerbuttonlabel"></springcore:message>"/></td>
<td><input type="reset" value="Cancel"/></td>
</table>
</springhtml:form>
${status}
</body>
</html>