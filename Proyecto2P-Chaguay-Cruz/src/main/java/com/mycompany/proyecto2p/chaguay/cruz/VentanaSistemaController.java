/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class VentanaSistemaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private VBox root;
    
    @FXML
    private Label lbltTittle;
        
    @FXML
    private GridPane gridUserPasswrd;
    
    @FXML
    private Label lblUsuario;
    
    @FXML
    private TextField txtUsuario;
    
    @FXML
    private Label lblContraseña;
        
    @FXML
    private PasswordField txtContraseña;
    
    @FXML
    private HBox contenedorIB;
    
    @FXML
    private ImageView imgRepartitor;
    @FXML
    private VBox contButton;
    
    @FXML 
    private Button btnIngresar;
    
    @FXML
    private ImageView Imagehmbrg;
    
    @FXML
    void eventKey(KeyEvent event){
        Object evt= event.getSource();
        if(evt.equals(txtUsuario)){
            if(event.getCharacter().equals(" ")){
                event.consume();
            }
            
        }else if(evt.equals(txtContraseña)){
            if(event.getCharacter().equals(" ")){
                event.consume();
            }
        }
        
    }
    
    @FXML
    void IngresarOptions(){
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
