/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monoprogramador.crud.jsf.dao;

import com.monoprogramador.crud.jsf.modelo.Estado;
import com.monoprogramador.crud.jsf.modelo.Municipio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mono
 */
public class UbicacionDao {
    
    public static List<Estado> obtenerEstados(){
        List<Estado> estados = new ArrayList<Estado>();
        
        Estado est1 = new Estado();
        est1.setIdEstado(1);
        est1.setNombreEstado("CDMX");
        
        Estado est2 = new Estado();
        est2.setIdEstado(2);
        est2.setNombreEstado("Mexico");
        
        estados.add(est1);
        estados.add(est2);
        return estados;
    }
    
    public static Map<Integer, List> obtenerMunicipios(){
        Map<Integer, List> mapaMunicipios = new HashMap<Integer, List>();
        //Crea otra instancia de municipios para el primer estado
        // Otra opcion podria haber sido crear dos objetos, municipios1 y municipios2s
        List<Municipio> municipios = new ArrayList<Municipio>();
        
        Municipio municipio = new Municipio();
        municipio.setIdMunicipio(1);
        municipio.setNombreMunicipio("Benito Juarez");
        municipios.add(municipio);
        municipio = new Municipio();
        municipio.setIdMunicipio(2);
        municipio.setNombreMunicipio("Gustavo A. Madero");
        municipios.add(municipio);
        mapaMunicipios.put(1, municipios);
        
        //Crea otra instancia de municipios para el segundo estado
        municipios = new ArrayList<Municipio>();
        municipio = new Municipio();
        municipio.setIdMunicipio(3);
        municipio.setNombreMunicipio("Ecatepec");
        municipios.add(municipio);
        municipio = new Municipio();
        municipio.setIdMunicipio(4);
        municipio.setNombreMunicipio("Tlalnepantla");
        municipios.add(municipio);
        mapaMunicipios.put(2, municipios);
        
        //switch (usuario.getEstado().getIdEstado()) {
        return mapaMunicipios;
    }
}
