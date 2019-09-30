/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santa.helena;


/**
 *
 * @author EltonSSD
 */
public class Usuario
{
    private String nome, cpf, senha;
    
    
    
    //setters
    public void setNome(String n) 
    {
        //String oldNome = nome;
        nome = n;
    }
    
    public void setCpf (String c)
    {
        cpf = c;
    }
    
    public void setSenha (String s)
    {
        senha = s;
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
 
}