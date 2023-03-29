package com.example.poointerfaz;

public abstract class Producto {
        protected  double precio;
        protected String nombreP;

        public Producto(double _precio){
            this.precio = _precio;
        }

        public abstract double calcularPrecio();

        public String verInformacion(){
            return "";
        }
}
