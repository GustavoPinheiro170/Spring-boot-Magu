package br.com.magu.magu.service.impl;

import br.com.magu.magu.models.Clients.ClientResponseDTO;
import br.com.magu.magu.service.ClientService;
import br.com.magu.magu.utils.IntegrationUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.inject.internal.ErrorsException;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import java.io.IOException;


public class clientServiceImpl implements ClientService {
    private static final Logger logger = LoggerFactory.getLogger(clientServiceImpl.class);
    private static final  TypeReference<ClientResponseDTO> clientResponse = new TypeReference<>() {};

    @Value("${url.mp}")
    private String urlMp;

    @Autowired private IntegrationUtil integrationUtil;

    @SneakyThrows
    @Override
    public ClientResponseDTO getCustomerClient(String email) throws IOException, ErrorsException {

        logger.info("Calling Client By Email MP");

        ResponseEntity<ClientResponseDTO> response =
                    integrationUtil.getRestCall(
                            urlMp + "/v1/customers/search?email=" + email ,
                            "GET",
                            null,
                            clientResponse);
        if(response.getBody() != null && response.getBody().getResults().size() != 0){
            return response.getBody();
        }
        return null ;

    }
}
