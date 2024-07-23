import java.sql.*;

public class PesquisarRegistro {
        public static void main(String[] args) throws Exception {
        try{
        Connection conexao = MySQLConnector.conectar();
        String strSqlPesquisarRegistro = "select * from `db_teste`.`tbl_teste` where `nome`='Teste';";
        Statement stmSqlInserirRegistro = conexao.createStatement();
        ResultSet resultado = stmSqlInserirRegistro.executeQuery(strSqlPesquisarRegistro);
        while (resultado.next()){
            System.out.println(resultado.getString("senha"));
        }
    
        System.out.println("Pesquisa realizada com sucesso!");
    } catch (Exception e){
        System.out.println("Ops! Ocorreu o erro: " + e);
    }

    }
}
    
