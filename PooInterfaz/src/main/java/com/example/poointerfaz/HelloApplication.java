package com.example.poointerfaz;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
public class HelloApplication extends Application {
    private Almacen almacen;
    private Venta vendedor = new Venta();

    @Override
    public void start(Stage stage) throws IOException {
        almacen = almacen.getInstance();
        almacen.aniadirFruta(new Fruta(15, 10));
        almacen.aniadirFruta(new Fruta(15, 10));
        almacen.aniadirGranos(new Granos(10, 10));
        almacen.aniadirGranos(new Granos(10, 10));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 636, 410);
        stage.setTitle("Registro de productos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button Generar;
    @FXML private Button Venta;
    @FXML private Button Llenar;

    @FXML
    void generarReporte(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Reporte.fxml"));
        Node nodo = (Node) event.getSource();
        stage = (Stage) nodo.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void llenarAlmacen(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("LLenar.fxml"));
        Node nodo = (Node) event.getSource();
        stage = (Stage) nodo.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
     void generarVenta(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Vender.fxml"));
        Node nodo = (Node) event.getSource();
        stage = (Stage) nodo.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}