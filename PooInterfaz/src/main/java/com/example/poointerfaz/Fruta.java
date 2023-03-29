package com.example.poointerfaz;
public class Fruta extends Producto{
    private  double unidad;

    public Fruta(double precio, double _unidad){
        super(precio);
        this.unidad=_unidad;
    }

    public double calcularPrecio(){
        return precio *unidad;
    }

    public double getUnidad(){
        return unidad;
    }

    public boolean comprobrarunidadVacia(){
        return unidad <=0;
    }

    public void quitar(double i){
        this.unidad = this.unidad -i;
    }

    @Override
    public String verInformacion(){
        return "Unidades " + unidad + "\nprecio total: " +calcularPrecio();
    }
}

