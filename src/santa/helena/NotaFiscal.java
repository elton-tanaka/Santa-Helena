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
 * @author Laboratorio
 */
public class NotaFiscal {
    
    private Integer notaFiscal_id;

    public Integer getNotaFiscal_id() {
        return notaFiscal_id;
    }

    public void setNotaFiscal_id(Integer notaFiscal_id) {
        this.notaFiscal_id = notaFiscal_id;
    }

    private String cnpj;

    public static final String PROP_CNPJ = "cnpj";

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        String oldCnpj = this.cnpj;
        this.cnpj = cnpj;
        propertyChangeSupport.firePropertyChange(PROP_CNPJ, oldCnpj, cnpj);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private String nome;

    public static final String PROP_NOME = "nome";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }

    private String nome_produto;

    public static final String PROP_NOME_PRODUTO = "nome_produto";

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        String oldNome_produto = this.nome_produto;
        this.nome_produto = nome_produto;
        propertyChangeSupport.firePropertyChange(PROP_NOME_PRODUTO, oldNome_produto, nome_produto);
    }

    private int qntd_item;

    public static final String PROP_QNTD_ITEM = "qntd_item";

    public int getQntd_item() {
        return qntd_item;
    }

    public void setQntd_item(int qntd_item) {
        int oldQntd_item = this.qntd_item;
        this.qntd_item = qntd_item;
        propertyChangeSupport.firePropertyChange(PROP_QNTD_ITEM, oldQntd_item, qntd_item);
    }

    private String nome_cliente;

    public static final String PROP_NOME_CLIENTE = "nome_cliente";

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        String oldNome_cliente = this.nome_cliente;
        this.nome_cliente = nome_cliente;
        propertyChangeSupport.firePropertyChange(PROP_NOME_CLIENTE, oldNome_cliente, nome_cliente);
    }

    private String cpf_cliente;

    public static final String PROP_CPF_CLIENTE = "cpf_cliente";

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        String oldCpf_cliente = this.cpf_cliente;
        this.cpf_cliente = cpf_cliente;
        propertyChangeSupport.firePropertyChange(PROP_CPF_CLIENTE, oldCpf_cliente, cpf_cliente);
    }

    private boolean tipo_nota;

    public static final String PROP_TIPO_NOTA = "tipo_nota";

    public boolean isTipo_nota() {
        return tipo_nota;
    }

    public void setTipo_nota(boolean tipo_nota) {
        boolean oldTipo_nota = this.tipo_nota;
        this.tipo_nota = tipo_nota;
        propertyChangeSupport.firePropertyChange(PROP_TIPO_NOTA, oldTipo_nota, tipo_nota);
    }

}
