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
public class Fornecedor
{
    private String cnpj, nome, cidade;
    
    public static final String PROP_CNPJ = "cnpj";
    public static final String PROP_NOME = "nome";
    public static final String PROP_CIDADE = "cidade";
    
        private Integer IdFornecedor;

    public Integer getIdFornecedor() {
        return IdFornecedor;
    }

    public void setIdFornecedor(Integer IdFornecedor) {
        this.IdFornecedor = IdFornecedor;
    }

    //setters
    public void setCnpj(String c)
    {
        //cnpj = c;
        
        String oldCnpj = this.cnpj;
        this.cnpj = c;
        propertyChangeSupport.firePropertyChange(PROP_CNPJ, oldCnpj, c);
    }
    public void setNome(String n)
    {
        //nome = n;
        
        String oldNome = this.nome;
        this.nome = n;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, n);
    }
    public void setCidade(String ci)
    {
        //cidade = ci;
        
        String oldCidade = this.cidade;
        this.cidade = ci;
        propertyChangeSupport.firePropertyChange(PROP_CIDADE, oldCidade, ci);
    }
    
    //getters
    public String getCnpj()
    {
        return cnpj;
    }
    public String getNome()
    {
        return nome;
    }
    public String getCidade()
    {
        return cidade;
    }
    
    
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
