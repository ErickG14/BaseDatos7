package org.example.Pesistencia;

import org.example.Modelo.Libro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DemoLibroDB {
    public DemoLibroDB() {
    }

    public void InsertarStatement() {
        String elTitulo = "Arrancame la vida";
        String elAutor = "Angeles Matreta";

        try {
            Statement stm = ConexionSingleton.getInstance("LibrosDB3.db").getConnection().createStatement();
            String sqlInsert = "INSERT INTO libros(Titulo,Autor) VALUES ('" + elTitulo + "' , '" + elAutor + "')";
            int rowCount = stm.executeUpdate(sqlInsert);
            System.out.println("Se insertoron " + rowCount + " registros");

        } catch (SQLException sqle) {
            System.out.println("Error al conectar " + sqle.getMessage());
        }

    }

    public void insertarPreparedStatement() {
        String elTitulo = "El principito";
        String elAutor = "Antoine";
        String sqlinsert = "INSERT INTO libros(Titulo,Autor) VALUES(?, ?) ";

        try {
            PreparedStatement pstm = ConexionSingleton.getInstance("Librosdb3.db").getConnection().prepareStatement(sqlinsert);
            pstm.setString(1, elTitulo);
            pstm.setString(2, elAutor);
            int rowCount = pstm.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Error prepared statement " + sqle.getMessage());
        }


    }

    public boolean insertaLibro(Libro libro) {
        String sqlinsert = "INSERT INTO libros(Titulo,Autor) VALUES(?, ?) ";
        int rowCount = 0;

        try {
            PreparedStatement pstm = ConexionSingleton.getInstance("Librosdb3.db").getConnection().prepareStatement(sqlinsert);
            pstm.setString(1, libro.getTitulo());
            pstm.setString(2, libro.getAutor());
            rowCount = pstm.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Error prepared statement " + sqle.getMessage());
        }
        return rowCount > 0;
    }

    public Libro buscarLibroid(int id) {
        String sql = "SELECT * FROM libros WHERE id = ? ";
        Libro libro = null;
        try {
            PreparedStatement pstm = ConexionSingleton.getInstance("LibrosDB3.db").getConnection().prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rst = pstm.executeQuery();
            if (rst.next()) {
                libro = new Libro(rst.getInt(1), rst.getString(2), rst.getString(3));

            }
        } catch (SQLException sqle) {
            System.out.println("Error al buscar");
        }
        return libro;
    }

    public ArrayList<Libro> obtenertodos(){
        String sql = "SELECT * FROM libros";
        ArrayList<Libro> resultado = new ArrayList<>();
        try {
            Statement stm = ConexionSingleton.getInstance("LibroDB3.db").getConnection().createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()){
                resultado.add(new Libro(rst.getInt(1),rst.getString(2),rst.getString(3)));
            }

        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
}







