/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santa.helena;

import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Danilo
 */
public class AreaDeTrabalho extends JDesktopPane{
    private JInternalFrame cadProduto;
    private JInternalFrame cadFornecedor;
    private JInternalFrame cadUsuario;
    
    public void abrirCadastroProduto(){
        if(cadProduto == null){
            cadProduto = new CadastroProduto();
            cadProduto.setVisible(true);
            add(cadProduto);
        }
        else{
            try{
                cadProduto.setSelected(true);
                cadProduto.setIcon(false);
                cadProduto.moveToFront();
            }
            catch(PropertyVetoException e){
                System.out.print("Nao foi possivel restaurar a janela!");
            }
        }
    }
    public void fecharCadastroProduto(){
        cadProduto = null;
    }
    
    public void abrirCadastroFornecedor(){
        if(cadFornecedor == null){
            cadFornecedor = new CadastroFornecedor();
            cadFornecedor.setVisible(true);
            add(cadFornecedor);
        }
        else{
            try{
                cadFornecedor.setSelected(true);
                cadFornecedor.setIcon(false);
                cadFornecedor.moveToFront();
            }
            catch(PropertyVetoException e){
                System.out.print("Nao foi possivel restaurar a janela!");
            }
        }
    }
    public void fecharCadastroFornecedor(){
        cadFornecedor = null;
    }
    
    public void abrirCadastroUsuario(){
        if(cadUsuario == null){
            cadUsuario = new CadastroUsuario();
            cadUsuario.setVisible(true);
            add(cadUsuario);
        }
        else{
            try{
                cadUsuario.setSelected(true);
                cadUsuario.setIcon(false);
                cadUsuario.moveToFront();
            }
            catch(PropertyVetoException e){
                System.out.print("Nao foi possivel restaurar a janela!");
            }
        }
    }
    public void fecharCadastroUsuario(){
        cadUsuario = null;
    }
    
}
