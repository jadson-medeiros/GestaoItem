/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import dao.GrupoDao;
import dao.ItemDao;
import dao.ModalidadeDao;
import dao.UnidadeDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import model.Componente;
import model.Grupo;
import model.Item;
import model.Modalidade;
import model.Unidade;

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
    @EJB
    GrupoDao daoGrupo;
     
    @EJB
    ModalidadeDao daoModalidade;
        
    @EJB
    ItemDao daoItem;
    
    @EJB
    UnidadeDao daoUnidade;
            
    private String usuario;    
    private String senha; 
    private String nome;
    
    private List<Grupo> grupos;
    private List<Item> itens;
    private List<Grupo> gruposGrupo;
    
    private Grupo grupo;
    private Modalidade modalidade;
    private Unidade unidade;
    private Item item  = new Item();
    
    private Long idModalidade;
    private Long id;
    private Long idUnidade;

    public GuiGrupo() 
    {        
    }
    
    public String iniciar() 
    {
        List<Grupo> grupoList = daoGrupo.getAllGrupos();
        List<Grupo> newGrupoList = daoGrupo.getAllGrupos();
        
        for (Grupo g : grupoList)
        {
            if(g.getComponentes().size() > 0)
            {
                for (Componente c : g.getComponentes())
                {
                    if(newGrupoList.contains(c)) newGrupoList.remove(c);
                }
            }             
        }
        
        this.grupos = newGrupoList;
        
        return "GrupoList";
    }
    
    public String addGrupo(Grupo g)
    {
        Grupo newGrupo = new Grupo();
        
        if (g == null)                
        {
            newGrupo.setNome(nome);
            daoGrupo.add(newGrupo);            
        }
        else
        {
            newGrupo.setNome(nome);

            g.addGrupo(newGrupo);
            daoGrupo.update(g);             
        }       
        
        return iniciar();
    }
    
    public String addItem(Grupo g)
    {                   
        List<Unidade> unidades = daoUnidade.getAllUnidades();
                 
        for(Unidade u : unidades)
        {
            if(u.getId().equals(idUnidade)) 
            {
                item.setUnidade(u);
            }
        }
        
        item.setGrupo(g);
        daoItem.add(item);
        
        return itensList(g);
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
    
    public String itensList(Grupo g)
    {
        itens = daoGrupo.getItens(g);
        this.grupo = g;
        return "ItensGrupo";
    }
    
    public String gruposList(Grupo g)
    {
        Grupo gp = daoGrupo.getGrupo(g);
        List<Grupo> gruposLista = new ArrayList();
        
        for(Componente c : gp.getComponentes())
        {
            gruposLista.add((Grupo) c);
        }
        
        this.grupo = gp;
        this.gruposGrupo = gruposLista;
        return "GruposGrupo";
    }
    
    public String addNewGrupoByGrupo(Grupo g)
    {        
        this.grupo = g;
        return "CadastroGrupo";
    }
    
    public String addNewGrupo()
    {
        return "CadastroGrupo";
    }
    
    public String addNewItemByGrupo(Grupo g)
    {        
        this.grupo = g;
        return "CadastroItem";
    }
       
    // Getters and Setters
    public Long getIdUnidade() 
    {
        return idUnidade;
    }
   
    public void setIdUnidade(Long idUnidade) 
    {
        this.idUnidade = idUnidade;
    }

    public Unidade getUnidade() 
    {
        return unidade;
    }

    public void setUnidade(Unidade unidade) 
    {
        this.unidade = unidade;
    }
     
    public List<Unidade> getUnidades() 
    {
        return daoUnidade.getAllUnidades();
    }
    
    public Item getItem() 
    {
        return item;
    }

    public void setItem(Item item) 
    {
        this.item = item;
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
        
    public GrupoDao getDaoGrupo() 
    {
        return daoGrupo;
    }

    public void setDaoGrupo(GrupoDao daoGrupo) 
    {
        this.daoGrupo = daoGrupo;
    }

    public ModalidadeDao getDaoModalidade()
    {
        return daoModalidade;
    }

    public void setDaoModalidade(ModalidadeDao daoModalidade) 
    {
        this.daoModalidade = daoModalidade;
    }

    public ItemDao getDaoItem() 
    {
        return daoItem;
    }

    public void setDaoItem(ItemDao daoItem) 
    {
        this.daoItem = daoItem;
    }

    public UnidadeDao getDaoUnidade() 
    {
        return daoUnidade;
    }

    public void setDaoUnidade(UnidadeDao daoUnidade) 
    {
        this.daoUnidade = daoUnidade;
    }
    
    public List<Grupo> getGruposGrupo() 
    {
        return gruposGrupo;
    }

    public void setGruposGrupo(List<Grupo> gruposGrupo) 
    {
        this.gruposGrupo = gruposGrupo;
    }
       
    public Long getIdModalidade() 
    {
        return idModalidade;
    }

    public void setIdModalidade(Long idModalidade) 
    {
        this.idModalidade = idModalidade;
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