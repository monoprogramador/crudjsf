/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monoprogramador.crud.jsf.modelo;

import java.util.Objects;

public class Municipio {

    private int idMunicipio;
    private String nombreMunicipio;

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idMunicipio;
        hash = 37 * hash + Objects.hashCode(this.nombreMunicipio);
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
        final Municipio other = (Municipio) obj;
        if (this.idMunicipio != other.idMunicipio) {
            return false;
        }
        if (!Objects.equals(this.nombreMunicipio, other.nombreMunicipio)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Municipio{" + "idMunicipio=" + idMunicipio + ", nombreMunicipio=" + nombreMunicipio + '}';
    }

}
