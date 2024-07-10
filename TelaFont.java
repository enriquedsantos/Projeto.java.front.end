import javax.swing.JFrame;

public class TelaFont
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Cores do Senac");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Tela colorJPanel = new Tela();
      frame.add(colorJPanel); 
      frame.setSize(160, 160);
      frame.setVisible(true);
   } 
   
}