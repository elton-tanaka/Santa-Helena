/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santa.helena;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author EltonSSD
 */
public class Funcao {
    
    private int funcaoId;

    public static final String PROP_FUNCAOID = "funcaoId";

    public int getFuncaoId() {
        return funcaoId;
    }

    public void setFuncaoId(int funcaoId) {
        int oldFuncaoId = this.funcaoId;
        this.funcaoId = funcaoId;
        propertyChangeSupport.firePropertyChange(PROP_FUNCAOID, oldFuncaoId, funcaoId);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private String descricao;

    public static final String PROP_DESCRICAO = "descricao";

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        propertyChangeSupport.firePropertyChange(PROP_DESCRICAO, oldDescricao, descricao);
    }
    
    @Override
    public String toString() {
        return descricao;
    }
    
}
