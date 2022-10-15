package br.com.magu.magu.repository.impl;


import br.com.magu.magu.repository.mapper.RegistredClientRowMapper;
import br.com.magu.magu.repository.model.RegistredClient;
import br.com.magu.magu.repository.service.RegisterServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.ExecutionException;


public class RegisterServiceDAO implements RegisterServices {
    private static final Logger logger = LoggerFactory.getLogger(RegisterServiceDAO.class);

    @Autowired
    private JdbcTemplate JdbcTemplate;


    @Override
    public RegistredClient getClientDetails(Integer userId) throws Exception {
        try{

            String sql = " select" +
                    " adr.id ," +
                    " adr.street ," +
                    " adr.neighborhood ," +
                    " adr.city ," +
                    " adr.state ," +
                    " adr.zipcode ," +
                    " adr.\"number\" ," +
                    " reg.\"name\" ," +
                    " reg.last_name ," +
                    " reg.document_type ," +
                    " reg.document_number ," +
                    " reg.email ," +
                    " reg.birth_date ," +
                    " sig.\"user\" " +
                    " from" +
                    " user_address adr ," +
                    " user_register reg ," +
                    " user_sign_in sig" +
                    " where" +
                    " adr.id = reg.id" +
                    " and reg.id = sig.id" +
                    " and sig.id = reg.id" +
                    " and adr.id = ? ;";

            RegistredClient registredClient = JdbcTemplate.queryForObject(sql, new RegistredClientRowMapper(), userId);
            return registredClient;

        }catch (Exception ex){
            logger.info(ex.getMessage());
            throw new Exception();
        }
    }
}
