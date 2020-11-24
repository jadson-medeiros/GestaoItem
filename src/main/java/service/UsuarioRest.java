/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UsuarioDao;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Usuario;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author jadson
 */

@Stateless
@Path("user")
@Named
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)    
public class UsuarioRest  {
    
    @EJB
    UsuarioDao daoUsuario;
        
    @GET
    @Path("auth/{email}/{password}")
    public Usuario validarLogin(@PathParam("email")String email, @PathParam("password")String senha) 
    {
        Usuario usuario = daoUsuario.getUsuario(email);
        
        if (usuario.getSenha().equals(encrypt(email, senha)))
        {
            return usuario;
        }
       return null;
    }
    
    private String encrypt(String login, String senha) 
    {
        String sign = senha;
        try
        {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(sign.getBytes());
            byte[] hash = md.digest();
            StringBuffer hexString = new StringBuffer();
            
            for (int i = 0; i < hash.length; i++) 
            {
                if ((0xff & hash[i]) < 0x10) 
                {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
            
            sign = hexString.toString();
        } catch (Exception nsae) 
        {
            nsae.printStackTrace();
        }
        
        return sign;
    }    
}