/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas_classes;



/**
 *
 * @author EltonSSD
 */
public class Produto 
{
    private String nome;
    private float preco;
    
    //setters
    public void setNome(String n) 
    {
        nome = n;
    }
    
    public void setPreco(float p)
    {
        preco = p;
    }
    
    //getters
    public String getNome()
    {
        return nome;
    }
    
    public float getPreco()
    {
        return preco;
    }
}

 