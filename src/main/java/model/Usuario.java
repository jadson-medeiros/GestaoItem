/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jadson
 */

@Entity
public class Usuario implements Serializable  
{    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private TipoUsuarioENUM tipoUsuarioENUM;
    
    private String nome;
    private String sobreNome;
    private String usuario;
    private String senha;

    public TipoUsuarioENUM getTipoUsuarioENUM() 
    {
        return tipoUsuarioENUM;
    }

    public void setTipoUsuarioENUM(TipoUsuarioENUM tipoUsuarioENUM) 
    {
        this.tipoUsuarioENUM = tipoUsuarioENUM;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }
    
    public String getSenha() 
    {
        return senha;
    }

    public void setSenha(String senha) 
    {
        this.senha = senha;
    }  
    
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getSobreNome() 
    {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) 
    {
        this.sobreNome = sobreNome;
    }
    
     public TipoUsuarioENUM getTipo() 
     {
        return tipoUsuarioENUM;
    }

    public void setTipo(TipoUsuarioENUM tipoUsuarioENUM) 
    {
        this.tipoUsuarioENUM = tipoUsuarioENUM;
    }
    
    @Override
    public int hashCode() 
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) 
    {
        if (!(object instanceof Usuario))
        {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && 
                !this.id.equals(other.id))) 
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() 
    {
        return this.nome + " " + this.sobreNome;
    }
}
