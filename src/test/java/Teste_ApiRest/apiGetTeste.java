package ApiRest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

public class apiGetTeste {

@Test
    public void testGet() {

    Response response = RestAssured.request(Method.GET, "https://api.trello.com/1/actions/592f11060f95a3d3d46a987a");

    System.out.println(response.getBody().asString());

    //Teste do status code
    Assert.assertTrue(response.statusCode() == 200);

    //Teste para gerar erro em tela caso não seja status code 200
    ValidatableResponse validacao = response.then();
    validacao.statusCode(200);

}

@Test
    public void validaStatusCode200(){

    RestAssured.get("https://api.trello.com/1/actions/592f11060f95a3d3d46a987a").then().statusCode(200);

    RestAssured.given()
                    .when()
                        .get("https://api.trello.com/1/actions/592f11060f95a3d3d46a987a")
                    .then()
                 .statusCode(200);

}


@Test
    public void exibeNome(){

  //  String retornoApi =Arrays.asList(RestAssured.get("https://api.trello.com/1/actions/592f11060f95a3d3d46a987a")).addAll();

    System.out.println("teste");

}










}
