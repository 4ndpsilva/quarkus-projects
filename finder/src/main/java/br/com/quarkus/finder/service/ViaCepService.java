package br.com.quarkus.finder.service;

import br.com.quarkus.finder.dto.ViaCepResponseDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/ws")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface ViaCepService {
    @GET
    @Path("/{cep}/json/")
    ViaCepResponseDTO getAddress(@PathParam("cep") String cep);
}