<%@page import="com.amazonaws.services.dynamodbv2.model.AttributeValue"%>
<%@page import="java.util.Map"%>
<%@page import="com.amazonaws.services.dynamodbv2.model.ScanResult"%>
<%@page import="com.amazonaws.services.dynamodbv2.model.ScanRequest"%>
<%@page import="com.amazonaws.regions.Region"%>
<%@page import="com.amazonaws.regions.Regions"%>
<%@page import="com.amazonaws.auth.AWSCredentials"%>
<%@page import="com.amazonaws.auth.BasicAWSCredentials"%>
<%@page import="com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
			logindetails();

			ScanRequest scanRequest = new ScanRequest().withTableName("ProductCatalog");

			ScanResult result = amazonDynamoDBClient.scan(scanRequest);
			for (Map<String, AttributeValue> item : result.getItems()) {
		%>
		<%
			for (Map.Entry<String, AttributeValue> record : item.entrySet()) {

					String attributeName = record.getKey();
					AttributeValue value = record.getValue();
					Object data = attributeName + "=" + (value.getS() == null ? "" : value.getS())
							+ (value.getN() == null ? "" : value.getN()) + (value.getB() == null ? "" : value.getB())
							+ (value.getSS() == null ? "" : value.getSS())
							+ (value.getNS() == null ? "" : value.getNS())
							+ (value.getBS() == null ? "" : value.getBS());
		%>
		<%=data%>&nbsp;
		<%
			}
		%>
		<br />

		<%
			}
		%>

		<a href="deletetable.jsp">Delete Table</a>

		<%
			closeClient();
		%>
	</center>
</body>
</html>

<%!private AmazonDynamoDBClient amazonDynamoDBClient;

	private void logindetails() {

		//AWSCredentials credentials = new BasicAWSCredentials("",
		//		"");

		//amazonDynamoDBClient = new AmazonDynamoDBClient(credentials);
		amazonDynamoDBClient = new AmazonDynamoDBClient();
		Region usEast1 = Region.getRegion(Regions.US_EAST_1);
		amazonDynamoDBClient.setRegion(usEast1);
	}

	private void closeClient() {

		amazonDynamoDBClient.shutdown();
	}%>