package com.example.poointerfaz;
import java.util.ArrayList;

public class Almacen {
    private static Almacen instancia = null;
    private ArrayList<Producto> productos = new ArrayList<>();
    private double invertido = 0;


    public static Almacen getInstance() {
        if (instancia == null) {
            instancia = new Almacen();
        }
        return instancia;
    }

    private boolean validarUnidades(double unidad) {

        return unidad <= 0;
    }

    public void aniadirGranos(Granos granos) {
        if(!validarUnidades(granos.getkilos())){
            productos.add(granos);
            invertido = invertido + granos.calcularPrecio();
        }

    }

    public void aniadirFruta(Fruta frutas) {
        if(!validarUnidades(frutas.getUnidad())){
            productos.add(frutas);
            invertido = invertido + frutas.calcularPrecio();
        }

    }



    //comprobar solo frutas aplicacion del polimorfismo
    public boolean comprobarProductos(Fruta f){
        double cantidad = f.getUnidad();
        double cantidad2 = 0;
        for(int i = 0; i <productos.size();i++){
            if(productos.get(i) instanceof Fruta){
                Fruta fruta = (Fruta)productos.get(i);
                cantidad2 = cantidad2 + fruta.getUnidad();
            }

        }
        boolean bandera = cantidad2 >= cantidad;

        if(!bandera){
            System.out.println("la cantidad no es suficiente");
            System.out.println("la cantidad de fruta es" + cantidad2);
        }
        return bandera;
    }



    // Comprar para granos aplicacion del polimorfismo

    public boolean comprobarProductos(Granos g){
        double cantidad = g.getkilos();
        double cantidad2 = 0;
        for(int i = 0; i <productos.size();i++){
            if(productos.get(i) instanceof Granos){
                Granos granos= (Granos)productos.get(i);
                cantidad2 = cantidad2 + granos.getkilos();
            }

        }

        boolean bandera = cantidad2 >= cantidad;

        if(!bandera){
            System.out.println("la cantidad no es suficiente");
            System.out.println("la cantidad de kilos de grano es" + cantidad2);
        }
        return bandera;
    }


    //quitar productos de tipo frua
    public void quitarProducto(Fruta f) {
        double cantidad = f.getUnidad();
        double cantidad2 = 0;
        for(int i = 0; i <productos.size();i++){
            if(productos.get(i) instanceof Fruta){
                Fruta fruta = (Fruta)productos.get(i);

                while( cantidad2 < cantidad && !fruta.comprobrarunidadVacia()){
                    cantidad2++;
                    fruta.quitar(1);
                    if(fruta.comprobrarunidadVacia()){
                        productos.remove(i);
                        i--;
                    }
                }

            }

        }
    }



//quitar productos para granos aplicando el polimorfismo

    public void quitarProducto(Granos g) {
        double cantidad = g.getkilos();
        double cantidad2 = 0;
        for(int i = 0; i <productos.size();i++){
            if(productos.get(i) instanceof Granos){
                Granos granos = (Granos)productos.get(i);
                while( cantidad2 < cantidad && !granos.comprobrarunidadVacia()){
                    cantidad2++;
                    granos.quitar(1);
                    if(granos.comprobrarunidadVacia()){
                        productos.remove(i);
                        i--;
                    }
                }
            }
        }
    }

    public String informacionStock(){
        int canFruta = 0;
        int canGranos = 0;
        String informacion;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i) instanceof Fruta){
                canFruta = (int) (canFruta + ((Fruta) productos.get(i)).getUnidad());
            }else {
                canGranos = (int) (canGranos + ((Granos) productos.get(i)).getkilos());
            }
        }
        informacion = "Cantidad de frutas: " + canFruta + " Cantidad granos: " + canGranos;
        return informacion;
    }

    public double getInvertido(){
        return this.invertido;
    }




}
