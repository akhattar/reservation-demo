package com.xyz.server;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import com.xyz.handler.LogHandler;
import com.xyz.handler.ReservationHandler;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;
import io.muserver.rest.RestHandlerBuilder;

public class ReservationController {

    public static void main(String[] args) {
        JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();
        ReservationHandler reservationHandler = new ReservationHandler();
        MuServer server = MuServerBuilder.httpServer()
                .withHttpPort(61206)
                .addHandler(new LogHandler())
                .addHandler(
                        RestHandlerBuilder.restHandler( reservationHandler)
                                .addCustomWriter(jacksonJsonProvider)
                                .addCustomReader(jacksonJsonProvider))
                .start();
        System.out.println("Started server at " + server.uri());
    }
}
