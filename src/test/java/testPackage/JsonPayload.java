package testPackage;
public class JsonPayload {
	
	
	
	public static String createUserJsonPayload(String name, String job) {
		String payload = "{\r\n"
				+ "   \"name\":\""+name+"\",\r\n"
				+ "   \"job\":\""+job+"\"\r\n"
				+ "}";
		return payload;
	}
}
