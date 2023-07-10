package fr.gigaillards.city;

import fr.gigaillards.entity.City;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CityResourceE2E {
    @Test
    public void testFindAllEndpoint() {
        given()
                .when().get("/city")
                .then()
                .statusCode(HttpResponseStatus.OK.code());
    }

    @Test
    public void testCreateOneEndpoint() {
        float longitude = 12f;
        float latitude = 8f;
        City newCity = new City();
        newCity.setLon(longitude);
        newCity.setLat(latitude);
        newCity.setName("Aubagne");
        newCity.setZipCode("13400");
        newCity.setDepartmentCode("13");


        given()
                .when()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .with()
                .body(newCity)
                .post("/city")
                .then()
                .statusCode(HttpResponseStatus.CREATED.code())
                .body("id", notNullValue())
                .body("name", is(newCity.getName()))
                .body("zipCode", is(newCity.getZipCode()))
                .body("departmentCode", is(newCity.getDepartmentCode()))
                .body("lat", is(newCity.getLat()))
                .body("lon", is(newCity.getLon()));
    }
}
