/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.proyecto2p.chaguay.cruz;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class Principal extends Application{
    private static Scene scene;
    public static String pathFiles="src/main/resources/Files/";
    public static String pathImages="src/main/resources/Images/";
    
    @Override
    public void start(Stage s) throws IOException{
        FXMLLoader fxmlloader= new FXMLLoader(Principal.class.getResource("VentanaSistema.fxml"));
        Parent root= fxmlloader.load();
        scene = new Scene(root, 640,480);
        s.setScene(scene);
        s.setTitle("The Good Burguer Restaurant");
        s.show();
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch();
    }
    
}
