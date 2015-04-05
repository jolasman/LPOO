package maze.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;

import java.awt.GridLayout;

import net.miginfocom.swing.MigLayout;

import java.awt.Component;

import javax.swing.LayoutStyle.ComponentPlacement;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JSplitPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.SystemColor;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.SwingConstants;

public class jogo {

	JTextField textField = new JTextField(25);

	private JFrame frame;
	private JPanel painelJogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jogo window = new jogo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public jogo() throws IOException {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel parentPanel = new JPanel();
		parentPanel.setBackground(Color.MAGENTA);
		frame.getContentPane().add(parentPanel, BorderLayout.CENTER);
		parentPanel.setLayout(new CardLayout(0, 0));
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		parentPanel.add(panel_2, "name_5355690780279");
		panel_2.setLayout(new CardLayout(0, 0));
		panel_2.setFocusable(true);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_5.setForeground(Color.BLACK);
		panel_2.add(panel_5, "name_7681047023173");
	
		painelJogo = new mazePanel();
		panel_2.add(painelJogo, "name_7868442625847");
		painelJogo.setFocusable(true);
		
		
		JButton btnNewButton = new JButton("Novo Jogo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					painelJogo = new mazePanel();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				panel_2.removeAll();
				panel_2.add(painelJogo);
				panel_2.repaint();
				painelJogo.requestFocus();
				panel_2.revalidate();
				
			}
		});
		panel_5.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_2.add(panel_1, "name_7667436044093");
		
		JButton btnNewButton_1 = new JButton("Configurações");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.removeAll();
				panel_2.add(panel_1);
				panel_2.repaint();
				panel_2.revalidate();
			}
		});
		panel_5.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.removeAll();
				panel_2.add(panel_5);
				panel_2.repaint();
				panel_2.revalidate();
				
			}
		});
		panel_1.add(btnNewButton_2);
		
		
	
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton button_1 = new JButton("Close");
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(Color.RED);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		JButton button = new JButton("Menu");
		button.setBackground(Color.RED);
		button.setForeground(Color.BLACK);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentPanel.removeAll();
				parentPanel.add(panel_2);
				panel_2.removeAll();
				panel_2.add(panel_5);
				panel_2.repaint();
				panel_2.revalidate();
				parentPanel.repaint();
				parentPanel.revalidate();
				
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(button);
		panel.add(button_1);
		
		
		
	
		
		
	}
}
