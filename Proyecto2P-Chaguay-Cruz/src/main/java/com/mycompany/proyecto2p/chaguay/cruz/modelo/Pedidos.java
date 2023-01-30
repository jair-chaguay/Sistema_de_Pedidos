/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
/**
 * 
 * @author HP
 */
public class Pedidos implements Serializable{
    int idPedido;
    String nombreCliente;
    double total;
    /**
     * 
     * @param idPedido
     * @param nombreCliente
     * @param total 
     */
 public Pedidos(int idPedido, String nombreCliente, double total){
     this.idPedido=idPedido;
     this.nombreCliente=nombreCliente;
     this.total=total;
 }
/**
 * 
 * @return 
 */
    public int getIdPedido() {
        return idPedido;
    }
/**
 * 
 * @param idPedido 
 */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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
    public double getTotal() {
        return total;
    }
/**
 * 
 * @param total 
 */
    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
