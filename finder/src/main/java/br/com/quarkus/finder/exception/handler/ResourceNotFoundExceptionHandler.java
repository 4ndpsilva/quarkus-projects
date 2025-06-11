package br.com.quarkus.finder.exception.handler;

import br.com.quarkus.finder.dto.ErrorDetailDTO;
import br.com.quarkus.finder.dto.ErrorResponseDTO;
import br.com.quarkus.finder.exception.ResourceNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.List;

@Provider
public class ResourceNotFoundExceptionHandler implements ExceptionMapper<ResourceNotFoundException>{

    @Override
    public Response toResponse(ResourceNotFoundException ex) {
        Response.Status status = Response.Status.NOT_FOUND;
        ErrorDetailDTO detailDTO = new ErrorDetailDTO(ex.getMessage());
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(status.getStatusCode(), List.of(detailDTO));
        return Response.status(status).entity(errorResponse).build();
    }
}