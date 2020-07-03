/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.inject.Named;

import java.io.Serializable;
import model.Item;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import org.primefaces.model.TreeNode;

/**
 *
 * @author jadson
 */
@Named(value = "guiListaItem")
@SessionScoped
public class GuiListaItem implements Serializable 
{
    /**
     * Creates a new instance of GuiListaItem
     */
    private TreeNode root;
     
    private Item selectedItem;
              
    @PostConstruct
    public void init() 
    {
        //root = service.createItens();
    }
 
    public TreeNode getRoot() 
    {
        return root;
    }
    
    public String addGrupo()
    {
        return "./CadastroGrupo.xhtml";
    }
     
    public String addItem()
    {
        return "./CadastroItem.xhtml";
    }
     
 
    public Item getSelectedItem() 
    {
        return selectedItem;
    }
 
    public void setSelectedItem(Item selectedItem) 
    {
        this.selectedItem = selectedItem;
    }
}
