package com.cognitodemo;

import com.amazonaws.services.cognitoidentity.*;
import com.amazonaws.services.cognitoidentity.model.*;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.auth.*;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult;
import com.amazonaws.services.securitytoken.model.Credentials;

public class TestCase2 {

	public static void main(String[] args) {

		AmazonCognitoIdentity identityClient = new AmazonCognitoIdentityClient();

		// Call the GetId API providing your AWS account and identity pool
		// details to retrieve a unique identifier for your end user.
		// You should then cache the identity id returned.

		GetIdRequest idRequest = new GetIdRequest();
		//idRequest.setAccountId("928092407064");
		idRequest.setIdentityPoolId("us-east-1:c0534acc-f882-4770-a8ad-366044f8c497");
		identityClient.setRegion(Region.getRegion(Regions.US_EAST_1));
		
		Map<String,String> providerTokens = new HashMap<>();
		String fbAccessToken = "EAAKxVJjrolsBAKbFChZBw0fyYRYRlJFdcMuYidX0SRV3O6ziLeWq2FBGTZAZA0j6tDOCepFNMJOeqkgoYmor1ZAZBzcXnZCvZAgj9388uwaf9AuyYc0lhWbzqp1bolVrvmU3FjDRNkqDweR4I7MZAOlBnhAXGtmXs2zfTiFmruBDQQUUpqljnKe08w5YQBmmZAI0ZD";
		providerTokens.put("graph.facebook.com", fbAccessToken);

		idRequest.setLogins(providerTokens);
		
		
		GetIdResult idResp = identityClient.getId(idRequest);
		String identityId = idResp.getIdentityId();

		System.out.println("------------------------------------------------------------");
		System.out.println("identityId: \n" + identityId);
		System.out.println("------------------------------------------------------------");

		// TODO: At this point you should save this identifier so you won't
		// have to make this call the next time a user connects
		// ----------------------------------------------------------------------------

		// Call the GetOpenIdToken API to receive a valid OpenId Connect token
		// for the unique identifier you retrieve with the GetId call.

		// The token returned by this call can be traded to the Security Token
		// Service (STS) in exchange for temporary, limited-privilege AWS
		// credentials.

		GetOpenIdTokenRequest tokenRequest = new GetOpenIdTokenRequest();
		tokenRequest.setIdentityId(identityId);

		tokenRequest.setLogins(providerTokens);
		
		GetOpenIdTokenResult tokenResp = identityClient.getOpenIdToken(tokenRequest);
		String openIdToken = tokenResp.getToken();

		System.out.println("openIdToken: \n" + openIdToken);
		System.out.println("------------------------------------------------------------");

		// you can now create a set of temporary, limited-privilege credentials
		// to access your AWS resources through the Security Token Service
		// utilizing the
		// OpenID token returned by the previous API call. The IAM Role ARN
		// passed to
		// this call will be applied to the temporary credentials returned
		AWSSecurityTokenService stsClient = new AWSSecurityTokenServiceClient(new AnonymousAWSCredentials());

		AssumeRoleWithWebIdentityRequest stsReq = new AssumeRoleWithWebIdentityRequest();
		stsReq.setRoleArn("arn:aws:iam::928092407064:role/Cognito_myauthenticatedapplicationpoolAuth_Role");
		stsReq.setWebIdentityToken(openIdToken);
		stsReq.setRoleSessionName("AppTestSession");

		AssumeRoleWithWebIdentityResult stsResp = stsClient.assumeRoleWithWebIdentity(stsReq);
		Credentials stsCredentials = stsResp.getCredentials();

		System.out.println("getAccessKeyId: \n" + stsCredentials.getAccessKeyId());
		System.out.println("getSecretAccessKey: \n" + stsCredentials.getSecretAccessKey());
		System.out.println("getSessionToken: \n" + stsCredentials.getSessionToken());
		System.out.println("getExpiration: \n" + stsCredentials.getExpiration());
		System.out.println("------------------------------------------------------------");

		AWSSessionCredentials sessionCredentials = new BasicSessionCredentials(stsCredentials.getAccessKeyId(),
				stsCredentials.getSecretAccessKey(), stsCredentials.getSessionToken());

		System.out.println("getAWSAccessKeyId: \n" + sessionCredentials.getAWSAccessKeyId());
		System.out.println("------------------------------------------------------------");

		// Perform ListBucket operation on S3
		AmazonS3Client s3client = new AmazonS3Client(sessionCredentials);
		s3client.setEndpoint("ec2.us-east-1.amazonaws.com");
		s3client.setRegion(Region.getRegion(Regions.US_EAST_1));

		listBuckets(s3client);

	}

	private static void listBuckets(AmazonS3Client amazonS3Client) {

		List<Bucket> buckets = amazonS3Client.listBuckets();
		for (Bucket bucket : buckets) {

			System.out.println("Bucket Name:" + bucket.getName());
			System.out.println("Bucket Owner:" + bucket.getOwner().getDisplayName() + "\t" + bucket.getOwner().getId());

			ObjectListing objectListing = amazonS3Client.listObjects(bucket.getName());
			List<S3ObjectSummary> summaries = objectListing.getObjectSummaries();

			for (S3ObjectSummary summary : summaries) {

				System.out.println(summary.getKey() + "\t" + amazonS3Client.getUrl(bucket.getName(), summary.getKey()));
			}
		}
	}
}
