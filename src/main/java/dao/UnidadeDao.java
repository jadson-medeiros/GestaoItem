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
import model.Unidade;

/**
 *
 * @author jadson
 */

@Stateless
public class UnidadeDao 
{
    @PersistenceContext
    EntityManager em;
    
    public void add(Unidade unidade) 
    {
        em.persist(unidade);
    }
    
    public void update(Unidade unidade)
    {
        em.merge(unidade);
    }
    
    public void remove(Unidade unidade) 
    {
        em.remove(unidade);
    }
    
    public List<Unidade> getAllUnidades() 
    {
        Query q = em.createQuery("select u from Unidade u order by u.nome");
        return q.getResultList();
    }    

    public EntityManager getEm() 
    {
        return em;
    }

    public void setEm(EntityManager em) 
    {
        this.em = em;
    }
}
