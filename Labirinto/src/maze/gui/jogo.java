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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

public class jogo {

	JTextField textField = new JTextField(25);

	private JFrame frame;
	private JPanel painelJogo;
	Dialog dialog = new Dialog();

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
		JPanel painelBisavo = new JPanel();
		painelBisavo.setBackground(Color.MAGENTA);
		frame.getContentPane().add(painelBisavo, BorderLayout.CENTER);
		painelBisavo.setLayout(new CardLayout(0, 0));
		
		
		JPanel painelAvo = new JPanel();
		painelAvo.setBackground(Color.GRAY);
		painelBisavo.add(painelAvo, "name_5355690780279");
		painelAvo.setLayout(new CardLayout(0, 0));
		painelAvo.setFocusable(true);
		
		JPanel painelPai = new JPanel();
		painelPai.setBackground(Color.LIGHT_GRAY);
		painelPai.setForeground(Color.BLACK);
		painelAvo.add(painelPai, "name_7681047023173");
	
		painelJogo = new JPanel();
		painelJogo.setBackground(Color.BLACK);
		painelAvo.add(painelJogo, "name_7868442625847");
		painelJogo.setFocusable(true);
		
		
		
		JPanel painelConfig = new JPanel();
	
		JButton newGame = new JButton("Novo Jogo");
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					painelJogo= new mazePanel(dialog.getModo(),dialog.getNumDragoes(),dialog.getTamanho(),dialog.getCospe(),
							dialog.getAnda(),dialog.getDorme());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				painelAvo.removeAll();
				painelAvo.add(painelJogo);
				painelAvo.repaint();
				painelJogo.requestFocus();
				painelAvo.revalidate();
				
			}
		});
		painelPai.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		painelPai.add(newGame);
		
		JButton configurations = new JButton("Configurações");
		configurations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAvo.removeAll();
				painelAvo.add(painelConfig);
				painelAvo.repaint();
				painelAvo.revalidate();
				dialog.setVisible(true);
			}
		});
		
		JButton continuar = new JButton("Continuar");
		continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				painelAvo.removeAll();
				painelAvo.add(painelJogo);
				painelAvo.repaint();
				painelJogo.requestFocus();
				painelAvo.revalidate();
				
			}
		});
		painelPai.add(continuar);
		painelPai.add(configurations);
		
		
		painelConfig.setBackground(Color.LIGHT_GRAY);
		painelAvo.add(painelConfig, "name_7667436044093");
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAvo.removeAll();
				painelAvo.add(painelPai);
				painelAvo.repaint();
				painelAvo.revalidate();

			}
		});
		painelConfig.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		painelConfig.add(btnNewButton_2);
		
		
	
		
		
		JPanel painelMenuClose = new JPanel();
		painelMenuClose.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(painelMenuClose, BorderLayout.NORTH);
		
		JButton close = new JButton("Close");
		close.setForeground(Color.BLACK);
		close.setBackground(UIManager.getColor("Button.background"));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		JButton menu = new JButton("Menu");
		menu.setBackground(UIManager.getColor("Button.background"));
		menu.setForeground(Color.BLACK);
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				painelBisavo.removeAll();
				painelBisavo.add(painelAvo);
				painelAvo.removeAll();
				painelAvo.add(painelPai);
				painelAvo.repaint();
				painelAvo.revalidate();
				painelBisavo.repaint();
				painelBisavo.revalidate();
				
			}
		});
		painelMenuClose.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		painelMenuClose.add(menu);
		painelMenuClose.add(close);
		
		
		
	
		
		
	}
}
