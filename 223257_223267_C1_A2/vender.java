package com.example.proyectoedac1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class vender{
    @FXML
    private TextField codigoField;
    @FXML
    private TextField cantidadField;
    almacen inventario;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void venderProducto(ActionEvent event) throws IOException {
        inventario = almacen.getInstance();
        String codigo = codigoField.getText();
        String cantidadText = cantidadField.getText();

        // Validar que se haya ingresado un código y una cantidad
        if (codigo.isEmpty() || cantidadText.isEmpty()) {
            mostrarAlerta("Error", "Necesitas llenar todos los campos.");
            return;
        }

        // Validar que la cantidad ingresada sea mayor a 0
        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadText);
            if (cantidad <= 0) {
                mostrarAlerta("Error", "La cantidad debe ser mayor a 0.");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "La cantidad debe ser un número válido.");
            return;
        }

        Producto productoEncontrado = null;
        for (Producto producto : inventario.getInventario()) {
            if (producto.getCodigo().equals(codigo)) {
                productoEncontrado = producto;
                break;
            }
        }

        if (productoEncontrado != null) {
            int stockDisponible = productoEncontrado.getCantidad();
            if (cantidad > stockDisponible) {
                mostrarAlerta("Error", "No hay suficiente stock disponible.");
                return;
            }

            int nuevaCantidad = stockDisponible - cantidad;
            if (nuevaCantidad <= 0) {
                inventario.getInventario().remove(productoEncontrado);
                mostrarAlerta("Información", "Producto vendido exitosamente. Ya no hay stock disponible.");
            } else {
                productoEncontrado.setCantidad(nuevaCantidad);
                mostrarAlerta("Información", "Producto vendido exitosamente. Stock actualizado.");
            }
        } else {
            mostrarAlerta("Error", "Producto no encontrado en el inventario.");
        }

        almacen.getInstance().guardarDatosEnArchivo("C:\\Users\\et059\\OneDrive\\Escritorio\\ProductosEDA\\Productos.txt");
    }

    void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    public void regresarMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Node nodo = (Node) event.getSource();
        stage = (Stage) nodo.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
