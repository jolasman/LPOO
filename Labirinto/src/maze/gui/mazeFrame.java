package maze.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class mazeFrame extends JFrame{
	
		private JFrame frame;
	 private CardLayout cl = new CardLayout();
	 private JButton firstPanel ;
	 private mazePanel secondPanel;
	 
	 public mazeFrame() throws IOException {
			JFrame frame= new JFrame("Maze Frame");
				firstPanel= new JButton("Novo Jogo");
			 	secondPanel = new mazePanel();
			
			 
			 
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(500, 500);
	        setLayout(cl);
	        
	  

	        add(firstPanel, "first");
	        add(secondPanel, "second");
	    
	        firstPanel.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					switchPanel("second");
					secondPanel.requestFocus();
				}
	        	
	        });
	        
	       
	        
	        
	    	        	
	        
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }
	 
	 public void switchPanel(String name) {
	        cl.show(getContentPane(), name);
	    }
	 
	 public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	try {
						mazeFrame window = new mazeFrame();
						
					} catch (Exception e) {
						e.printStackTrace();
					}	                
	            }
	        });
	    }
	


}
