import java.sql.*;

public class InserirRegistro {
    
    public static void main(String[] args) throws Exception {
        try{
        Connection conexao = MySQLConnector.conectar();
        String strSqlInserirRegistro = "insert into `db_teste`.`tbl_teste` (`nome`, `email`, `senha`) values ('teste', 'teste@teste.teste', 'senhateste');";
        Statement stmSqlInserirRegistro = conexao.createStatement();
        //stmSqlCriarBancoDeDados.executeQuery(strSqlCriarBancoDeDados);
        stmSqlInserirRegistro.addBatch(strSqlInserirRegistro);
        stmSqlInserirRegistro.executeBatch();
        stmSqlInserirRegistro.close();
        System.out.println("Registro inserido com sucesso!");
    } catch (Exception e){
        System.out.println("Ops! Ocorreu o erro: " + e);
    }

    }
}

