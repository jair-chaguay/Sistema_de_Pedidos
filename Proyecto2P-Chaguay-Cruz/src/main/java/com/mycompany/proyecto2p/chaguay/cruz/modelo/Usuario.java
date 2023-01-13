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
    
    public Usuario(String usuario, String password){
        this.usuario=usuario;
        this.password=password;
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
    
    @Override
    public String toString(){
        return "usuario: " + usuario + "password" + password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
