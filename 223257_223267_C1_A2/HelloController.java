package com.example.proyectoedac1;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
public class HelloController {
    private Stage stage;
    private Scene scene;
    private almacen inventario = almacen.getInstance().extraerArchivos();
    @FXML
    private Button salir;

    @FXML
     void agregarProducto(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("agregar.fxml"));
        Node nodo = (Node) event.getSource();
        stage = (Stage) nodo.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void venderProducto(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("vender.fxml"));
        Node nodo = (Node) event.getSource();
        stage = (Stage) nodo.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void verInventario(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("verInventario.fxml"));
        Node nodo = (Node) event.getSource();
        stage = (Stage) nodo.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void salirApp(ActionEvent event){
            Platform.exit();
    }
}