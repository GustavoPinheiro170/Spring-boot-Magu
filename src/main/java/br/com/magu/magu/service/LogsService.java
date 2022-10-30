package br.com.magu.magu.service;

import br.com.magu.magu.repository.model.Logs;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LogsService")
@Configurable
public interface LogsService {

    String inrLog(String user, String api ) throws Exception;

    List<Logs> getAllLogs () throws Exception;


}
