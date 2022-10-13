package br.com.magu.magu.repository.impl;


import br.com.magu.magu.repository.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class LogsDAO implements LogsService {

    @Autowired
    private JdbcTemplate JdbcTemplate;

    public String inrLog(String userName, String apiName) throws Exception {

        try {
            String sql1 = "SELECT COUNT(*) ID FROM LOG_API";
            Integer id = JdbcTemplate.queryForObject(sql1, Integer.class);
            String sql = " INSERT INTO LOG_API (api_name, user_name, local_data, id) values (? ,? , CURRENT_DATE, ? + 1 )";
            JdbcTemplate.update(sql, apiName, userName , id);

            return "Sucess";
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

}
