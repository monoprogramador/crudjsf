/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monoprogramador.crud.jsf.controller;

import com.monoprogramador.crud.jsf.dao.UbicacionDao;
import com.monoprogramador.crud.jsf.modelo.Estado;
import com.monoprogramador.crud.jsf.modelo.Municipio;
import com.monoprogramador.crud.jsf.modelo.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ApplicationScoped
@ManagedBean(name = "capturarController")
public class CapturaController {

    /**
     * @return the selectedUser
     */
    public Usuario getSelectedUser() {
        return selectedUser;
    }

    /**
     * @param selectedUser the selectedUser to set
     */
    public void setSelectedUser(Usuario selectedUser) {
        this.selectedUser = selectedUser;
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

    private Usuario usuario;
    private List<Estado> estados;
    private List<Municipio> municipios;
    private Integer edad;
    private List<Usuario> listaUsuario;

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @PostConstruct
    public void init() {
        listaUsuario = new ArrayList<>();
        System.out.println("CapturaController");
        this.usuario = new Usuario();
        estados = UbicacionDao.obtenerEstados();
    }

    public void updateMunicipios() {
        Map<Integer, List> mapaMunicipios = UbicacionDao.obtenerMunicipios();

        if (mapaMunicipios.containsKey(usuario.getEstado().getIdEstado())) {
            this.municipios = mapaMunicipios.get(usuario.getEstado().getIdEstado());
        } else {
            this.municipios = new ArrayList<>();
        }
    }

    public void updateEdad() {
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaNacimiento = Calendar.getInstance();
        System.out.println("Fecha:" + this.usuario.getFecha());
        int ano = 0;
        if (this.usuario.getFecha() != null) {
            fechaNacimiento.setTime(this.usuario.getFecha());
            ano = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        }

        usuario.setEdad(ano);
        setEdad(ano);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void guardar() {
        if (listaUsuario.contains(usuario)) {
            int indice = listaUsuario.indexOf(usuario);
            listaUsuario.set(indice, usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Los datos de " + usuario.getNombre() + " " + usuario.getApellido() + " se actualizaron correctamente."));
        } else {
            listaUsuario.add(usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Los datos de " + usuario.getNombre() + " " + usuario.getApellido() + " se registraron correctamente."));
        }

        setUsuario(new Usuario());
        setEdad(null);
    }
    private Usuario selectedUser;

    public void delete() {
        listaUsuario.remove(getSelectedUser());
        setSelectedUser(null);
    }

    public void modificar() {
        //listaUsuario.remove(getSelectedUser());
        Usuario user = getSelectedUser();
        setUsuario(getSelectedUser());
        updateEdad();
        updateMunicipios();
        //setSelectedUser(null);
    }

    public String buscar() {
        if (usuario != null && listaUsuario.contains(usuario)) {
            int indice = listaUsuario.indexOf(usuario);
            if(indice >= 0){
                Usuario usuarioEncontrado = listaUsuario.get(indice);
                setUsuario(usuarioEncontrado);
                updateEdad();
                updateMunicipios();
            }
            
            //FacesContext.getCurrentInstance().addMessage(null,
            //    new FacesMessage("Los datos de " + usuario.getNombre() + " " + usuario.getApellido() + " se actualizaron correctamente."));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("No fue encontrado ningun usuario con id " + usuario.getId()));
            return "buscar.xhtml";
        }
        return "CapturaUsuario.xhtml";
    }

}
