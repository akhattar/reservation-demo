package com.xyz.handler;

import io.muserver.MuHandler;
import io.muserver.MuRequest;
import io.muserver.MuResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogHandler implements MuHandler {

    public boolean handle(MuRequest request, MuResponse response) {
        log.debug("Recieved {} from {}", request, request.remoteAddress());
        return false; // so that the next handler is invoked
    }
}
