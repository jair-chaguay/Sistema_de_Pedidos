/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz.modelo;

/**
 * 
 * @author HP
 */
public class Usuario {
    String usuario;
    String password;
    String NameApellido;
   /**
    * 
    * @param usuario
    * @param password
    * @param NameApellido 
    */ 
    public Usuario(String usuario, String password,String NameApellido){
        this.usuario=usuario;
        this.password=password;
        this.NameApellido=NameApellido;
    }
/**
 * 
 * @return 
 */
    public String getUsuario() {
        return usuario;
    }
/**
 * 
 * @param usuario 
 */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
/**
 * 
 * @return 
 */
    public String getPassword() {
        return password;
    }
    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * 
     * @return 
     */
    public String getNameApellido(){
        return NameApellido;
    }
    /**
     * 
     * @param NameApellido 
     */
    public void setNameApellido(String NameApellido){
        this.NameApellido=NameApellido;
    }
    /**
     * S
     * @return 
     */
    @Override
    public String toString(){
        return "usuario: " + usuario + "password" + password;
    }

    
    
    
}
