package Helper;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class Webservicecall {

	 public  String invokeWebserviceResponse(String projectInitUrl, String jsonRequest, String reqType){
	        System.out.println("Url:\n" + projectInitUrl);
	        System.out.println("Request:\n" + jsonRequest);

	        Response response = null;

	        if(reqType.equals("POST")){
	            response = RestAssured.given()
	                    .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
	                    .header("Content-Type", "application/json;charset=UTF-8")
	                    .body(jsonRequest)
	                    .post(projectInitUrl);
	        } else if(reqType.equals("DELETE")){
	            response = RestAssured.given()
	                    .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
	                    .header("Content-Type", "application/json;charset=UTF-8")
	                    .body(jsonRequest)
	                    .delete(projectInitUrl);
	        } else {
	            response = RestAssured.given()
	                    .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
	                    .header("Content-Type", "application/json;charset=UTF-8")
	                    .get(projectInitUrl);
	        }

	        String responseBody = response.getBody().asString();
	        System.out.println("Response Body:\n" + responseBody);

	        return responseBody;
	    }
}
