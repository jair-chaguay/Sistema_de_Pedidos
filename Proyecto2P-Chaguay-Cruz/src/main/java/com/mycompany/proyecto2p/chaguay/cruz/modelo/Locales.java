/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz.modelo;

/**
 *
 * @author HP
 */
public class Locales {
    String nombre;
    String direccion;
    String horario;
    int coordX;
    int coordY;
    
    public Locales(String nombre, String direccion, String horario, int coordX, int coordY){
        this.nombre=nombre;
        this.direccion=direccion;
        this.horario=horario;
        this.coordX=coordX;
        this.coordY=coordY;
    }
    
    public String getNombre(){
    return nombre;
    }   
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    
    public String getHorario(){
        return horario;
    }
    
    public void setHorario(String horario){
        this.horario=horario;
    }
    
    public int getCoordX(){
        return coordX;
    }
    
    public void setCoordX(int coordX){
        this.coordX=coordX;
    }
    
    public int getCoordY(){
        return coordY;
    }
    
    public void setCoordY(int coordY){
        this.coordY=coordY;
    }
    
    
    
}
