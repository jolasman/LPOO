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

public class Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
		
		JToggleButton tglbtnAleatrio = new JToggleButton("Aleat\u00F3rio");

		JToggleButton tglbtnEsttico = new JToggleButton("Est\u00E1tico");
		
		tglbtnAleatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnEsttico.setSelected(false);
			}
		});
		tglbtnAleatrio.setBounds(117, 13, 121, 23);
		contentPanel.add(tglbtnAleatrio);
		
		tglbtnEsttico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tglbtnAleatrio.setSelected(false);
			}
		});
		tglbtnEsttico.setBounds(248, 13, 121, 23);
		contentPanel.add(tglbtnEsttico);
		
		JLabel lblNDrages = new JLabel("N\u00FAmero de drag\u00F5es:");
		lblNDrages.setBounds(26, 84, 135, 14);
		contentPanel.add(lblNDrages);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(194, 82, 44, 17);
		contentPanel.add(formattedTextField);
		
		JLabel lblTamanhoDoLabirinto = new JLabel("Tamanho do labirinto:");
		lblTamanhoDoLabirinto.setBounds(26, 59, 135, 14);
		contentPanel.add(lblTamanhoDoLabirinto);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setEnabled(false);
		formattedTextField_1.setBounds(194, 57, 44, 17);
		contentPanel.add(formattedTextField_1);
		
		JLabel lblDragoAnda = new JLabel("Drag\u00E3o anda:");
		lblDragoAnda.setBounds(26, 109, 81, 14);
		contentPanel.add(lblDragoAnda);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Sim");
		tglbtnNewToggleButton.setBounds(172, 110, 66, 17);
		contentPanel.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnNo = new JToggleButton("Nao");
		tglbtnNo.setBounds(248, 110, 66, 17);
		contentPanel.add(tglbtnNo);
		
		JLabel lblDragoDeitaFogo = new JLabel("Drag\u00E3o deita fogo:");
		lblDragoDeitaFogo.setBounds(26, 139, 121, 14);
		contentPanel.add(lblDragoDeitaFogo);
		
		JToggleButton toggleButton = new JToggleButton("Sim");
		toggleButton.setBounds(172, 138, 66, 17);
		contentPanel.add(toggleButton);
		
		JToggleButton toggleButton_1 = new JToggleButton("Nao");
		toggleButton_1.setBounds(248, 138, 66, 17);
		contentPanel.add(toggleButton_1);
		
		JLabel lblDragoDorme = new JLabel("Drag\u00E3o dorme:");
		lblDragoDorme.setBounds(26, 164, 121, 14);
		contentPanel.add(lblDragoDorme);
		
		JToggleButton toggleButton_2 = new JToggleButton("Sim");
		toggleButton_2.setBounds(172, 166, 66, 17);
		contentPanel.add(toggleButton_2);
		
		JToggleButton toggleButton_3 = new JToggleButton("Nao");
		toggleButton_3.setBounds(248, 166, 66, 17);
		contentPanel.add(toggleButton_3);
		
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
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
