package br.com.quarkus.finder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class AddressControllerTest {
    private static final String API_URL = "/api/addresses?zipCode";

    @Test
    void shouldReturnAddressByZipCode() {
        final String ZIP_CODE = "13075901";

        final String address = """
        {"zipCode":"13075-901","ddd":"19","street":"Avenida Doutor Heitor Penteado","complement":"1770","district":"Jardim Nossa Senhora Auxiliadora","city":"Campinas","state":"SP"}
        """;

        given()
            .when().get(String.format("%s=%s", API_URL, ZIP_CODE))
            .then()
            .statusCode(200)
            .body(is(address.strip()));
    }

    @Test
    void shouldReturnResponseErrorWhenZipCodeNotFound(){
        final String ZIP_CODE = "13075922";

        given()
            .when().get(String.format("%s=%s", API_URL, ZIP_CODE))
            .then()
            .body(containsString("Endereço não encontrado para o CEP informado"));
    }

    @Test
    void shouldReturnResponseErrorWhenInvalidZipCode(){
        final String ZIP_CODE = "130759222";

        given()
            .when().get(String.format("%s=%s", API_URL, ZIP_CODE))
            .then()
            .body(containsString("CEP Inválido"));
    }

    @Test
    void shouldReturnResponseErrorWhenZipCodeIsEmpty(){
        final String ZIP_CODE = "";

        given()
            .when().get(String.format("%s=%s", API_URL, ZIP_CODE))
            .then()
            .body(containsString("É obrigatório informar o CEP"));
    }
}