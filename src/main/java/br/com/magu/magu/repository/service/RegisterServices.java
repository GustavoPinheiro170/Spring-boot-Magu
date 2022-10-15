package br.com.magu.magu.repository.service;

import br.com.magu.magu.repository.model.RegistredClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service("RegisterServices")
@Configurable
public interface RegisterServices {
     RegistredClient getClientDetails(Integer userId) throws Exception;
}
