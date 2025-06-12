package br.com.quarkus.finder.controller;

import br.com.quarkus.finder.mapper.AddressMapper;
import br.com.quarkus.finder.service.AddressService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.NoArgsConstructor;

@Path("/api/addresses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@NoArgsConstructor
public class AddressController extends AbstractController{
    @Inject
    private AddressService service;

    @Inject
    private AddressMapper mapper;

    @GET
    public Response find(@QueryParam("zipCode") String zipCode){
        service.setLanguage(resolve().toLanguageTag());
        return Response.ok(mapper.toResponseDTO(service.find(zipCode))).build();
    }
}