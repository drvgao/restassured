package basictests;

//without creating objects, directly use.
import static io.restassured.RestAssured.given;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class RestAssuredBDD {

	@Test
	void test_02_BDD_get() {
//		given().get("http://localhost:3000/posts/").then().statusCode(200); //ex1: works
//		given().get("http://localhost:3000/posts/").then().body("author", equalTo("Karthik K")); //ex2: fails
		given().get("http://localhost:3000/posts/").then()
		.statusCode(200)
		.body("author", hasItems("Karthik KK")); // ex3: works
	}

	@Test
	void test_03_BDD_get_log() {
		given().get("http://localhost:3000/posts/").then()
		.statusCode(200)
		.log().all();
	}
}
