/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz.modelo;

/**
 *
 * @author mcruz
 */
public class Pedido implements Comparable<Pedido>{
    
    private String descripcion;
    private int cantidad; //cantidad de comida escogida
    private String nombreCliente;
    private double valor;
    
    @Override
    public int compareTo(Pedido p){
        if(this.valor<p.getValor()){
            return -1;
        }else if(this.valor>p.getValor()){
            return 1;
        
        }else
            return 0;
    
    }

    public Pedido( String descripcion,int cantidad, String nombreCliente, double valor) {
        this.descripcion=descripcion;
        this.cantidad = cantidad;
        this.nombreCliente = nombreCliente;
        this.valor = valor;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

   
    
    public double valorTotal(){
        double total = this.getCantidad() * this.getValor();
        return total;
      
    }
    
    
  
    
}
