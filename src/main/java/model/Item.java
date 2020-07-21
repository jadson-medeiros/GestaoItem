/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author acg
 */
@Entity
public class Item extends Componente implements Serializable {

    private String descricao;
    private String codigoComprasnet;
    
    @ManyToOne
    private Unidade unidade;
    
    @ManyToOne
    private Grupo grupo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoComprasnet() {
        return codigoComprasnet;
    }

    public void setCodigoComprasnet(String codigoComprasnet) {
        this.codigoComprasnet = codigoComprasnet;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
