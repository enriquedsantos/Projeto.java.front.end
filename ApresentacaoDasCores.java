import javax.swing.JFrame;

public class ApresentacaoDasCores
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Cores do Senac");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      CorDoPainelJava colorJPanel = new CorDoPainelJava();
      frame.add(colorJPanel); 
      frame.setSize(660, 300);
      frame.setVisible(true);
   } 
}