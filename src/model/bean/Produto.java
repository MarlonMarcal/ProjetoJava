/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Marlon
 */
@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    Locale localeBR = new Locale("pt", "BR");
    NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String referencia;
    private String codBarras;
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name="idfornecedor")
    private Fornecedor fornecedor;
    
    @ManyToOne
    @JoinColumn(name="idmarca")
    private Marca marca;
    
    @ManyToOne
    @JoinColumn(name="idgrupo")
    private Grupo grupo;
    
    private Integer subgrupo;
    
    @ManyToOne
    @JoinColumn(name="idembalagem")
    private Embalagem embalagem;
    
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

    public Produto() {
    }

    public Produto(int codigo, String referencia, String codBarras, String descricao, Fornecedor fornecedor, Marca marca, Grupo grupo, Integer subgrupo, Embalagem embalagem, float peso, float altura, float largura, float precoCompra, float prIpi, float icmsST, float frete, float custoTotal, float cmv, float mk, float ll, float precoVenda, int ncm, int cest, int cst, float icmsInterno, float icmsExterno, float pis, float cofins, Date dataCadastro) {
        this.codigo = codigo;
        this.referencia = referencia;
        this.codBarras = codBarras;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.marca = marca;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.embalagem = embalagem;
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.precoCompra = precoCompra;
        this.prIpi = prIpi;
        this.icmsST = icmsST;
        this.frete = frete;
        this.custoTotal = custoTotal;
        this.cmv = cmv;
        this.mk = mk;
        this.ll = ll;
        this.precoVenda = precoVenda;
        this.ncm = ncm;
        this.cest = cest;
        this.cst = cst;
        this.icmsInterno = icmsInterno;
        this.icmsExterno = icmsExterno;
        this.pis = pis;
        this.cofins = cofins;
        this.dataCadastro = dataCadastro;
    }

    public Locale getLocaleBR() {
        return localeBR;
    }

    public void setLocaleBR(Locale localeBR) {
        this.localeBR = localeBR;
    }

    public NumberFormat getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(NumberFormat dinheiro) {
        this.dinheiro = dinheiro;
    }

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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Integer getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(Integer subgrupo) {
        this.subgrupo = subgrupo;
    }

    public Embalagem getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Embalagem embalagem) {
        this.embalagem = embalagem;
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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Produto{" + "localeBR=" + localeBR + ", dinheiro=" + dinheiro + ", codigo=" + codigo + ", referencia=" + referencia + ", codBarras=" + codBarras + ", descricao=" + descricao + ", fornecedor=" + fornecedor + ", marca=" + marca + ", grupo=" + grupo + ", subgrupo=" + subgrupo + ", embalagem=" + embalagem + ", peso=" + peso + ", altura=" + altura + ", largura=" + largura + ", precoCompra=" + precoCompra + ", prIpi=" + prIpi + ", icmsST=" + icmsST + ", frete=" + frete + ", custoTotal=" + custoTotal + ", cmv=" + cmv + ", mk=" + mk + ", ll=" + ll + ", precoVenda=" + precoVenda + ", ncm=" + ncm + ", cest=" + cest + ", cst=" + cst + ", icmsInterno=" + icmsInterno + ", icmsExterno=" + icmsExterno + ", pis=" + pis + ", cofins=" + cofins + ", dataCadastro=" + dataCadastro + '}';
    }

    
    

}
