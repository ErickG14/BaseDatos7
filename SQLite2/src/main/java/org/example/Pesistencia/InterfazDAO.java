package org.example.Pesistencia;

import java.security.PublicKey;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfazDAO {


    public abstract boolean insetar(Object obj) throws SQLException;
    public abstract boolean update(Object obj) throws SQLException;
    public abstract boolean delete(String id) throws SQLException;
    public abstract ArrayList obtenertodo() throws SQLException;
    public abstract Object buscarporid(String id) throws SQLException;
}
