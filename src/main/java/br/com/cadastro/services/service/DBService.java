package br.com.cadastro.services.service;

import br.com.cadastro.domain.Produto;
import br.com.cadastro.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    @Autowired
    private ProdutoRepository repo;

    public void inicializarBancodados() {
        Produto produto = new Produto(null,"camiseta",2,29.99);
        repo.save(produto);
    }
}
