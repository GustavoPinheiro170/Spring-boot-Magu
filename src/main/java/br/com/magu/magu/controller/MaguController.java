package br.com.magu.magu.controller;

import br.com.magu.magu.Api.ClientsApi;
import br.com.magu.magu.models.Clients.ClientResponseDTO;
import br.com.magu.magu.service.CardsService;
import br.com.magu.magu.service.ClientService;
import com.mercadopago.client.cardtoken.CardTokenRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.CardToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/v1/magu")
@Api(value = "API Rest Magu")

public class MaguController implements ClientsApi {
    @Autowired
    private ClientService clientService;
    @Autowired
    private CardsService cardsService;

    @GetMapping("/client")
    public ResponseEntity<ClientResponseDTO> getClientbyEmailMP(@RequestParam String email) throws MPException, MPApiException {
        ClientResponseDTO clientResponseDTO = clientService.getCustomerClient(email);
        if (clientResponseDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clientResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/create_card")
    @ApiOperation(value = "Post Credit Card")
    public ResponseEntity<CardToken> createCard(@RequestBody CardTokenRequest card) throws MPException, MPApiException, IOException {
        CardTokenRequest request = CardTokenRequest.builder()
                .cardId(card.getCardId())
                .customerId(card.getCustomerId())
                .securityCode(card.getSecurityCode())
                .build();

        return ResponseEntity.ok(cardsService.createCard(request));
    }

}
