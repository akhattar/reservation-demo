package com.xyz.server;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import com.xyz.handler.ReservationHandler;
import com.xyz.model.Reservation;
import io.muserver.*;
import io.muserver.rest.RestHandlerBuilder;
import org.junit.jupiter.api.*;
import io.restassured.http.ContentType;

public class ReservationControllerTest {
    private static MuServer server;

    @BeforeAll
    public static void startServer() {
        JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();
        server = MuServerBuilder.httpServer()
                .addHandler(RestHandlerBuilder.restHandler(new ReservationHandler())
                        .addCustomWriter(jacksonJsonProvider)
                        .addCustomReader(jacksonJsonProvider))
                .start();
        baseURI = server.uri().toString();
    }

    @AfterAll
    public static void stopServer() {
        server.stop();
    }

    @Test
    public void testCreateReservation() {
        String requestBody = """
        {
            "name": "ankit",
            "date": "2025-06-19",
            "guests": 4
        }
        """;

        Boolean result = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/reservations/create-reservation")
                .then()
                .statusCode(200)
                .extract().as(Boolean.class);

        assertTrue(result);
    }

    @Test
    public void testGetReservations() {
        given().when().get("/reservations/list-reservations").then().statusCode(200);
    }


}
