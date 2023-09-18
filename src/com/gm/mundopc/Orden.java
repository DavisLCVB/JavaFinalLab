package com.gm.mundopc;

import javax.swing.*;
import java.util.Scanner;

public class Orden {
    private int idOrden;
    private Computadora[] computadoras;
    private static int contadorOrdenes;
    private int contadorComputadoras;
    private static final int MAX_COMPUTADORAS = 10;

    public Orden() {
        computadoras = new Computadora[Orden.MAX_COMPUTADORAS];
        this.idOrden = ++Orden.contadorOrdenes;
    }

    public void agregarComputadoras() {
        var computadora = llenarDatos();
        computadoras[contadorComputadoras] = computadora;
    }

    public void mostrarOrden() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("\t.:Orden #").append(idOrden).append(":.\n");
        buffer.append("Cantidad de computadoras: ").append(contadorComputadoras).append("\n");
        for (var computadora : computadoras) {
            buffer.append("Computadora:\n").append(computadora.toString());
            buffer.append("\n");
        }
        buffer.append("----------------------------------------------------------");
        System.out.println(buffer);
    }

    public Computadora llenarDatos() {
        System.out.println("Ingrese los datos de la computadora:");
        System.out.print("Nombre: ");
        var nombre = new Scanner(System.in).nextLine();
        System.out.print("Marca del monitor: ");
        var marcaMonitor = new Scanner(System.in).nextLine();
        System.out.print("Tamaño del monitor: ");
        var sizeMonitor = Double.parseDouble(new Scanner(System.in).nextLine());
        System.out.print("Marca del mouse: ");
        var marcaMouse = new Scanner(System.in).nextLine();
        var tipoDeMouse = "Inalámbrico";
        System.out.print("Marca del teclado: ");
        var marcaTeclado = new Scanner(System.in).nextLine();
        var tipoDeTeclado = "Alámbrico";
        var mouse = new Mouse(tipoDeMouse, marcaMouse);
        var teclado = new Teclado(tipoDeTeclado, marcaTeclado);
        var monitor = new Monitor(marcaMonitor, sizeMonitor);
        return new Computadora(nombre, monitor, teclado, mouse);
    }

    public void menu() {
        int option;
        do {
            System.out.println("\t.:Orden de Computadoras:.");
            System.out.println("1. Agregar Computadora");
            System.out.println("2. Mostrar orden");
            System.out.print("Ingresa una opción:\n>>");
            option = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (option) {
                case 1 -> agregarComputadoras();
                case 2 -> mostrarOrden();
                default -> {
                    break;
                }
            }
        } while (option != 3);

    }
}
