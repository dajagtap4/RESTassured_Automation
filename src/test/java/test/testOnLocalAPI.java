package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.*;


public class testOnLocalAPI {

	@Test
	public void get() {

		baseURI = "http://localhost:3000/";

		given().get("/posts").then().statusCode(200).log().all();

	}

	@Test
	public void post() {

		JSONObject request = new JSONObject();

		request.put("firstname", "akshay");
		request.put("lastname", "kumar");
		request.put("location", "Mumbai");

		baseURI = "http://localhost:3000/";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when().post("/users")
				.then().statusCode(201);
	}

	@Test
	public void put() {

		JSONObject request = new JSONObject();

		request.put("firstname", "pratush");
		request.put("lastname", "mishra");
		request.put("location", "pune");

		baseURI = "http://localhost:3000";

		// Correct the URL to /users/2 (without query parameters)
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when().put("/users/573a") 
		.then().statusCode(200); // Expecting status 200 (OK) after successful update
	}

	@Test
	public void patch() {

		JSONObject request = new JSONObject();

		request.put("lastname", "naik");

		baseURI = "http://localhost:3000";

		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toString()).when()
				.patch("/users/573a").then().statusCode(200);

	}	

	@Test
	public void delete() {

		baseURI = "http://localhost:3000";

		when().delete("/users/573a").then().statusCode(200);
	}
}
