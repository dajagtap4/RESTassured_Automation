package test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class GetAndPostExamples {

	@Test
	public void GetTest() {
		baseURI = "https://reqres.in/api";

		given().get("/users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George"))
				.body("data.first_name", hasItems("George", "Rachel", "Byron")).log().all();
	}

	
	@Test
	public void PostTest() {
		
		// Refer below video link for this test (PostTest) explanation
		// https://www.youtube.com/watch?v=EvG8r7AhanI&list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx&index=6
		// 09:00
		JSONObject request = new JSONObject();

		request.put("name", "Deepak");
		request.put("job", "QA");

		baseURI = "https://reqres.in/api";

		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}
}
