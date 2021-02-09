package mockapitests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class MockAPITests {

	@Test
	void test_01_mock_get_users() {
		baseURI = "http://localhost:3000/";
		
		given().
			get("users/").
		then().
			statusCode(200).log().all();
	}
	
	// parameterized test
	@Test
	void test_02_mock_get_param_subjects() {
		baseURI = "http://localhost:3000/";
		
		given().
			params("name", "Automation").
			get("subjects/").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	void test_03_post_user_test() {
		baseURI = "http://localhost:3000/";
		JSONObject payload = new JSONObject();
		payload.put("firstName", "Hema");
		payload.put("lastName", "Durgam");
		payload.put("subjectId", 3);
		payload.put("id", 4);
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(payload.toJSONString()).
		when().
			post("users/").
		then().
			statusCode(201).log().all();
	}
	
	@Test
	void test_04_put_user_test() {
		baseURI = "http://localhost:3000/";
		JSONObject payload = new JSONObject();
		payload.put("firstName", "Sanvi Sri");
		payload.put("lastName", "Durgam");
		payload.put("subjectId", 3);
		payload.put("id", 3);
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(payload.toJSONString()).
		when().
			put("users/3").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	void test_05_patch_user_test() {
		baseURI = "http://localhost:3000/";
		JSONObject payload = new JSONObject();
		payload.put("subjectId", 2);
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(payload.toJSONString()).
		when().
			patch("users/3").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	void test_06_delete_user_test() {
		baseURI = "http://localhost:3000/";
		
		when().
			delete("users/4").
		then().
			statusCode(200).log().all();
	}
}
