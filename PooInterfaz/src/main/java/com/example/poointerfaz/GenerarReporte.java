package com.example.poointerfaz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class GenerarReporte {
    @FXML
    private Button salir;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextArea text;
    static Almacen almacen;
    public void imprimirReporte(){

        almacen = almacen.getInstance();
        double ganancia =  Venta.totalVendido() - almacen.getInvertido();
        String texto = "*********************************************** \n" + " \t\t\t\tReporte\t\t\t\t \n" + "*********************************************** \n" + "Cantidad de dinero invertido: " + almacen.getInvertido() +"\n" + "Total vendido: " + Venta.totalVendido() + "\n" + "Hubo ganancias: " + ((ganancia > 0) ? "si":"No \n" + "Cuanto fue la ganancia invertida: " + ((ganancia > 0) ? ganancia: (ganancia < 0) ? " " : "se desea recuperarar \n" + (ganancia * -1))) + "\n" + "***********************************************";
        text.setText(texto);
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
}
