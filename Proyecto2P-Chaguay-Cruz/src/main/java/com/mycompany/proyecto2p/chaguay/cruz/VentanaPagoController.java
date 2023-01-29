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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
    
    @FXML
    private ToggleGroup opcionesPago;
    @FXML
    private Label Labeltxt;
    
           
    
    double total;
    double totalIVA;
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Labeltxt.setText("");                
        // TODO
    }

    @FXML
    void opcionEscogida(ActionEvent e){
        for (Pedido p : VentanaPedidoController.listaPedidos) {
                total=p.getValor();
                totalIVA = (total + (total * 0.12))/2;
                
            }
        
        if(btnEfectivo.isSelected()){
            Labeltxt.setText("Tendrá que pagar " +totalIVA+ "dólares.\n Aségurese de tener el dinero completo por si el repartidor no tiene cambio.");
        }else if(btnTarjeta.isSelected()){
            Label lblTittular=new Label("Titular");
            Label lblNumero=new Label("Número");
            Label lblCaducidad=new Label("Caducidad");
            Label lblCv=new Label("CVV");
            TextField txtTi=new TextField();
            TextField txtNum= new TextField();
            TextField txtcad=new TextField();
            TextField txtcv=new TextField();
            GridPane.setConstraints(lblTittular, 0, 0);
            GridPane.setConstraints(lblNumero, 0, 1);
            GridPane.setConstraints(lblCaducidad, 0, 2);
            GridPane.setConstraints(lblCv, 0, 3);
            GridPane.setConstraints(txtTi, 1, 0);
            GridPane.setConstraints(txtNum, 1, 1);
            GridPane.setConstraints(txtcad, 1, 2);
            GridPane.setConstraints(txtcv, 1, 3);
            
        }
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
