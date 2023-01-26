/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 *
 * @author mcruz
 */
public class VentanaPagoController implements Initializable {

   
    @FXML
    private Button btnIngresar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }
    
    public void closeWindows() {
            try{
            FXMLLoader loader = new FXMLLoader(Principal.class.getResource("VentanaPedido.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
            myStage.close();                       
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
