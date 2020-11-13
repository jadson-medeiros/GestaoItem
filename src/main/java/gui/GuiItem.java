/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import dao.ItemDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Item;

/**
 *
 * @author jadson
 */
@Named(value = "guiItem")
@SessionScoped
public class GuiItem implements Serializable 
{
    /**
     * Creates a new instance of GuiLogin
     */
    private List<Item> itens;
    private Item item;

    @EJB
    ItemDao daoItem;
    
    public GuiItem() 
    {
        //this.itens = daoItem.getAllItemByGrupoId(grupo.getId());
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemDao getDaoItem() {
        return daoItem;
    }

    public void setDaoItem(ItemDao daoItem) {
        this.daoItem = daoItem;
    }
      
   
}