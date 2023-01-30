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
public class Pagos {
    private int idPago;
    private int idPedido;
    private String nombreCliente;
    private  double totalPagar;
    private String fecha;
    private String tipo;
/**
 * 
 * @param idPago
 * @param idPedido
 * @param nombreCliente
 * @param totalPagar
 * @param fecha
 * @param tipo 
 */
    public Pagos(int idPago, int idPedido, String nombreCliente, double totalPagar, String fecha, String tipo) {
        this.idPago = idPago;
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.totalPagar = totalPagar;
        this.fecha = fecha;
        this.tipo = tipo;
    }
/**
 * 
 * @return 
 */
    public int getIdPago() {
        return idPago;
    }
/**
 * 
 * @param idPago 
 */
    public void setIdPago(int idPago) {
        this.idPago = idPago;
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
    public double getTotalPagar() {
        return totalPagar;
    }
/**
 * 
 * @param totalPagar 
 */
    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
/**
 * 
 * @return 
 */
    public String getFecha() {
        return fecha;
    }
/**
 * 
 * @param fecha 
 */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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
 * @param tipo 
 */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
