package com.example.proyectoedac1;

import java.io.*;
import java.util.TreeSet;

public class almacen {

    //Utilizando Singleton para crear una sola instancia y pueda funcionar como un verdadero almacen
        private static almacen instancia;
        private TreeSet<Producto> inventario;

        private almacen() {
            inventario = new TreeSet<>();
        }

        public static synchronized almacen getInstance() {
            if (instancia == null) {
                instancia = new almacen();
            }
            return instancia;
        }

        public TreeSet<Producto> getInventario() {
            return inventario;
        }

        //Extraer dato del archivo txt que funciona como base de datos
        public almacen extraerArchivos() {
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\et059\\OneDrive\\Escritorio\\ProductosEDA\\Productos.txt"))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split("-");

                    String codigo = datos[0].trim();
                    String nombre = datos[1].trim();
                    int cantidad = Integer.parseInt(datos[2]);
                    double precio = Double.parseDouble(datos[3].trim());

                    inventario.add(new Producto(codigo, nombre, cantidad, precio));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    public void guardarDatosEnArchivo(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, false))) {
            for (Producto producto : inventario) {
                String linea = producto.getCodigo() + "-" + producto.getNombre() + "-" + producto.getCantidad() + "-" + producto.getPrecio();
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

