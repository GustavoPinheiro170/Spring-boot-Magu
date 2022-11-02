package br.com.magu.magu.repository.mapper;

import br.com.magu.magu.repository.model.Products.InfoQtdCor;
import br.com.magu.magu.repository.model.Products.Products;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoQtdCorRowMapper implements RowMapper<InfoQtdCor>  {


    @Override
    public InfoQtdCor mapRow(ResultSet rs, int rowNum) throws SQLException {
        return InfoQtdCor.builder()
                .quantidade(rs.getString("quantidade"))
                .cor(rs.getString("cor"))
                .build();
    }
}
