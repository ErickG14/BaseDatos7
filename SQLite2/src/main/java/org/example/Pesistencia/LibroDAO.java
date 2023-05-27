package org.example.Pesistencia;

import org.example.Modelo.Libro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LibroDAO implements InterfazDAO {

    public LibroDAO() {
    }

    @Override
    public boolean insetar(Object obj) throws SQLException {
        String sqlinsert = "INSERT INTO libros(Titulo,Autor) VALUES(?, ?) ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Librosdb3.db").getConnection().prepareStatement(sqlinsert);
        pstm.setString(1, ((Libro) obj).getTitulo());
        pstm.setString(2, ((Libro) obj).getAutor());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlupdate = "UPDATE libros SET Titulo = ?, Autor= ? WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Librosdb3.db").getConnection().prepareStatement(sqlupdate);
        pstm.setString(1, ((Libro) obj).getTitulo());
        pstm.setString(2, ((Libro) obj).getAutor());
        pstm.setInt(3, ((Libro) obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;

    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM libros WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("LibrosDB3.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenertodo() throws SQLException {
        String sql = "SELECT * FROM libros";
        ArrayList<Libro> resultado = new ArrayList<>();

            Statement stm = ConexionSingleton.getInstance("LibroDB3.db").getConnection().createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()) {
                resultado.add(new Libro(rst.getInt(1), rst.getString(2), rst.getString(3)));
            }
        return resultado;


    }

    @Override
    public Object buscarporid(String id) throws SQLException {
        String sql = "SELECT * FROM libros WHERE id = ? ";
        Libro libro = null;

        PreparedStatement pstm = ConexionSingleton.getInstance("LibrosDB3.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            libro = new Libro(rst.getInt(1), rst.getString(2), rst.getString(3));


            return libro;

        }
        return null;
    }
}
