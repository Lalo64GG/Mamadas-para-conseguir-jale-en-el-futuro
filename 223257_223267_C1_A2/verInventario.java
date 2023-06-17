package com.example.proyectoedac1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class verInventario implements Initializable {
    @FXML
    TextArea mostrarProductos;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void regresarMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Node nodo = (Node) event.getSource();
        stage = (Stage) nodo.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        almacen inventario = almacen.getInstance();
        for (Producto producto : inventario.getInventario()) {
            String linea = "Código: " + producto.getCodigo() + "\n" +
                    "Nombre: " + producto.getNombre() + "\n" +
                    "Cantidad: " + producto.getCantidad() + "\n" +
                    "Precio: " + producto.getPrecio() + "\n\n";
            mostrarProductos.appendText(linea);
        }
    }
}
