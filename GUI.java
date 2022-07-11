import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame{
  private JPanel contentPane;
  int x,y=60; //tamaño celdas
  int p=50;//origen tabla
  public JLabel 
  t1,t2,t3,t4,t5,t6,t7,
  deal1,deal2,deal3,deal4,deal5,
  arrive1,arrive2,arrive3,arrive4,arrive5,
  burst1,burst2,burst3,burst4,burst5,
  start1,start2,start3,start4,start5,
  end1,end2,end3,end4,end5,
  back1,back2,back3,back4,back5,
  wait1,wait2,wait3,wait4,wait5;

  
  public GUI(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    setBounds(0,0,500,700);
    setTitle("FCFS");
    //titles
    t1=new JLabel("Proceso");
    t1.setBounds(245, 75, 50, 25);//posi(x,y)- tamaño(x,y)
    add(t1);
    t2=new JLabel("T. llegada");
    t2.setBounds(170, 225,50,25);
    add(t2);
    t3=new JLabel("Rafaga");
    t3.setBounds(245, 225,50,25);
    add(t3);
    t4=new JLabel("T. comienzo");
    t4.setBounds(320, 225,50,25);
    add(t4);
    t5=new JLabel("T. final");
    t5.setBounds(170, 300,50,25);
    add(t5);
    t6=new JLabel("T. retorno");
    t6.setBounds(245, 300,50,25);
    add(t6);
    t7=new JLabel("T. espera");
    t7.setBounds(320, 300,50,25);
    add(t7);
    //procesos
    deal1=new JLabel("A");
    deal1.setBounds(245, 100, 50, 25);
    add(deal1);
    deal2=new JLabel("B");
    deal2.setBounds(170, 250,50,25);
    add(deal2);
    deal3=new JLabel("C");
    deal3.setBounds(245, 250,50,25);
    add(deal3);
    deal4=new JLabel("D");
    deal4.setBounds(320, 250,50,25);
    add(deal4);
    deal5=new JLabel("E");
    deal5.setBounds(170, 325,50,25);
    add(deal5);
    //T. llegada
    arrive1=new JLabel("12");
    arrive1.setBounds(245, 325,50,25);
    add(arrive1);
    arrive2=new JLabel("14");
    arrive2.setBounds(320, 325,50,25);
    add(arrive2);
    arrive3=new JLabel("15");
    arrive3.setBounds(170, 375,50,25);
    add(arrive3);
    arrive4=new JLabel("16");
    arrive4.setBounds(170, 400,50,25);
    add(arrive4);
    arrive5=new JLabel("17");
    arrive5.setBounds(245,375,50,25);
    add(arrive5);
    //rafaga
    burst1=new JLabel("19");
    burst1.setBounds(320, 375,50,25);
    add(burst1);
    burst2=new JLabel("18");
    burst2.setBounds(245,400,50,25);
    add(burst2);
    burst3=new JLabel("20");
    burst3.setBounds(320, 400,50,25);
    add(burst3);
    burst4=new JLabel("19");
    burst4.setBounds(320, 375,50,25);
    add(burst4);
    burst5=new JLabel("18");
    burst5.setBounds(245,400,50,25);
    add(burst5);
    //T. comienzo
    burst1=new JLabel("19");
    burst1.setBounds(320, 375,50,25);
    add(burst1);
    burst2=new JLabel("18");
    burst2.setBounds(245,400,50,25);
    add(burst2);
    burst3=new JLabel("20");
    burst3.setBounds(320, 400,50,25);
    add(burst3);
    burst4=new JLabel("19");
    burst4.setBounds(320, 375,50,25);
    add(burst4);
    burst5=new JLabel("18");
    burst5.setBounds(245,400,50,25);
    add(burst5);
    //T. final
    burst1=new JLabel("19");
    burst1.setBounds(320, 375,50,25);
    add(burst1);
    burst2=new JLabel("18");
    burst2.setBounds(245,400,50,25);
    add(burst2);
    burst3=new JLabel("20");
    burst3.setBounds(320, 400,50,25);
    add(burst3);
    burst4=new JLabel("19");
    burst4.setBounds(320, 375,50,25);
    add(burst4);
    burst5=new JLabel("18");
    burst5.setBounds(245,400,50,25);
    add(burst5);
    //T. retorno
    burst1=new JLabel("19");
    burst1.setBounds(320, 375,50,25);
    add(burst1);
    burst2=new JLabel("18");
    burst2.setBounds(245,400,50,25);
    add(burst2);
    burst3=new JLabel("20");
    burst3.setBounds(320, 400,50,25);
    add(burst3);
    burst4=new JLabel("19");
    burst4.setBounds(320, 375,50,25);
    add(burst4);
    burst5=new JLabel("18");
    burst5.setBounds(245,400,50,25);
    add(burst5);
    //T. espera
    
    
  }
  
  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.black);//verticales
    g.drawLine(p      , p, p      , p+y);//x1,y1,x2,y2
    g.drawLine(p+x    , p, p+x    , p+y);
    g.drawLine(p+(2*x), p, p+(2*x), p+y);
    g.drawLine(p+(3*x), p, p+(3*x), p+y);
    g.drawLine(p+(4*x), p, p+(4*x), p+y);
    g.drawLine(p+(5*x), p, p+(5*x), p+y);
    g.drawLine(p+(6*x), p, p+(6*x), p+y);
    g.drawLine(p+(7*x), p, p+(7*x), p+y);
    //horizontales
    g.drawLine(p, p      , p+(7*x), p);//x1,y1,x2,y2
    g.drawLine(p, p+y    , p+(7*x), p+y);
    g.drawLine(p, p+(y*2), p+(7*x), p+(y*2));
    g.drawLine(p, p+(y*3), p+(7*x), p+(y*3));
    g.drawLine(p, p+(y*4), p+(7*x), p+(y*4));
    g.drawLine(p, p+(y*5), p+(7*x), p+(y*5));
    g.drawLine(p, p+(y*6), p+(7*x), p+(y*6));

    
    g.setColor(Color.blue);//division
    g.drawLine(p, p+(y*8), p+(7*x), p+(y*8));
    
    }
}