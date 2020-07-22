/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ItemDao;
import dao.UnidadeDao;
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
    
    @EJB
    UnidadeDao daoUnidade;
    
    private List<Item> itens;
    private Item item  = new Item();
 
    public ItemDao getDaoItem() 
    {
        return daoItem;
    }

    public void setDaoItem(ItemDao daoItem) 
    {
        this.daoItem = daoItem;
    }

    public Item getItem() 
    {
        return item;
    }

    public void setItem(Item item) 
    {
        this.item = item;
    }

    public GuiCadastroItem() 
    {
    }   

    public void addItem()
    {
        daoItem.add(item);
    }

    public List<Item> getItens() 
    {
        return itens;
    }

    public void setItens(List<Item> itens)
    {
        this.itens = itens;
    }
}
