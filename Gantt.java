import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Gantt extends JFrame{
  private JPanel contentPane;
  
  private int x=20, y=58;//size entre lineas
  private int px=50,py=50;//origen linea
  private int lineV=30;//#lines Verticales
  public int plH;//1<=plH<6 == posicion
  public int plVf,  plVi;  //plVi= T.comienzo plVf=T.final
  
  public Gantt(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0,0,700,450);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    setTitle("FCFS");
    setBackground(Color.lightGray);
    setVisible(true);
  }
  
  public void paint(Graphics g) {
    super.paint(g);
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
    for(int lv=plVi; lv<plVf+1; lv++){//vertical
     g.drawLine(px+(lv*x), py+(y*plH), px+(lv*x), py+(y*plH)+5);//x1,y1,x2,y2
    }
    //horizontal
    g.drawLine(px, py+(plH*y), px+(lineV*x), py+(plH*y));//x1,y1,x2,y2 
  }
}