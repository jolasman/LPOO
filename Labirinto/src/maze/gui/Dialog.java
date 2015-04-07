package maze.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int numDragoes=1;
	private int tamanho=10;
	private int modo=1; // 0 para aleatorio, 1 para estatico
	private int anda=2;  //1 para sim 2 para nao
	private int cospe=2;
	private int dorme=2;
	
	private int keyCima =KeyEvent.VK_UP;
	private int keyEsquerda=KeyEvent.VK_LEFT;
	private int keyDireita=KeyEvent.VK_RIGHT;
	private int keyBaixo=KeyEvent.VK_DOWN;
	
	
	public int getKeyCima() {
		return keyCima;
	}

	public void setKeyCima(int keyCima) {
		this.keyCima = keyCima;
	}

	public int getKeyEsquerda() {
		return keyEsquerda;
	}

	public void setKeyEsquerda(int keyEsquerda) {
		this.keyEsquerda = keyEsquerda;
	}

	public int getKeyDireita() {
		return keyDireita;
	}

	public void setKeyDireita(int keyDireita) {
		this.keyDireita = keyDireita;
	}

	public int getKeyBaixo() {
		return keyBaixo;
	}

	public void setKeyBaixo(int keyBaixo) {
		this.keyBaixo = keyBaixo;
	}

	JToggleButton tglbtnAleatrio = new JToggleButton("Aleat\u00F3rio");
	JToggleButton tglbtnEsttico = new JToggleButton("Est\u00E1tico");
	JToggleButton andaSim = new JToggleButton("Sim");
	JToggleButton andaNao = new JToggleButton("Nao");
	JToggleButton fogoSim = new JToggleButton("Sim");
	JToggleButton fogoNao = new JToggleButton("Nao");
	JToggleButton dormeSim = new JToggleButton("Sim");
	JToggleButton dormeNao = new JToggleButton("Nao");
	JFormattedTextField numeroDrag = new JFormattedTextField();
	JFormattedTextField tamanhoLab = new JFormattedTextField();
	
	public int getCospe() {
		return cospe;
	}
	
	public int getNumDragoes() {
		
		
		
		return numDragoes;
	}

	public int getTamanho() {
		
		return tamanho;
	}

	public int getModo() {
		return modo;
	}

	public int getAnda() {
		return anda;
	}

	public int getDorme() {
		return dorme;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog dialog = new Dialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialog() {
		setBounds(100, 100, 508, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNmeroDeDrages = new JLabel("Modo:");
		lblNmeroDeDrages.setBounds(26, 16, 81, 17);
		contentPanel.add(lblNmeroDeDrages);
		

		numeroDrag.setText("1");
	
		tamanhoLab.setText("10");

		tglbtnEsttico.setSelected(true);
		
		tglbtnAleatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnEsttico.setSelected(false);
				
				if(!tglbtnEsttico.isSelected())
					tglbtnAleatrio.setSelected(true);
				
				andaSim.setEnabled(true);
				andaNao.setEnabled(true);
				fogoSim.setEnabled(true);
				fogoNao.setEnabled(true);
				dormeSim.setEnabled(true);
				dormeNao.setEnabled(true);
				numeroDrag.setEnabled(true);
				tamanhoLab.setEnabled(true);
				
			}
		});
		tglbtnAleatrio.setBounds(117, 13, 121, 23);
		contentPanel.add(tglbtnAleatrio);
		
		tglbtnEsttico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tglbtnAleatrio.setSelected(false);
				
				
				if(!tglbtnAleatrio.isSelected())
					tglbtnEsttico.setSelected(true);
				
				andaSim.setEnabled(true);
				andaNao.setEnabled(true);
				fogoSim.setEnabled(false);
				fogoSim.setSelected(false);
				fogoNao.setSelected(true);
				fogoNao.setEnabled(false);
				dormeSim.setEnabled(true);
				dormeNao.setEnabled(true);
				numeroDrag.setEnabled(false);
				tamanhoLab.setEnabled(false);
				tamanhoLab.setText("10");
				numeroDrag.setText("1");
			}
		});
		tglbtnEsttico.setBounds(248, 13, 121, 23);
		contentPanel.add(tglbtnEsttico);
		
		JLabel lblNDrages = new JLabel("N\u00FAmero de drag\u00F5es:");
		lblNDrages.setBounds(26, 84, 135, 14);
		contentPanel.add(lblNDrages);
		
	
		numeroDrag.setEnabled(false);
		numeroDrag.setBounds(194, 82, 44, 17);
		contentPanel.add(numeroDrag);
		
		JLabel lblTamanhoDoLabirinto = new JLabel("Tamanho do labirinto:");
		lblTamanhoDoLabirinto.setBounds(26, 59, 135, 14);
		contentPanel.add(lblTamanhoDoLabirinto);
		
		
		tamanhoLab.setEnabled(false);
		tamanhoLab.setBounds(194, 57, 44, 17);
		contentPanel.add(tamanhoLab);
		
		JLabel lblDragoAnda = new JLabel("Drag\u00E3o anda:");
		lblDragoAnda.setBounds(26, 109, 81, 14);
		contentPanel.add(lblDragoAnda);
		
		andaSim.setEnabled(true);
		andaNao.setSelected(true);
		andaNao.setEnabled(true);
		
		andaSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				andaNao.setSelected(false);
				if(!andaNao.isSelected())
					andaSim.setSelected(true);
				
				
			}
		});
		
		andaNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				andaSim.setSelected(false);
				if(!andaSim.isSelected())
					andaNao.setSelected(true);
				
				
			}
		});
		andaSim.setBounds(172, 110, 66, 17);
		contentPanel.add(andaSim);
	
		andaNao.setBounds(248, 110, 66, 17);
		contentPanel.add(andaNao);
		
		JLabel lblDragoDeitaFogo = new JLabel("Drag\u00E3o deita fogo:");
		lblDragoDeitaFogo.setBounds(26, 139, 121, 14);
		contentPanel.add(lblDragoDeitaFogo);
		
		fogoNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fogoSim.setSelected(false);

				if(!fogoSim.isSelected())
					fogoNao.setSelected(true);
				
			}
		});
		fogoNao.setSelected(true);
		
		
		fogoSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fogoNao.setSelected(false);
				
				if(!fogoNao.isSelected())
					fogoSim.setSelected(true);
				
			}
		});
		fogoSim.setEnabled(false);
		fogoSim.setBounds(172, 138, 66, 17);
		contentPanel.add(fogoSim);
		
	
		fogoNao.setEnabled(false);
		fogoNao.setBounds(248, 138, 66, 17);
		contentPanel.add(fogoNao);
		
		JLabel lblDragoDorme = new JLabel("Drag\u00E3o dorme:");
		lblDragoDorme.setBounds(26, 164, 121, 14);
		contentPanel.add(lblDragoDorme);
		

		dormeNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dormeSim.setSelected(false);
				
				if(!dormeSim.isSelected())
					dormeNao.setSelected(true);
				
			}
		});
		
		dormeSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dormeNao.setSelected(false);
				if(!dormeNao.isSelected())
					dormeSim.setSelected(true);
			}
		});
		dormeSim.setEnabled(true);
		dormeSim.setBounds(172, 166, 66, 17);
		contentPanel.add(dormeSim);
		
	
		dormeNao.setSelected(true);
		dormeNao.setEnabled(true);
		dormeNao.setBounds(248, 166, 66, 17);
		contentPanel.add(dormeNao);
		
		JLabel lblComandos = new JLabel("Comandos:");
		lblComandos.setBounds(26, 219, 81, 17);
		contentPanel.add(lblComandos);
		
		JLabel labelCima = new JLabel("Up");
		JLabel lblDireita = new JLabel("Right");
		JLabel lblEsquerda = new JLabel("Left");
		JLabel lblBaixo = new JLabel("Down");
		
		
		
		JToggleButton btnCima = new JToggleButton("Cima");
		btnCima.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(btnCima.isSelected())
				labelCima.setText(KeyEvent.getKeyText(arg0.getKeyCode()));
				
				keyCima=arg0.getKeyCode();
				btnCima.setSelected(false);
			}
		});
		
		btnCima.setBounds(117, 219, 98, 17);
		contentPanel.add(btnCima);
		
		JToggleButton btnEsquerda = new JToggleButton("Esquerda");
		btnEsquerda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(btnEsquerda.isSelected())
					lblEsquerda.setText(KeyEvent.getKeyText(e.getKeyCode()));
				keyEsquerda=e.getKeyCode();
				btnEsquerda.setSelected(false);
				
			}
		});
		btnEsquerda.setBounds(117, 239, 98, 17);
		contentPanel.add(btnEsquerda);
		
		JToggleButton btnBaixo = new JToggleButton("Baixo");
		btnBaixo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(btnBaixo.isSelected())
					lblBaixo.setText(KeyEvent.getKeyText(e.getKeyCode()));
				keyBaixo=e.getKeyCode();
				
				btnBaixo.setSelected(false);
			}
		});
		btnBaixo.setBounds(117, 276, 98, 17);
		contentPanel.add(btnBaixo);
		
		JToggleButton btnDireita = new JToggleButton("Direita");
		btnDireita.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(btnDireita.isSelected())
					lblDireita.setText(KeyEvent.getKeyText(e.getKeyCode()));
				keyDireita=e.getKeyCode();
				btnDireita.setSelected(false);
				
			}
		});
		btnDireita.setBounds(117, 257, 98, 17);
		contentPanel.add(btnDireita);
		
		
		labelCima.setBounds(248, 219, 98, 15);
		contentPanel.add(labelCima);
		lblEsquerda.setBounds(248, 240, 98, 15);
		contentPanel.add(lblEsquerda);
		
		lblDireita.setBounds(248, 258, 98, 15);
		contentPanel.add(lblDireita);
		
	
		lblBaixo.setBounds(248, 277, 98, 15);
		contentPanel.add(lblBaixo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							numDragoes= Integer.parseInt(numeroDrag.getText());
							
						}
						catch (NumberFormatException ex){
							
						 JOptionPane.showMessageDialog(null,"Carater em Nº dragões incorreto.\nValor 1 será usado.","Aviso",JOptionPane.WARNING_MESSAGE);	
							numDragoes=1;
							numeroDrag.setText("1");
						}
						
						try {
							tamanho= Integer.parseInt(tamanhoLab.getText());
							
						}
						catch (NumberFormatException ex){
							 JOptionPane.showMessageDialog(null,"Carater em tamanho do labirinto incorreto.\nValor 10 será usado.","Aviso",JOptionPane.WARNING_MESSAGE);	
							tamanhoLab.setText("10");
							tamanho=10;
						}
					
						
						
						if(tglbtnAleatrio.isSelected())
							modo=0;
						else if(tglbtnEsttico.isSelected())
							modo=1;
						
						if(andaSim.isSelected())
							anda=1;
						else if(andaNao.isSelected())
							anda=2;
						
						if(dormeSim.isSelected())
							dorme=1;
						else if(dormeNao.isSelected())
							dorme=2;
						
						if(fogoSim.isSelected())
							cospe=1;
						else if(fogoNao.isSelected())
							cospe=2;
						
						
						setVisible(false);
						
						
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
