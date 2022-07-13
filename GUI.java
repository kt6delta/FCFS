import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants; 

public class GUI extends JFrame {
  private JPanel contentPane;
  
  //private int x=80, y=50; //size celdas
  private int p=50;//origin tabla
  private Font letra = new Font("Verdana", Font.PLAIN, 12);
  private JLabel[] title=new JLabel[7]; 
  JLabel[][] deal = new JLabel[5][7];
  public int[][] date= new int[5][2];
  
  private int x=20, y=58;//size entre lineas
  private int px=50,py=50;//origen linea
  private int lineV=30;

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

    public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.black);//verticales base
    for(int lv=0; lv<lineV+1; lv++){
      g.drawLine(px+(lv*x), py, px+(lv*x), py+5);//x1,y1,x2,y2
      if(lv%10 ==0){ //multiplo 10
        //escribe 10,20,30
      }
    }
    //horizontal base
    g.drawLine(px, py, px+(lineV*x), py);//x1,y1,x2,y2
      //vertical variable
    for(int lh=1; lh<6; lh++){//1<lh<6 == posicion
      for(int lv=0; lv<lineV+1; lv++){//lv= T.comienzo lineV=T.final
      g.drawLine(px+(lv*x), py+(y*lh), px+(lv*x), py+(y*lh)+5);//x1,y1,x2,y2
      }
    }
    for(int i=1; i<6; i++){//horizontales variable
      g.drawLine(px, py+(i*y), px+(lineV*x), py+(i*y));//x1,y1,x2,y2
    }  
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