/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


/**
 *
 * @author Marlon
 */

@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 2L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pessoa_sequece")
    @SequenceGenerator(name="pessoa_sequece", sequenceName="pes_seq")
    private Integer idcliente;
    private String cgc;
    private String nome;
    private String celular;
    private String telefone;
    private String email;
    private String cep;
    private String endereco;
    private String complemento;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private Boolean inativo;
    private Date datacadastro;
    private Date dataalteracao;
    private String operadorcadastro;
    private String operadoalteracao;

    public Cliente() {
    }

    public Cliente(Integer idcliente, String cgc, String nome, String celular, String telefone, String email, String cep, String endereco, String complemento, String numero, String bairro, String cidade, String uf, Boolean inativo, Date datacadastro, Date dataalteracao, String operadorcadastro, String operadoalteracao) {
        this.idcliente = idcliente;
        this.cgc = cgc;
        this.nome = nome;
        this.celular = celular;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.inativo = inativo;
        this.datacadastro = datacadastro;
        this.dataalteracao = dataalteracao;
        this.operadorcadastro = operadorcadastro;
        this.operadoalteracao = operadoalteracao;
    }



    public Integer getIdCliente() {
        return idcliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idcliente = idCliente;
    }

    public String getCgc() {
        return cgc;
    }

    public void setCgc(String cgc) {
        this.cgc = cgc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public Date getDataalteracao() {
        return dataalteracao;
    }

    public void setDataalteracao(Date dataalteracao) {
        this.dataalteracao = dataalteracao;
    }

    public String getOperadorcadastro() {
        return operadorcadastro;
    }

    public void setOperadorcadastro(String operadorcadastro) {
        this.operadorcadastro = operadorcadastro;
    }

    public String getOperadoalteracao() {
        return operadoalteracao;
    }

    public void setOperadoalteracao(String operadoalteracao) {
        this.operadoalteracao = operadoalteracao;
    }
    
    
}
