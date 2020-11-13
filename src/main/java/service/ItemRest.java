/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GrupoDao;
import dao.ItemDao;
import dao.UnidadeDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Grupo;
import model.Item;
import model.Unidade;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author jadson
 */

@Stateless
@Path("item")
public class ItemRest  
{    
    @EJB
    ItemDao daoItem;
       
    @EJB
    GrupoDao daoGrupo;
    
    @EJB
    UnidadeDao daoUnidade;
    
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)  
    public Response addItem(String res) 
    {        
        JSONObject response = new JSONObject(res);
        Integer grupoId = Integer.parseInt(response.getString("grupoId"));
        Integer idUnidade = Integer.parseInt(response.getString("idUnidade"));
        
        String nome = response.getString("nome");
        String descricao = response.getString("descricao");
        String codComprasNet = response.getString("codComprasNet");
        
        if (grupoId != null || grupoId != 0)
        {
            Grupo grupo = daoGrupo.getGrupoById(grupoId);            
            List<Unidade> unidades = daoUnidade.getAllUnidades();
            Item item = new Item();
            for(Unidade u : unidades)
            {
                if(u.getId().equals(idUnidade)) 
                {
                    item.setUnidade(u);
                }
            }
            
            item.setNome(nome);
            item.setDescricao(descricao);
            item.setCodigoComprasnet(codComprasNet);
            item.setGrupo(grupo);
            daoItem.add(item);

            response.put("token", "200");
            response.put("message", "Item criado.");
            return Response.status(200).entity(response.toString()).build();            
        }
       
        response.put("token", "404");
        response.put("message", "Error ao criar o Item.");
        return Response.status(404).entity(response.toString()).build();
    }    
}