package br.com.quarkus.finder.mapper;

import br.com.quarkus.finder.dto.AddressResponseDTO;
import br.com.quarkus.finder.dto.ViaCepResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "cdi")
public interface AddressMapper {

    @Mappings({
        @Mapping(source = "cep", target = "zipCode"),
        @Mapping(source = "logradouro", target = "street"),
        @Mapping(source = "bairro", target = "district"),
        @Mapping(source = "localidade", target = "city"),
        @Mapping(source = "uf", target = "state"),
        @Mapping(source = "complemento", target = "complement"),
        @Mapping(source = "ddd", target = "ddd")
    })
    AddressResponseDTO toResponseDTO(ViaCepResponseDTO enderecoDTO);
}