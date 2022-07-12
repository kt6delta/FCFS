import java.awt.Color;
//import java.awt.Graphics;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants; 

public class GUI extends JFrame{
  private JPanel contentPane;
  private int x=80, y=50; //size celdas
  private int p=50;//origin tabla

  private Font letra = new Font("Verdana", Font.PLAIN, 12);
  private JLabel[] title=new JLabel[7]; 
  JLabel[][] deal = new JLabel[5][7];
  JTextField[][] txt = new JTextField[5][7];
  
  public GUI(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    setBounds(0,0,700,500);
    setTitle("FCFS");
    setBackground(Color.lightGray);
    setVisible(true);

    //titles
    for(int c = 0; c < 7; c++) {
      title[c] = new JLabel("",SwingConstants.CENTER);
      title[c].setBounds(p+(c*x), p,x,y);//posi(x,y)- tamaño(x,y)
      title[c].setBorder(BorderFactory.createLineBorder(Color.blue));
      add(title[c]);
     }
    title[0].setText("Proceso");
    title[1].setText("T.llegada");
    title[2].setText("Rafaga");
    title[3].setText("T.comienzo");
    title[4].setText("T.final");
    title[5].setText("T.retorno");
    title[6].setText("T.espera");

    //procesos
    for(int f = 0; f < 5; f++) { //primero columnas
      for(int c = 0; c < 7; c++) {
        deal[f][c] = new JLabel("",SwingConstants.CENTER);
        deal[f][c].setBounds(p+(c*x), (p+y)+(f*y),x,y);//posi(x,y)- tamaño(x,y)
        deal[f][c].setText("Dato"+f+" "+c);             
        deal[f][c].setBorder(BorderFactory.createLineBorder(Color.blue));
        deal[f][c].setVerticalAlignment(SwingConstants.CENTER);
        deal[f][c].setFont(letra);
        add(deal[f][c]);
        txt[f][c] = new JTextField("",SwingConstants.CENTER);
        txt[f][c].setBounds(p+(c*x), (p+y)+(f*y),x,y);
      }
    }
    //SeeTxt();
  }
  public void SeeTxt(){
    for(int f=0; f<5; f++){
      for(int c=0; c<7; c++){
        add(txt[f][c]);
      }
    }
  }
  /*
  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.black);//verticales
    for(int i=0; i<7; i++){
      g.drawLine(p+(i*x), p, p+(i*x), p+(y*6));//x1,y1,x2,y2
    }
    //horizontales
    for(int i=0; i<7; i++){
      g.drawLine(p, p+(i*y), p+(7*x), p+(i*y));//x1,y1,x2,y2
    }
    
    }
  */
}