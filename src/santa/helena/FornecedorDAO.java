/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santa.helena;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author EltonSSD
 */
public class FornecedorDAO extends DAO<Fornecedor> {

    @Override
    public boolean inserir(Fornecedor element) {
        String sql = "INSERT INTO fornecedor (cnpj_fornecedor, nome_fornecedor, cidade_fornecedor) values (?,?,?);";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, element.getCnpj());
            stmt.setString(2,element.getNome());
            stmt.setString(3,element.getCidade());
            
            if(stmt.executeUpdate()==1){
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                element.setIdFornecedor(rs.getInt(1));
                return true;
            }
        }catch(SQLException e){
            System.out.append("Erro ao inserir");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean alterar(Fornecedor element) {
        String sql = "UPDATE fornecedor set cnpj_fornecedor = ?, nome_fornecedor = ?, cidade_fornecedor = ? WHERE (id_fornecedor) = ? ;";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setString(1,element.getCnpj());
             stmt.setString(2,element.getNome());
             stmt.setString(3,element.getCidade());
             stmt.setInt(4,element.getIdFornecedor());
        
        if(stmt.executeUpdate()==1){
            return true;
                 }       
            }catch(SQLException e){
                System.out.println("erro ao inserir");
                e.printStackTrace();
            }
        return false;
    }

    @Override
    public boolean remover(Fornecedor element) {
        String sql = "DELETE FROM fornecedor WHERE (id_fornecedor) = ?;";
    try{
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, element.getIdFornecedor());
        
        if(stmt.executeUpdate()==1){
            return true;
        }
    }catch(SQLException e){
        System.out.println("erro ao remover");
        e.printStackTrace();
    }
    return false;
    }

    @Override
    public List<Fornecedor> listar() {
        List<Fornecedor> lstFornecedor = new ArrayList<>();
        lstFornecedor = ObservableCollections.observableList(lstFornecedor);
        
        String sql = "SELECT * FROM Fornecedor;";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                Fornecedor f = new Fornecedor();
                f.setIdFornecedor(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("nome_fornecedor"));
                f.setCnpj(rs.getString("cnpj_fornecedor"));
                f.setCidade(rs.getString("cidade_fornecedor"));
                lstFornecedor.add(f);
            }
            
        }catch(SQLException e){
            System.out.println("erro ao listar: " +e.getMessage());
        }
        return lstFornecedor;
    }
public static void main(String[] args){
    Fornecedor f = new Fornecedor();
    
    FornecedorDAO fd = new FornecedorDAO();
    fd.inserir(f);
}
    

   
    
}
