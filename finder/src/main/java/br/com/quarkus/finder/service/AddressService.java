package br.com.quarkus.finder.service;

import br.com.quarkus.finder.dto.ViaCepResponseDTO;
import br.com.quarkus.finder.exception.BusinessException;
import br.com.quarkus.finder.exception.ResourceNotFoundException;
import br.com.quarkus.finder.exception.handler.I18N;
import io.quarkus.qute.i18n.Localized;
import io.quarkus.qute.i18n.MessageBundles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;

@Slf4j
@ApplicationScoped
public class AddressService {

    @RestClient
    @Inject
    private ViaCepService viaCepService;

    @Inject
    private Instance<I18N> instance;

    private I18N i18N;

    @Setter
    private String language;


    public ViaCepResponseDTO find(String zipCode){
        this.i18N = MessageBundles.get(I18N.class, Localized.Literal.of(language));

        try{
            validateZipCode(zipCode);
            ViaCepResponseDTO responseDTO = viaCepService.getAddress(zipCode);

            if(responseDTO.cep() == null || responseDTO.cep().isBlank()){
                throw new ResourceNotFoundException(i18N.api003(zipCode));
            }

            return responseDTO;
        }
        catch (ResteasyWebApplicationException ex) {
            if(ex.getMessage().contains("400")){
                throw new BusinessException(i18N.api002(zipCode));
            }

            log.error("OTHER ERROR: {}", ex.getMessage());
            throw new RuntimeException(i18N.api004());
        }
    }

    public void validateZipCode(String zipCode){
        if(zipCode == null || zipCode.isBlank()){
            throw new BusinessException(i18N.api001());
        }

        if(!zipCode.matches("^[0-9]{8}$")){
            throw new BusinessException(i18N.api002(zipCode));
        }
    }
}