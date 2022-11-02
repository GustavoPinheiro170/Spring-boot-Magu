package br.com.magu.magu.service;

import br.com.magu.magu.repository.model.Products.Products;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductsService")

@Configurable
public interface ProductsService {

    public List<Products> getAllProducts();

}
