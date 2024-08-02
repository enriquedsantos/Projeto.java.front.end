import java.sql.*;

public class InserirRegistro2 {
    public static void main(String[] args) throws Exception {
        try {
            Connection conexao = MySQLConnector.conectar();
            Statement stmSqlInserirRegistro = conexao.createStatement();
            String strSqlInserirRegistro = "";
            for (int i = 1; i < 25; i++) {
                    strSqlInserirRegistro = "insert into `db_teste`.`tbl_teste` (`nome`, `email`, `senha`) values ('Teste" + i + "', 'teste" + i + "@teste.teste', 'senhaTeste" + i + "');";
                    System.out.println(strSqlInserirRegistro);
                    stmSqlInserirRegistro.addBatch(strSqlInserirRegistro);
                    stmSqlInserirRegistro.executeBatch();
            }
            stmSqlInserirRegistro.close();
            System.out.println("Registro inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Ops! Ocorreu o erro: " + e);
        }
    }
}