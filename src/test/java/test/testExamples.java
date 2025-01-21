package test;

//import static io.restassured.RestAssured.*;
// We can use above, instead of below 3
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class testExamples {
	@Test
	public void testOne() {

		// Refer below video link for this test (testOne) explanation
		// https://www.youtube.com/watch?v=vgMyJhrMV0o&list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx
		// From 03:55
		
		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println("getStatusCode :" + response.getStatusCode());
		System.out.println("getTime :" + response.getTime());
		System.out.println("getBody :" + response.getBody().asString());
		System.out.println("getStatusLine :" + response.getStatusLine());

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void testTwo() {
		
		// Refer below video link for this test (testTwo) explanation
		// https://www.youtube.com/watch?v=iXQimBnjgfc&list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx&index=5
		// 02:20
		
		baseURI = "https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[2].first_name", equalTo("Tobias")).
		log().all();
		
	}
}
