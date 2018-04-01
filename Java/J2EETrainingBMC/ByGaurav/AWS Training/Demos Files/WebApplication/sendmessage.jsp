<%@page import="com.amazonaws.services.sqs.model.SendMessageRequest"%>
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

		sendMessageToQueue("https://sqs.us-east-1.amazonaws.com/928092407064/myqueue",
				"This is my SQS message text.");

		closeClient();
	%>
	<center>
		<h1>Message Send</h1>
		<a href="receivemessage.jsp">Receive message from SQS</a>
	</center>
</body>
</html>

<%!private AmazonSQSClient sqsClient;

	private void logindetails() {

		//AWSCredentials credentials = new BasicAWSCredentials("",
		//		"");

		//sqsClient = new AmazonSQSClient(credentials);
		sqsClient = new AmazonSQSClient();
		Region usEast1 = Region.getRegion(Regions.US_EAST_1);
		sqsClient.setRegion(usEast1);
	}

	private void sendMessageToQueue(String queueUrl, String messageBody) {

		SendMessageRequest sendMessageRequest = new SendMessageRequest(queueUrl, messageBody);
		sqsClient.sendMessage(sendMessageRequest);
		System.out.println("message send....");
	}

	private void closeClient() {

		sqsClient.shutdown();
	}%>