package test;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class GetUsersTest {
	@Test
	public void getUsers() {

		baseURI = "http://localhost:3000";

		given().when().get("/users").then().statusCode(200);

	}
}
