//How to run SOAP API from file | How to Validate XML

package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class SOAP_XML_Request {
	@Test
	public void validateSoapXML() throws IOException {

		File file = new File("./SoapRequest/add.xml");

		if (file.exists()) {
			System.out.println(">> >> File Existed");
		}
		FileInputStream fileinputstream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileinputstream, "UTF-8");

		baseURI = "http://www.dneonline.com";

		given().contentType("text/xml").accept(ContentType.XML).body(requestBody).when().post("/calculator.asmx").then()
				.statusCode(200).log().all();
	}
}
