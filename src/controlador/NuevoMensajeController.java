/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.MensajeDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import modelo.Mensaje;
import vista.BandejaEntrada;
import vista.NuevoMensaje;

/**
 *
 * @author Ricardo
 */
public class NuevoMensajeController implements ActionListener {

    private NuevoMensaje nv;
    private BandejaEntrada be;
    private ArrayList<Usuario> listaUsuarios;
   
    

    public NuevoMensajeController(NuevoMensaje nv) {
        this.nv = nv;
        rellenarJComboxDestinatario();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      String comando = e.getActionCommand();
      
        if (comando == "enviarMensaje") {
            registrarMensaje();
        }else{
            if (comando=="cerrar") {
                nv.dispose();
            }
        }
    }

    public void rellenarJComboxDestinatario() {

        UsuarioDAO u = new UsuarioDAO();
        listaUsuarios = u.getUsuarios();

        for (int i = 0; i < listaUsuarios.size(); i++) {
            String nombre = listaUsuarios.get(i).getNombre();

            nv.getDestinatarioCB().addItem(nombre);
        }
    }
    
    public void registrarMensaje(){
     Mensaje nuevoMensaje;  
     MensajeDAO m = new MensajeDAO();
        
     String contenido= nv.getCuerpoMensajeTA().getText();
     String receptor = nv.getDestinatarioCB().getSelectedItem().toString();
     
     int emisor = be.idUsuarioLogueado;
   
     
   
    
             
             
     
     
     
    }

}
