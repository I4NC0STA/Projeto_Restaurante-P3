import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    // url que aponta para o banco de dados local na porta 3306
    private static final String URL = "jdbc:mysql://localhost:3306/bancobertis";
    private static final String USUARIO = "root";
    private static final String SENHA = "a senha de vcs aqui ta"; 
    public static Connection obterConexao() {
        try {
            // para carregar o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //  Tenta estabelecer a conexão e volta  o objeto Connection
            return DriverManager.getConnection(URL, USUARIO, SENHA);
            
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: O Driver JDBC não foi encontrado no projeto!");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}