/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.GrupoDao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Componente;
import model.Grupo;
import model.Modalidade;

/**
 *
 * @author jadson
 */

@Named(value = "guiCadastroGrupo")
@SessionScoped
public class GuiCadastroGrupo implements Serializable 
{
/**
 * Creates a new instance of GuiCadastroGrupo
*/
    @EJB
    GrupoDao daoGrupo;
    
    private Grupo grupo;
    private Long id;
    
    private String nome;
    
    private List<Modalidade> modalidades;
    
    private Modalidade modalidade  = new Modalidade();
    
    public GuiCadastroGrupo() 
    {
    }   

    public void addGrupo()
    {
        this.grupo = new Grupo();
        this.grupo.setNome(this.nome);        
        this.grupo.setModalidade(modalidade);
        
        daoGrupo.add(grupo);
    }


    public GrupoDao getDaoGrupo()
    {
        return daoGrupo;
    }

    public void setDaoGrupo(GrupoDao daoGrupo) 
    {
        this.daoGrupo = daoGrupo;
    }

    public Grupo getGrupo() 
    {
        return grupo;
    }

    public void setGrupo(Grupo grupo) 
    {
        this.grupo = grupo;
    }
    
    public List<Modalidade> getModalidades() 
    {
        return modalidades;
    }

    public void setModalidades(List<Modalidade> modalidades) 
    {
        this.modalidades = modalidades;
    }

    public Modalidade getModalidade() 
    {
        return modalidade;
    }

    public void setModalidade(Modalidade Modalidade) 
    {
        this.modalidade = Modalidade;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }
}
