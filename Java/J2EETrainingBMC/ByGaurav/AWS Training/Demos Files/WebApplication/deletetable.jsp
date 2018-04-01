<%@page import="com.amazonaws.services.dynamodbv2.document.Table"%>
<%@page import="com.amazonaws.regions.Region"%>
<%@page import="com.amazonaws.regions.Regions"%>
<%@page import="com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient"%>
<%@page import="com.amazonaws.auth.BasicAWSCredentials"%>
<%@page import="com.amazonaws.auth.AWSCredentials"%>
<%@page import="com.amazonaws.services.dynamodbv2.document.DynamoDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		logindetails();
		deleteTable("ProductCatalog");
		closeClient();
	%>
	<center>
		<h1>Table Deleted....</h1>
	</center>
</body>
</html>

<%!private DynamoDB dynamoDB;

	private void logindetails() {

		//AWSCredentials credentials = new BasicAWSCredentials("",
		//		"");

		//AmazonDynamoDBClient amazonDynamoDBClient = new AmazonDynamoDBClient(credentials);
		AmazonDynamoDBClient amazonDynamoDBClient = new AmazonDynamoDBClient();
		Region usEast1 = Region.getRegion(Regions.US_EAST_1);
		amazonDynamoDBClient.setRegion(usEast1);
		dynamoDB = new DynamoDB(amazonDynamoDBClient);
	}

	private void deleteTable(String tableName) {
		Table table = dynamoDB.getTable(tableName);
		try {
			System.out.println("Issuing DeleteTable request for " + tableName);
			table.delete();
			System.out.println("Waiting for " + tableName + " to be deleted...this may take a while...");
			table.waitForDelete();

		} catch (Exception e) {
			System.err.println("DeleteTable request failed for " + tableName);
			System.err.println(e.getMessage());
		}
	}

	private void closeClient() {

		dynamoDB.shutdown();
	}%>

