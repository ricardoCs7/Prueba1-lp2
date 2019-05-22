/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ricardo
 */
public class UsuarioDAO {

    Conexion con;

    public UsuarioDAO() {
        this.con = new Conexion();
    }

    public ArrayList<Usuario> getUsuarios() {
        Connection accesoBD = con.getConexion();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM usuario";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("id_usuario");
                String nombre = resultados.getString("nombre");
                Usuario u = new Usuario(id, nombre);
                usuarios.add(u);
            }
            accesoBD.close();
            return usuarios;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

    public Usuario getUsuarioByID(int id) {

        Connection accesoBD = con.getConexion();

        Usuario u = null;
        try {
            String sql = "SELECT * FROM cuenta WHERE usuario='" + id + "'";
            System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id = resultados.getInt("id_usuario");
                String nombre = resultados.getString("nombre");

            }
            accesoBD.close();
            return c;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }
