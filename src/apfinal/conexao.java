package apfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  

public class conexao {
    private Connection connection;
    public conexao(){
        this.connection = null;
    }
    private void SetConnection(Connection connection){
        this.connection = connection;
    }
    public Connection getConnection(){
        return this.connection;
    }
    public boolean abrirConexao(){
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:path");
            this.SetConnection(connection);
            return true;
        }
        catch(SQLException e)
        {
           return false; 
        }
    }
    public boolean fecharConexao(){
        try
        {
            if(this.getConnection() != null)
                this.getConnection().close();
                return true;
        }
        catch(SQLException e)
        {
            return false;
        }
    }
    
}  
    
