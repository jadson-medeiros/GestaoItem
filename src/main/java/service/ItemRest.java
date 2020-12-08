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
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Grupo;
import model.Item;

/**
 *
 * @author jadson
 */

@Stateless
@Path("item")
@Named
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)  
public class ItemRest  
{    
    @EJB
    GrupoDao daoGrupo;
    
    @GET
    @Path("{grupoId}")
    public List<Item> ItemByGrupoId(@PathParam("grupoId")Integer grupoId) 
    {        
        Grupo grupo = daoGrupo.getGrupoById(grupoId);
        return daoGrupo.getItens(grupo);
    }    
}