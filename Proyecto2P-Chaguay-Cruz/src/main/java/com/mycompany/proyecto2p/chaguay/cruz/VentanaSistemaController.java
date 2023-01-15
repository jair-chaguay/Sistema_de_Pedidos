/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import com.mycompany.proyecto2p.chaguay.cruz.modelo.Usuario;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private HBox seccionTitle;

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
    void IngresarOptions(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(Principal.class.getResource("VentanaOpciones.fxml"));
            
            Parent root = loader.load();
            VentanaOpcionesController controlador= loader.getController();
            Scene scene = new Scene(root, 640, 480);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage myStage = (Stage) this.btnIngresar.getScene().getWindow();
            myStage.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

//    static ArrayList<Usuario> listUsuario=new ArrayList<>();
//    
//    public void validarUsuario(){
//        try (BufferedReader bfr = new BufferedReader(new FileReader(Principal.pathFiles+"Usuarios.txt"))) {
//                String linea;
//                while((linea=bfr.readLine())!=null){
//                    String[] lineas=linea.strip().split(";");
//                            String user=lineas[0];
//                            String psswrd=lineas[1];
//                            listUsuario=new ArrayList<>();
//                            Usuario n=new Usuario(user,psswrd);
//                            listUsuario.add(n);
//                }
//
//            } catch (IOException e) {
//            }
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
