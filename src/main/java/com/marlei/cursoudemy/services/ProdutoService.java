package com.marlei.cursoudemy.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.marlei.cursoudemy.model.Produto;
import com.marlei.cursoudemy.repository.ProdutoRepository_old;
import com.marlei.cursoudemy.shared.ProdutoDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
   
    @Autowired  
    private ProdutoRepository_old produtoRepository;
    /**
     * metodo para retorna uma lista de produtos
     * @return lista de produtos
     */
    public List<ProdutoDTO> obterTodos(){
        //colocar regra aqui caso tenha...
        List<Produto> produtos = produtoRepository.obterTodos();
        return produtos.stream().map(produto -> new ModelMapper().map(produto, ProdutoDTO.class)).collect(Collectors.toList());
    }
    public Optional<ProdutoDTO> obterPorId(Integer id){
        //obtendo optional de produto pelo id.
       Optional<Produto> produto = produtoRepository.obterPorId(id);//se encontrar vai devolver um produto
       if(produto.isEmpty()){ //se não tiver produto ele vai retorna o system.out.println
           System.out.println("Produto com id" + id + "não econtrado");
        }
        //convertendo o meu optional de produto em um produtoDto
        ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        // criando e retornando um optional de produtoDto.
        return Optional.of(dto);
    }
    public ProdutoDTO adicionar(ProdutoDTO produtoDto){
        produtoDto.setId(null);//removendo o id
        //Criar um objeto de mapeamento.
        ModelMapper mapper = new ModelMapper();

        //converter o nosso produtoDto em um produto
        Produto produto = mapper.map(produtoDto, Produto.class);

        //salvar o produto no banco
        produto = produtoRepository.adicionar(produto);
        produtoDto.setId(produto.getId());
        

        // retornar o produtodto atualizado.
        return produtoDto;
    
        //poderia ter alguma regra de negocio aqui para validar o produto
        
    }
    public void deletar(Integer id){
        //verificar se o produto existe
        Optional<Produto> produto = produtoRepository.obterPorId(id);
        //se não existir lança uma expection
        if(produto.isEmpty()){
            System.out.println("não foi possivel deletar o produto com o id: " + id + "produto não existe");

        }
        produtoRepository.deletar(id);
    }
    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto){
        //passar o id para o produtodto 
        produtoDto.setId(id);

        //Criar um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();


        //converter o dto em um produto
        Produto produto = mapper.map(produtoDto, Produto.class);

        //atualizar o produto no banco de dados.
        produtoRepository.atualizar(produto);

        //retornar o produtoDto atualizado
        return produtoDto;
    }

}
