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
import model.Item;

/**
 *
 * @author rodrigo.ribeiro
 */

@Stateless
public class ItemDao 
{
    @PersistenceContext
    EntityManager em;
    
    public void add(Item item) 
    {
        if (item.getNome() != null)
            em.persist(item);
    }
    
    public void update(Item item)
    {
        em.merge(item);
    }
    
    public void remove(Item item) 
    {
        em.remove(em.merge(item));
    }
    
    public List<Item> getAllItem() 
    {
        Query q = em.createQuery("select u from Item u order by u.nome");
        return q.getResultList();
    }    

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }   
}
