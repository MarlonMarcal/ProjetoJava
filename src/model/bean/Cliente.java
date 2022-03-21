/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Timestamp;


/**
 *
 * @author Marlon
 */
public class Cliente {

    private int idcliente;
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
    private Timestamp datacadastro;
    private Timestamp dataalteracao;
    


    public int getIdCliente() {
        return idcliente;
    }

    public void setIdCliente(int idCliente) {
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

    public Timestamp getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Timestamp datacadastro) {
        this.datacadastro = datacadastro;
    }

    public Timestamp getDataalteracao() {
        return dataalteracao;
    }

    public void setDataalteracao(Timestamp dataalteracao) {
        this.dataalteracao = dataalteracao;
    }

}
