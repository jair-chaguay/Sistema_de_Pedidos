/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import com.mycompany.proyecto2p.chaguay.cruz.modelo.Locales;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class VentanaMapaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    static ArrayList<Locales> local;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public static ArrayList<Locales>leerLocales(){
        local=new ArrayList<>();
        try(BufferedReader bfr= new BufferedReader(new FileReader(Principal.pathFiles+"Locales.txt"))){
            String linea;
            while((linea=bfr.readLine())!=null){
                String[] lineas=linea.trim().strip().split(",");
                String nombre=lineas[0];
                String direccion=lineas[1];
                String horario=lineas[2];
                int coordX=Integer.parseInt(lineas[3]);
                int coordY=Integer.parseInt(lineas[4]);
                Locales lcal=new Locales(nombre,direccion,horario,coordX,coordY);
                local.add(lcal);
                
            }
            
        }catch(IOException ex){
            
        }
        return null;
    }
   
    
}
