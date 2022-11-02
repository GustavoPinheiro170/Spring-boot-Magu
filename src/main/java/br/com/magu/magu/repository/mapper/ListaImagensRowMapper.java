package br.com.magu.magu.repository.mapper;

import br.com.magu.magu.repository.model.Products.ListaImagens;
import br.com.magu.magu.repository.model.Products.Products;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListaImagensRowMapper  implements RowMapper<ListaImagens> {
    @Override
    public ListaImagens mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ListaImagens.builder()
                .url(rs.getString("url"))
                .build();
    }
}
