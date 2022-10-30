package br.com.magu.magu.service;

import br.com.magu.magu.repository.model.ClientRegister;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("RegisterServices")
@Configurable
public interface RegisterServices {
     ClientRegister getClientDetails(Integer userId) throws Exception;
     ClientRegister postCreateUser(ClientRegister clientRegister) throws Exception;
}
