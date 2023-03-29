package com.example.poointerfaz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Venta implements Initializable{
    public static ArrayList<Producto> vendido = new ArrayList<>();
    private Almacen almacen;
    @FXML
    private Pane pane;

    @FXML
    private RadioButton fruta;

    @FXML
    private RadioButton granos;

    @FXML
    private Label mensaje;

    @FXML
    private Label cantidadLabel;
    @FXML
    private  Label mostrarCant;

    @FXML
    private TextField cliente;

    @FXML
    private TextField cantidad;
    @FXML
    private Label a;

    @FXML
    private Button vender;
    @FXML
    private Button salir;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void vender(ActionEvent event) {
        if (fruta.isSelected()) venderFruta();
        else if (granos.isSelected()) venderGranos();
    }

    private void venderFruta() {
        almacen = almacen.getInstance();
        String nombre = cliente.getText();
        for(int i = 0; i<nombre.length(); i++){
            if(nombre.charAt(i)>=48 && nombre.charAt(i)<=67){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Datos invalidos, intente de nuevo");
                alert.showAndWait();
            }

        }
        double cant = Double.parseDouble(cantidad.getText());
        Fruta fruta = new Fruta(17, cant);
        if (cant > 0 && almacen.comprobarProductos(fruta)) {
            vendido.add(fruta);
            almacen.quitarProducto(fruta);
            Ticket ticket = new Ticket(new Cliente(nombre), fruta);
            a.setText("Venta realizada con exito.");
            ticket.imprimirTicket();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Datos invalidos, intente de nuevo");
            alert.showAndWait();
        }
    }

    private void venderGranos() {
        almacen = almacen.getInstance();
        String nombre = cliente.getText();
        for(int i = 0; i<nombre.length(); i++){
            if(nombre.charAt(i)>=48 && nombre.charAt(i)<=67){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Datos invalidos, intente de nuevo");
                alert.showAndWait();
            }

        }
        double cant = Double.parseDouble(cantidad.getText());
        Granos granos = new Granos(12, cant);
        if (cant > 0 && almacen.comprobarProductos(granos)) {
            vendido.add(granos);
            almacen.quitarProducto(granos);
            Ticket ticket = new Ticket(new Cliente(nombre), granos);
            a.setText("Venta realizada con exito.");
            ticket.imprimirTicket();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("Datos invalidos, intente de nuevo");
            alert.showAndWait();
        }

    }

    public static double totalVendido() {
        double vendido1 = 0;
        for (Producto p : vendido) {
            vendido1 = vendido1 + p.calcularPrecio();
        }
        return vendido1;
    }

    @FXML
    public void regresarMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        Node nodo = (Node) event.getSource();
        stage = (Stage) nodo.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        almacen = almacen.getInstance();
        mostrarCant.setText(almacen.informacionStock());
    }
}
