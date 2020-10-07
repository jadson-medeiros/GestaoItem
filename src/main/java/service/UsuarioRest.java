/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UsuarioDao;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.ws.rs.Consumes;
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

@Named
@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRest {
    
    @EJB
    UsuarioDao daoUsuario;
        
    @POST
    @Path("auth")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Response validarLogin(@PathParam("usuario") String user, @PathParam("password") String password) 
    {        
        JSONObject response = new JSONObject();
        Usuario usuario = daoUsuario.getUsuario(user);
        
        if(usuario == null){
            response.put("token", "404");
            return Response.status(404).entity(response.toString()).build();
        }
        
        if (usuario.getSenha().equals(encrypt(user, password))) {
            response.put("token", "200");
            response.put("nome", usuario.getNome());
            response.put("user", usuario.getUsuario());
            return Response.status(200).entity(response.toString()).build();
        }
       
        response.put("token", "404");
        return Response.status(404).entity(response.toString()).build();
    }
    
    private String encrypt(String login, String senha) 
    {
        String sign = senha;
        try {
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
        } catch (Exception nsae) {
            nsae.printStackTrace();
        }
        
        return sign;
    }    
}
