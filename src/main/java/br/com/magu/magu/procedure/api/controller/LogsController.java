package br.com.magu.magu.procedure.api.controller;

import br.com.magu.magu.procedure.api.procs.LogsPROC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LogsController {

    @Autowired
    private LogsPROC dao;

    //TODO IMPLEMENTAR CONTROLLERS DAS PROCS

    @PostMapping("/log/{apiInfo}")
    public HttpEntity<HttpStatus> postLogApplication(@PathVariable String apiInfo) {
        try {
            dao.postRegisterApi(apiInfo);
            return new HttpEntity<>(HttpStatus.OK);

        } catch (Exception ex) {
            return new HttpEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

}
