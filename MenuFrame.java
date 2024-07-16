import java.awt.*;
import javax.swing.*;

public class MenuFrame extends JFrame {

    private final Color[] colorValues = {Color.RED, Color.BLUE, Color.RED, Color.GREEN};
    private final JRadioButtonMenuItem[] colorItems;
    private final JRadioButtonMenuItem[] fonts;
    private final JCheckBoxMenuItem[] styleItems;
    private final JLabel displayJLabel;
    private final ButtonGroup fontButtonGroup;
    private final ButtonGroup colorButtonGroup;
    private int style;
    


    public MenuFrame() {
        super("Menu");

       
        JMenu fileMenu = new JMenu("Arquivo");
        fileMenu.setMnemonic('F');

 
        JMenu formatMenu = new JMenu("Editar");

    
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(fileMenu);
        bar.add(formatMenu);

      
        colorItems = new JRadioButtonMenuItem[4]; 
        fonts = new JRadioButtonMenuItem[4]; 
        styleItems = new JCheckBoxMenuItem[4]; 
        fontButtonGroup = new ButtonGroup();
        colorButtonGroup = new ButtonGroup(); 

        displayJLabel = new JLabel("Java Senac", SwingConstants.CENTER);
        displayJLabel.setForeground(colorValues[0]); 
        displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72)); 



        getContentPane().setBackground(Color.black); 
        add(displayJLabel, BorderLayout.CENTER); 
    }

    public static void main(String[] args) {
        MenuFrame menuFrame = new MenuFrame();
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(400, 300); 
        menuFrame.setVisible(true); 
    }
}






   
