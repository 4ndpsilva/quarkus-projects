package br.com.quarkus.finder.exception.handler;

import br.com.quarkus.finder.dto.ErrorDetailDTO;
import br.com.quarkus.finder.dto.ErrorResponseDTO;
import br.com.quarkus.finder.exception.BusinessException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.apache.http.HttpStatus;

import java.util.List;

@Provider
public class BusinessExceptionHandler implements ExceptionMapper<BusinessException> {

    @Override
    public Response toResponse(BusinessException ex) {
        int status = HttpStatus.SC_UNPROCESSABLE_ENTITY;
        ErrorDetailDTO detailDTO = new ErrorDetailDTO(ex.getMessage());
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(status, List.of(detailDTO));
        return Response.status(status).entity(errorResponse).build();
    }
}