package com.example.proyectoedac1;

import java.util.Objects;

public class Producto implements Comparable<Producto> {
    // Resto del código de la clase Producto



    private String codigo;
    private String nombre;
    private double precio;

    private int cantidad;

    public Producto(String _codigo, String _nombre, int _cantidad, double _precio) {
        this.codigo = _codigo;
        this.nombre = _nombre;
        this.precio = _precio;
        this.cantidad = _cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    @Override
    public int compareTo(Producto otroProducto) {
        return this.codigo.compareTo(otroProducto.getCodigo());
    }
}
