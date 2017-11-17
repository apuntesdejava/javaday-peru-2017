package com.apuntesdejava.rest.client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.sse.SseEventSource;

/**
 *
 * @author diego
 */
public class SseEventClient {

    public static void main(String[] args) {
        WebTarget target = ClientBuilder.newClient()
                .target("http://localhost:8080/rest-server/webresources/stream/progress/100");

        try (SseEventSource source = SseEventSource
                .target(target).build()) {
            source.register(System.out::println);
            source.open();
        }
    }
}
