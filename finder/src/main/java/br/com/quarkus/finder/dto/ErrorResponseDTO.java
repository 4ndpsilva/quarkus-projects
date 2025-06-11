package br.com.quarkus.finder.dto;

import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonbPropertyOrder({"statusCode", "timestamp", "errors"})
public class ErrorResponseDTO {
    private int statusCode;
    private OffsetDateTime timestamp = OffsetDateTime.now();
    private List<ErrorDetailDTO> errors;

    public ErrorResponseDTO(int statusCode, List<ErrorDetailDTO> errors){
        this.statusCode = statusCode;
        this.errors = errors;
    }
}