/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santa.helena;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Danilo
 */
public class AreaDeTrabalho extends JDesktopPane{
    private JInternalFrame cadProduto;
    
    public void abrirCadastroProduto(){
        if(cadProduto == null){
            cadProduto = new CadastroProduto();
            cadProduto.setVisible(true);
            add(cadProduto);
        }
    }
    public void fecharCadastroProduto(){
        cadProduto = null;
    }
}
