import javax.swing.JFrame;

public class ApresentacaoDasCores
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Using colors");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      CorDoPainelJava colorJPanel = new CorDoPainelJava();
      frame.add(colorJPanel); 
      frame.setSize(400, 180);
      frame.setVisible(true);
   } 
}