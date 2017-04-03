/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monoprogramador.crud.jsf;

import com.monoprogramador.crud.jsf.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ApplicationScoped
@ManagedBean(name = "capturaUsuarioBean")
public class CapturaUsuario implements Serializable {

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private List<Usuario> listaUsuario;
    private Usuario usuario = new Usuario();

    @PostConstruct
    public void init() {
        listaUsuario = new ArrayList<>();
    }

    public void guardar() {

        listaUsuario.add(usuario);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Los datos de " + getUsuario().getNombre() + " " + getUsuario().getApellido() + " se registraron correctamente."));
        setUsuario(new Usuario());
    }
    
    /**
     * @return the listaUsuario
     */
    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    /**
     * @param listaUsuario the listaUsuario to set
     */
    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

}
