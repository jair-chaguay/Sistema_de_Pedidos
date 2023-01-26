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
        
        try{
            cargarCombo();
        
        
        }catch(IOException | RuntimeException e){
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
    private ComboBox<String> cbxmenu;

    @FXML
    private ComboBox<Menu> cbxordenar;

    void cargarCombo() throws IOException {
        ArrayList<String> tipos= new ArrayList<>();
        tipos.add("Plato Fuerte");
        tipos.add("Bebida");
        tipos.add("Postre");
        tipos.add("Piqueo");
        cbxmenu.getItems().setAll(tipos);
    }

    @FXML
    void contPago(ActionEvent e) throws IOException {
        mostrarVentana(e);

    }

    void mostrarVentana(ActionEvent ae) throws IOException {
        FXMLLoader loader = new FXMLLoader(Principal.class.getResource("VentanaPago.fxml"));
        try {
            Parent root = loader.load();

            VentanaPagoController controlador = loader.getController();
            Scene scene = new Scene(root, 640, 500);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage myStage = (Stage) this.btnContinuar.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    

        @FXML 
        void limpiar(ActionEvent ev){
        
    }
    
    

}
