package br.com.magu.magu.repository.mapper;

import br.com.magu.magu.repository.model.Products.Products;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsRowMapper implements RowMapper<Products> {
    @Override
    public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
        Products product =  Products.builder()
                .id(rs.getString("id"))
                .nome(rs.getString("nome"))
                .altura(rs.getString("altura"))
                .preco(rs.getString("preco"))
                .detalhe(rs.getString("detalhe"))
                .formato(rs.getString("formato"))
                .largura(rs.getString("largura"))
                .quantidade(rs.getString("quantidade"))
                .diametro(rs.getString("diametro"))
                .build();
    return product;
    }
}
