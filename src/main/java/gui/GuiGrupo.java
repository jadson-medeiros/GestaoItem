/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import dao.GrupoDao;
import dao.ItemDao;
import dao.ModalidadeDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Componente;
import model.Grupo;
import model.Item;
import model.Modalidade;

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
    private List<Item> itens;
    private Grupo grupo;

    @EJB
    GrupoDao daoGrupo;
    
//#region Itens from GuiCadastroGrupo    
    @EJB
    ModalidadeDao daoModalidade;
    
    //private Grupo grupo = new Grupo();
    private Long id;
    
    private Long idModalidade;

    private String nome;
        
    private Modalidade modalidade;

    public void addGrupo()
    {        
        List<Modalidade> modalidades = daoModalidade.getAllModalidade();
        System.out.println(idModalidade);
        for(Modalidade m : modalidades){
            System.out.println(m.getId());
            if(m.getId().equals(idModalidade)) {
                grupo.setModalidade(m);
                System.out.println(m);
            }
        }
        
        daoGrupo.add(grupo);
    }

    public Long getIdModalidade() 
    {
        return idModalidade;
    }

    public void setIdModalidade(Long idModalidade) 
    {
        this.idModalidade = idModalidade;
    }
    
    public ModalidadeDao getDaoModalidade() 
    {
        return daoModalidade;
    }

    public void setDaoModalidade(ModalidadeDao daoModalidade) 
    {
        this.daoModalidade = daoModalidade;
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
//#endregion

//#region Itens from GUiCadastroItem
    @EJB
    ItemDao daoItem;
    
    //private List<Item> itens;
    private Item item  = new Item();
    
    public Item getItem() 
    {
        return item;
    }

    public void setItem(Item item) 
    {
        this.item = item;
    }
    
    public void addItem(Grupo g)
    {       
        item.setGrupo(g);
        daoItem.add(item);
        iniciar();
    }
//#endregion
    public GuiGrupo() 
    {
        
    }
        
    public String iniciar() 
    {
        this.grupos = daoGrupo.getAllGrupo();
        return "GrupoList";
    }
    
    public void addGrupoByGrupo(Grupo g)
    {        
        List<Modalidade> modalidades = daoModalidade.getAllModalidade();
                
        Grupo newGrupo = new Grupo();
        newGrupo.setNome(nome);
        //newGrupo.setComponentes(g.getComponentes());
        
        for(Modalidade m : modalidades)
        {
            if(m.getId().equals(idModalidade)) 
            {
                newGrupo.setModalidade(m);
                System.out.println(m);
            }
        }
        
        daoGrupo.add(newGrupo);        
        iniciar();
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
     
    public String itensList(Grupo g)
    {
        itens = daoGrupo.getItens(g);
        this.grupo = g;
        return "ItensGrupo";
    }
    
    public String gruposList(Grupo g)
    {
        itens = daoGrupo.getItens(g);
        this.grupo = g;
        return "GruposGrupo";
    }
    
    public String addNewGrupoByGrupo(Grupo g)
    {        
        this.grupo = g;
        return "CadastroGrupo";
    }
    
    public String addNewItemByGrupo(Grupo g)
    {        
        this.grupo = g;
        return "CadastroItem";
    }

    public String removeGrupo(Grupo g) 
    {
        daoGrupo.remove(g);
        return iniciar();
    } 
    
    public String removeItem(Item i) 
    {
        daoItem.remove(i);
        return iniciar();
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

    public List<Item> getItens() 
    {
        return itens;
    }

    public void setItens(List<Item> itens) 
    {
        this.itens = itens;
    }
}