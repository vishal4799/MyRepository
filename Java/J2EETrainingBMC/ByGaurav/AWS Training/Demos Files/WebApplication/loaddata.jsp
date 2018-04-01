<%@page import="java.util.HashSet"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.amazonaws.services.dynamodbv2.document.Item"%>
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
		loadSampleProducts("ProductCatalog");
		closeClient();
	%>
	<center>
		<h1>Table Created</h1>
		<a href="fetchdata.jsp">Fetch Data from Table</a>
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

	private void loadSampleProducts(String tableName) {

		Table table = dynamoDB.getTable(tableName);

		try {

			System.out.println("Adding data to " + tableName);

			Item item = new Item().withPrimaryKey("Id", 101).withString("Title", "Book 101 Title")
					.withString("ISBN", "111-1111111111")
					.withStringSet("Authors", new HashSet<String>(Arrays.asList("Author1"))).withNumber("Price", 2)
					.withString("Dimensions", "8.5 x 11.0 x 0.5").withNumber("PageCount", 500)
					.withBoolean("InPublication", true).withString("ProductCategory", "Book");
			table.putItem(item);

			item = new Item().withPrimaryKey("Id", 102).withString("Title", "Book 102 Title")
					.withString("ISBN", "222-2222222222")
					.withStringSet("Authors", new HashSet<String>(Arrays.asList("Author1", "Author2")))
					.withNumber("Price", 20).withString("Dimensions", "8.5 x 11.0 x 0.8").withNumber("PageCount", 600)
					.withBoolean("InPublication", true).withString("ProductCategory", "Book");
			table.putItem(item);

			item = new Item().withPrimaryKey("Id", 103).withString("Title", "Book 103 Title")
					.withString("ISBN", "333-3333333333")
					.withStringSet("Authors", new HashSet<String>(Arrays.asList("Author1", "Author2")))
					// Intentional. Later we'll run Scan to find price error.
					// Find
					// items > 1000 in price.
					.withNumber("Price", 2000).withString("Dimensions", "8.5 x 11.0 x 1.5").withNumber("PageCount", 600)
					.withBoolean("InPublication", false).withString("ProductCategory", "Book");
			table.putItem(item);

			// Add bikes.

			item = new Item().withPrimaryKey("Id", 201).withString("Title", "18-Bike-201")
					// Size, followed by some title.
					.withString("Description", "201 Description").withString("BicycleType", "Road")
					.withString("Brand", "Mountain A")
					// Trek, Specialized.
					.withNumber("Price", 100).withStringSet("Color", new HashSet<String>(Arrays.asList("Red", "Black")))
					.withString("ProductCategory", "Bicycle");
			table.putItem(item);

			item = new Item().withPrimaryKey("Id", 202).withString("Title", "21-Bike-202")
					.withString("Description", "202 Description").withString("BicycleType", "Road")
					.withString("Brand", "Brand-Company A").withNumber("Price", 200)
					.withStringSet("Color", new HashSet<String>(Arrays.asList("Green", "Black")))
					.withString("ProductCategory", "Bicycle");
			table.putItem(item);

			item = new Item().withPrimaryKey("Id", 203).withString("Title", "19-Bike-203")
					.withString("Description", "203 Description").withString("BicycleType", "Road")
					.withString("Brand", "Brand-Company B").withNumber("Price", 300)
					.withStringSet("Color", new HashSet<String>(Arrays.asList("Red", "Green", "Black")))
					.withString("ProductCategory", "Bicycle");
			table.putItem(item);

			item = new Item().withPrimaryKey("Id", 204).withString("Title", "18-Bike-204")
					.withString("Description", "204 Description").withString("BicycleType", "Mountain")
					.withString("Brand", "Brand-Company B").withNumber("Price", 400)
					.withStringSet("Color", new HashSet<String>(Arrays.asList("Red")))
					.withString("ProductCategory", "Bicycle");
			table.putItem(item);

			item = new Item().withPrimaryKey("Id", 205).withString("Title", "20-Bike-205")
					.withString("Description", "205 Description").withString("BicycleType", "Hybrid")
					.withString("Brand", "Brand-Company C").withNumber("Price", 500)
					.withStringSet("Color", new HashSet<String>(Arrays.asList("Red", "Black")))
					.withString("ProductCategory", "Bicycle");
			table.putItem(item);

		} catch (Exception e) {
			System.err.println("Failed to create item in " + tableName);
			System.err.println(e.getMessage());
		}
	}

	private void closeClient() {

		dynamoDB.shutdown();
	}%>