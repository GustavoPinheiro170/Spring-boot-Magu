package br.com.magu.magu.controller;

import br.com.magu.magu.models.Clients.ClientRequest;
import br.com.magu.magu.models.Clients.ClientResponseDTO;
import br.com.magu.magu.service.CardsService;
import br.com.magu.magu.service.ClientService;
import com.google.inject.internal.ErrorsException;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/v1/magu")
@Api(value = "API Rest Magu")
@CrossOrigin("*")
public class MaguController {
    @Autowired private ClientService clientService;
    @Autowired private CardsService cardsService;

    @GetMapping("/client")
    @ApiOperation(value = "Get Client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna dados do Cliente"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public ResponseEntity<ClientResponseDTO> getClientMP(@RequestBody ClientRequest email) throws IOException, ErrorsException {
        return ResponseEntity.ok(clientService.getCustomerClient(email));
    }

    @PostMapping("/create_card")
    @ApiOperation(value = "Post Credit Card")
    public ResponseEntity<CardToken> createCard(@RequestBody br.com.magu.magu.models.Cards.CardTokenRequest card) throws MPException, MPApiException, IOException {
        CardTokenRequest request = CardTokenRequest.builder()
                .cardId(card.getCardId())
                .customerId(card.getCustomerId())
                .securityCode(card.getSecurityCode())
                .build();

        return ResponseEntity.ok(cardsService.createCard(request));
    }
}
