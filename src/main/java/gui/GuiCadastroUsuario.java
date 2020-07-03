/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.UsuarioDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.TipoUsuarioENUM;
import model.Usuario;

/**
 *
 * @author rodrigo.ribeiro
 */
@Named(value = "guiCadastroUsuario")
@SessionScoped
public class GuiCadastroUsuario implements Serializable 
{
    /**
     * Creates a new instance of GuiCadastroUsuario
     */    
    @EJB
    UsuarioDao daoUsuario;
    
    private List<Usuario> usuarios;
    private Usuario usuario  = new Usuario();
    private Boolean incluindo;
    private TipoUsuarioENUM  tipoUsuarioENUM;

    public GuiCadastroUsuario() 
    {
    }  

    public UsuarioDao getDaoUsuario()
    {
        return daoUsuario;
    }

    public void setDaoUsuario(UsuarioDao daoUsuario) 
    {
        this.daoUsuario = daoUsuario;
    }
    
    public TipoUsuarioENUM[] getTiposUsuarioENUM() 
    {
        return TipoUsuarioENUM.values();
    }

    public TipoUsuarioENUM getTipoUsuarioENUM() 
    {
        return tipoUsuarioENUM;
    }

    public void setTipoUsuarioENUM(TipoUsuarioENUM tipoUsuarioENUM) 
    {
        this.tipoUsuarioENUM = tipoUsuarioENUM;
    }

    public void addUsuario()
    {
      //  if(incluindo)
        //{
            daoUsuario.add(usuario);
        //} 
       // else
        //{
        //    daoUsuario.update(usuario);
        //}
             
        // return "./Cadastro.xhtml";
    }
     
    public List<Usuario> getUsuarios() 
    {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) 
    {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario) 
    {
        this.usuario = usuario;
    }

    public Boolean getIncluindo() 
    {
        return incluindo;
    }

    public void setIncluindo(Boolean incluindo)
    {
        this.incluindo = incluindo;
    }       
}
