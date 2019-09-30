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
public class Fornecedor
{
    private String cnpj, nome, cidade;
    
    //setters
    public void setCnpj(String c)
    {
        cnpj = c;
    }
    public void setNome(String n)
    {
        nome = n;
    }
    public void cidade(String ci)
    {
        cidade = ci;
    }
    
    //getters
    public String getCpnj()
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
}
