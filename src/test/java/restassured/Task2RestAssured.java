package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Task2RestAssured {
    public static void main(String[] args) {
        getAllProducts();
    }
    
    public static void getAllProducts(){
        //Define baseURI
       /*
        *  "https://dummyjson.com/products"
        baseURI = https://dummyjson.com
        path = products
        */

        RestAssured.baseURI = "https://dummyjson.com";
        RequestSpecification requestSpecification = RestAssured
                                                    .given();

        Response response = requestSpecification.log().all().get("products");


        Response response2 = requestSpecification
                                .log()
                                .all()
                            .when()
                                .get("products");

        System.out.println("Hasilnya adalah " + response2.asPrettyString());
        System.out.println("Hasilnya adalah " + response.asPrettyString());
    }
}
