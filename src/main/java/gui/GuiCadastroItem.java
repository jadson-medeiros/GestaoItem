/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ItemDao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Item;

/**
 *
 * @author rodrigo.ribeiro
 */

@Named(value = "guiCadastroItem")
@SessionScoped
public class GuiCadastroItem implements Serializable 
{   
/**
 * Creates a new instance of GuiCadastroItem
*/    
    @EJB
    ItemDao daoItem;
    
    private List<Item> itens;
    private Item item  = new Item();
    
    private Long id;
    private String idf;
    private String nome;
    private Integer quantidade;
    private String descricao;

    public GuiCadastroItem() 
    {
    }   

    public void addItem()
    {
      //  if(incluindo)
        //{
            daoItem.add(item);
        //} 
       // else
        //{
        //    daoItem.update(item);
        //}
             
        // return "./CadastroItem.xhtml";
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdf() {
        return idf;
    }

    public void setIdf(String idf) {
        this.idf = idf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
