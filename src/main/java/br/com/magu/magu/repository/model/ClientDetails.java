package br.com.magu.magu.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Setter
@Getter
public class ClientDetails {

    String id = null;
    String name  = null;
    String lastName  = null;
    String birthDate  = null;
    String email  = null;
    String user  = null;
    ClientDocuments clientDocuments = null;

}
