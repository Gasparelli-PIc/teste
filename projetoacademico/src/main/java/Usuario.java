
// Conexao
import java.sql.Connection;
// Comando pré compilado
import java.sql.PreparedStatement;
// resultado 
import java.sql.ResultSet;

public class Usuario {
    private String login;
    private String senha;
    
    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public int existe(){
        String sql = "SELECT * FROM tb_usuario WHERE login = ?";
        ConnectionFactory factory = new ConnectionFactory();
        try(Connection c = factory.obtemConexao()) {
            PreparedStatement ps = c.prepareStatement(sql);            
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                String senhaCadastrada = rs.getString("senha");
                if (senhaCadastrada.equals(senha)){
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
