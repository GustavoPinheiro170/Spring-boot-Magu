package br.com.magu.magu.Api;

import br.com.magu.magu.models.Clients.ClientResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin("*")
@Api(value = "Logs Information")
@RequestMapping(value = "/logs")

public interface LogsApi {

    Logger log = LoggerFactory.getLogger(LogsApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }


    @ApiOperation(value = "",
            nickname = "Clients",
            notes = "This service get Clients Information",
            response = String.class,
            authorizations = {@Authorization(value = "basicAuth")},
            tags = {"Logs"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = String.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal error", response = Error.class)})
    @RequestMapping(value = "/logs",
            produces = {"application/json"},
            method = RequestMethod.GET)
    default ResponseEntity<HttpStatus> inputLog (
            @Valid @RequestParam(value = "apiName", required = true) String apiName ,  @Valid @RequestParam (value = "userName", required = true) String userName) throws Exception {

        if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default EventsVcrApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}