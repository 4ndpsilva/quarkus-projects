package br.com.quarkus.finder.controller;

import br.com.quarkus.finder.service.AddressService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("/api/addresses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class AddressController {
    private final AddressService service;

    @GET
    public Response find(@QueryParam("zipCode") String zipCode){
        return Response.ok(service.find(zipCode)).build();
    }
}