package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Task2RestAssured {
    public static void main(String[] args) {
        //getAllProducts();
        getSingleProduct();
        //addProduct();
        //updateProduct();
        //deleteProduct();
    }
    public static void getSingleProduct(){


         RestAssured.baseURI = "https://api.restful-api.dev";
         RequestSpecification requestSpecification = RestAssured
                                                     .given();

        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("idProduct", "ff808181932badb6019517426caf4b77")
                                .pathParam("path", "objects")
                            .when()
                                .get("{path}/{idProduct}");



        System.out.println("Harusnya muncul seperti ini " + response.asPrettyString()); 
    }
   

    public static void getAllProducts(){
   

        RestAssured.baseURI = "https://api.restful-api.dev";
        RequestSpecification requestSpecification = RestAssured
                                                    .given();

        Response response = requestSpecification.log().all().get("objects");

        System.out.println("Hasilnya seperti ini " + response.asPrettyString());
    }
    public static void addProduct(){
        String Json = "{" + 
        "\"name\": \"Samsung Galaxy S25 Plus 5G\","
        + "\"data\": {"
        + "\"year\": 2025,"
        + "\"price\": 18999999,"
        + "\"CPU model\": \"Snapdragon 8 Elite\","
        + "\"Hard disk size\": \"512 GB\""
        + "}"
        + "}";


        RestAssured.baseURI = "https://api.restful-api.dev";
        RequestSpecification requestSpecification = RestAssured
                                            .given();

        Response response = requestSpecification
                    .log()
                    .all()
                    .pathParam("path", "objects")
                    .body(Json)
                    .contentType("application/json")
                    .when()
                        .post("{path}");

        System.out.println("Hasil Add Product nya" + response.asPrettyString());

    }
    public static void updateProduct(){
        String Json = "{" + 
        "\"name\": \"Samsung Galaxy S25 Ultra 5G\"," 
        + "\"data\": {"
        + "\"year\": 2025,"
        + "\"price\": 22999999,"
        + "\"CPU model\": \"Snapdragon 8 Elite for Galaxy\","
        + "\"Hard disk size\": \"512 GB\""
        + "}"
        + "}";


        RestAssured.baseURI = "https://api.restful-api.dev";
        RequestSpecification requestSpecification = RestAssured
                                            .given();

        Response response = requestSpecification
                    .log()
                    .all()
                    .pathParam("path", "objects")
                    .pathParam("idProduct", "ff808181932badb601951737a0bd4995")
                    .body(Json)
                    .contentType("application/json")
                    .when()
                        .put("{path}/{idProduct}");

        System.out.println("Hasil Update Product nya" + response.asPrettyString());

    }
    public static void deleteProduct(){
        RestAssured.baseURI = "https://api.restful-api.dev";
        RequestSpecification requestSpecification = RestAssured
                                            .given();

        Response response = requestSpecification
                    .log()
                    .all()
                    .pathParam("path", "objects")
                    .pathParam("idProduct", "ff808181932badb6019517426caf4b77")
                    .when()
                        .delete("{path}/{idProduct}");

        System.out.println("Hasil Delete Product nya" + response.asPrettyString());

    }
}
