/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.GrupoDao;
import dao.ModalidadeDao;
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
    
    @EJB
    ModalidadeDao daoModalidade;
    
    private Grupo grupo = new Grupo();
    private Long id;
    
    private String nome;
        
    private Modalidade modalidade;
    
    public GuiCadastroGrupo() 
    {
    }   

    public void addGrupo()
    {        
        daoGrupo.add(grupo);
    }

    public ModalidadeDao getDaoModalidade() {
        return daoModalidade;
    }

    public void setDaoModalidade(ModalidadeDao daoModalidade) {
        this.daoModalidade = daoModalidade;
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
        return daoModalidade.getAllModalidade();
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
