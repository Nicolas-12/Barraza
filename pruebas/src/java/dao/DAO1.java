/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Valentin
 */
public class DAO1 {
     private Connection cn;

    public void Conectar() throws Exception {       //Metodo con los datos de acceso
        try {
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prueba", "postgres", "admin");
        } catch (ClassNotFoundException | SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No hay conexcion a la base de datos"));
            throw e;
        }
    }

    public void Cerrar() throws SQLException {      //Cerrar la coneccion
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
            }
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public static void main(String[] args) throws Exception {
        DAO1 dao = new DAO1();
        dao.Conectar();
        if (dao.getCn() != null) {
            System.out.println("conectado");
        } else {
            System.out.println("error");
        }
    }
    
}
