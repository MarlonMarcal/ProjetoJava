/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Marlon
 */

@Entity
public class Marca implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private int codigo;
    private String marca;
    
    @OneToMany(mappedBy = "marca")
    private List<Produto> produtos = new ArrayList();

    public Marca() {
    }

    public Marca(int codigo, String marca) {
        this.codigo = codigo;
        this.marca = marca;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    public List<Produto> getProdutos(String marca) {
        return produtos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.codigo;
        hash = 61 * hash + Objects.hashCode(this.marca);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Marca other = (Marca) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        return true;
    }






    
    
    @Override
    public String toString() {
        return this.getMarca();
    }

}
