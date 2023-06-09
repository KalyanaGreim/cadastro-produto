package br.com.cadastro.services.service;

import br.com.cadastro.domain.Produto;
import br.com.cadastro.repositories.ProdutoRepository;
import br.com.cadastro.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;
    public Produto findById(Integer id){
        Optional<Produto> produto = repo.findById(id);
        return produto.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto nao encontrado Id: " + id + "Tipo: " + Produto.class.getName()
        ));
    }
    public List<Produto> findAll(){
        return repo.findAll();
    }

    public Produto save(Produto produto) {
        produto.setId(null);
        return repo.save(produto);
    }

    public Produto update(Produto produto) {
        Produto newProduto = findById(produto.getId());
        updateProduto(produto, newProduto);
        return repo.save(newProduto);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    private void updateProduto(Produto oldProduto, Produto newProduto) {
        newProduto.setNome(oldProduto.getNome());
        newProduto.setQuantidade(oldProduto.getQuantidade());
        newProduto.setValor(oldProduto.getValor());
    }
}
