package com.marlei.cursoudemy.repository;

import com.marlei.cursoudemy.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
    
       
    
    

