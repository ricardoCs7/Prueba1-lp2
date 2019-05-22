/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import vista.NuevoMensaje;

/**
 *
 * @author Ricardo
 */
public class MensajeDAO {

    Conexion con;
    NuevoMensaje nm;

    public MensajeDAO() {
        this.con = new Conexion();
    }

    public boolean registrarMensaje(Mensaje nuevoMensaje) throws SQLException {
        Connection accesoBD = con.getConexion();

        //    CUERPO MENSAJE Mensaje(int id_mensaje, Usuario emisor, Usuario receptor, String contenido) {
        // CREATE TABLE `mensaje` (
        //  `id_mensaje` int(10) NOT NULL,
        //  `contenido` varchar(500) DEFAULT NULL,
        //  `id_usr_emisor` int(10) NOT NULL,
        //  `id_usr_receptor` int(10) NOT NULL
        String contenido = nuevoMensaje.getContenido();
        Usuario emisor = nuevoMensaje.getEmisor();
        Usuario receptor = nuevoMensaje.getReceptor();
    

        try {
            String sql = "INSERT INTO mensaje (id_mensaje,contenido, id_usr_emisor, id_usr_receptor)"
                    + " VALUES (NULL, '" + contenido + "', '" + emisor+ "', '" + receptor+"')";

            //ejemplo: SELECT * FROM Customers WHERE Country='Mexico'; 
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();

            st.executeUpdate(sql);
            System.out.println("Mensaje  registrado con exito en la DB");
            accesoBD.close();
            return true;

        } catch (Exception e) {
            System.out.println("Error al registrar mensaje en la DB");
            accesoBD.close();
            return false;
        }

    }

}
