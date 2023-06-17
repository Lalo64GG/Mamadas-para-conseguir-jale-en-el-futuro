package com.example.proyectoedac1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.util.TreeSet;

public class agregar {
    @FXML
    private TextField nombreField;
    @FXML
    private TextField codigoField;
    @FXML
    private TextField precioField;
    @FXML
    private TextField existenciaField;
    private Stage stage;
    private Scene scene;
    private Parent root;


    private TreeSet<Producto> inventario = almacen.getInstance().getInventario();

    @FXML
    void agregarProducto(ActionEvent event) {
        String codigo = codigoField.getText();
        String nombre = nombreField.getText();
        String existenciaText = existenciaField.getText();
        String precioText = precioField.getText();

        // Validar que todos los campos estén llenos
        if (codigo.isEmpty() || nombre.isEmpty() || existenciaText.isEmpty() || precioText.isEmpty()) {
            mostrarAlerta("Error", "Necesitas llenar todos los campos.");
            return;
        }

        // Validar que la cantidad ingresada sea mayor a 0
        int cantidad;
        try {
            cantidad = Integer.parseInt(existenciaText);
            if (cantidad <= 0) {
                mostrarAlerta("Error", "La cantidad debe ser mayor a 0.");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "La cantidad debe ser un número válido.");
            return;
        }

        // Validar que el precio ingresado sea válido
        double precio;
        try {
            precio = Double.parseDouble(precioText);
            if (precio <= 0) {
                mostrarAlerta("Error", "El precio debe ser mayor a 0.");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El precio debe ser un número válido.");
            return;
        }

        Producto productoExistente = null;

        for (Producto producto : inventario) {
            if (producto.getCodigo().equals(codigo)) {
                productoExistente = producto;
                break;
            }
        }

        if (productoExistente != null) {
            int nuevaCantidad = productoExistente.getCantidad() + cantidad;
            productoExistente.setCantidad(nuevaCantidad);
            mostrarAlerta("Información", "El producto ya está registrado. Se ha actualizado la cantidad en existencia.");
        } else {
            Producto productoNuevo = new Producto(codigo, nombre, cantidad, precio);
            inventario.add(productoNuevo);
            mostrarAlerta("Información", "El producto se ha registrado correctamente.");
        }

        // Guardar los datos actualizados en el archivo
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
