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
public class Usuario
{
    private String nome, cpf, senha;
    private int funcao;
    
    
    
    
    public void setNome(String n) 
    {
        String oldNome = nome;
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
    
    public void setFuncao (int f)
    {
        funcao = f;
    }
    
    public String getNome() 
    {
        return nome;
    }
}