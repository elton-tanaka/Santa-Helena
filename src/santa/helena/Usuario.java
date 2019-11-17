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
public class Usuario
{
    private String nome, cpf, senha;
    
    public static final String PROP_NOME = "nome";
    public static final String PROP_CPF = "cpf";
    public static final String PROP_SENHA = "senha";
 
    
    
    private Integer IdUsuario;

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    private Funcao funcao;
    public static final String PROP_FUNCAO = "funcao";
    
    public Funcao getFuncao(){
        return funcao;
    }
    
    public void setFuncao(Funcao funcao) {
        Funcao oldfuncao = this.funcao;
        this.funcao = funcao;
        propertyChangeSupport.firePropertyChange(PROP_FUNCAO, oldfuncao, funcao);
    }
    
    
    //setters
    public void setNome(String n) 
    {
        //nome = n;
        String oldNome = this.nome;
        this.nome = n;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, n);
    }
    
    public void setCpf (String c)
    {
        //cpf = c;
        String oldCpf = this.cpf;
        this.cpf = c;
        propertyChangeSupport.firePropertyChange(PROP_CPF, oldCpf, c);
    }
    
    public void setSenha (String s)
    {
        //senha = s;
        String oldSenha = this.senha;
        this.senha = s;
        propertyChangeSupport.firePropertyChange(PROP_SENHA, oldSenha, s);
    }

    //getters
    public String getNome() 
    {
        return nome;
    }
    
    public String getCpf()
    {
        return cpf;
    }
    
    public String getSenha()
    {
        return senha;
    }
 
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}