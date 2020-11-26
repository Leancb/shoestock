package Teste_ApiRest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.Test;

public class testeApi {

    @Test
    public void exibirNome(){
        Response response = RestAssured.request(Method.GET, "https://api.trello.com/1/actions/592f11060f95a3d3d46a987a");

        System.out.println(response.path("data.list.name"));

    }

    @Test
    public void verificaStatusCode(){

        RestAssured.given()
                .when()
                .get("https://api.trello.com/1/actions/592f11060f95a3d3d46a987a")
                .then()
                .statusCode(200);
    }

}
