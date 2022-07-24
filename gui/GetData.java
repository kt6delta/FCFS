package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logic.Cola;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class GetData extends JFrame implements ActionListener, KeyListener{

	private JPanel contentPane;
	private JLabel[] title=new JLabel[5];
	private JTextField[] llegada= new JTextField[5];
	private JTextField[] rafaga= new JTextField[5];
	private JButton btnStart; 
	private JLabel titulo[]= new JLabel[2];
	  private int x=80, y=50; //size celdas
	  private int p=50;//origin tabla
	  
	public GetData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Planificacion FCFS");
		lblNewLabel.setFont(new java.awt.Font("Verdana", 1, 14));
		lblNewLabel.setBounds(149, 12, 165, 26);
		contentPane.add(lblNewLabel);
		
		
		btnStart = new JButton();
		btnStart.setBounds(180, 368, x, y);
		btnStart.setBackground(new java.awt.Color(255, 102, 51));
		btnStart.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
		btnStart.setForeground(new java.awt.Color(255, 255, 255));
		btnStart.setText("Start");
		getContentPane().add(btnStart);
		btnStart.addActionListener(this);
		

		for(int f=0; f<5; f++) {
			title[f] = new JLabel("Proceso "+(f+1),SwingConstants.CENTER);
			title[f].setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
			title[f].setForeground(new java.awt.Color(0, 102, 102));
			title[f].setBounds(p, p+(f*y)+50 ,x,y);//posi(x,y)- tamaño(x,y)
			contentPane.add(title[f]);
		}
		
		for(int c=0; c<2; c++) {
			titulo[c]= new JLabel("",SwingConstants.CENTER);
			titulo[c].setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
			titulo[c].setBounds(p+(x*(c+2))-40, p+10 ,x,y-20);//2-3
			getContentPane().add(titulo[c]);
		}
		titulo[0].setText("T llegada");
		titulo[1].setText("Rafaga");
		
		
		for(int f=0; f<5; f++) {
			llegada[f] = new JTextField(SwingConstants.CENTER);
			llegada[f].setBounds(p+(x*2)-40, p+(f*y)+10+50 ,x,y-20);//posi(x,y)- tamaño(x,y)
			contentPane.add(llegada[f]);
			llegada[f].addKeyListener(this);
		}
		
		for(int f=0; f<5; f++) {
			rafaga[f] = new JTextField(SwingConstants.CENTER);
			rafaga[f].setBounds(p+(x*3), p+(f*y)+10+50 ,x,y-20);//posi(x,y)- tamaño(x,y)
			contentPane.add(rafaga[f]);
			rafaga[f].addKeyListener(this);
		}
		
	}
	
	  public void actionPerformed(ActionEvent e) {
		    if (e.getSource()==btnStart) {
				  int numdata=0; //1-5
			    	  	
				    for(int i=0; i<llegada.length; i++) {
				    	if((!rafaga[i].getText().equals("") && llegada[i].getText().equals("")) || (rafaga[i].getText().equals("") && !llegada[i].getText().equals("")) ) {
				    		JOptionPane.showMessageDialog(null,"complete los datos");
				    		numdata=0;
				    		break;
				    	}else {
				    		numdata++;
				    	}
				    }
			    	if(!(llegada[0].getText().equals("0"))&&!(llegada[1].getText().equals("0"))&&!(llegada[2].getText().equals("0"))&&!(llegada[3].getText().equals("0"))&&!(llegada[4].getText().equals("0"))) {
			    		JOptionPane.showMessageDialog(null,"tiene que haber un tiempo 0");
			    		numdata=0;
			    	}
			    	
				    if(numdata!=0) {
				    int[] deal = new int[numdata];
				    int[] Tllegada = new int[numdata];
				    for(int n=0; n<numdata; n++){
				      deal[n]=Integer.parseInt(rafaga[n].getText());
				      Tllegada[n]=Integer.parseInt(llegada[n].getText()); 
				    }
				    //Arrays.sort(Tllegada);
					for (int i = 0; i < Tllegada.length; i++) {
						for (int j = 0; j < Tllegada.length; j++) {
							if (Tllegada[i] < Tllegada[j]) {
								int temp = Tllegada[i];
								Tllegada[i] = Tllegada[j];
								Tllegada[j] = temp;
								
								int temp2= deal[i];
								deal[i] = deal[j];
								deal[j] = temp2;
								
							}
						}
					}

				    Tabla t = new Tabla(); 
				    Cola ct = new Cola(t); //colaT
				    ct.SetNum(numdata);
				    ct.setLlegada(Tllegada);
				    ct.SetDeal(deal);  
				    Gantt g= new Gantt();
				    Cola cg= new Cola(g); //colaG
				    cg.SetNum(numdata);
				    cg.SetDeal(deal); 
				    cg.setLlegada(Tllegada);
				    
				    cg.start();
				    ct.start();
				    
		      this.BorraData();
				    }
		      
		    }
		  }
	  
	  public void BorraData() {
			for(int f=0; f<5; f++) {
				rafaga[f].setText("");
				llegada[f].setText("");
			}
	  }
	  

	public void keyTyped(KeyEvent evt) {
	    int key = evt.getKeyChar();
	    boolean numeros = key >= 48 && key <= 57;
	        
	    if (!numeros)
	    {
	        evt.consume();
	    }
	    for(int i=0; i<rafaga.length; i++) {
		    if(evt.getSource()==rafaga[i]) {
			    if (rafaga[i].getText().trim().length() == 10) {
			        evt.consume();
			        break;
			    }
		    }
		    if(evt.getSource()==rafaga[i]) {
			    if (rafaga[i].getText().trim().length() == 10) {
			        evt.consume();
			        break;
			    }
		    }
	    }
		
	}

	public void keyReleased(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}   
}
