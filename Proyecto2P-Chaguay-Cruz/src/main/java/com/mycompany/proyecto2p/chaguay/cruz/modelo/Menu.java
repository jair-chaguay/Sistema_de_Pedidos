package com.mycompany.proyecto2p.chaguay.cruz.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {

    String descripcion;
    double precio;
    String tipo;

    public Menu(String descripcion, double precio, String tipo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Menu{" + "descripcion=" + descripcion + ", precio=" + precio + ", tipo=" + tipo + '}';
    }

    public static ArrayList<Menu> leerArchivo() {
        try ( BufferedReader bfr = new BufferedReader(new FileReader("Menu.txt"))) {
            ArrayList<Menu> menu = new ArrayList<>();
            String linea;
            Menu m;
            while((linea=bfr.readLine())!=null){
                String[] lineas=linea.trim().strip().split(",");
                Menu mn= new Menu(lineas[0],Double.parseDouble(lineas[1]),lineas[2]);
                menu.add(mn);
            
            
            }
            return menu;

        } catch (IOException ex) {
            ex.getMessage();
            return null;
        }

    }

}
