package org.example.Controlador;

import org.example.Modelo.Libro;
import org.example.Modelo.ModeloTablaLibro;
import org.example.Vista.VentanaLibro;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorLibro extends MouseAdapter {

    private VentanaLibro view;
    private ModeloTablaLibro modelo;


    public ControladorLibro(VentanaLibro view){
        this.view = view;
        modelo = new ModeloTablaLibro();
        this.view.getTblLibro().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()){

            modelo.cargardatos();
            this.view.getTblLibro().setModel(modelo);
            this.view.getTblLibro().updateUI();
        }
        if (e.getSource() == this.view.getBtnAgregar()){
            Libro libro = new Libro();
            libro.setTitulo(this.view.getTxtiTitulo().getText());
            libro.setAutor(this.view.getTxtAutor().getText());
           if (modelo.agregarLibro(libro)){
               JOptionPane.showMessageDialog(view,"Se agrego correctamente", "AVISO",JOptionPane.INFORMATION_MESSAGE);
               this.view.getTblLibro().updateUI();
           }else {
               JOptionPane.showMessageDialog(view,"No se pudo agregar a la base de datos","Error al insertar",JOptionPane.ERROR_MESSAGE);

           }
           this.view.limpiar();

        }



    }

}

