/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import com.mycompany.proyecto2p.chaguay.cruz.modelo.Menu;
//import static com.mycompany.proyecto2p.chaguay.cruz.modelo.Menu.leerArchivo;
import com.mycompany.proyecto2p.chaguay.cruz.modelo.Pedido;
import com.mycompany.proyecto2p.chaguay.cruz.modelo.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mcruz
 */
public class VentanaPedidoController implements Initializable {

    private static ArrayList<Menu> mn = new ArrayList<>();
    private static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    double total;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            mn = leerArchivo();
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
                String tipo1 = "F";
                mostrarMenu(tipo1);
                break;
            case "Bebida":
                String tipo2 = "B";

                mostrarMenu(tipo2);
                break;
            case "Postre":
                String tipo3 = "P";
                mostrarMenu(tipo3);
                break;
            case "Piqueo":
                String tipo4 = "Q";
                mostrarMenu(tipo4);
                break;
            default:
                break;
        }

    }

    public void mostrarMenu(String tipo) {
        for (int i = 0; i < mn.size(); i++) {
            Menu menu = mn.get(i);

            if (menu.getTipo().equals(tipo)) {
                Label lblDescrp = new Label(menu.getDescripcion());
                Label lblPrecio = new Label(String.valueOf(menu.getPrecio()));
                TextField cantidad = new TextField();

                Button btnAgregar = new Button("Agregar");
                btnAgregar.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        //CREACION DE UN PEDIDO
                        //ARREGLAR ERROR DE NOMBRE Y APELLIDO
//                        Pedido p=new Pedido(menu.getDescripcion(),Usuario.getUsuario(),Integer.parseInt(cantidad.getText()),menu.getPrecio());

                    }

                });

                GridPane.setConstraints(lblDescrp, 0, i + 1);
                GridPane.setConstraints(lblPrecio, 1, i + 1);
                GridPane.setConstraints(cantidad, 2, i + 1);
                GridPane.setConstraints(btnAgregar, 3, i + 1);

                gridOpciones.getChildren().addAll(lblDescrp, lblPrecio, cantidad, btnAgregar);

            }

        }

    }
    //METODO PARA CREAR ID PEDIDO

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

    public void mostrarEscogidos() {
        Platform.runLater(new Runnable() {
            @Override

            public void run() {
                for (int i = 0; i < listaPedidos.size(); i++) {
                    Label lblDescr= new Label(listaPedidos.get(i).getDescripcion());
                    Label lblCant= new Label(String.valueOf(listaPedidos.get(i).getCantidad()));
                    Label lblPrecio= new Label(String.valueOf(listaPedidos.get(i).valorTotal()));
                    
                    
                    GridPane.setConstraints(lblDescr,0,i+1);
                    GridPane.setConstraints(lblCant,1,i+1);
                    GridPane.setConstraints(lblPrecio,2,i+1);

                    gridPedido.getChildren().addAll(lblDescr,lblCant,lblPrecio);

                }
                for(int j = 0;j<listaPedidos.size();j++){
                    double suma = listaPedidos.get(j).valorTotal();
                    total += suma;
                    
                  
                    double subtotalIVA = total + (total*0.14);
                    lblSubtotal.setText(String.valueOf(total));
                    lblIva.setText("12%");
                    lblTotal.setText(String.valueOf(subtotalIVA));
                   
                }
            }

        });
    
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
        listaPedidos.clear();

    }
    
     @FXML
    public void ordenarPor(ActionEvent ae){
        
    }
    
    
    public static ArrayList<Menu> leerArchivo() {
        try ( BufferedReader bfr = new BufferedReader(new FileReader("Menu.txt"))) {
            ArrayList<Menu> menu = new ArrayList<>();
            String linea;
            Menu m;
            while((linea=bfr.readLine())!=null){
                String[] lineas=linea.trim().strip().split(",");
                Menu mn= new Menu(lineas[0],Double.parseDouble(lineas[1]),lineas[2]);
                menu.add(mn);
            
            
            }
            return menu;

        } catch (IOException ex) {
            ex.getMessage();
            return null;
        }

    }

}
