package api;

import br.com.magu.magu.models.Clients.ClientRequest;
import br.com.magu.magu.models.Clients.ClientResponseDTO;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ClientApi {

    @ApiOperation(value = "Register user" )
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/client",
            method = RequestMethod.POST)
    default ResponseEntity<ClientResponseDTO> getClientMP(@ApiParam(value = "" ,required=true )
                                               @RequestBody ClientRequest body) {

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
