/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Marlon
 */
public class Produto {
    
    Locale localeBR = new Locale("pt","BR");
    NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodFornecedor() {
        return codfornecedor;
    }

    public void setCodFornecedor(int codfornecedor) {
        this.codfornecedor = codfornecedor;
    }

    public int getCodMarca() {
        return codmarca;
    }

    public void setCodMarca(int codmarca) {
        this.codmarca = codmarca;
    }

    public int getCodGrupo() {
        return codgrupo;
    }

    public void setCodGrupo(int codgrupo) {
        this.codgrupo = codgrupo;
    }

    public int getCodSubgrupo() {
        return codsubgrupo;
    }

    public void setCodSubgrupo(int codsubgrupo) {
        this.codsubgrupo = codsubgrupo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public float getPrIpi() {
        return prIpi;
    }

    public void setPrIpi(float prIpi) {
        this.prIpi = prIpi;
    }

    public float getIcmsST() {
        return icmsST;
    }

    public void setIcmsST(float icmsST) {
        this.icmsST = icmsST;
    }

    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }

    public float getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(float custoTotal) {
        this.custoTotal = custoTotal;
    }

    public float getCmv() {
        return cmv;
    }

    public void setCmv(float cmv) {
        this.cmv = cmv;
    }

    public float getMk() {
        return mk;
    }

    public void setMk(float mk) {
        this.mk = mk;
    }

    public float getLl() {
        return ll;
    }

    public void setLl(float ll) {
        this.ll = ll;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }
    public String getPrecoFormatado(){
      return  dinheiro.format(precoVenda);
    }

    public int getNcm() {
        return ncm;
    }

    public void setNcm(int ncm) {
        this.ncm = ncm;
    }

    public int getCest() {
        return cest;
    }

    public void setCest(int cest) {
        this.cest = cest;
    }

    public int getCst() {
        return cst;
    }

    public void setCst(int cst) {
        this.cst = cst;
    }

    public float getIcmsInterno() {
        return icmsInterno;
    }

    public void setIcmsInterno(float icmsInterno) {
        this.icmsInterno = icmsInterno;
    }

    public float getIcmsExterno() {
        return icmsExterno;
    }

    public void setIcmsExterno(float icmsExterno) {
        this.icmsExterno = icmsExterno;
    }

    public float getPis() {
        return pis;
    }

    public void setPis(float pis) {
        this.pis = pis;
    }

    public float getCofins() {
        return cofins;
    }

    public void setCofins(float cofins) {
        this.cofins = cofins;
    }
    
    private int codigo;
    private String referencia;
    private String codBarras;
    private String descricao;
    private int codfornecedor;
    
    
    private int codmarca;
    private int codgrupo;
    private int codsubgrupo;
    private String unidade;
    private float peso;
    private float altura;
    private float largura;
    
    private float precoCompra;
    private float prIpi;
    private float icmsST;
    private float frete;
    private float custoTotal;
    
    private float cmv;
    private float mk;
    private float ll;
    private float precoVenda;
  
    private int ncm;
    private int cest;
    private int cst;
    private float icmsInterno;
    private float icmsExterno;
    private float pis;
    private float cofins;
    private Date dataCadastro;

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
}
