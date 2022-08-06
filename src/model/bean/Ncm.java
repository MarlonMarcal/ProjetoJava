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
public class Ncm {
    
    
    private int idncm;
    private String ncm;
    private String descricao;
    private Double aliqnac;
    private Double aliqimp;
    private Boolean inativo;

    public int getCodigo() {
        return idncm;
    }

    public void setCodigo(int codigo) {
        this.idncm = codigo;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getAliqnac() {
        return aliqnac;
    }

    public void setAliqnac(Double aliqnac) {
        this.aliqnac = aliqnac;
    }

    public Double getAliqimp() {
        return aliqimp;
    }

    public void setAliqimp(Double aliqimp) {
        this.aliqimp = aliqimp;
    }

    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }
    
}
