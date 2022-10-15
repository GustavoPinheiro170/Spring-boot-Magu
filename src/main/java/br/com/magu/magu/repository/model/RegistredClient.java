package br.com.magu.magu.repository.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Setter
@Getter
public class RegistredClient {
    ClientDetails clientDetails ;
    ClientAddress clientAddress ;
}
