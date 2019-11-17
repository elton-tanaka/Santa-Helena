/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santa.helena;

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
public class FuncaoDAO extends DAO<Funcao> {

    @Override
    public boolean inserir(Funcao element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Funcao element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Funcao element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcao> listar() {
        List<Funcao> lstFuncao = new ArrayList<>();
        lstFuncao = ObservableCollections.observableList(lstFuncao);
        
        String sql = "SELECT * FROM funcao;";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                Funcao f = new Funcao();
                f.setFuncaoId(rs.getInt("id"));
                f.setDescricao(rs.getString("descricao"));
                lstFuncao.add(f);
            }
        }catch(SQLException e){
            System.out.println("erro ao listar" +e.getMessage());
        }
        return lstFuncao;
    }
    
    public Funcao getById(int id){
        String sql = "SELECT * FROM funcao WHERE id ="+id;
        Funcao f = null;
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                f = new Funcao();
                f.setFuncaoId(rs.getInt("id"));
                f.setDescricao(rs.getString("descricao"));
            }
            
        }catch(SQLException e){
            System.out.println("erro ao listar: "+e.getMessage());
        }
        return f;
    }
    
    
    public static void main(String[] args){
        Funcao f = new Funcao();
        FuncaoDAO fd = new FuncaoDAO();
    }
}
