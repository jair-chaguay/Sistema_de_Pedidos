/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import com.mycompany.proyecto2p.chaguay.cruz.modelo.Pedidos;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author mcruz
 */
public class VentanaFinalController implements Initializable {

    @FXML
    private VBox rootFinal;

    @FXML
    private ImageView imgg;

    @FXML
    private Label lblPedido;

    @FXML
    private Label cerrar;

    ArrayList<Pedidos> p = new ArrayList<>();
    String numeroPedido;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p=leerPedido();
        settearText(lblPedido);
        cargarImg();
        
        Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 5; i >= 0; i--) {
                int contador = i;
                String finish = "La ventana se cerrara en " + i + " segundos";
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {

                }
                Platform.runLater(new Runnable(){
                    @Override
                    public void run(){
                        cerrar.setText(finish);
                        if(contador==0){
                            Platform.exit();
                        }
                    }
                });
                
            }
        }
    });
          t1.start();

    }

    void cargarImg() {
        try ( FileInputStream input = new FileInputStream(Principal.pathImages + "Delivery.png")) {
            Image img = new Image(input);
            imgg.setImage(img);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public ArrayList<Pedidos> leerPedido() {
        ArrayList<Pedidos> ped = new ArrayList<>();
        try ( BufferedReader bfr = new BufferedReader(new FileReader("Pedidos.txt", StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = bfr.readLine()) != null) {
                String[] lineas = linea.split(",");
                Pedidos pedido = new Pedidos(Integer.parseInt(lineas[0]), lineas[1], Double.parseDouble(lineas[2]));
                ped.add(pedido);
            }
        } catch (IOException e) {
            e.getMessage();
            return null;
        }
        return ped;
    }

    void settearText(Label l) {       
        for (Pedidos pedido : p) {
            numeroPedido = String.valueOf(pedido.getIdPedido());
        }
        String set = "Su pedido Nro" + numeroPedido + "ha sido pegado y empezaremos a prepararlo";
        l.setText(set);
    }

    
    
}
