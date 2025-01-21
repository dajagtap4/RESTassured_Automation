package test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {
	@Test
	public void PutTest() {
		
		//https://www.youtube.com/watch?v=QDp7EQga3ME&list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx&index=7
		//01:48
		
		JSONObject request = new JSONObject();

		request.put("name", "Deepak");
		request.put("job", "QA");

		baseURI = "https://reqres.in/api";

		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void PatchTest() {
		JSONObject request = new JSONObject();

		request.put("name", "Deepak");
		request.put("job", "QA");

		baseURI = "https://reqres.in";

		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().put("/api/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void DeleteTest() {
		
		baseURI = "https://reqres.in";

		when().delete("/api/users/2").then().statusCode(204).log().all();
	}
}
