/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import dao.GrupoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Grupo;

/**
 *
 * @author jadson
 */
@Named(value = "guiGrupo")
@SessionScoped
public class GuiGrupo implements Serializable 
{
    /**
     * Creates a new instance of GuiLogin
     */
    private String usuario;    
    private String senha; 
    private List<Grupo> grupos;
    private Grupo grupo;

    @EJB
    GrupoDao daoGrupo;
    
    public GuiGrupo() 
    {
        this.grupos = daoGrupo.getAllGrupo();
    }
      
    public Grupo getGrupo() 
    {
        return grupo;
    }

    public void setGrupo(Grupo grupo) 
    {
        this.grupo = grupo;
    }
    
    
    public List<Grupo> getGrupos()
    {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) 
    {
        this.grupos = grupos;
    }
    
  
    
    public String logar()
    {
        return "./Cadastro.xhtml";
    }
        
    public String getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }
    
    public String getSenha() 
    {
        return senha;
    }

    public void setSenha(String senha) 
    {
        this.senha = senha;
    }
}