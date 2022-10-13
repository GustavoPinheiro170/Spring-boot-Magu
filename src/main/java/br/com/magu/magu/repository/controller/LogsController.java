package br.com.magu.magu.repository.controller;

import br.com.magu.magu.Api.LogsApi;
import br.com.magu.magu.repository.service.LogsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/magu")
public class LogsController implements LogsApi {

    @Autowired LogsService logsService;

    @PostMapping("/logs")
    public ResponseEntity<HttpStatus> inputLog(@RequestParam String userName, @RequestParam String apiName) throws Exception {

        logsService.inrLog(userName,apiName );

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
