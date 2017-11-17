package com.apuntesdejava.rest.client;

import com.apuntesdejava.rest.common.Actor;
import java.util.List;
import java.util.concurrent.CompletionStage;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.junit.Test;

/**
 *
 * @author diego
 */
public class RestClientTest {

    @Test
    public void testClient() throws InterruptedException {
        CompletionStage<Response> cs1 = ClientBuilder.newClient()
                .target("http://localhost:8080/rest-server/webresources/actors")
                .request()
                .rx()
                .get();

        cs1.whenComplete((t, u) -> {

            List<Actor> actors = t.readEntity(new GenericType<List<Actor>>() {
            });
            actors.forEach((a) -> {
                System.out.println("\t" + a.getFirstName() + " " + a.getLastName());
            });
        });

        Thread.sleep(10000);
    }

    @Test
    public void testCombine() throws InterruptedException {
        CompletionStage<Response> cs1 = ClientBuilder.newClient()
                .target("http://localhost:8080/rest-server/webresources/actors/103")
                .request()
                .rx()
                .get();
        CompletionStage<Response> cs2 = ClientBuilder.newClient()
                .target("http://localhost:8080/rest-server/webresources/langs/4")
                .request()
                .rx()
                .get();
        cs1.thenCombine(cs2, (r1, r2)
                -> r1.readEntity(String.class) + r2.readEntity(String.class))
                .thenAccept(System.out::println);

        Thread.sleep(10000);
    }

}
