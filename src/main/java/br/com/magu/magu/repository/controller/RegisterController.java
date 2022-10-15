package br.com.magu.magu.repository.controller;

import br.com.magu.magu.Api.LogsApi;
import br.com.magu.magu.repository.model.Logs;
import br.com.magu.magu.repository.model.RegistredClient;
import br.com.magu.magu.repository.service.LogsService;
import br.com.magu.magu.repository.service.RegisterServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/magu")
public class RegisterController  {

    @Autowired
    RegisterServices registerServices;


    @GetMapping("/user/{id}")
    public ResponseEntity<RegistredClient> getUserById(@PathVariable  Integer id) throws Exception {
        RegistredClient user = registerServices.getClientDetails( id);
       return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
