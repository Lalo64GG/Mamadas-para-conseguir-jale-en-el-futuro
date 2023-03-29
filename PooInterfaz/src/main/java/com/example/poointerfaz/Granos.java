package com.example.poointerfaz;
public class Granos extends Producto {
    private double kilos;

    public Granos(double precio, double _kilos){
        super(precio);
        this.kilos = _kilos;
    }

    public double getPrecio(){
        return precio;
    }

    public double getkilos(){
        return this.kilos;
    }

    public double calcularPrecio() {
        double precioBase = precio;
        double precioFinal;
        double des = 0;

        if (kilos >= 10) {
            des = 0.1;
        }
        precioFinal = precioBase * kilos * (1 - des);
        return precioFinal;
    }

    public boolean comprobrarunidadVacia(){
        return kilos <= 0;
    }

    public void quitar(double i){
        this.kilos = this.kilos -i;
    }

    @Override
    public String verInformacion(){
        return "Kilos " + kilos + "\nprecio total: " + calcularPrecio();
    }
}

