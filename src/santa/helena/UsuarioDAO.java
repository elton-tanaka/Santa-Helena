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
 * @author j_joa
 */
public class UsuarioDAO extends DAO<Usuario> {

    @Override
    public boolean inserir(Usuario element) {
        
        Funcao f = element.getFuncao();
        FuncaoDAO fd = new FuncaoDAO();
        
        
        String sql = "INSERT INTO Usuario (nome, cpf, senha, Funcao_id) VALUES (?,?,?,?);";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getCpf());
            stmt.setString(3, element.getSenha());
            stmt.setInt(4, element.getFuncao().getFuncaoId());
            
            if(stmt.executeUpdate() == 1){
                ResultSet rs = stmt.getGeneratedKeys();
                 rs.next();
                 element.setIdUsuario(rs.getInt(1));
                 return true;
            }
        }catch(SQLException e){
            System.out.append("Erro ao inserir");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean alterar(Usuario element) {
        String sql = "UPDATE usuario set nome = ?, cpf = ?, senha = ?, Funcao_id = ? WHERE (id) = ?;";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getCpf());
            stmt.setString(3, element.getSenha());
            stmt.setInt(4, element.getFuncao().getFuncaoId());
            stmt.setInt(5, element.getIdUsuario());
            
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
    public boolean remover(Usuario element) {
        String sql = "DELETE FROM usuario WHERE (id) = ?;";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, element.getIdUsuario());
            
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
    public List<Usuario> listar() {
        List<Usuario> lstUsuario = new ArrayList<>();
        lstUsuario = ObservableCollections.observableList(lstUsuario);
        FuncaoDAO fd = new FuncaoDAO();
        
        String sql = "SELECT * FROM Usuario;";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setCpf(rs.getString("cpf"));
                u.setSenha(rs.getString("senha"));
                u.setFuncao(fd.getById(rs.getInt("Funcao_id")));
                lstUsuario.add(u);
            }
        }catch(SQLException e){
            System.out.println("erro ao listar: "+e.getMessage());
        }
        return lstUsuario;
    }
    
    public static void main(String[] args) {
        Usuario u = new Usuario();
        
        UsuarioDAO ud = new UsuarioDAO();
        ud.inserir(u);
    }
    
}
