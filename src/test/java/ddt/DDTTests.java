package ddt;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DDTTests {

	/*
	 * The testNG data provider annotation provides the row-column data to the
	 * users/ post api. Note, the name is used as reference in the calling method.
	 * And matched no# of arguments.
	 * Assigning values to individual element is not effective.
	 */
	@DataProvider(name = "users-payload2")
	public Object[][] userData() {
		Object[][] users = new Object[2][3];

		users[0][0] = "Prabhas";
		users[0][1] = "Raj";
		users[0][2] = 1;

		users[1][0] = "Herald";
		users[1][1] = "Finch";
		users[1][2] = 2;

		return users;

	}

	// A better way to use DataProvider with direct values.
	@DataProvider(name = "users-payload")
	public Object[][] usersData() {

		return new Object[][] { { "John", "Reese", 2 }, { "Groove", "Root", 1 } };

	}

	@Test(dataProvider = "users-payload")
	void test_01_post_user_test(String fname, String lname, int subjectId) {
		baseURI = "http://localhost:3000/";
		JSONObject payload = new JSONObject();
		payload.put("firstName", fname);
		payload.put("lastName", lname);
		payload.put("subjectId", subjectId);

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(payload.toJSONString()).when().post("users/").then().statusCode(201).log().all();
	}

	@DataProvider(name = "deleteUserIDs")
	public Object[] deleteUsersDP() {
		return new Object[] { 5, 6, 7 };
	}

	@Test(dataProvider = "deleteUserIDs")
	void test_02_delete_user_test(int id) {
		baseURI = "http://localhost:3000/";

		when().delete("users/" + id).then().statusCode(200).log().all();
	}

	/*
	 * The below parameter userId is referenced from testng.xml file. To use this
	 * feature, run the test with testng.xml file as suite.
	 */
	@Parameters({ "userId" })
	@Test
	void test_03_delete_user_test(int userId) {
		baseURI = "http://localhost:3000/";

		when().delete("users/" + userId).then().statusCode(200).log().all();
	}

	@Test
	void test_00_get_users() {
		baseURI = "http://localhost:3000/";

		given().get("users/").then().statusCode(200).log().all();
	}
}
