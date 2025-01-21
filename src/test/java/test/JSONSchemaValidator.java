package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.Test;

public class JSONSchemaValidator {

	@Test
	public void getTest() {
		
		//https://www.youtube.com/watch?v=rkGI32WXmPQ&list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx&index=10
		// use this video for JSON schema validation
		
		baseURI = "https://reqres.in/api";

		given().get("/users?page=2").then()
		.assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
		.statusCode(200);
	}
}
