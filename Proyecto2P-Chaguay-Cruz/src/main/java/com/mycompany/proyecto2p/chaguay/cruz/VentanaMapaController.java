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
import java.util.Random;
import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class VentanaMapaController implements Initializable {

    private ArrayList<Locales> local;
    private ImageView imgv;

    @FXML
    private Pane rootPane;
/**
 * 
 * @param url
 * @param rb 
 */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        local = Locales.leerLocales();
        agregarImgview();
    }
    /**
     * 
     */
    void agregarImgview() {

        rootPane.getChildren().clear();
        imgv = null;

        Thread t = new Thread(new Runnable() {
            public void run() {

                for (Locales loc : local) {
                    Random r = new Random();
                    int n = r.nextInt(11);
                    try {
                        Thread.sleep(n * 1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try ( FileInputStream input = new FileInputStream(Principal.pathImages + "iconoComida.png")) {
                                Image img = new Image(input, 40, 40, false, false);
                                imgv = new ImageView(img);

                                imgv.setX(loc.getCoordX());
                                imgv.setY(loc.getCoordY());

                            } catch (IOException ex) {

                            }

                            String name = loc.getNombre();
                            String direccion =loc.getDireccion();
                            String horario = loc.getHorario();

                            rootPane.getChildren().add(imgv);
                            imgv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                public void handle(MouseEvent e) {
                                    Alert al = new Alert(AlertType.INFORMATION);                                    
                                    al.setHeaderText(name+"\n"+direccion+"\n"+horario);

                                    Thread t2 = new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (int i = 5; i >= 0; i--) {
                                                int contador=i;
                                                String finish = "La ventana se cerrara en " + i + " segundos";
                                                
                                                try {
                                                    Thread.sleep(1000);                                                    
                                                } catch (InterruptedException ex) {

                                                }
                                                Platform.runLater(new Runnable() {
                                                    
                                                    @Override
                                                    public void run() {
                                                        
                                                        al.setContentText(finish);
                                                        if(contador==0){
                                                            al.close();
                                                        }
                                                    }

                                                });
                                                

                                            }

                                        }

                                    });

                                    t2.setDaemon(true);
                                    t2.start();
                                    al.showAndWait();                                    
                                }

                            });

                        }
                    });

                }
            }
        }
        );
        t.start();

    }

}
