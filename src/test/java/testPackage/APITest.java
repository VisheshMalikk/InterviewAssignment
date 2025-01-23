package testPackage;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojoClasses.CreatedUserResponse;
import reusableComponents.APIReusableMethods;
import utils.DataProviderClass;

public class APITest {

	@Test(dataProvider = "userDataProvider", dataProviderClass = DataProviderClass.class)
	public void TestCreateUser(String name, String job) {
		
		// Endpoint of the API
		RestAssured.baseURI = "https://reqres.in/api/";
		
		String payload = JsonPayload.createUserJsonPayload(name,job);
		Response response = given().log().all()
							.body(payload)
							.when().post("users");
		
		response.then().log().all();
		String contentType = response.getHeader("Content-Type");
		// Validating response status code and content type
		Assert.assertEquals(response.statusCode(), 201, "Status Code is not matching");
		Assert.assertTrue(contentType.contains("application/json"), "Content Type is not application/json");
		
		// Fetching response value using JSONPath class
		String ID = APIReusableMethods.getJsonPath(response, "id");
		System.out.println("User's ID is : " + ID);
		
		// Fetching response value using POJO class :
		CreatedUserResponse createdUserResponse = response.as(CreatedUserResponse.class);
		System.out.println("Get ID from POJO class : " + createdUserResponse.getId());
		System.out.println("Get createdAt from POJO class : " + createdUserResponse.getCreatedAt());
		
	}
}
