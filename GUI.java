import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame{
  private JPanel contentPane;

  public JLabel txt,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,deal1,deal2,deal3,deal4,deal5,deal6,deal7,deal8,deal9,deal10;

  
  public GUI(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    setBounds(0,0,500,600);
    setTitle("banco");

    txt=new JLabel("Caja");
    txt.setBounds(225,25,50,25);//posi(x,y)- tamaño(x,y)
    add(txt);
  
    id1=new JLabel("");
    id1.setBounds(245, 75, 50, 25);
    add(id1);
    deal1=new JLabel("");
    deal1.setBounds(245, 100, 50, 25);
    add(deal1);
    
    id2=new JLabel("");
    id2.setBounds(170, 225,50,25);
    add(id2);
    deal2=new JLabel("");
    deal2.setBounds(170, 250,50,25);
    add(deal2);
    
    id3=new JLabel("");
    id3.setBounds(245, 225,50,25);
    add(id3);
    deal3=new JLabel("");
    deal3.setBounds(245, 250,50,25);
    add(deal3);
    
    id4=new JLabel("");
    id4.setBounds(320, 225,50,25);
    add(id4);
    deal4=new JLabel("");
    deal4.setBounds(320, 250,50,25);
    add(deal4);

    id5=new JLabel("");
    id5.setBounds(170, 300,50,25);
    add(id5);
    deal5=new JLabel("");
    deal5.setBounds(170, 325,50,25);
    add(deal5);
    
    id6=new JLabel("");
    id6.setBounds(245, 300,50,25);
    add(id6);
    deal6=new JLabel("");
    deal6.setBounds(245, 325,50,25);
    add(deal6);
    
    id7=new JLabel("");
    id7.setBounds(320, 300,50,25);
    add(id7);
    deal7=new JLabel("");
    deal7.setBounds(320, 325,50,25);
    add(deal7);
    
    id8=new JLabel("");
    id8.setBounds(170, 375,50,25);
    add(id8);
    deal8=new JLabel("");
    deal8.setBounds(170, 400,50,25);
    add(deal8);
    
    id9=new JLabel("");
    id9.setBounds(245,375,50,25);
    add(id9);
    deal9=new JLabel("");
    deal9.setBounds(245,400,50,25);
    add(deal9);
    
    id10=new JLabel("");
    id10.setBounds(320, 375,50,25);
    add(id10);
    deal10=new JLabel("");
    deal10.setBounds(320, 400,50,25);
    add(deal10);
  }
    
  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.blue);
    g.drawLine(100, 100, 400, 100);//x1,y1,x2,y2
    g.drawLine(100, 0, 100, 100);
    g.drawLine(400, 0, 400, 100);
    
    g.setColor (Color.red);
    
    g.drawOval (225, 100, 50, 50);//x,y 1
    g.drawOval (150, 250, 50, 50);//x,y 2
    g.drawOval (225, 250, 50, 50);//x,y 3
    g.drawOval (300, 250, 50, 50);//x,y 4
    
    g.drawOval (150, 325, 50, 50);//x,y 5
    g.drawOval (225, 325, 50, 50);//x,y 6
    g.drawOval (300, 325, 50, 50);//x,y 7 

    g.drawOval (150, 400, 50, 50);//x,y 8
    g.drawOval (225, 400, 50, 50);//x,y 9
    g.drawOval (300, 400, 50, 50);//x,y 10
    }
}