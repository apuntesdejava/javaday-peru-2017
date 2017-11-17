/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apuntesdejava.rest.server.service;

import com.apuntesdejava.rest.common.Language;
import com.apuntesdejava.rest.server.LanguageFacade;
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
@Path("langs")
@Stateless
public class LanguageREST {

    @Inject
    private LanguageFacade langFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Language> findAll() {
        return langFacade.findAll();
    }

    @GET
    @Path("{langId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Language findAll(@PathParam("langId") Short langId) {
        Language lang = langFacade.find(langId);
        return lang;
    }

}
