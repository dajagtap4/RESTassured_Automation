---
  # RESTAssured Automation Framework

  A beginner-friendly API test automation framework built with **Java** and **REST Assured**. This project helps you learn how to test REST and SOAP
  APIs automatically without manual effort.

  ---

  ## What is This Framework?

  This framework lets you:
  - Send API requests (GET, POST, PUT, PATCH, DELETE)
  - Validate API responses automatically
  - Test both **REST** and **SOAP** APIs
  - Validate response structure using **JSON/XML Schema**
  - Run all tests automatically using **Maven**

  ---

  ## Technologies Used

  | Tool | Purpose |
  |------|---------|
  | Java 17 | Programming language |
  | REST Assured 5.5.0 | API testing library |
  | TestNG 7.10.2 | Test runner (runs and reports tests) |
  | Maven | Build tool & dependency manager |
  | JSON Schema Validator | Validates API response structure |
  | json-server | Creates a fake local API for testing |
  | GitHub Actions | Runs tests automatically on every push |

  ---

  ## Project Structure

  ```
  RESTassured_Automation/
  ├── src/
  │   ├── test/
  │   │   ├── java/test/               # All test classes
  │   │   │   ├── GetAndPostExamples.java      # GET & POST request examples
  │   │   │   ├── GetUsersTest.java            # Test to fetch users from API
  │   │   │   ├── JSONSchemaValidator.java     # Validate JSON response structure
  │   │   │   ├── PutPatchDeleteExamples.java  # PUT, PATCH, DELETE examples
  │   │   │   ├── SOAP_XML_Request.java        # SOAP API testing
  │   │   │   ├── XMLSchemaValidation.java     # Validate XML response structure
  │   │   │   ├── testExamples.java            # Basic test examples
  │   │   │   └── testOnLocalAPI.java          # Tests on local json-server API
  │   │   └── resources/                       # Test config & schema files
  │   └── main/resources/                      # JSON schema files (schema.json)
  ├── SoapRequest/                             # SOAP request XML files
  ├── .github/workflows/                       # CI/CD pipeline (GitHub Actions)
  ├── pom.xml                                  # Maven dependencies config
  └── setup.md                                 # Setup instructions
  ```

  ---

  ## Prerequisites (What to Install First)

  Before running this project, install the following:

  1. **Java 17** — [Download here](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
  2. **Eclipse IDE** — with Maven and TestNG plugins
  3. **Node.js** — needed for json-server
  4. **Maven** — usually comes with Eclipse

  ---

  ## Setting Up json-server (Local Mock API)

  json-server creates a **fake API on your computer** so you can test without a real server.

  **Step 1:** Install json-server
  ```bash
  npm install -g json-server
  ```

  **Step 2:** Create a file called `db.json` with this content:
  ```json
  {
    "users": [
      { "id": 1, "name": "Alice", "email": "alice@example.com" },
      { "id": 2, "name": "Bob", "email": "bob@example.com" }
    ],
    "subjects": [
      { "id": 1, "name": "Math" },
      { "id": 2, "name": "Science" }
    ]
  }
  ```

  **Step 3:** Start the server
  ```bash
  json-server --watch db.json
  ```

  This creates two local API endpoints:
  - `http://localhost:3000/users`
  - `http://localhost:3000/subjects`

  ---

  ## How to Run Tests

  **Option 1: Using Maven (recommended)**
  ```bash
  mvn test
  ```

  **Option 2: Using Eclipse**
  - Right-click any test class → Run As → TestNG Test

  ---

  ## Understanding the Test Classes

  ### `GetAndPostExamples.java`
  Shows how to send **GET** (fetch data) and **POST** (send data) requests and verify the response.

  ### `GetUsersTest.java`
  Tests fetching a list of users from an API and checks the response is correct.

  ### `PutPatchDeleteExamples.java`
  Shows how to **update** (PUT/PATCH) and **delete** records via API.

  ### `testOnLocalAPI.java`
  Runs tests against your local json-server API (`localhost:3000`).

  ### `JSONSchemaValidator.java`
  Checks that the API response **structure** matches an expected schema — useful to catch when an API changes its response format.

  ### `XMLSchemaValidation.java`
  Same as JSON schema validation but for **XML** responses.

  ### `SOAP_XML_Request.java`
  Tests **SOAP APIs** by sending XML-based requests (older style of web services).

  ---

  ## What is JSON Schema Validation?

  Think of it like a **blueprint check**. After you get an API response, you verify it has the correct fields and data types.

  **Example:** If your API should always return a `name` (string) and `id` (number), the schema validation will fail the test if either is missing or
  wrong.

  **Steps to generate a schema:**
  1. Get a sample API response (e.g., from `https://reqres.in`)
  2. Paste it into a [JSON to JSON Schema converter](https://www.jsonschema.net/)
  3. Save the output as `schema.json` in `src/main/resources/`
  4. Use it in your test:

  ```java
  .body(matchesJsonSchemaInClasspath("schema.json"))
  ```

  ---

  ## CI/CD (Automated Test Runs)

  This project uses **GitHub Actions** to automatically run all tests every time code is pushed to the repository. No manual effort needed — results
  appear in the **Actions** tab on GitHub.

  ---

  ## Quick Start Summary

  ```
  1. Install Java 17, Eclipse, Node.js
  2. Clone this repo
  3. Run: npm install -g json-server
  4. Create db.json and run: json-server --watch db.json
  5. Open project in Eclipse
  6. Run: mvn test
  ```

  ---

  ## Good for Beginners Because...

  - Each test class covers **one concept** at a time
  - Local json-server means **no real API needed** to start learning
  - Maven handles all library downloads automatically
  - TestNG gives **clear pass/fail reports**

  ---
