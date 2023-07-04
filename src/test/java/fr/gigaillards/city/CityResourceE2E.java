package fr.gigaillards.city;

import fr.gigaillards.entity.City;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class CityResourceE2E {
    @Test
    public void testHealthCheckEndpoint() {
        given()
                .when().get("/_health")
                .then()
                .statusCode(200);
    }

    @Test
    public void testFindAllEndpoint() {
        given()
                .when().get("/city")
                .then()
                .statusCode(200);
    }

    @Test
    public void testCreateOneEndpoint() {
        City newCity = new City();
        newCity.setLon(12f);
        newCity.setLat(8f);
        newCity.setName("Aubagne");
        newCity.setZipCode("13400");
        newCity.setDepartmentCode("13");;

        given()
                .when()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .with()
                .body(newCity)
                .post("/city")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("name", is(newCity.getName()))
                .body("zipCode", is(newCity.getZipCode()))
                .body("departmentCode", is(newCity.getDepartmentCode()))
                .body("lat", is(newCity.getLat()))
                .body("lon", is(newCity.getLon()));
    }
}
