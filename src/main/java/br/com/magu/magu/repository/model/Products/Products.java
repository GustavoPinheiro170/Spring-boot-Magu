package br.com.magu.magu.repository.model.Products;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Products {
    public String id;
    public String nome;
    public String preco;
    public String diametro;
    public String formato;
    public String altura;
    public String largura;
    public String detalhe;
    public String quantidade;
    public List<String> cores;
    public String imagem;
    public List<ListaImagens> listaImagens;

}
