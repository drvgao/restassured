package basictests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

//https://www.youtube.com/watch?v=IbJdcApXziU&ab_channel=AutomationStepbyStep-RaghavPal

public class FirstRestAssuredClass {

	@Test
	public void test_01_get_posts() {
		Response response = RestAssured.get("http://localhost:3000/posts/");
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeaders());
		System.out.println(response.getTime());
		
//		assertion
		int statusCode = response.getStatusCode();
		AssertJUnit.assertEquals(statusCode, 200);
	}

}
