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
public class Grupo {

    private int codigo;
    private String Grupo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Marca) {
        this.Grupo = Marca;
    }

    @Override
    public String toString() {
        return this.getGrupo();
    }

}
