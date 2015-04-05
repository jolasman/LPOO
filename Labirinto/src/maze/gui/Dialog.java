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
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int numDragoes=1;
	private int tamanho=10;
	private int modo=1; // 0 para aleatorio, 1 para estatico
	private int anda=2;
	private int cospe=2;
	private int dorme=2;
	
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
		
		andaSim.setEnabled(false);
		andaNao.setSelected(true);
		andaNao.setEnabled(false);
		
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
		dormeSim.setEnabled(false);
		dormeSim.setBounds(172, 166, 66, 17);
		contentPanel.add(dormeSim);
		
	
		dormeNao.setSelected(true);
		dormeNao.setEnabled(false);
		dormeNao.setBounds(248, 166, 66, 17);
		contentPanel.add(dormeNao);
		
		JLabel lblComandos = new JLabel("Comandos:");
		lblComandos.setBounds(26, 243, 81, 17);
		contentPanel.add(lblComandos);
		
		JLabel lblCima = new JLabel("Cima");
		lblCima.setHorizontalAlignment(SwingConstants.CENTER);
		lblCima.setBounds(221, 213, 46, 14);
		contentPanel.add(lblCima);
		
		JLabel lblEsquerda = new JLabel("Esquerda");
		lblEsquerda.setHorizontalAlignment(SwingConstants.CENTER);
		lblEsquerda.setBounds(117, 244, 66, 14);
		contentPanel.add(lblEsquerda);
		
		JLabel lblBaixo = new JLabel("Baixo");
		lblBaixo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaixo.setBounds(221, 272, 46, 14);
		contentPanel.add(lblBaixo);
		
		JLabel lblDireita = new JLabel("Direita");
		lblDireita.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireita.setBounds(323, 244, 46, 14);
		contentPanel.add(lblDireita);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						numDragoes= Integer.parseInt(numeroDrag.getText());
						tamanho= Integer.parseInt(tamanhoLab.getText());
						
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
