package apfinal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class crud {
    private Connection conexao;

    public crud (Connection conexao){
        this.conexao = conexao;
        }
    // Create
    public boolean inserirDisciplina(String nome, int semestre, int cargaHoraria){
       try{
           Statement statement = this.conexao.createStatement();
           statement.executeUpdate("INSERT INTO DISCIPLINAS(nome, semestre, cargaHoraria) VALUES('"+nome+"', "+semestre+", "+cargaHoraria+")");
           return true;
       }catch(SQLException e){
           System.out.println("SQL ERROR");
           return false;
       }
       }
  
    public boolean inserirUsuario(String nome, int semestre, int IraI){
       try{
           Statement statement = this.conexao.createStatement();
           statement.executeUpdate("INSERT INTO USUARIO(nome, semestre, IraI) VALUES('"+nome+"', "+semestre+", "+IraI+")");
           return true;
       }catch(SQLException e){
           System.out.println("SQL ERROR");
           return false;
       }
       }
    
    // Read 
    public ResultSet lerDisciplinaFeita() throws SQLException{
    try{
        Statement statement = this.conexao.createStatement();
        return statement.executeQuery("SELECT nome FROM DISCIPLINA WHERE feito = 1 ");

    }catch(SQLException e){
        System.out.println("SQL ERROR");
        throw e;
    }
    }  

    public ResultSet lerDisciplinaNota(int codigo) throws SQLException{
    try{
        Statement statement = this.conexao.createStatement();
        return statement.executeQuery("SELECT nota FROM DISCIPLINA WHERE codigo = "+codigo+"");

    }catch(SQLException e){
        System.out.println("SQL ERROR");
        throw e;
    }
    }    
    
    public ResultSet lerDadosUsuario() throws SQLException{
    try{
        Statement statement = this.conexao.createStatement();
        return statement.executeQuery("SELECT * FROM USUARIO");

    }catch(SQLException e){
        System.out.println("SQL ERROR");
        throw e;
    }
    } 
    // Update 
    public boolean atualizarDisciplinaFeita(int codigo){
       try{
           Statement statement = this.conexao.createStatement();
           statement.executeUpdate("UPDATE Disciplina SET Feito = 1 WHERE codigo = "+codigo+"");
           return true;
       }catch(SQLException e){
           System.out.println("SQL ERROR");
           return false;
       }
       }
    
    public boolean atualizarDisciplinaNota(int codigo, float nota){
       try{
           Statement statement = this.conexao.createStatement();
           statement.executeUpdate("UPDATE Disciplina SET Nota = "+nota+" WHERE codigo = "+codigo+"");
           return true;
       }catch(SQLException e){
           System.out.println("SQL ERROR");
           return false;
       }
       }

    public boolean atualizarUsuario(String nome, int semestre, int IraI){
       try{
           Statement statement = this.conexao.createStatement();
           statement.executeUpdate("UPDATE Usuario SET nome = '"+nome+"', semestre = "+semestre+", IraI = "+IraI+"");
           return true;
       }catch(SQLException e){
           System.out.println("SQL ERROR");
           return false;
       }
       }
    
    /*
    public boolean inserirDisciplina(String nome, int codigo, int cargaHoraria){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO DISCIPLINA(nome, codigo, cargaHoraria) VALUES('"+nome+"', "+codigo+", "+cargaHoraria+")");
            return true;
        }catch(SQLException e){
            System.out.println("SQL ERROR");
            return false;
        }
        }


    
        public boolean inserirUsuario(String nome, int matricula, int ira, int semestre){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO USUARIO(nome, matricula, ira, semestre) VALUES('"+nome+"', "+matricula+", "+ira+", "+semestre+")");
            return true;
        }catch(SQLException e){
            System.out.println("SQL ERROR");
            return false;
        }
        }
        
        public ResultSet lerDisciplina(int codigo) throws SQLException{
        try{
            Statement statement = this.conexao.createStatement();
            return statement.executeQuery("SELECT * FROM DISCIPLINA WHERE codigo = "+codigo+"");
               
        }catch(SQLException e){
            System.out.println("SQL ERROR");
            throw e;
        }
        }
    
        public boolean lerUsuario(int matricula){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM USUARIO WHERE matricula = "+matricula+"");
            
            while (rs.next()){
                Integer id = rs.getInt("matricula");
                String nome = rs.getString("nome");
                Integer ira = rs.getInt("ira");
                Integer semestre = rs.getInt("semestre");
                
                System.out.println("Código: " + matricula + "\n" + "Nome: " + nome + "\n" + "semestre: " + semestre + "\n" + "Ira:" + ira);
                
            }
            return true;
        }catch(SQLException e){
            System.out.println("SQL ERROR");
            return false;
        }
        }
    */        
        }
    
    
