/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monoprogramador.crud.jsf.modelo;

import java.util.Objects;

public class Estado{
    
    private int idEstado;
    private String nombreEstado;
    

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idEstado;
        hash = 59 * hash + Objects.hashCode(this.nombreEstado);
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
        final Estado other = (Estado) obj;
        if (this.idEstado != other.idEstado) {
            return false;
        }
        if (!Objects.equals(this.nombreEstado, other.nombreEstado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estado{" + "idEstado=" + idEstado + ", nombreEstado=" + nombreEstado + '}';
    }
    
}
