import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    // Usuario
    private String usuario = "root";
    private String senha = "123456";   
    // Acesso
    private String host = "localhost";
    private String porta = "3306";
    // Banco de Dados
    private String banco =  "db_teste";
    
    public Connection obtemConexao() {
        try {
            /*Connection c = DriverManager.getConnection("jdbc://mysql://" + host + ":" + porta + "/" + banco,usuario,senha);
            return c;*/
                return DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta+ "/" + banco + "?user=" + usuario + "&password=" + senha+ "&useTimezone=true&serverTimezone=America/Sao_Paulo");
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
