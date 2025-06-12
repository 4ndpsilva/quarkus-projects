package br.com.quarkus.finder.controller;

import br.com.quarkus.finder.mapper.AddressMapper;
import br.com.quarkus.finder.service.AddressService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Locale;
import lombok.RequiredArgsConstructor;

@Path("/api/addresses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class AddressController {
    private final AddressService service;

    private final AddressMapper mapper;

    @Context
    HttpHeaders headers;

    public Locale resolve(){
        return headers.getAcceptableLanguages()
            .stream()
            .findFirst()
            .orElse(Locale.ENGLISH);
    }

    @GET
    public Response find(@QueryParam("zipCode") String zipCode){
        service.setLanguage(resolve().toLanguageTag());
        return Response.ok(mapper.toResponseDTO(service.find(zipCode))).build();
    }
}