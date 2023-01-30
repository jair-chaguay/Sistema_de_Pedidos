/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import com.mycompany.proyecto2p.chaguay.cruz.modelo.Pedido;
import com.mycompany.proyecto2p.chaguay.cruz.modelo.Pedidos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    String d = "";
    ArrayList<Pedidos> ped = new ArrayList<>();
    int cod;

    @FXML
    private Button btnIngresar;

    @FXML
    private TextField txtDireccion;

    @FXML
    private RadioButton btnEfectivo;

    @FXML
    private RadioButton btnTarjeta;

    @FXML
    private VBox seccionDatos;
    @FXML
    private GridPane gdOpciones;

    @FXML
    private ToggleGroup opcionesPago;
    @FXML
    private Label Labeltxt;
    
    @FXML
    private Button btnLimpiar;
            

    @FXML 
    private VBox rootFinal;
    String tipo;
    String nom;
    double total;
    double totalIVA;

    double totalPorc;
    TextField txtTi;
    TextField txtNum;
    TextField txtcad;
    TextField txtcv;
/**
 * 
 * @param url
 * @param rb 
 */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Labeltxt.setText("");

        // TODO
    }
/**
 * 
 * @param e 
 */
    @FXML
    void opcionEscogida(ActionEvent e) {

        double valorTotal = 0;

        for (Pedido p : VentanaPedidoController.listaPedidos) {

            valorTotal += p.valorTotal() + (p.valorTotal() * 0.12);
        }
        totalPorc = (valorTotal * 0.05) + valorTotal;
        if (btnEfectivo.isSelected()) {
            seccionDatos.getChildren().clear();
            Labeltxt.setText("Tendrá que pagar " + valorTotal + " dólares.\n Aségurese de tener el dinero completo por si el repartidor no tiene cambio.");
            seccionDatos.getChildren().add(Labeltxt);
        } else if (btnTarjeta.isSelected()) {
            seccionDatos.getChildren().clear();
            Label lblTittular = new Label("Titular");
            Label lblNumero = new Label("Número");
            Label lblCaducidad = new Label("Caducidad");
            Label lblCv = new Label("CVV");
            txtTi = new TextField();
            txtNum = new TextField();
            txtcad = new TextField();
            txtcv = new TextField();
            GridPane.setConstraints(lblTittular, 0, 0);
            GridPane.setConstraints(lblNumero, 0, 1);
            GridPane.setConstraints(lblCaducidad, 0, 2);
            GridPane.setConstraints(lblCv, 0, 3);
            GridPane.setConstraints(txtTi, 1, 0);
            GridPane.setConstraints(txtNum, 1, 1);
            GridPane.setConstraints(txtcad, 1, 2);
            GridPane.setConstraints(txtcv, 1, 3);

            gdOpciones.getChildren().addAll(lblTittular, lblNumero, lblCaducidad, lblCv, txtTi, txtNum, txtcad, txtcv);
            gdOpciones.setVgap(20);
            Labeltxt.setText("Tendrá que pagar un total de " + totalPorc + " dólares por el incremento \ndel 5% por uso de la tarjeta");
            seccionDatos.getChildren().addAll(gdOpciones, Labeltxt);
            seccionDatos.setSpacing(20);
            seccionDatos.setVisible(true);
        }

    }
/**
 * 
 * @param e 
 */
    @FXML
    void MostrarFinal(ActionEvent e) {

        if (txtDireccion.getText().equals("")) {
            Alert al = new Alert(AlertType.ERROR);
            al.setTitle("Error");
            al.setHeaderText("Error: El campo de dirección se encuentra vacío");
            al.setContentText("Ingrese un valor");
            al.showAndWait();
        } else if ((!(btnEfectivo.isSelected())) && (!(btnTarjeta.isSelected()))) {
            Alert al = new Alert(AlertType.ERROR);
            al.setTitle("Error");
            al.setHeaderText("Error: No se ha seleccionado un método con que pagar");
            al.setContentText("Seleccione un método para pagar");
            al.showAndWait();
        } else if (btnTarjeta.isSelected()) {
            if (txtTi.getText().equals("")) {
                Alert al = new Alert(AlertType.ERROR);
                al.setTitle("Error");
                al.setHeaderText("Error: El campo de titular se encuentra vacío");
                al.setContentText("Ingrese un valor");
                al.showAndWait();
            } else if (txtNum.getText().equals("")) {
                Alert al = new Alert(AlertType.ERROR);
                al.setTitle("Error");
                al.setHeaderText("Error: El campo del numero de tarjeta se encuentra vacío");
                al.setContentText("Ingrese un valor");
                al.showAndWait();
            } else if (txtcad.getText().equals("")) {
                Alert al = new Alert(AlertType.ERROR);
                al.setTitle("Error");
                al.setHeaderText("Error: El campo de caducidad se encuentra vacío");
                al.setContentText("Ingrese un valor");
                al.showAndWait();
            } else if (txtcv.getText().equals("")) {
                Alert al = new Alert(AlertType.ERROR);
                al.setTitle("Error");
                al.setHeaderText("Error: El campo de CVV se encuentra vacío");
                al.setContentText("Ingrese un valor");
                al.showAndWait();

            } else {
                try {
                    MostrarVentana(e);
                } catch (IOException ex) {

                }
                ingresardatos();

            }

        }

    }
/**
 * 
 * @param a
 * @throws IOException 
 */
    void MostrarVentana(ActionEvent a) throws IOException {
        FXMLLoader loader = new FXMLLoader(Principal.class.getResource("VentanaFinal.fxml"));
        try {
            Parent root = loader.load();

            VentanaFinalController controlador = loader.getController();
            Scene scene = new Scene(root, 640, 600);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
/**
 * 
 * @return 
 */
    public int crearCodigo() {
        String opciones = "1234567890";
        String cadena = "";
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int posicion = r.nextInt(opciones.length());
            char caracter = opciones.charAt(posicion);
            cadena += caracter;
        }
        int valor = Integer.parseInt(cadena);
        return valor;

    }
/**
 * 
 * @return 
 */
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
/**
 * 
 */
    void ingresardatos() {

        try ( BufferedWriter bf = new BufferedWriter(new FileWriter("pagos.txt"))) {
            ped = leerPedido();
            if (btnEfectivo.isSelected()) {
                tipo = "E";
            } else if (btnTarjeta.isSelected()) {
                tipo = "C";
            }
            Date today = Calendar.getInstance().getTime();
            for (Pedidos p : ped) {
                cod = p.getIdPedido();
                nom = p.getNombreCliente();
            }
            bf.write(crearCodigo() + "," + cod + "," + totalPorc + "," + today + "," + tipo);
        } catch (IOException e) {
            e.getMessage();
        }
    }
/**
 * 
 */
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
   /**
    * 
    * @param e 
    */ 
    @FXML
    void limpiar(ActionEvent e){
        txtDireccion.setText("");
        txtTi.setText("");
            txtNum.setText("");
            txtcad.setText("");
            txtcv.setText("");
            btnEfectivo.setSelected(false);
            btnTarjeta.setSelected(false);

}
}
