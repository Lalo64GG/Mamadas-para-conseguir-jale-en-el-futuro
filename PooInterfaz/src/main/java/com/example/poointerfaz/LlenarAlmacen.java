package com.example.poointerfaz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class LlenarAlmacen {
    private Almacen almacen;
    @FXML
    private RadioButton fruta;

    @FXML
    private RadioButton granos;

    @FXML
    private TextField canti;
    @FXML
    private Button salir;
    @FXML
    private Button llenar;
    @FXML
    private Label mensaje;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void regresarMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        Node nodo = (Node) event.getSource();
        stage = (Stage) nodo.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public  void encargarProducto(ActionEvent event) {
        almacen = almacen.getInstance();
        int opcion = 0;
        String tipoProducto = null;
        if (fruta.isSelected()) {
            tipoProducto = "fruta";
            opcion = 1;
        } else {
            if (granos.isSelected()) {
            } else {
                tipoProducto = "granos";
                opcion = 2;
            }
        }
        double cantidad = Double.parseDouble(canti.getText());
        if (cantidad <= 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Datos invalidos, intente de nuevo");
            alert.showAndWait();
        } else {

            if (opcion == 1) {
                Fruta fruta = new Fruta(15, cantidad);
                almacen.aniadirFruta(fruta);
            } else {
                Granos granos = new Granos(10, cantidad);
                almacen.aniadirGranos(granos);
            }
            mensaje.setText("Cantidad agregada.");
        }
    }



}