/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class VentanaOpcionesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private VBox rootOpciones;
    
    @FXML
    private Button btnGrabar;
    
    @FXML
    private Label LblUsuario;
    
    @FXML HBox seccionImg;
    
    
    @FXML
    void localcercano(ActionEvent e){
        try{
        Image image=new Image(new FileInputStream(Principal.pathImages+"mapa2.png"));
        ImageView imagev=new ImageView(image);
        imagev.setFitHeight(480);
        imagev.setFitWidth(640);
        Group root=new Group();
        root.getChildren().add(imagev);
        Scene scene=new Scene(root, 640,480);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }catch(FileNotFoundException ex){
        
    }
    }
    @FXML
    void hazPedido(ActionEvent evt){
        
    }

    
    
    public void closeWindows() {
       
        try {
            FXMLLoader loader = new FXMLLoader(Principal.class.getResource("VentanaSistema.fxml"));
            
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.btnGrabar.getScene().getWindow();
            myStage.close();                       
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    void init(String txt){
        LblUsuario.setText("Bienvenid@ " +txt);
        
    }
    
    
  
    
}
