package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gantt extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnExit; 
	public int tamaño;
	public int Tstart[],  Tdeal[], idName[]; //Procesos
	
	public void SeeGantt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 700, 450);
		contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    setTitle("FCFS");
	    setBackground(Color.lightGray);
	    setVisible(true);
	    
		panel = new JPanel();
		panel.setBounds(83, 79, 542, 250);
		contentPane.add(panel);
		
		btnExit = new JButton();
		btnExit.setBounds(300, 380, 80, 50);
		btnExit.setBackground(new java.awt.Color(255, 102, 51));
		btnExit.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
		btnExit.setForeground(new java.awt.Color(255, 255, 255));
		btnExit.setText("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				setVisible(false);
			}
			});
		btnExit.setBounds(297, 385, 117, 25);
		contentPane.add(btnExit);
		
		GraficaGantt();
	}
	public void initArray() {
		
		Tstart= new int[tamaño];
		Tdeal= new int[tamaño];
		idName= new int[tamaño];
	}
	
	public void GraficaGantt() {
		DefaultCategoryDataset datos = new DefaultCategoryDataset();
		
		for(int i=0; i<idName.length; i++) {
			datos.setValue(Tstart[i],"T. Espera",""+idName[i]);
			datos.setValue(Tdeal[i],"rafaga",""+idName[i]);
		}
		
		JFreeChart grafico = ChartFactory.createStackedBarChart("Diagrama de Gantt", "Proceso", "tiempo", datos, PlotOrientation.HORIZONTAL, true, true, false);
		ChartPanel p =new ChartPanel(grafico);
		p.setMouseWheelEnabled(true);
		p.setPreferredSize(new Dimension(400,200));
		
		panel.setLayout(new BorderLayout());
		panel.add(p, BorderLayout.NORTH);
		
		pack();
		repaint();
		setBounds(100, 100, 691, 453);
		
	}
	}
