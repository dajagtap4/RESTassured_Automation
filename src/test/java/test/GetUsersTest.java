package test;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class GetUsersTest {
	@Test
	public void getUsers() {

		// npm install -g json-server
		// db.json file search on laptop its available at C:\Users\Deepak\db.json
		// Start the server -> json-server --watch db.json
		// Opne http://localhost:3000

		baseURI = "http://localhost:3000";

		given().
		when().
		 get("/posts").
		then().
		 statusCode(200);

	}
}
