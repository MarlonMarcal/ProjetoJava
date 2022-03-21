/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Marlon
 */
public class PesquisaProduto {
    
    
    Locale localeBR = new Locale("pt","BR");
    NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getValor() {
        return valor;
    }
    public String getPrecoFormatado(){
      return  dinheiro.format(valor);
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
    private int codigo;
    private String descricao;
    private String marca;
    private float valor;
    
}
