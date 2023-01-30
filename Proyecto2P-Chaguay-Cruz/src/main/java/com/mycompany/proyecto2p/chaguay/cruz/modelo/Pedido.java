/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz.modelo;

/**
 *
 * @author mcruz
 */
/**
 * 
 * @author HP
 */
public class Pedido {
    
    private String descripcion;
    private int cantidad; //cantidad de comida escogida
    private String nombreCliente;
    private double valor;
/**
 * 
 * @param descripcion
 * @param cantidad
 * @param nombreCliente
 * @param valor 
 */
    public Pedido( String descripcion,int cantidad, String nombreCliente, double valor) {
        this.descripcion=descripcion;
        this.cantidad = cantidad;
        this.nombreCliente = nombreCliente;
        this.valor = valor;
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
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     * @return 
     */
    public int getCantidad() {
        return cantidad;
    }
/**
 * 
 * @param cantidad 
 */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
/**
 * 
 * @return 
 */
    public String getNombreCliente() {
        return nombreCliente;
    }
/**
 * 
 * @param nombreCliente 
 */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
/**
 * 
 * @return 
 */
    public double getValor() {
        return valor;
    }
/**
 * 
 * @param valor 
 */
    public void setValor(double valor) {
        this.valor = valor;
    }

   
  /**
   * 
   * @return 
   */  
    public double valorTotal(){
        double total = this.getCantidad() * this.getValor();
        return total;
      
    }
    
    
  
    
}
