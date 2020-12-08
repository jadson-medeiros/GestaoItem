/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
        if (grupo.getNome() != null)
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
    
    public List<Grupo> getAllGrupos() 
    {
        Query q = em.createQuery("select g from Grupo g where g.nome is not null order by g.nome");
        return q.getResultList();
    }  
    
    public Grupo getGrupo(Grupo grupo) 
    {
        Query q = em.createQuery("select g from Grupo g where g.id = :id");
        q.setParameter("id", grupo.getId());
        return (Grupo) q.getSingleResult();        
    } 
    
    public Grupo getGrupoById(Integer grupoId) 
    {
        Query q = em.createQuery("select g from Grupo g where g.id = :id");
        q.setParameter("id", grupoId);
        return (Grupo) q.getSingleResult();        
    } 
    
    public EntityManager getEm()
    {
        
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
    
    public List<Item> getItensByGrupoId(Long grupoId)
    {
        Query q = em.createQuery("select i from Item i where i.grupo.id = :id");
        q.setParameter("id", grupoId);
        return q.getResultList();
    }
}
