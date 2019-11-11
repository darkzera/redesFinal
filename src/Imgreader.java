package redesFinal;

import java.awt.*; 
import javax.swing.*; 

@SuppressWarnings("serial")
public class Imgreader extends JFrame
{    
  private Imgreader(String arg){
      if (arg == null ) {
        arg = "\\Users\\nicol\\Desktop\\ImagemRetornada.png";
    }      
    JPanel panel = new JPanel(); 
    
    //panel.setSize(800,940);
    this.getContentPane().add(panel);
    panel.setBackground(Color.darkGray); 
    ImageIcon icon = new ImageIcon(arg); 
    JLabel label = new JLabel(); 
    label.setIcon(icon); 
    panel.add(label);
    //this.getContentPane().add(panel);
    this.pack();
  }
  public static void main(String[] args) {
      new Imgreader(args.length == 0 ? null : args[0]).setVisible(true); 
  }
}
