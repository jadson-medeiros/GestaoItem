/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Grupo;
import model.Item;


/**
 *
 * @author rodrigo.ribeiro
 */

@Stateless
public class GrupoDao 
{
    @PersistenceContext
    EntityManager em;
    
    public void add(Grupo grupo) 
    {
        em.persist(grupo);
    }
    
    public void update(Grupo grupo)
    {
        em.merge(grupo);
    }
    
    public void remove(Grupo grupo) 
    {
        em.remove(em.merge(grupo));
    }
    
    public List<Grupo> getAllGrupo() 
    {
        Query q = em.createQuery("select u from Grupo u order by u.nome");
        return q.getResultList();
    } 
    
    public List<Grupo> getAllGrupos() 
    {
        Query q = em.createQuery("select u from Grupo u  order by u.nome");
        return q.getResultList();
    }  
    public EntityManager getEm() {
        
        return em;
    }

    public void setEm(EntityManager em) 
    {
        this.em = em;
    }    
    
    public List<Item> getItens(Grupo grupo)
    {
        Query q = em.createQuery("select i from Item i where i.grupo.id = :id");
        q.setParameter("id", grupo.getId());
        return q.getResultList();
    }
}
