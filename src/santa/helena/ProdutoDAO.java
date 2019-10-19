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
 *
 */
public class ProdutoDAO extends DAO<Produto> {

    @Override
    public boolean inserir(Produto element) {
        String sql = "INSERT INTO produto (nome, preco) values (?,?);";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             stmt.setString(1, element.getNome());
             stmt.setString(2, element.getPreco());
             
             if(stmt.executeUpdate()==1){
                 ResultSet rs = stmt.getGeneratedKeys();
                 rs.next();
                 element.setIdProduto(rs.getInt(1));
                 return true;
             }
            
        }catch(SQLException e){ 
            System.out.append("Erro ao inserir");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean alterar(Produto  element) {
        String sql = "UPDATE produto set nome = ?, preco = ? WHERE (idProdutos) = ? ;";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, element.getNome());
            stmt.setString(2, element.getPreco());
            stmt.setInt(3, element.getIdProduto());
            
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
    public boolean remover(Produto element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> listar() {
        List<Produto> lstProduto = new ArrayList<>();
        lstProduto = ObservableCollections.observableList(lstProduto);
        
        String sql = "SELECT * FROM produto;";
        try{
            Statement stmt = conn.createStatement();
            //ResultSet rs = stmt.executeQuery(sql);
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getString("preco"));
                lstProduto.add(p);
            }
        }catch(SQLException e){
            System.out.println("erro ao listar: "+e.getMessage());
        }
        return lstProduto;
    }
    
    public static void main(String[] args) {
        Produto p = new Produto();
        
        ProdutoDAO pd = new ProdutoDAO();
        pd.inserir(p);
    }
    
    
}
