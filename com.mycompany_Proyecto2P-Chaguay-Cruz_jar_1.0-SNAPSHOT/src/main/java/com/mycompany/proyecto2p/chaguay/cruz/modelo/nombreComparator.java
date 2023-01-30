/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz.modelo;

import java.util.Comparator;

/**
 *
 * @author mcruz
 */
public class nombreComparator implements Comparator<Pedido>{
    @Override
    public int compare(Pedido p, Pedido p1){
        return p.getDescripcion().compareTo(p1.getDescripcion());
    
    }
    
}
