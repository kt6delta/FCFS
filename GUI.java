import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants; 

public class GUI extends JFrame {
  private int x=80, y=50; //size celdas
  private int p=50;//origin tabla
  public int[][] date= new int[5][2];


  private JPanel contentPane;
  private Font letra = new Font("Verdana", Font.PLAIN, 12);
  private JLabel[] title=new JLabel[7]; 
  JLabel[][] deal = new JLabel[5][7];

  public GUI(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0,0,700,450);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    setTitle("FCFS");
    setBackground(Color.lightGray);
    setVisible(true);
    
    //this.SeeTabla();
  }
  
  public void SeeTabla(){
    //titles
    for(int c = 0; c < 7; c++) {
      title[c] = new JLabel("",SwingConstants.CENTER);
      title[c].setBounds(p+(c*x), p,x,y);//posi(x,y)- tamaño(x,y)
      title[c].setBorder(BorderFactory.createLineBorder(Color.black));
      add(title[c]);
     }
    title[0].setText("Proceso");
    title[1].setText("Rafaga");
    title[2].setText("T.llegada");
    title[3].setText("T.comienzo");
    title[4].setText("T.final");
    title[5].setText("T.retorno");
    title[6].setText("T.espera");

    //procesos
    for(int f = 0; f < 5; f++) { //primero columnas
      for(int c = 0; c < 7; c++) {
        switch(c){//date defaul
          case 0:
            deal[f][c] = new JLabel(""+(f+1),SwingConstants.CENTER);
            break;
          case 2:
            deal[f][c] = new JLabel(""+f,SwingConstants.CENTER);
            break;
          default:
            deal[f][c] = new JLabel("",SwingConstants.CENTER);
            break;
        }
        deal[f][c].setBounds(p+(c*x), (p+y)+(f*y), x,y);//posi(x,y)- tamaño(x,y)        
        deal[f][c].setBorder(BorderFactory.createLineBorder(Color.black));
        deal[f][c].setVerticalAlignment(SwingConstants.CENTER);
        deal[f][c].setFont(letra);
        add(deal[f][c]);
      }
    }
    deal[0][1].setText("8");
    deal[1][1].setText("4");
    deal[2][1].setText("9");
    deal[3][1].setText("5");
    deal[4][1].setText("2");
  }
  
  public void BorraDeal(){
    for(int f=0; f<5; f++){
      for(int c=0; c<7; c++){
        deal[f][c].setText("");  
      }
    }
        
    }

}