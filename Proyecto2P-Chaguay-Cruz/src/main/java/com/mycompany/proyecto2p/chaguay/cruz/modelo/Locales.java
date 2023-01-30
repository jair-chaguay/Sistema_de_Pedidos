/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz.modelo;

import com.mycompany.proyecto2p.chaguay.cruz.Principal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Locales {
    String nombre;
    String direccion;
    String horario;
    double coordX;
    double coordY;
    /**
     * 
     * @param nombre
     * @param direccion
     * @param horario
     * @param coordX
     * @param coordY 
     */
    public Locales(String nombre, String direccion, String horario, double coordX, double coordY){
        this.nombre=nombre;
        this.direccion=direccion;
        this.horario=horario;
        this.coordX=coordX;
        this.coordY=coordY;
    }
    /**
     * 
     * @return 
     */
    public String getNombre(){
    return nombre;
    }   
    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    /**
     * 
     * @return 
     */
    public String getDireccion(){
        return direccion;
    }
    /**
     * 
     * @param direccion 
     */
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    /**
     * 
     * @return 
     */
    public String getHorario(){
        return horario;
    }
    /**
     * 
     * @param horario 
     */
    public void setHorario(String horario){
        this.horario=horario;
    }
    /**
     * 
     * @return 
     */
    public double getCoordX(){
        return coordX;
    }
    /**
     * 
     * @param coordX 
     */
    public void setCoordX(double coordX){
        this.coordX=coordX;
    }
    /**
     * 
     * @return 
     */
    public double getCoordY(){
        return coordY;
    }
    /**
     * 
     * @param coordY 
     */
    public void setCoordY(double coordY){
        this.coordY=coordY;
    }
    
        public static ArrayList<Locales> leerLocales() {
        try ( BufferedReader bfr = new BufferedReader(new FileReader(Principal.pathFiles + "Locales.txt",StandardCharsets.UTF_8))) {
            ArrayList<Locales> local = new ArrayList<>();
            String linea=null;
            while ((linea = bfr.readLine()) != null) {
                String[] lineas = linea.trim().strip().split(",");
                String nombre = lineas[0];
                String direccion = lineas[1];
                String horario = lineas[2];
                double coordX = Double.parseDouble(lineas[3]);
                double coordY = Double.parseDouble(lineas[4]);
                Locales lo = new Locales(nombre, direccion, horario, coordX, coordY);
                local.add(lo);

            }
            return local;

        } catch (IOException ex) {
            return null;
        }
    }
    
    
}
