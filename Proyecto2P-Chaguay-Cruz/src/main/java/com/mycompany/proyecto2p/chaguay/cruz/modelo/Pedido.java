/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz.modelo;

/**
 *
 * @author mcruz
 */
public class Pedido {
    private int idPedido;
    private String descripcion;
    private int cantidad; //cantidad de comida escogida
    private String nombreCliente;
    private double valor;

    public Pedido(int idPedido, String descripcion,int cantidad, String nombreCliente, double valor) {
        this.idPedido = idPedido;
        this.descripcion=descripcion;
        this.cantidad = cantidad;
        this.nombreCliente = nombreCliente;
        this.valor = valor;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getdescripcion() {
        return descripcion;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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

    public String getDescripcion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public double valorTotal(){
        double total = this.getCantidad() * this.getValor();
        return total;
      
    }
    
    
  
    
}
