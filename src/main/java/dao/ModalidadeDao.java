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
import model.Modalidade;


/**
 *
 * @author jadson
 */

@Stateless
public class ModalidadeDao 
{
    @PersistenceContext
    EntityManager em;
    
    public void add(Modalidade modalidade) 
    {
        em.persist(modalidade);
    }
    
    public void update(Modalidade modalidade)
    {
        em.merge(modalidade);
    }
    
    public void remove(Modalidade modalidade) 
    {
        em.remove(modalidade);
    }
    
    public List<Modalidade> getAllModalidade() 
    {
        Query q = em.createQuery("select u from Modalidade u order by u.nome");
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
