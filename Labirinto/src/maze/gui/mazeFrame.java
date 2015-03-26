package maze.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mazeFrame {

	public static void main(String[] args) throws IOException {
		
		JFrame frame= new JFrame("Maze Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		frame.setBounds(100, 100, 500, 500);
		JPanel panel=new mazePanel();
		frame.getContentPane().add(panel);
		
		frame.setVisible(true);
		panel.requestFocus();
		
	}

	

}
