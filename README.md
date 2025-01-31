# RESTAssured_Automation

***Refer this Videos***
https://www.youtube.com/watch?v=oVNbaBlrhbo&list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx&index=1

Pre Requisites

1. ***java***
2. ***eclipse ide | maven | TestNg***
3. ***node.js***
4. ***json-server***


## JSON-Server Installation
>#### Pre Requisite -  ***node.js***

Refer [this video](https://www.youtube.com/watch?v=V7sLq7u28BA&list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx&index=8) for json-server installation and creat local API
Create file ___`"db.json"`___ at any place, i have created it at `C:\Users\deepak.jagtap>`

Paste below data into  ___`"db.json"`___
```
{
  "users": [
    {
      "firstname": "anmol",
      "location": "pune",
      "lastname": "naik",
      "id": "8c7e"
    },
    {
      "id": "7b67",
      "firstname": "johny",
      "location": "NYC",
      "lastname": "paul"
    },
    {
      "id": "6c6e",
      "firstname": "akshay",
      "location": "Mumbai",
      "lastname": "kumar"
    }
  ],
  "subjects": [
    {
      "name": "automation",
      "id": "1"
    },
    {
      "name": "QA",
      "id": "2"
    }
  ]
}
```
---
Open cmd from same location, Hit below command,
```
npm install -g json-server
```
```
Output :
changed 45 packages in 5s

14 packages are looking for funding
  run `npm fund` for details
```
---
Check json server installed succesfully in system with below command,
```
json-server --version
```
```
Output:
1.0.0-beta.3
```
hit below command to read data from ___`"db.json"`___

```
json-server --watch db.json
```

```
Output:

--watch/-w can be omitted, JSON Server 1+ watches for file changes by default
JSON Server started on PORT :3000
Press CTRL-C to stop
Watching db.json...

♡( ◡‿◡ )

Index:
http://localhost:3000/

Static files:
Serving ./public directory if it exists

Endpoints:
http://localhost:3000/users
http://localhost:3000/subjects
```

We are done with json-server installation, now hover over on endpoints listed and ctr+click or open "http://localhost:3000/" on any browser and see results

> DONE

## JSON Schema Validation

Refer This Link - 
```
https://www.youtube.com/watch?v=rkGI32WXmPQ&list=PLhW3qG5bs-L8xPrBwDv66cTMlFNeUPdJx&index=10
```
Search "json to json schema converter" and click below link 
```
https://www.liquid-technologies.com/online-json-to-schema-converter
```
Add JSON data as below
```
https://reqres.in/api/users?page=2
```
(copy all JSON data from above link and paste in JSOn Schema Validator)

Now Navigate to peoject explorer and go to "target " folder path which is 

Example -
```
C:\Users\deepak.jagtap\eclipse-workspace\RESTassured_Automation\targets
```
in above path there should be two folders 

`classes` , `test-classes`

in classes folder create schema.json file and paste that schema we generated.

```
package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.Test;

public class JSONSchemaValidator {

	@Test
	public void getTest() {
		
		baseURI = "https://reqres.in/api";

		given().get("/users?page=2").then()
		.assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
		.statusCode(200);
	}
}

```

>DONE **JSON Schema Valitation**


