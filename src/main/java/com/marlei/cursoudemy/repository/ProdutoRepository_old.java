package com.marlei.cursoudemy.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.marlei.cursoudemy.model.Produto;
import org.springframework.stereotype.Repository;

@Repository 
public class ProdutoRepository_old {

    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * metodo para retorna uma lista de produtos
     * @return lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
    }
    /**
     * metodo que retorna o produto encontrado pelo seu id
     * @param id do produto que sera localizado
     * @return retorna um produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos.stream().filter(produto -> produto.getId() == id).findFirst();
    }
    /**
     * metodo para adicionar produto na lista
     * @param produto que sera adicionado
     * @return retorna o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }
    /**
     * metodo para deletar o produto por id
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
       
    }
    /**
     * metodo para atualizar o produto na lista
     * @param produto que sera atualizado
     * @return retorna o produto apos atualizar a lista
     */
    public Produto atualizar(Produto produto){
        //encontrar o produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("produto não encontrado");  
        }
        deletar(produto.getId());
        produtos.add(produto);
        //Eu tenho que remover o produto antigo da lista
        //Depois adicionar o novo produto
        return produto;
    }

}
