<%@page import="com.amazonaws.services.sqs.model.Message"%>
<%@page import="java.util.List"%>
<%@page import="com.amazonaws.services.sqs.model.ReceiveMessageResult"%>
<%@page import="com.amazonaws.services.sqs.model.ReceiveMessageRequest"%>
<%@page import="com.amazonaws.regions.Region"%>
<%@page import="com.amazonaws.regions.Regions"%>
<%@page import="com.amazonaws.auth.BasicAWSCredentials"%>
<%@page import="com.amazonaws.auth.AWSCredentials"%>
<%@page import="com.amazonaws.services.sqs.AmazonSQSClient"%>
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

		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(
				"https://sqs.us-east-1.amazonaws.com/928092407064/myqueue");
		ReceiveMessageResult receiveMessageResult = sqsClient.receiveMessage(receiveMessageRequest);
		List<Message> messages = receiveMessageResult.getMessages();
		for (Message message : messages) {
	%>
	<h1><%=message.getBody()%></h1>
	<%
		}

		closeClient();
	%>
	<center>
		<a href="deletemessage.jsp">Delete message from SQS</a>
	</center>
</body>
</html>

<%!private AmazonSQSClient sqsClient;
	private String messageBody;

	private void logindetails() {

		//AWSCredentials credentials = new BasicAWSCredentials("",
		//		"");

		//sqsClient = new AmazonSQSClient(credentials);
		sqsClient = new AmazonSQSClient();
		Region usEast1 = Region.getRegion(Regions.US_EAST_1);
		sqsClient.setRegion(usEast1);
	}

	private void closeClient() {

		sqsClient.shutdown();
	}%>