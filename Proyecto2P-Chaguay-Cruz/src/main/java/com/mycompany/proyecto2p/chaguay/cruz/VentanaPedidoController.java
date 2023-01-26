/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import com.mycompany.proyecto2p.chaguay.cruz.modelo.Menu;
import static com.mycompany.proyecto2p.chaguay.cruz.modelo.Menu.leerArchivo;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mcruz
 */
public class VentanaPedidoController implements Initializable {

    private static ArrayList<Menu> mn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mn=leerArchivo();

        try {
            cargarCombo();

        } catch (IOException | RuntimeException e) {
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

    @FXML
    private GridPane gridOpciones;

    @FXML
    private GridPane gridPedido;

    void cargarCombo() throws IOException {
        ArrayList<String> tipos = new ArrayList<>();
        tipos.add("PlatoFuerte");
        tipos.add("Bebida");
        tipos.add("Postre");
        tipos.add("Piqueo");
        cbxmenu.getItems().setAll(tipos);
    }

    @FXML
    void comboEvents(ActionEvent e) {

        String opcion = cbxmenu.getValue();
        switch (opcion) {
            
            case "PlatoFuerte":
                String tipo1= "F";
                mostrarMenu(tipo1);
                break;
            case "Bebida":
                String tipo2= "B";
                
                mostrarMenu(tipo2);
                break;
            case "Postre":
                String tipo3= "P";
                mostrarMenu(tipo3);
                break;
            case "Piqueo":
                String tipo4= "Q";
                mostrarMenu(tipo4);
                break;
            default:
                break;
        }

    }

    public void mostrarMenu(String tipo) {
        for (int i = 0; i < mn.size(); i++) {
            Menu menu=mn.get(i);
            
                if (menu.getTipo().equals(tipo)) {
                    Label lblDescrp = new Label(menu.getDescripcion());
                    Label lblPrecio = new Label(String.valueOf(menu.getPrecio()));
                    TextField cantidad = new TextField();

                    Button btnAgregar = new Button("Agregar");

                    GridPane.setConstraints(lblDescrp, 0, i + 1);
                    GridPane.setConstraints(lblPrecio, 1, i + 1);
                    GridPane.setConstraints(cantidad, 2, i + 1);
                    GridPane.setConstraints(btnAgregar, 3, i + 1);

                    gridOpciones.getChildren().addAll(lblDescrp, lblPrecio, cantidad, btnAgregar);

                }

            
        }

    }
    
    public void mostrarPedido(){
    
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
    void limpiar(ActionEvent ev) {

    }

}
