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
public class Venda {

    public int getCodloja() {
        return codloja;
    }

    public void setCodloja(int codloja) {
        this.codloja = codloja;
    }

    public int getCodorcamento() {
        return codorcamento;
    }

    public void setCodorcamento(int codorcamento) {
        this.codorcamento = codorcamento;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getTotalprodutos() {
        return totalprodutos;
    }

    public void setTotalprodutos(float totalprodutos) {
        this.totalprodutos = totalprodutos;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getValorfrete() {
        return valorfrete;
    }

    public void setValorfrete(float valorfrete) {
        this.valorfrete = valorfrete;
    }

    public float getTotalvenda() {
        return totalvenda;
    }

    public void setTotalvenda(float totalvenda) {
        this.totalvenda = totalvenda;
    }

    public int getCodvendedor() {
        return codvendedor;
    }

    public void setCodvendedor(int codvendedor) {
        this.codvendedor = codvendedor;
    }

    public int getCfop() {
        return cfop;
    }

    public void setCfop(int cfop) {
        this.cfop = cfop;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCodpagamento() {
        return codpagamento;
    }

    public void setCodpagamento(int codpagamento) {
        this.codpagamento = codpagamento;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
 private int codloja;
 private int codorcamento;
 private Timestamp data;
 private String cliente;
 private float totalprodutos;
 private float desconto;
 private float valorfrete;
 private float totalvenda;
 private int codvendedor;
 private int cfop;
 private int status;
 private int codpagamento;
 private String obs;
 
    
}
