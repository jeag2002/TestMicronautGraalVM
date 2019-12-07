package es.edreams.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class RTBDispatcherTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/rtbdispatcher/rtb/270")
          .then()
             .statusCode(200)
             .body(is("RTB Code (270) Not found"));
    }

}