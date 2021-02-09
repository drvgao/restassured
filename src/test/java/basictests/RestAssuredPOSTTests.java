package basictests;

//without creating objects, directly use.
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

/**
 * To post data use simple map collection or use json libraries like gson,
 * Jackson, json.
 *
 * JSON Simple: Library to serialize and deserialize JSON data. use
 * toJSONString() for better results for serialization.
 * 
 * @author Rajesh Durgam
 * @version 1.0
 * @since 2021-02-08
 */
public class RestAssuredPOSTTests {

	@Test
	void test_01_BDD_post() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "Rajesh Durgam");
		map.put("job", "Software QA Engg");

		System.out.println("map > " + map);

		// Use JSON Simple library to serialize map data to json
		JSONObject payload = new JSONObject(map);
		System.out.println(payload);
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(payload.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);
	}

	@Test
	void test_01_how_to_use_JSON_Library() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "Rajesh Durgam");
		map.put("job", "Software QA Engg");

		System.out.println("map > " + map);

		// Use JSON Simple library to serialize map data to json
		JSONObject payload = new JSONObject(map);
		System.out.println(payload);
		System.out.println(payload.toJSONString());

	}

	@Test
	void test_02_how_to_use_JSON_Library_without_map() {
		JSONObject payload = new JSONObject();
		payload.put("name", "Rajesh Durgam");
		payload.put("job", "Software QA Engg");
		System.out.println(payload);
		System.out.println(payload.toJSONString());

	}
}
