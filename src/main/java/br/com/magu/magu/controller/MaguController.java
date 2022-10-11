package br.com.magu.magu.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @RequestMapping(path = "/client", method = RequestMethod.GET)
    @ApiOperation(value = "Get Client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = String.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal error", response = Error.class)
    })
    public ResponseEntity<ClientResponseDTO> getClientbyEmailMP( @RequestParam String email) throws IOException, ErrorsException {
        ClientResponseDTO clientResponseDTO = clientService.getCustomerClient(email);

        if(clientResponseDTO == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(clientResponseDTO,HttpStatus.OK);
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
