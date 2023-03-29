package com.example.poointerfaz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private static int contadorTickets = 0;
    private Cliente cliente;
    private Producto producto;
    private int numeroTicket;

    public Ticket(Cliente cliente, Producto producto) {
        this.cliente = cliente;
        this.producto = producto;
        this.numeroTicket = ++contadorTickets;
    }

    public void imprimirTicket() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        int dia = fechaHoraActual.getDayOfMonth();
        int mes = fechaHoraActual.getMonthValue();
        int hora = fechaHoraActual.getHour();
        int minutos = fechaHoraActual.getMinute();


        String informacion = "**********************************\n"
                + "\t\t Ticket \t\t \n"
                + "Nombre del que adquirio el producto: " + cliente.getNombre() + "\n"
                + "Adquirio: " + ((producto instanceof Granos) ? "grano " : "fruta") + "\n"
                + producto.verInformacion() + "\n"
                + "**********************************\n"
                + "Fecha y hora de emisión: " + dia + " de " + obtenerNombreMes(mes) + " a las " + hora + ":" + minutos + " horas.";

        try {
            File archivo = new File("C:\\Users\\et059\\OneDrive\\Escritorio\\Tickets\\ticket_" + numeroTicket + ".txt");
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(informacion);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String obtenerNombreMes(int numeroMes) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM");
        return formatter.format(LocalDateTime.of(2022, numeroMes, 1, 0, 0));
    }
}
