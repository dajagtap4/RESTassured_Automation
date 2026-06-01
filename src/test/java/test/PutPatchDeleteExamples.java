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

		request.put("firstname", "amol");
        request.put("location", "Nanded");
		request.put("lastname", "jadhav"); //naik previously

        baseURI = "http://localhost:3000";

		        given().
		        header("Content-Type","application/json").
		        contentType(ContentType.JSON).
                accept(ContentType.JSON).
		        body(request.toJSONString()).
                when().
                put("/users/8c7e").
                then().
                statusCode(200).
                log().all();
	}
	
	@Test
		JSONObject request = new JSONObject();

        request.put("location", "Mumbai");

        baseURI = "http://localhost:3000";

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/users/ESFKhKCg9hs").
                then().
                statusCode(200).
                log().all();
	}
	
	@Test
	public void DeleteTest() {

        baseURI = "http://localhost:3000";

		when().delete("/users/8aSR0DMAJoc").then().statusCode(200).log().all();
	}
}
