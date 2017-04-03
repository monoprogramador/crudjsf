/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monoprogramador.crud.jsf.converter;

import com.monoprogramador.crud.jsf.modelo.Municipio;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("municipioConverter")
public class MunicipioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Municipio mun = new Municipio();
        if (value != null && !value.isEmpty() && !value.equals("-- Selecciona una muncipio --")) {
            String[] split = value.split(",");
            mun.setIdMunicipio(Integer.parseInt(split[0]));
            mun.setNombreMunicipio(split[1]);
            return mun;

        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Municipio) {
            return String.valueOf(((Municipio) value).getIdMunicipio()) + "," + ((Municipio) value).getNombreMunicipio();
        }
        return null;
    }

}
