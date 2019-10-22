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
        String sql = "INSERT INTO usuario (nome_usuario, cpf_usuario, senha_usuario, cargo_usuario) values (?,?,?,?);";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getCpf());
            stmt.setString(3, element.getSenha());
            stmt.setString(4, element.getFuncao());
            
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
        String sql = "UPDATE usuario set nome_usuario = ?, cpf_usuario = ?, senha_usuario = ?, cargo_usuario = ? WHERE (id_usuario) = ?;";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getCpf());
            stmt.setString(3, element.getSenha());
            stmt.setString(4, element.getFuncao());
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
        String sql = "DELETE FROM usuario WHERE (id_usuario) = ?;";
        
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
        
        String sql = "SELECT * FROM usuario;";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome_usuario"));
                u.setCpf(rs.getString("cpf_usuario"));
                u.setSenha(rs.getString("senha_usuario"));
                u.setFuncao(rs.getString("cargo_usuario"));
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
