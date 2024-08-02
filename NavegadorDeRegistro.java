import java.sql.*;

public class NavegadorDeRegistro {
    public static String[]  irParaRegistro(String db, String tbl, String id, String botao) throws Exception{
        Connection conexao = MySQLConnector.conectar();
        Statement stmSqlRegistro = conexao.createStatement();

        String strSqlRegistro = "";
        switch (botao) {
            case "primeiro":
                strSqlRegistro = "select * from `" +  db + "`.`" + tbl + "` order by id limit 1;";
                break;
            case "anterior":
                strSqlRegistro = "select * from `" +  db + "`.`" + tbl + "` where (id < '" + id + "') order by id desc limit 1;";
                break;
            case "próximo":
                strSqlRegistro = "select * from `" +  db + "`.`" + tbl + "` where (id > '" + id + "') order by id asc limit 1;";
                break;
            case "último":
                strSqlRegistro = "select * from `" +  db + "`.`" + tbl + "` order by id desc limit 1;";
                break;
            default:
                strSqlRegistro = "select * from `" + db + "`.`" + tbl + "` where (nome = '" + botao + "') order by nome asc limit 1;";
                break;
        }

        ResultSet rstSqlRegistro = stmSqlRegistro.executeQuery(strSqlRegistro);
        rstSqlRegistro.next();
        String[] resultado = {
            rstSqlRegistro.getString("id"),
            rstSqlRegistro.getString("nome"),
            rstSqlRegistro.getString("email"),
            rstSqlRegistro.getString("senha"),
        };
    
        stmSqlRegistro.close();
        return resultado; 
    }
}