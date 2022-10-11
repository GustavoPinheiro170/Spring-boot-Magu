package br.com.magu.magu.service;

import br.com.magu.magu.models.Clients.ClientRequest;
import br.com.magu.magu.models.Clients.ClientResponseDTO;
import com.google.inject.internal.ErrorsException;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Configurable
public interface ClientService {

    ClientResponseDTO getCustomerClient(String email) throws MPException, MPApiException;
}
