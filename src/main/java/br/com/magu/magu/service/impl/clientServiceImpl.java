package br.com.magu.magu.service.impl;

import br.com.magu.magu.models.Clients.ClientRequest;
import br.com.magu.magu.models.Clients.ClientResponseDTO;
import br.com.magu.magu.service.ClientService;
import br.com.magu.magu.utils.IntegrationUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.inject.internal.ErrorsException;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.common.PhoneRequest;
import com.mercadopago.client.customer.CustomerAddressRequest;
import com.mercadopago.client.customer.CustomerClient;
import com.mercadopago.client.customer.CustomerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.customer.Customer;
import com.nimbusds.oauth2.sdk.client.ClientRegistrationResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


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

    public Customer createClient(CustomerRequest clientRequest ) throws MPException, MPApiException {
        CustomerClient client = new CustomerClient();
        CustomerRequest customerRequest =
                CustomerRequest.builder()
                        .email(clientRequest.getEmail())
                        .firstName(clientRequest.getFirstName())
                        .lastName(clientRequest.getLastName())
                        .phone(PhoneRequest.builder()
                                .areaCode(clientRequest.getPhone().getAreaCode())
                                .number(clientRequest.getPhone().getNumber()).build())
                        .identification(
                                IdentificationRequest.builder()
                                        .type(clientRequest.getIdentification().getType())
                                        .number(clientRequest.getIdentification().getNumber()).build())
                        .defaultAddress("Home")
                        .address(
                                CustomerAddressRequest.builder()
                                        .id(clientRequest.getAddress().getId())
                                        .zipCode(clientRequest.getAddress().getZipCode())
                                        .streetName(clientRequest.getAddress().getStreetName())
                                        .streetNumber(clientRequest.getAddress().getStreetNumber())
                                        .build())
                        .dateRegistred(OffsetDateTime.of(2000, 1, 18, 0, 0, 0, 0, ZoneOffset.UTC))
                        .description(clientRequest.getDescription())
                        .defaultCard(clientRequest.getDefaultCard())
                        .build();
       return client.create(customerRequest);
    }


}
