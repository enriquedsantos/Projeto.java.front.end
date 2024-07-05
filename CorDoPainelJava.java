import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class CorDoPainelJava extends JPanel 
{
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.RED);

      // set new drawing color using integers
      g.setColor(new Color(0, 0, 255));
      g.fillRect(330, 70, 300, 120);
      g.drawString("Senac " , 460, 65);

      // set new drawing color using floats
      g.setColor(new Color(255, 255, 255));
      g.fillRect(15, 70, 300, 120);
      g.drawString("Curso de Java ", 120, 65);
   }
}