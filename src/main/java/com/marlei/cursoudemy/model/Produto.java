package com.marlei.cursoudemy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//vai comunicar entre o service e o repository
@Entity //esse cara cria automaticamente uma tabela no meu banco de dados
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //esse cara vai gerar um seguencia para dentro do meu banco de dados
    private Integer id;

    private String nome;

    private Integer quantidade;

    private double valor;
    
    private String observacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    
}
