/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author acg
 */
@Entity
public class Grupo extends Componente implements Serializable 
{
    //@ManyToOne
    //private Modalidade modalidade;
    
    @OneToMany
    private List<Componente> componentes;

    // public Modalidade getModalidade() 
    // {
    //     return modalidade;
    // }

    // public void setModalidade(Modalidade modalidade) 
    // {
    //     this.modalidade = modalidade;
    // }

    public List<Componente> getComponentes() 
    {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes)
    {
        this.componentes = componentes;
    }
    
    public void addGrupo(Grupo grupo)
    {
        if(componentes == null) componentes = new ArrayList();
        
        componentes.add(grupo);
    }    
}