import java.sql.*;

public class MySQLConnector {
    public static Connection conectar() {
        String status = "Nada aconteceu ainda...";
        String mysqlHost = "127.0.0.1";
        String mysqlDb = "db_mysql_connector";
        String mysqlUser = "root";
        String mysqlPassword = "123456";
        String mysqlPort = "3306";
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(mysqlUrl);
            status = "Conexão realizada com sucesso!";

        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e){
            status = "Ops! algo de errado não está certo com a conexão com o bando de cados MySQL! Mensagem do servidor: " + e;

        }
    
        System.out.println(status);
        return conn;
    }
}
