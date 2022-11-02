package br.com.magu.magu.repository.Dao;

import br.com.magu.magu.repository.mapper.ListaImagensRowMapper;
import br.com.magu.magu.repository.mapper.ProductsRowMapper;
import br.com.magu.magu.repository.model.Products.ListaImagens;
import br.com.magu.magu.repository.model.Products.Products;
import br.com.magu.magu.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductsDAO implements ProductsService {

    @Autowired
    private JdbcTemplate JdbcTemplate;

    public List<Products> getAllProducts(){
        String query = "select  distinct\n" +
                "\t\tprodutos.id_prod as id,\n" +
                "\t\tprod_name as nome, \n" +
                "\t\tprod_price as preco, \n" +
                "\t\tprod_peso as peso,\n" +
                "\t\tprod_formato as formato,\n" +
                "\t\tprod_diametro as diametro,\n" +
                "\t\tprod_altura as altura,\n" +
                "\t\tprod_largura as largura,\n" +
                "\t\tprod_detail as detalhe,\n" +
                "\t\testoque.qt_prod as quantidade\n" +
                "\t\tfrom tbl_prods as produtos , \n" +
                "\t\ttbl_estq as estoque \n" +
                "\t\twhere estoque.id_prod = produtos.id_prod ;";

       List<Products> products =  JdbcTemplate.query(query, new ProductsRowMapper());


        for (Products product : products) {

        String queryImage = "select " +
                    " imagem.prod_url as url from " +
                    " tbl_prod_img as imagem , " +
                    " tbl_prods as produto where imagem.id_prod = "  + product.getId() ;

        List<ListaImagens> listImagens = JdbcTemplate.query(queryImage, new ListaImagensRowMapper());
        product.setListaImagens(listImagens);

        }

       return products;

    }

}
