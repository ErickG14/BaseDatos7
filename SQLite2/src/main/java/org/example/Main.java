package org.example;

import org.example.Controlador.ControladorLibro;
import org.example.Modelo.Libro;
import org.example.Pesistencia.DemoLibroDB;
import org.example.Pesistencia.LibroDAO;
import org.example.Vista.VentanaLibro;

import java.sql.SQLException;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        VentanaLibro view = new VentanaLibro("MVC , JDMC");
        ControladorLibro controlador = new ControladorLibro(view);

    }
}