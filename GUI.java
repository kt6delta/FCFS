import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants; 

public class GUI extends JFrame implements ActionListener{
  private int x=80, y=50; //size celdas
  private int p=50;//origin tabla
  public int[][] date= new int[5][2];

  
  private JButton btn;
  private JPanel contentPane;
  private Font letra = new Font("Verdana", Font.PLAIN, 12);
  private JLabel[] title=new JLabel[7]; 
  JLabel[][] deal = new JLabel[5][7];
  JTextField[][] txt = new JTextField[5][2];
  
  public GUI(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0,0,(int) Math.round(x*8.7),(y*10));
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    setTitle("FCFS");
    setBackground(Color.lightGray);
    setVisible(true);
    //btn
    btn= new JButton("Start");
    btn.setBounds(p+((int) Math.round(x*3.5)), (p+y)+(6*y),x,y);//posi(x,y)- tamaño(x,y)
    add(btn);
    btn.addActionListener(this);
    
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
        if(c==2){//date defaul
          deal[f][c] = new JLabel(""+f,SwingConstants.CENTER);
        }else{
          deal[f][c] = new JLabel("",SwingConstants.CENTER);
        }
        deal[f][c].setBounds(p+(c*x), (p+y)+(f*y), x,y);//posi(x,y)- tamaño(x,y)        
        deal[f][c].setBorder(BorderFactory.createLineBorder(Color.black));
        deal[f][c].setVerticalAlignment(SwingConstants.CENTER);
        deal[f][c].setFont(letra);
        add(deal[f][c]);
      }
    }
    //get datos
    for(int f = 0; f < 5; f++) { //primero columnas
      for(int c = 0; c < 2; c++) {
        txt[f][c] = new JTextField("",SwingConstants.CENTER);
        txt[f][c].setBounds(p+(c*x), (p+y)+(f*y),x,y);
        txt[f][c].setFont(letra);
        add(txt[f][c]);
      }
    }
    //date default
    txt[0][0].setText("1");
    txt[1][0].setText("2");
    txt[2][0].setText("3");
    txt[3][0].setText("4");
    txt[4][0].setText("5");
    
    txt[0][1].setText("8");
    txt[1][1].setText("4");
    txt[2][1].setText("9");
    txt[3][1].setText("5");
    txt[4][1].setText("2");
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==btn) {
      SeeTxt(false);
      for(int f=0; f<5; f++){
        for(int c=0; c<2; c++){
          date[f][c]=Integer.parseInt(txt[f][c].getText());
        }
      }
      Cola c = new Cola(this);
      for(int n=0; n<5; n++){
        c.Insert2(this.date[n][0],this.date[n][1],n);//id, rafaga,posicion
      }
    c.Calcula();
    c.DeployCola();
    System.out.println();
    c.Change();

    int l=1;
    int l2=0;
    //System.out.println("id cliente" +"  "+"transacciones");
    for(int i=0; i<10; i++){
      int num = (int)(Math.random()*4+2); //2-4
      for(int n=1; n<num; n++){
         c.Insert(l,(n+l2));
         l++;
       }
        if(l2==0){
          l2++;
        }
        c.Calcula();
        c.DeployCola();
        System.out.println();
        c.Change();
      }
    }
  }
  
  private void SeeTxt(boolean see){
    for(int f=0; f<5; f++){
      for(int c=0; c<2; c++){
        deal[f][c].setText(txt[f][c].getText());
        txt[f][c].setVisible(see);
      }
    }
  }
  public void BorraDeal(){
    for(int f=0; f<5; f++){
      for(int c=0; c<7; c++){
        deal[f][c].setText("");  
      }
    }
        
  }
}