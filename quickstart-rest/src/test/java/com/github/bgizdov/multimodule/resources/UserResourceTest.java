package com.github.bgizdov.multimodule.resources;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class UserResourceTest {

  @Test
  void helloTest() {
    given().accept("application/json")
        .header("Content-type", "application/json")
        .get("/users/hello")
        .then()
        .log().body()
        .statusCode(200)
        .assertThat()
        .contentType("application/json")
        .body("id", is(1))
        .body("username", is("foobar"));
  }
}