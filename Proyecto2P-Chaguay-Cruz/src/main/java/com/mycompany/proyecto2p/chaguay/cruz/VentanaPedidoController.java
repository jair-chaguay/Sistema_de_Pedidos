/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import com.mycompany.proyecto2p.chaguay.cruz.modelo.Menu;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mcruz
 */
public class VentanaPedidoController implements Initializable {

    private ArrayList<Menu> mn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            mn = Menu.leerArchivo();
            cargarCombo();
        } catch (IOException ex) {
            ex.printStackTrace();

        }
        // TODO
    }

    @FXML
    private VBox root;

    @FXML
    private Button btnContinuar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Label lblSubtotal;

    @FXML
    private Label lblIva;

    @FXML
    private Label lblTotal;

    @FXML
    private ComboBox<Menu> cbxmenu;

    @FXML
    private ComboBox<Menu> cbxordenar;

    void cargarCombo() throws IOException {
        for (Menu menu : mn) {
            if (menu.getDescripcion().equals("F")) {
                

            }

        }
    }
    
    @FXML
    void contPago(ActionEvent e)throws IOException{
        mostrarVentana(e);
        
    }
    
    void mostrarVentana(ActionEvent ae)throws IOException{
        FXMLLoader fxml=new FXMLLoader(Principal.class.getResource("VentanaPago.fxml"));
        Parent root=fxml.load();
        Scene scene=new Scene(root, 640,520);
            Stage stage=new Stage();
            stage.setScene(scene);            
            stage.show();
        
        
    }
    
    @FXML 
    void limpiar(ActionEvent ea){
        
    }
    
    

}
