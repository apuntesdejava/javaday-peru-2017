package com.apuntesdejava.rest.server.service;

import com.apuntesdejava.rest.common.Actor;
import com.apuntesdejava.rest.server.ActorFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author diego
 */
@Path("actors")
@Stateless
public class ActorREST {

    @Inject
    private ActorFacade actorFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Actor> findAll() {
        return actorFacade.findAll();
    }

    @Path("{actorId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Actor findByActorId(@PathParam("actorId") Short actorId) {
        Actor actor = actorFacade.find(actorId);
        return actor;
    }

}
