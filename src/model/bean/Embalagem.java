/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Marlon
 */
public class Embalagem {

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

    private int codigo;
    private String Embalagem;
    private String Descricao;

   

    @Override
    public String toString() {
        return this.getEmbalagem();
    }

}
