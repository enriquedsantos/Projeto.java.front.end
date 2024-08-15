import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EditarCadastro extends JFrame {

    private final JTextField idTextField = new JTextField(15);  
    private final JTextField nomeTextField = new JTextField(20); 
    private final JTextField emailTextField = new JTextField(20); 
    private final JTextField senhaPasswordField = new JPasswordField(20); 
    private final JLabel idJLabel = new JLabel("ID:");
    private final JLabel nomeJLabel = new JLabel("Digite o nome:");
    private final JLabel emailJLabel = new JLabel("Digite o email:");
    private final JLabel senhaJLabel = new JLabel("Digite a senha:");
    private final JLabel notificacaoJLabel = new JLabel("Notificações:");
    private final JButton consultarJButton = new JButton("🔎");
    private final JButton incluirJButton = new JButton("Incluir");
    private final JButton atualizarJButton = new JButton("Atualizar");
    private final JButton excluirJButton = new JButton("Excluir");
    private final JButton limparJButton = new JButton("Limpar");
    private final JButton primeiroRegistroJButton = new JButton("<<");
    private final JButton registroAnteriorJButton = new JButton("<");
    private final JButton proximoRegistroJButton = new JButton(">");
    private final JButton ultimoRegistroJButton = new JButton(">>");

    public EditarCadastro() {

        super("Editar Cadastro");
        setLayout(new GridLayout(6, 4, 5, 5));

        idTextField.setEditable(false);
        idTextField.setToolTipText("Não pode ser mudado!");
        consultarJButton.setToolTipText("Consultar cadastro");
        incluirJButton.setToolTipText("Incluir cadastro");
        atualizarJButton.setToolTipText("Atualizar cadastro");
        excluirJButton.setToolTipText("Excluir cadastro");
        limparJButton.setToolTipText("Limpar campos");
        primeiroRegistroJButton.setToolTipText("Primeiro registro");
        registroAnteriorJButton.setToolTipText("Registro antetior");
        proximoRegistroJButton.setToolTipText("Proximo registro");
        ultimoRegistroJButton.setToolTipText("Ultimo registro");
        
        consultarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                String[] resultado;
                String nome;
                try{
                    idTextField.setText("");
                    emailTextField.setText("");
                    senhaPasswordField.setText("");
                    nome = nomeTextField.getText();
                    resultado = NavegadorDeRegistro.irParaRegistro("db_teste", "tbl_teste", "0", nome);
                    notificacaoJLabel.setText("Registro posicionado com sucesso");
                    idTextField.setText(resultado[0]);
                    nomeTextField.setText(resultado[1]);
                    emailTextField.setText(resultado[2]);
                    senhaPasswordField.setText(resultado[3]);
                    primeiroRegistroJButton.setEnabled(true);
                    registroAnteriorJButton.setEnabled(true);
                    proximoRegistroJButton.setEnabled(true);
                    ultimoRegistroJButton.setEnabled(true);
                } catch(Exception e) {
                    System.out.println("Ocorreu erro ao executar o comando: " + e);
                    return;
                }
            }
        }); 

        incluirJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                String nome, email, senha;
                String[] resultado;
                try{
                    nome = nomeTextField.getText();
                    email = emailTextField.getText();
                    senha = senhaPasswordField.getText();
                    
                    notificacaoJLabel.setText(GerirRegistro.atualizar("db_teste", "tbl_teste", idTextField.getText(), nome, email, senha, "incluir"));
                    resultado = NavegadorDeRegistro.irParaRegistro("db_teste", "tbl_teste", "0", "último");
                    idTextField.setText(resultado[0]);
                    nomeTextField.setText(resultado[1]);
                    emailTextField.setText(resultado[2]);
                    senhaPasswordField.setText(resultado[3]);
                    primeiroRegistroJButton.setEnabled(true);
                    registroAnteriorJButton.setEnabled(true);
                    proximoRegistroJButton.setEnabled(false);
                    ultimoRegistroJButton.setEnabled(false);
                } catch(Exception e){
                    System.out.println("Ocorreu erro ao executar o comando: " + e);
                    return;
                } 
            }
        }); 

        atualizarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                String nome, email, senha;
                try{
                    nome = nomeTextField.getText();
                    email = emailTextField.getText();
                    senha = senhaPasswordField.getText();
                    // aqui vamos incluir a ação de cadastrar no bando de dados
                    notificacaoJLabel.setText(GerirRegistro.atualizar("db_teste", "tbl_teste", idTextField.getText(), nome, email, senha, "atualizar"));
                } catch(Exception e){
                    System.out.println("Ocorreu erro ao executar o comando: " + e);
                    return;
                } 
            }
        }); 

        excluirJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                try{
                    notificacaoJLabel.setText(GerirRegistro.atualizar("db_teste", "tbl_teste", idTextField.getText(), "", "", "", "excluir"));
                    idTextField.setText("");
                    nomeTextField.setText("");
                    emailTextField.setText("");
                    senhaPasswordField.setText("");
                    
                    String[] resultado;
                    resultado = NavegadorDeRegistro.irParaRegistro("db_teste", "tbl_teste", idTextField.getText(), "próximo");

                    if (resultado != null && resultado.length > 0) {
                        idTextField.setText(resultado[0]);
                        nomeTextField.setText(resultado[1]);
                        emailTextField.setText(resultado[2]);
                        senhaPasswordField.setText(resultado[3]);
                        notificacaoJLabel.setText("Próximo registro posicionado com sucesso");
                        
                        primeiroRegistroJButton.setEnabled(true);
                        registroAnteriorJButton.setEnabled(true);
                        proximoRegistroJButton.setEnabled(true);
                        ultimoRegistroJButton.setEnabled(true);

                    } else {
                        
                        primeiroRegistroJButton.setEnabled(false);
                        registroAnteriorJButton.setEnabled(false);
                        proximoRegistroJButton.setEnabled(false);
                        ultimoRegistroJButton.setEnabled(false);
                        
                        notificacaoJLabel.setText("Nenhum registro restante");
                    }

                } catch(Exception e) {
                    System.out.println("Ocorreu erro ao executar o comando: " + e);
                    return;
                }
            }
        });
        
        limparJButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                
               try {
                idTextField.setText("");
                nomeTextField.setText("");
                emailTextField.setText("");
                senhaPasswordField.setText("");
                
                primeiroRegistroJButton.setEnabled(true);
                registroAnteriorJButton.setEnabled(false);
                proximoRegistroJButton.setEnabled(false);
                ultimoRegistroJButton.setEnabled(false);
                notificacaoJLabel.setText("Campos limpos.");
        } catch (Exception e) {
          
            System.out.println("Erro ao limpar campos: " + e.getMessage());
        }
    }
});
    

        primeiroRegistroJButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                String[] resultado;
                try{
                    resultado = NavegadorDeRegistro.irParaRegistro("db_teste", "tbl_teste", "0", "primeiro");
                    notificacaoJLabel.setText("Primeiro registro posicionado com sucesso");
                    idTextField.setText(resultado[0]);
                    nomeTextField.setText(resultado[1]);
                    emailTextField.setText(resultado[2]);
                    senhaPasswordField.setText(resultado[3]);
                    primeiroRegistroJButton.setEnabled(false);
                    registroAnteriorJButton.setEnabled(false);
                    proximoRegistroJButton.setEnabled(true);
                    ultimoRegistroJButton.setEnabled(true);
                } catch(Exception e) {
                    System.out.println("Ocorreu erro ao executar o comando: " + e);
                    return;
                }
            }
        });
        
        registroAnteriorJButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                String[] resultado;
                try{
                    String idanterior = idTextField.getText();
                    if (idanterior.equals("")) {
                        resultado = NavegadorDeRegistro.irParaRegistro("db_teste", "tbl_teste", "0", "primeiro");
                    } else {
                        resultado = NavegadorDeRegistro.irParaRegistro("db_teste", "tbl_teste", idanterior, "anterior");
                    }
                    notificacaoJLabel.setText("Registro anterior posicionado com sucesso");
                    idTextField.setText(resultado[0]);
                    nomeTextField.setText(resultado[1]);
                    emailTextField.setText(resultado[2]);
                    senhaPasswordField.setText(resultado[3]);
                    primeiroRegistroJButton.setEnabled(true);
                    registroAnteriorJButton.setEnabled(true);    
                    proximoRegistroJButton.setEnabled(true);
                    ultimoRegistroJButton.setEnabled(true);
                } catch(Exception e) {
                    primeiroRegistroJButton.setEnabled(false);
                    registroAnteriorJButton.setEnabled(false);
                    notificacaoJLabel.setText("Primeiro registro posicionado com sucesso");
                    return;
                }
            }
        });
        
        proximoRegistroJButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                String[] resultado;
                try{
                    String idanterior = idTextField.getText();
                    if (idanterior.equals("")) {
                        resultado = NavegadorDeRegistro.irParaRegistro("db_teste", "tbl_teste", "0", "primeiro");
                    } else {
                        resultado = NavegadorDeRegistro.irParaRegistro("db_teste", "tbl_teste", idanterior, "próximo");
                    }
                    notificacaoJLabel.setText("Próximo registro posicionado com sucesso");
                    idTextField.setText(resultado[0]);
                    nomeTextField.setText(resultado[1]);
                    emailTextField.setText(resultado[2]);
                    senhaPasswordField.setText(resultado[3]);
                    primeiroRegistroJButton.setEnabled(true);
                    registroAnteriorJButton.setEnabled(true);
                    proximoRegistroJButton.setEnabled(true);
                    ultimoRegistroJButton.setEnabled(true);
                } catch(Exception e) {
                    proximoRegistroJButton.setEnabled(false);
                    ultimoRegistroJButton.setEnabled(false);
                    notificacaoJLabel.setText("Ultimo registro posicionado com sucesso");
                    return;
                }
            }
        });
        
        ultimoRegistroJButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                String[] resultado;
                try{
                    resultado = NavegadorDeRegistro.irParaRegistro("db_teste", "tbl_teste", "0", "último");
                    notificacaoJLabel.setText("Ultimo registro posicionado com sucesso");
                    idTextField.setText(resultado[0]);
                    nomeTextField.setText(resultado[1]);
                    emailTextField.setText(resultado[2]);
                    senhaPasswordField.setText(resultado[3]);
                    primeiroRegistroJButton.setEnabled(true);
                    registroAnteriorJButton.setEnabled(true);
                    proximoRegistroJButton.setEnabled(false);
                    ultimoRegistroJButton.setEnabled(false);
                } catch(Exception e) {
                    System.out.println("Ocorreu erro ao executar o comando: " + e);
                    return;
                }
            }
        }); 
        
        add(idJLabel);
        add(idTextField);
        add(limparJButton);
        add(consultarJButton);

        add(nomeJLabel);
        add(nomeTextField);
        add(new JLabel());
        add(incluirJButton);

        add(emailJLabel);
        add(emailTextField);
        add(new JLabel());
        add(atualizarJButton);

        add(senhaJLabel);
        add(senhaPasswordField);
        add(new JLabel());
        add(excluirJButton);
        
        add(primeiroRegistroJButton);
        add(registroAnteriorJButton);
        add(proximoRegistroJButton);
        add(ultimoRegistroJButton);
        
        add(notificacaoJLabel);


        setSize(500, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        EditarCadastro application = new EditarCadastro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
