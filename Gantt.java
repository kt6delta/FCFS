import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants; 

public class Gantt extends JFrame{
  private JPanel contentPane;
  private Font letra = new Font("Verdana", Font.PLAIN, 12);
  
  private int x=20, y=58;//size entre lineas
  private int px=50,py=50;//origen linea
  private int lineV=35;//#lines Verticales
  public int plH;//1<=plH<6 == posicion
  public int plVf,  plVi;  //plVi= T.comienzo plVf=T.final
  JLabel[]title = new JLabel[6];
  public int name; //Proceso
  
  public Gantt(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0,0,750,450);
    setLocation(0, 400);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    setTitle("FCFS");
    setBackground(Color.lightGray);
    setVisible(true);
    for(int f=1; f<6; f++){
      title[f] = new JLabel("",SwingConstants.CENTER);
    }
  }
  
  public void Empty(){
    for(int f=1; f<6; f++){
      title[f].setText("");
    }
  }
  public void idProceso(){//title
    int f=plH;
      if(f>0 && f<6){//1-5
      title[f].setText(""+name);
      title[f].setBounds(px, py+(y*f), 25,25);
      title[f].setBorder(BorderFactory.createLineBorder(Color.black));
      title[f].setVerticalAlignment(SwingConstants.CENTER);
      title[f].setFont(letra);
      add(title[f]);
    }
  }
  
  
  public void paint(Graphics g) {
    System.out.println("dibuje i="+plVi+" f="+plVf);
    //super.paint(g);
    g.setColor(Color.black);//verticales base
    for(int lv=0; lv<lineV+1; lv++){
      g.drawLine(px+(lv*x), py, px+(lv*x), py+5);//x1,y1,x2,y2
      if(lv%10 ==0){ //#guia
        g.drawString(""+lv, px+(lv*x),  py+5+12);
      }
    }
    //horizontal base
    g.drawLine(px, py, px+(lineV*x), py);//x1,y1,x2,y2
    //variable
    if(plVf!=0){
      for(int lv=plVi; lv<plVf+1; lv++){//vertical
        g.drawLine(px+(lv*x), py+(y*plH), px+(lv*x), py+(y*plH)+5);//x1,y1,x2,y2
        if(lv ==plVi || lv ==(plVf)){ //#guia
          g.drawString(""+lv, px+(lv*x),  py+(y*plH)+5+12);
      }
    }
      //horizontal
      g.drawLine(px+(plVi*x), py+(plH*y), px+(plVf*x), py+(plH*y));//x1,y1,x2,y2 
    }
  }
}