/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import com.mycompany.proyecto2p.chaguay.cruz.modelo.Pedido;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author mcruz
 */
public class VentanaPagoController implements Initializable {

    @FXML
    private Button btnIngresar;

    @FXML
    private RadioButton btnEfectivo;

    @FXML
    private RadioButton btnTarjeta;
    
    @FXML
    private GridPane gdOpciones;
           
    
    double total;
    double totalIVA;
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        escogerOpcion();
        

        // TODO
    }

    public void escogerOpcion() {
        for (Pedido p : VentanaPedidoController.listaPedidos) {
                total=p.getValor();
                totalIVA = (total + (total * 0.12))/2;
                
            }
        btnTarjeta.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                Label lblPrecio=new Label("Su valor a pagar es de: "+totalIVA+"  dolares");
                Label lblMensaje=new Label("Asegurese de tener el dinero completo por si el repartidor no tiene cambio");
                 GridPane.setConstraints(lblPrecio, 0, 0);
                 GridPane.setConstraints(lblMensaje, 0,1);
                 
                 gdOpciones.getChildren().addAll(lblPrecio,lblMensaje);
                
                

            }

        });
    }

    public void closeWindows() {
        try {
            FXMLLoader loader = new FXMLLoader(Principal.class.getResource("VentanaPedido.fxml"));

            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
