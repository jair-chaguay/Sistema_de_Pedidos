package com.mycompany.proyecto2p.chaguay.cruz.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 
 * @author HP
 */
public class Menu {

    String descripcion;
    double precio;
    String tipo;
/**
 * 
 * @param descripcion
 * @param precio
 * @param tipo 
 */
    public Menu(String descripcion, double precio, String tipo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }
/**
 * 
 * @return 
 */
    public String getDescripcion() {
        return descripcion;
    }
/**
 * 
 * @return 
 */
    public double getPrecio() {
        return precio;
    }
/**
 * 
 * @return 
 */
    public String getTipo() {
        return tipo;
    }
/**
 * 
 * @param descripcion 
 */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
/**
 * 
 * @param precio 
 */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
/**
 * 
 * @param tipo 
 */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
/**
 * 
 * @return 
 */
    @Override
    public String toString() {
        return "Menu{" + "descripcion=" + descripcion + ", precio=" + precio + ", tipo=" + tipo + '}';
    }
    
    
     
    

}
