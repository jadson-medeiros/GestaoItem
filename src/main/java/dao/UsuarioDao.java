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

/**
 *
 * @author rodrigo.ribeiro
 */

@Stateless
public class UsuarioDao 
{
    @PersistenceContext
    EntityManager em;
    
    public void add(Usuario usuario) 
    {
        System.out.println(usuario);
        em.persist(usuario);
    }
    
    public void update(Usuario usuario)
    {
        em.merge(usuario);
    }
    
    public void remove(Usuario usuario) 
    {
        em.remove(usuario);
    }
    
    public List<Usuario> getAllUsuarios() 
    {
        Query q = em.createQuery("select u from Usuario u order by u.nome");
        return q.getResultList();
    }  
    
    public Usuario getUsuario(String usuario) 
    {
        Query q = em.createQuery("select u from Usuario u where u.usuario = :usuario");
        q.setParameter("usuario", usuario);
        return (Usuario) q.getSingleResult();
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
