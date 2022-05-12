package com.slasher.controller;

import com.slasher.model.AdmPresident;
import com.slasher.repository.AdmPresidentRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("/presidents")
@Produces("application/json")
@Consumes("application/json")
@Transactional
public class AdmPresidentController {

    @Inject
    AdmPresidentRepository admPresidentRepository;

    @POST
    @Path("/create")
    public void AdmPresident(AdmPresident admPresident) {
        admPresidentRepository.create(admPresident);
    }

    @GET
    @Path("/get/all")
    public List<AdmPresident> getAll() {
        return admPresidentRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public AdmPresident getById(@PathParam("id") Long id) {
        return admPresidentRepository.findById(id);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, AdmPresident admPresident) {
        if ( !admPresident.getAdmPresidentID().equals(id) ) {
            throw new BadRequestException("Ids do not match");
        }
        admPresidentRepository.update(admPresident);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        AdmPresident admPresident = admPresidentRepository.findById(id);
        admPresidentRepository.delete(admPresident);
    }

}
