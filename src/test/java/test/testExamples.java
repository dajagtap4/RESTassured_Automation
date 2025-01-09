package test;

import org.testng.Assert;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class testExamples {
	@Test
	public void testOne() {

		Response response = get("https://reqres.in/api/users?page=2");
		//
		System.out.println("getStatusCode :" + response.getStatusCode());
		System.out.println("getTime :" + response.getTime());
		System.out.println("getBody :" + response.getBody().asString());
		System.out.println("getStatusLine :" + response.getStatusLine());

		int statusCode = response.getStatusCode();

		Assert.assertEquals(statusCode, 200);

	}

	@Test
	public void testTwo() {
		
		baseURI = "https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[1].id", equalTo(8)).
		log().all();
		
	}
}
