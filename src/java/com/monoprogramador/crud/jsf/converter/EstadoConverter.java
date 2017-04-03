/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monoprogramador.crud.jsf.converter;

import com.monoprogramador.crud.jsf.modelo.Estado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("estadoConverter")
public class EstadoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Estado est = new Estado();
        if (value != null && !value.isEmpty() && !value.equals("-- Selecciona una estado --")) {
            String[] split = value.split(",");
            est.setIdEstado(Integer.parseInt(split[0]));
            est.setNombreEstado(split[1]);
            return est;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Estado) {
            return String.valueOf(((Estado) value).getIdEstado()) + "," + ((Estado) value).getNombreEstado();
        }
        return null;
    }

}
