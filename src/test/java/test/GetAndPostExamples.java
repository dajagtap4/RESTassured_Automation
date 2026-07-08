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
		baseURI = "http://localhost:3000";

		given().when().get("/employees").then().statusCode(200).body("[0].name", equalTo("Deepak"))
				.body("name", hasItems("Deepak", "Rahul")).body("[1].city", equalTo("Hyderabad"))
				.body("[0].salary", equalTo(1200000)).log().all();
	}

	@Test
	public void PostTest() {

		// Refer below video link for this test (PostTest) explanation
		// https://www.youtube.com/watch?v=EvG8r7AhanI&list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx&index=6
		// 09:00
		JSONObject request = new JSONObject();

		// request.put("id", "3");
		request.put("name", "kavita");
		request.put("designation", "Channel Partner");
		request.put("salary", "450000");
		request.put("city", "Mumbai");

		baseURI = "http://localhost:3000";

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("/employees").then().statusCode(201).log().all();
	}

	@Test
	public void DeleteUserTest() {

		JSONObject request = new JSONObject();

		baseURI = "http://localhost:3000";

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().delete("/employees/kp60qF9wlZU").then().statusCode(200).log()
				.all();
	}
}
