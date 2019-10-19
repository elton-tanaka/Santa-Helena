package santa.helena;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class DAO <E> {
    
    protected Connection conn;
    public abstract boolean inserir(E element);
    public abstract boolean alterar(E element);
    public abstract boolean remover(E element);
    public abstract List<E> listar();
    
    public DAO(){
        String url = "jdbc:mysql://127.0.1:3306/SantaHelena?serverTimezone=UTC";
        String user = "root";
        String password = "root";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            
            Statement stmt = conn.createStatement();            
            
        }catch(ClassNotFoundException e) {
            System.out.println("erro no driver");
        }catch(SQLException e){
            System.out.println("erro na conexao "+ e.getMessage());
        }
        
        //conn = 
    }
       
}
