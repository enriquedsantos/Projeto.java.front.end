import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class Tela extends JPanel 
{
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.RED);

   

      
      g.setColor(Color.BLACK);
      g.fillRect(20, 40, 100, 50);
      g.setColor(Color.blue);
      g.setFont(new Font("Monospaced", Font.ITALIC, 22)); 
      g.drawString("Senac " , 38, 70);
      

   }
}