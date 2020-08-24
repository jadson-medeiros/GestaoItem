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

    public void addUsuario()
    {
        usuario.setSenha(encrypt(usuario.getUsuario(), usuario.getSenha()));
        daoUsuario.add(usuario);
    }
     
    public String encrypt(String login, String senha) 
    {
        String sign = senha;
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.update(sign.getBytes());
            byte[] hash = md.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) 
            {
                if ((0xff & hash[i]) < 0x10) 
                {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
            
            sign = hexString.toString();
        } catch (Exception nsae) {
            nsae.printStackTrace();
        }
        
        return sign;
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
