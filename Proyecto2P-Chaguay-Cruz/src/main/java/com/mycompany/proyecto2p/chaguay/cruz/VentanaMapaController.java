/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import com.mycompany.proyecto2p.chaguay.cruz.modelo.Locales;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class VentanaMapaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private ArrayList<Locales> local;
    @FXML 
    private Pane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
    void agregarImgview(){
        local=Locales.leerLocales();
        ImageView imgv=null;
        for(Locales loc:local){
            try(FileInputStream input=new FileInputStream(Principal.pathImages+"iconoComida.jpg")){
                Image img=new Image(input,20,20,false,false);
                imgv=new ImageView(img);
                imgv.setLayoutX(loc.getCoordX());
                imgv.setLayoutY(loc.getCoordY());
            }catch(IOException ex){
                
            }
            
            String name=loc.getNombre();
            String direccion=loc.getDireccion();
            String horario=loc.getHorario();
            
            imgv.setOnMouseClicked(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){
                    Alert al=new Alert(AlertType.INFORMATION);
                    
                }
            });
                        
        }
    }

}
