package org.example.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoLibroDB {

    public DemoLibroDB() {
    }

    public void insertarStatement(){
       String elTiluto = "Arrancame la vida";
       String elAutor = "ángeles Matreta";
    try{
        Statement stm = ConexionSingleton.getInstance("LibrosDB.db").getConnection().createStatement();
        String sqlInsert = "INSERT INTO libros(titulo,autor) VALUES ('"+ elTiluto +"', '"+ elAutor +"')";
        int rowCount = stm.executeUpdate(sqlInsert);
        System.out.println("Se insertaron" + rowCount + "registros");

    }catch (SQLException sqle){
        System.out.println("Error al conectar"+ sqle.getMessage());
    }

    }
    public void insertarPreparedStatement(){
        String elTiluto = "El principito";
        String elAutor = "No me acuerdo";
        String sqlInsert = "INSERT INTO libros(titulo,autor) VALUES(?,?)";
        try{
            PreparedStatement pstm= ConexionSingleton.getInstance("librosDB.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1,elTiluto);
            pstm.setString(2, elAutor);
            int rowCount = pstm.executeUpdate();
        }catch (SQLException sqle) {
            System.out.println("Error Prepared statement" + sqle.getMessage());
        }
        }

    }

