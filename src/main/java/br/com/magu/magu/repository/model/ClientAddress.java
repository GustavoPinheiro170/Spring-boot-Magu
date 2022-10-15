package br.com.magu.magu.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Setter
@Getter
public class ClientAddress {

    String street = null;
    String neighborhood  = null;
    String city  = null;
    String state  = null;
    String zipCode  = null;
    String number  = null;
}
