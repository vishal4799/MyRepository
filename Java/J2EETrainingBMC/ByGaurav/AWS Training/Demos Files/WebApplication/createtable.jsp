<%@page import="com.amazonaws.services.dynamodbv2.util.TableUtils"%>
<%@page
	import="com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput"%>
<%@page
	import="com.amazonaws.services.dynamodbv2.model.CreateTableRequest"%>
<%@page
	import="com.amazonaws.services.dynamodbv2.model.AttributeDefinition"%>
<%@page import="com.amazonaws.services.dynamodbv2.model.KeyType"%>
<%@page
	import="com.amazonaws.services.dynamodbv2.model.KeySchemaElement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.amazonaws.regions.Regions"%>
<%@page import="com.amazonaws.regions.Region"%>
<%@page import="com.amazonaws.auth.BasicAWSCredentials"%>
<%@page import="com.amazonaws.auth.AWSCredentials"%>
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

	<%
		logindetails();

		createTable("ProductCatalog", 10L, 5L, "Id", "N");

		closeClient();
	%>
	<center>
		<h1>Table Created</h1>
		<a href="loaddata.jsp">Load Data in Table</a>
	</center>
</body>
</html>


<%!private AmazonDynamoDBClient dynamoDB;

	private void logindetails() {

		//AWSCredentials credentials = new BasicAWSCredentials("","");

		//dynamoDB = new AmazonDynamoDBClient(credentials);
		dynamoDB = new AmazonDynamoDBClient();
		Region usEast1 = Region.getRegion(Regions.US_EAST_1);
		dynamoDB.setRegion(usEast1);
	}

	private void createTable(String tableName, long readCapacityUnits, long writeCapacityUnits, String partitionKeyName,
			String partitionKeyType) {

		try {

			ArrayList<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
			keySchema.add(new KeySchemaElement().withAttributeName(partitionKeyName).withKeyType(KeyType.HASH)); // Partition
																													// key
			ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
			attributeDefinitions.add(
					new AttributeDefinition().withAttributeName(partitionKeyName).withAttributeType(partitionKeyType));

			CreateTableRequest request = new CreateTableRequest().withTableName(tableName).withKeySchema(keySchema)
					.withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(readCapacityUnits)
							.withWriteCapacityUnits(writeCapacityUnits));

			request.setAttributeDefinitions(attributeDefinitions);

			System.out.println("Issuing CreateTable request for " + tableName);
			TableUtils.createTableIfNotExists(dynamoDB, request);
			System.out.println("Waiting for " + tableName + " to be created...this may take a while...");
			TableUtils.waitUntilActive(dynamoDB, tableName);

		} catch (Exception e) {
			System.err.println("CreateTable request failed for " + tableName);
			System.err.println(e.getMessage());
		}
	}

	private void closeClient() {

		dynamoDB.shutdown();
	}%>
