package br.com.magu.magu.controller;

import br.com.magu.magu.models.Clients.ClientRequest;
import br.com.magu.magu.models.Clients.ClientResponseDTO;
import br.com.magu.magu.service.CardsService;
import br.com.magu.magu.service.ClientService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.internal.ErrorsException;
import com.mercadopago.client.cardtoken.CardTokenClient;
import com.mercadopago.client.cardtoken.CardTokenRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.CardToken;
import com.mercadopago.resources.customer.CustomerCardIssuer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@Slf4j
@RestController
@RequestMapping("/api/v1/magu")
public class MaguController {
    @Autowired private ClientService clientService;
    @Autowired private CardsService cardsService;

    @GetMapping("/client")
    public ResponseEntity<ClientResponseDTO> getClientMP(@RequestBody ClientRequest email) throws IOException, ErrorsException {
        return ResponseEntity.ok(clientService.getCustomerClient(email));
    }

    @PostMapping("/create_card")
    public ResponseEntity<CardToken> createCard(@RequestBody br.com.magu.magu.models.Cards.CardTokenRequest card) throws MPException, MPApiException, IOException {
        CardTokenRequest request = CardTokenRequest.builder()
                .cardId(card.getCardId())
                .customerId(card.getCustomerId())
                .securityCode(card.getSecurityCode())
                .build();

        return ResponseEntity.ok(cardsService.createCard(request));
    }
}
