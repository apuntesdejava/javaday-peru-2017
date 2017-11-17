package com.apuntesdejava.rest.server.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;

/**
 *
 * @author diego
 */
@Path("stream")
@Stateless
public class StreamREST {

    @POST
    @Path("progress/{report_id}")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void eventStream(@PathParam("report_id") String id,
            @Context SseEventSink es,
            @Context Sse sse) {
        System.out.println("id:" + id);
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            try {
                es.send(
                        sse.newEventBuilder().name("report-progress")
                                .data(String.class,
                                        "Commencing process for report " + id)
                                .build());
                es.send(sse.newEvent("Progress", "25%"));
                Thread.sleep(500);
                es.send(sse.newEvent("Progress", "50%"));
                Thread.sleep(500);
                es.send(sse.newEvent("Progress", "75%"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
