/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Marlon
 */
@Entity
public class Embalagem implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private int codigo;
    private String Embalagem;
    private String Descricao;

    public Embalagem() {
    }

    public Embalagem(int codigo, String Embalagem, String Descricao) {
        this.codigo = codigo;
        this.Embalagem = Embalagem;
        this.Descricao = Descricao;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmbalagem() {
        return Embalagem;
    }

    public void setEmbalagem(String Embalagem) {
        this.Embalagem = Embalagem;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    @Override
    public String toString() {
        return this.getEmbalagem();
    }

}
