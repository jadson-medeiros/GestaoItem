/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GrupoDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Componente;
import model.Grupo;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author jadson
 */

@Stateless
@Path("grupo")
public class GrupoRest  
{    
    @EJB
    GrupoDao daoGrupo;
        
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)  
    public Response addGrupo(String res) 
    {        
        JSONObject response = new JSONObject(res);
        String nome = response.getString("nome");
        
        if (nome != null || nome != "")
        {
            Grupo grupo = new Grupo();
            grupo.setNome(nome);
            daoGrupo.add(grupo);
            
            response.put("token", "200");
            response.put("message", "Grupo criado.");
            return Response.status(200).entity(response.toString()).build();
        } 
        
        response.put("token", "404");
        response.put("message", "Error ao criar o Grupo.");
        return Response.status(404).entity(response.toString()).build();
    }    
    
    @GET
    @Path("grupos")
    @Consumes(MediaType.APPLICATION_JSON)  
    public Response getGrupos() 
    {                
        List<Grupo> grupoList = daoGrupo.getAllGrupos();
        List<Grupo> newGrupoList = daoGrupo.getAllGrupos();
        
        for (Grupo g : grupoList)
        {
            if(g.getComponentes().size() > 0)
            {
                for (Componente c : g.getComponentes())
                {
                    if(newGrupoList.contains(c)) newGrupoList.remove(c);
                }
            }             
        }
                
        JSONObject response = new JSONObject();
        response.put("grupos", newGrupoList);
        response.put("token", "200");
        return Response.status(200).entity(response.toString()).build();
    } 
}