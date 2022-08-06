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
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private int codigo;
    private String grupo;

    public Grupo() {
    }

    public Grupo(int codigo, String Grupo) {
        this.codigo = codigo;
        this.grupo = Grupo;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String Marca) {
        this.grupo = Marca;
    }

    @Override
    public String toString() {
        return this.getGrupo();
    }

}
