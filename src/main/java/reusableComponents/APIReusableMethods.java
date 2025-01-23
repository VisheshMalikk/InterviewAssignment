package reusableComponents;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIReusableMethods {
	
	public static String getJsonPath(Response response, String key) {
	    String complete = response.asString();
	    JsonPath js = new JsonPath(complete);
	    return js.get(key).toString();
	}

}
