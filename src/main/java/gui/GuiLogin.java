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
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Usuario;

/**
 *
 * @author jadson
 */
@Named(value = "guiLogin")
@SessionScoped
public class GuiLogin implements Serializable 
{
    /**
     * Creates a new instance of GuiLogin
     */    
    @EJB
    UsuarioDao daoUsuario;
    
    private String usuario;    
    private String senha; 
    
    public GuiLogin() 
    {
    }
    
    public String logar()
    {
        Usuario usuario = daoUsuario.getUsuario(this.usuario);
        if (usuario.getSenha().equals(encrypt(this.usuario, this.senha))) 
            return "./Cadastro.xhtml";
        
        mostrarMensagem("login ou senha invalida");
        
        return "";
    }
    
    public void mostrarMensagem(String mensagem) 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage();
        message.setDetail(mensagem);
        message.setSummary("");
        context.addMessage(null, message);
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