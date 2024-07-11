import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;


public class LinesRectsOvalsJPanel extends JPanel 
{
   // display various lines, rectangles and ovals
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.WHITE);

      g.setColor(Color.RED);
      g.drawLine(5, 30, 380, 30);
      g.setFont(new Font("Senac", Font.ITALIC, 22)); 
      g.drawString("Um" , 170, 28);

      g.setColor(Color.BLUE);
      g.drawRect(5, 40, 90, 55);
      g.setFont(new Font("Senac", Font.ITALIC, 22)); 
      g.drawString("Dois" , 20, 75);
      
      g.fillRect(100, 40, 90, 55);
      g.setColor(Color.BLACK);
      g.setFont(new Font("Senac", Font.ITALIC, 22)); 
      g.drawString("Três" , 115, 75);

      g.setColor(Color.BLACK);
      g.fillRoundRect(195, 40, 90, 55, 50, 50);
      g.setColor(Color.CYAN);
      g.setFont(new Font("Senac", Font.ROMAN_BASELINE, 22)); 
      g.drawString("Quatro" , 210, 75);

      g.drawRoundRect(290, 40, 90, 55, 20, 20);
      g.setFont(new Font("Senac", Font.ROMAN_BASELINE, 22)); 
      g.drawString("Cinco" , 310, 75);

      g.setColor(Color.GREEN);   
      g.draw3DRect(5, 100, 90, 55, false); 
      g.setFont(new Font("Senac", Font.BOLD, 22)); 
      g.drawString("Seis" , 20, 135);

      g.fill3DRect(100, 100, 90, 55, true);
      g.setFont(new Font("Senac", Font.BOLD, 22));
      g.setColor(Color.magenta); 
      g.drawString("Sete" , 115, 135);

      g.setColor(Color.MAGENTA);
      g.drawOval(195, 100, 90, 55);
      g.setFont(new Font("Senac", Font.PLAIN, 22)); 
      g.drawString("Oito" , 220, 135);

      g.fillOval(290, 100, 90, 55);
      g.setColor(Color.black);
      g.setFont(new Font("Senac", Font.BOLD, 22));
      g.drawString("Nove" , 305, 135);

   }
}