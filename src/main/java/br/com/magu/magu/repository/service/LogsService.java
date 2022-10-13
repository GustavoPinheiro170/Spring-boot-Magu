package br.com.magu.magu.repository.service;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service("LogsService")
@Configurable
public interface LogsService {

    String inrLog(String user, String api ) throws Exception;
}
