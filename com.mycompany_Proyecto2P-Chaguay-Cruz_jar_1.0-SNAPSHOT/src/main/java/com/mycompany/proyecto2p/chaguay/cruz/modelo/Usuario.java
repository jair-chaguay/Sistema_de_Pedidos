/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz.modelo;


public class Usuario {
    String usuario;
    String password;
    String NameApellido;
    
    public Usuario(String usuario, String password,String NameApellido){
        this.usuario=usuario;
        this.password=password;
        this.NameApellido=NameApellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getNameApellido(){
        return NameApellido;
    }
    
    public void setNameApellido(String NameApellido){
        this.NameApellido=NameApellido;
    }
    
    @Override
    public String toString(){
        return "usuario: " + usuario + "password" + password;
    }

    
    
    
}
