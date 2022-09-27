package br.com.magu.magu.service.impl;

import br.com.magu.magu.models.Clients.ClientRequest;
import br.com.magu.magu.models.Clients.ClientResponseDTO;
import br.com.magu.magu.service.ClientService;
import br.com.magu.magu.utils.IntegrationUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.inject.internal.ErrorsException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.io.IOException;


public class clientServiceImpl implements ClientService {
    private static final     TypeReference<ClientResponseDTO> clientResponse = new TypeReference<>() {};
    @Autowired private IntegrationUtil integrationUtil;
    @SneakyThrows
    @Override
    public ClientResponseDTO getCustomerClient(ClientRequest request) throws IOException, ErrorsException {
        ResponseEntity<ClientResponseDTO> response =
                    integrationUtil.getRestCall(
                            "https://api.mercadopago.com/v1/customers/search?email="+request.getEmail() ,
                            "GET",
                            null,
                            clientResponse);
        return response.getBody();


    }
}
