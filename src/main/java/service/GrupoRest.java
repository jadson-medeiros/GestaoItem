/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GrupoDao;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Componente;
import model.Grupo;

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
       
    @GET
    @Path("grupos")
    @Consumes(MediaType.APPLICATION_JSON)  
    public List<Grupo> getGrupos() 
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
                
        return newGrupoList;
    }  
    
    
    @GET
    @Path("grupos/{grupoId}")
    public List<Grupo> GrupoByGrupoId(@PathParam("grupoId")Integer grupoId) 
    {        
        Grupo grupo = daoGrupo.getGrupoById(grupoId);
        List<Grupo> gruposLista = new ArrayList();
        
        for(Componente c : grupo.getComponentes())
        {
            gruposLista.add((Grupo) c);
        }
        
        return gruposLista;
    }   
}