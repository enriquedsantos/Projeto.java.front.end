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

    public static void cadastrar(String string, String string2, String string3, String nome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    public static boolean excluir(String string, String string2, String string3, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }
}

