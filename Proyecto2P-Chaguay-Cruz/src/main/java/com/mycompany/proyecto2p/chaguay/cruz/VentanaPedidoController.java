/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import static com.mycompany.proyecto2p.chaguay.cruz.VentanaSistemaController.usuariosI;
import com.mycompany.proyecto2p.chaguay.cruz.modelo.Menu;
import com.mycompany.proyecto2p.chaguay.cruz.modelo.Pedido;
import com.mycompany.proyecto2p.chaguay.cruz.modelo.Usuario;
import com.mycompany.proyecto2p.chaguay.cruz.modelo.ValorInsuficienteException;
import com.mycompany.proyecto2p.chaguay.cruz.modelo.tipoAlimento;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mcruz
 */
public class VentanaPedidoController implements Initializable {

    static ArrayList<Menu> menulista = new ArrayList<>();
    static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    double total;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        menulista = leerArchivo();
        try {
            cargarCombo();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
    private ComboBox<String> cbxordenar;

    @FXML
    private GridPane gridOpciones;

    @FXML
    private GridPane gridPedido;

    public ArrayList<Menu> leerArchivo() {
        ArrayList<Menu> menulista = new ArrayList<>();
        try ( BufferedReader bfr = new BufferedReader(new FileReader(Principal.pathFiles + "Menu.txt", StandardCharsets.UTF_8))) {
            String linea;

            while ((linea = bfr.readLine()) != null) {
                String[] lineas = linea.split(",");
                Menu menu = new Menu(lineas[0], Double.parseDouble(lineas[1]), lineas[2]);
                menulista.add(menu);
            }
        } catch (IOException ex) {
            ex.getMessage();
            return null;
        }
        return menulista;
    }

    void cargarCombo() throws IOException {
        ArrayList<String> tipos = new ArrayList<>();
        tipos.add("Platos Fuertes");
        tipos.add("Bebidas");
        tipos.add("Postres");
        tipos.add("Piqueos");
        cbxmenu.getItems().setAll(tipos);

    }

    @FXML
    void comboEvents(ActionEvent e) {

        String opcion = cbxmenu.getValue();

        if (opcion.equals("Platos Fuertes")) {
            gridOpciones.getChildren().clear();
            Label lblDescrp = new Label("Descripcion");
            Label lblPrecio = new Label("Precio");
            Label lblCantidad = new Label("Cantidad");
            GridPane.setConstraints(lblDescrp, 0, 0);
            GridPane.setConstraints(lblPrecio, 1, 0);
            GridPane.setConstraints(lblCantidad, 2, 0);
            gridOpciones.getChildren().addAll(lblDescrp, lblPrecio, lblCantidad);

            String tipoPedido = "F";
            mostrarMenu(tipoPedido);

        } else if (opcion.equals("Bebidas")) {
            gridOpciones.getChildren().clear();
            Label lblDescrp = new Label("Descripcion");
            Label lblPrecio = new Label("Precio");
            Label lblCantidad = new Label("Cantidad");
            GridPane.setConstraints(lblDescrp, 0, 0);
            GridPane.setConstraints(lblPrecio, 1, 0);
            GridPane.setConstraints(lblCantidad, 2, 0);
            gridOpciones.getChildren().addAll(lblDescrp, lblPrecio, lblCantidad);

            String tipoPedido = "B";
            mostrarMenu(tipoPedido);

        } else if (opcion.equals("Postres")) {
            gridOpciones.getChildren().clear();
            Label lblDescrp = new Label("Descripcion");
            Label lblPrecio = new Label("Precio");
            Label lblCantidad = new Label("Cantidad");
            GridPane.setConstraints(lblDescrp, 0, 0);
            GridPane.setConstraints(lblPrecio, 1, 0);
            GridPane.setConstraints(lblCantidad, 2, 0);
            gridOpciones.getChildren().addAll(lblDescrp, lblPrecio, lblCantidad);

            String tipoPedido = "P";
            mostrarMenu(tipoPedido);

        } else if (opcion.equals("Piqueos")) {
            gridOpciones.getChildren().clear();
            Label lblDescrp = new Label("Descripcion");
            Label lblPrecio = new Label("Precio");
            Label lblCantidad = new Label("Cantidad");
            GridPane.setConstraints(lblDescrp, 0, 0);
            GridPane.setConstraints(lblPrecio, 1, 0);
            GridPane.setConstraints(lblCantidad, 2, 0);
            gridOpciones.getChildren().addAll(lblDescrp, lblPrecio, lblCantidad);
            String tipoPedido = "Q";
            mostrarMenu(tipoPedido);

        }

    }

    public void mostrarMenu(String tipo) {
        for (int i = 0; i < menulista.size(); i++) {
            Menu menu = menulista.get(i);

            if (menulista.get(i).getTipo().equals(tipo)) {
                Label lblDescrp = new Label(menu.getDescripcion());
                Label lblPrecio = new Label(String.valueOf(menu.getPrecio()));
                TextField cantidad = new TextField();

                Button btnAgregar = new Button("Agregar");
                btnAgregar.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {

                        //CREACION DE UN PEDIDO
                        Pedido p = new Pedido(menu.getDescripcion(), Integer.parseInt(cantidad.getText()), usuariosI.getNameApellido(), menu.getPrecio());
                        listaPedidos.add(p);
                        mostrarEscogidos();

                    }

                });

                GridPane.setConstraints(lblDescrp, 0, i + 1);
                GridPane.setConstraints(lblPrecio, 1, i + 1);
                GridPane.setConstraints(cantidad, 2, i + 1);
                GridPane.setConstraints(btnAgregar, 3, i + 1);
                gridOpciones.setVgap(10); //ESPACIADO ENTRE LINEAS           
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

                    Label lblDescr = new Label(listaPedidos.get(i).getDescripcion());
                    Label lblCant = new Label(String.valueOf(listaPedidos.get(i).getCantidad()));
                    Label lblPrecio = new Label(String.valueOf(listaPedidos.get(i).valorTotal()));

                    GridPane.setConstraints(lblDescr, 0, i + 1);
                    GridPane.setConstraints(lblCant, 1, i + 1);
                    GridPane.setConstraints(lblPrecio, 2, i + 1);

                    gridPedido.getChildren().addAll(lblDescr, lblCant, lblPrecio);

                }
                for (int j = 0; j < listaPedidos.size(); j++) {
                    double suma = listaPedidos.get(j).valorTotal();
                    total += suma;

                    double subtotalIVA = total + (total * 0.14);
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
    public void ordenarPor(ActionEvent ae) {

    }

}
