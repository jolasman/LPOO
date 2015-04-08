package maze.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import maze.logic.Jogo;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;

public class JogoGUI {

	JTextField textField = new JTextField(25);

	private JFrame frame;
	private MazePanel painelJogo =new MazePanel();
	private Construcao painelDesenho = new Construcao();
	JSplitPane splitPane = new JSplitPane();
	Dialog dialog = new Dialog();
	private boolean jogoIniciado=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogoGUI window = new JogoGUI();
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
	public JogoGUI() throws IOException {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
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

		JPanel painelPai = new JPanel();
		painelPai.setBackground(Color.LIGHT_GRAY);
		painelPai.setForeground(Color.BLACK);
		painelAvo.add(painelPai, "name_7681047023173");




		JButton continuar = new JButton("Continuar");
		continuar.setFocusable(false);
		continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				if(jogoIniciado){

					painelJogo.setKey(dialog.getKeyCima(), dialog.getKeyEsquerda(), dialog.getKeyDireita(), dialog.getKeyBaixo());

					painelAvo.removeAll();
					painelAvo.add(painelJogo);
					painelAvo.repaint();
					painelJogo.requestFocus();
					painelAvo.revalidate();
				}else
					JOptionPane.showMessageDialog(null,"Ainda não iniciou nenhum jogo.\n","Aviso",JOptionPane.INFORMATION_MESSAGE);


			}
		});

		JButton configurations = new JButton("Configurações");
		configurations.setFocusable(false);
		configurations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.requestFocus();
				dialog.setVisible(true);
			}
		});

		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setFocusable(false);
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					FileInputStream  fis = new FileInputStream("ficheiro.dat");
					ObjectInputStream ois = new ObjectInputStream(fis);
					Object obj = ois.readObject();
					ois.close();
					painelJogo.newGame(((Jogo)obj));
					painelJogo.setKey(dialog.getKeyCima(), dialog.getKeyEsquerda(), dialog.getKeyDireita(), dialog.getKeyBaixo());


					JOptionPane.showMessageDialog(null,"Jogo carregado com sucesso.\n","Aviso",JOptionPane.WARNING_MESSAGE);

					jogoIniciado=true;
					painelAvo.removeAll();
					painelAvo.add(painelJogo);
					painelJogo.requestFocus();
					painelAvo.repaint();
					painelAvo.revalidate();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Não existe nenhum jogo para carregar.\n","Aviso",JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JButton btnSaveGame = new JButton("Save Game");
		btnSaveGame.setFocusable(false);
		btnSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(jogoIniciado){
					FileOutputStream fos = null;
					ObjectOutputStream oos = null;
					try {
						Jogo jogo = ( painelJogo).getJogo();
						fos = new FileOutputStream("ficheiro.dat");
						oos = new ObjectOutputStream(fos);
						oos.writeObject(jogo);
						fos.close();
						JOptionPane.showMessageDialog(null,"\tJogo gravado com sucesso\n","Save Game",JOptionPane.CLOSED_OPTION);
					}
					catch (Exception e1) {
						JOptionPane.showMessageDialog(null,"Não existe nenhum jogo para gravar.\n","Aviso",JOptionPane.WARNING_MESSAGE);
					}
				}
				else
					JOptionPane.showMessageDialog(null,"Não existe nenhum jogo para gravar.\n","Aviso",JOptionPane.WARNING_MESSAGE);


			}
		});

		JButton newGame = new JButton("Novo Jogo");
		newGame.setFocusable(false);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					painelJogo.newGame(dialog.getModo(),dialog.getNumDragoes(),dialog.getTamanho(),dialog.getCospe(),
							dialog.getAnda(),dialog.getDorme());

					painelJogo.setKey(dialog.getKeyCima(), dialog.getKeyEsquerda(), dialog.getKeyDireita(), dialog.getKeyBaixo());

					jogoIniciado=true;
					painelAvo.removeAll();
					painelAvo.add(painelJogo);
					painelJogo.requestFocus();
					painelAvo.repaint();
					painelAvo.revalidate();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
		});

		JPanel painelConfirmar = new JPanel();

		JPanel painelOK = new JPanel();

		JButton butaoDesenhar = new JButton("Desenhar Labirinto");
		butaoDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean avanca=false;
				int tamanho ;
				do{
					try{
						tamanho= Integer.parseInt(JOptionPane.showInputDialog
								(null,"Tamanho: ","Tamanho do Labirinto", JOptionPane.QUESTION_MESSAGE));
						painelDesenho.setTamanho(tamanho);
						avanca=true;

					}catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Introduza número válido.","Aviso",JOptionPane.WARNING_MESSAGE);

					}
				}while(!avanca);



				painelOK.removeAll();
				painelOK.add(painelConfirmar);
				painelOK.repaint();
				painelOK.revalidate();


				painelAvo.removeAll();
				painelAvo.add(splitPane);
				painelAvo.repaint();
				painelAvo.revalidate();


			}
		});
		butaoDesenhar.setFocusable(false);
		GroupLayout gl_painelPai = new GroupLayout(painelPai);
		gl_painelPai.setHorizontalGroup(
				gl_painelPai.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelPai.createSequentialGroup()
						.addGap(90)
						.addComponent(newGame, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
						.addGap(104))
						.addGroup(gl_painelPai.createSequentialGroup()
								.addGap(171)
								.addComponent(continuar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(184))
								.addGroup(Alignment.TRAILING, gl_painelPai.createSequentialGroup()
										.addGap(113)
										.addGroup(gl_painelPai.createParallelGroup(Alignment.TRAILING)
												.addComponent(butaoDesenhar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
												.addGroup(gl_painelPai.createSequentialGroup()
														.addComponent(btnSaveGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(18)
														.addComponent(btnLoadGame, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
														.addGap(131))
														.addGroup(gl_painelPai.createSequentialGroup()
																.addGap(162)
																.addComponent(configurations, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGap(171))
				);
		gl_painelPai.setVerticalGroup(
				gl_painelPai.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelPai.createSequentialGroup()
						.addContainerGap()
						.addComponent(newGame)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(continuar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGap(29)
						.addGroup(gl_painelPai.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(btnSaveGame)
								.addComponent(btnLoadGame))
								.addGap(18)
								.addComponent(configurations, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGap(20)
								.addComponent(butaoDesenhar)
								.addContainerGap(25, Short.MAX_VALUE))
				);
		painelPai.setLayout(gl_painelPai);

		painelAvo.add(splitPane, "name_5118233268258");

		splitPane.setRightComponent(painelDesenho);

		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JToggleButton btnHeroi = new JToggleButton("Heroi");
		JToggleButton btnDragao = new JToggleButton("Dragao");
		JToggleButton btnParede = new JToggleButton("Parede");

		JToggleButton btnChao = new JToggleButton("Chao/erva");
		JToggleButton btnEspada = new JToggleButton("Espada");
		JToggleButton btnEscudo = new JToggleButton("Escudo");
		JToggleButton btnDardo = new JToggleButton("Dardo");
		JToggleButton btnSaida = new JToggleButton("Saida");

		panel_1.add(btnHeroi);
		panel_1.add(btnDragao);
		panel_1.add(btnParede);
		panel_1.add(btnChao);
		panel_1.add(btnEspada);
		panel_1.add(btnEscudo);
		panel_1.add(btnDardo);
		panel_1.add(btnSaida);


		btnHeroi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(btnHeroi.isSelected()){
					btnDragao.setSelected(false);
					btnParede.setSelected(false);
					btnChao.setSelected(false);
					btnEspada.setSelected(false);
					btnEscudo.setSelected(false); 
					btnDardo.setSelected(false); 
					btnSaida.setSelected(false);
					if(painelDesenho.verificaVezes("heroi")==0)
						painelDesenho.setConteudo("heroi");
					else{
						JOptionPane.showMessageDialog(null,"Só pode ter um Heroi.\nSubstitua o antigo heroi e tente novamente","Excesso",JOptionPane.CLOSED_OPTION);
					}
					btnHeroi.setSelected(false);
				}
				else
					painelDesenho.setConteudo("nada");
			}
		});

		btnDragao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(btnDragao.isSelected()){
					btnHeroi.setSelected(false);
					btnParede.setSelected(false);
					btnChao.setSelected(false);
					btnEspada.setSelected(false);
					btnEscudo.setSelected(false); 
					btnDardo.setSelected(false); 
					btnSaida.setSelected(false);

					painelDesenho.setConteudo("dragao");

				}
				else
					painelDesenho.setConteudo("nada");


			}
		});

		btnParede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnParede.isSelected()){
					btnHeroi.setSelected(false);
					btnDragao.setSelected(false);
					btnChao.setSelected(false);
					btnEspada.setSelected(false);
					btnEscudo.setSelected(false); 
					btnDardo.setSelected(false); 
					btnSaida.setSelected(false);
					painelDesenho.setConteudo("parede");

				}
				else
					painelDesenho.setConteudo("nada");

			}
		});

		btnChao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnChao.isSelected()){
					btnHeroi.setSelected(false);
					btnDragao.setSelected(false);
					btnParede.setSelected(false);
					btnEspada.setSelected(false);
					btnEscudo.setSelected(false); 
					btnDardo.setSelected(false); 
					btnSaida.setSelected(false);
					painelDesenho.setConteudo("erva");

				}
				else
					painelDesenho.setConteudo("nada");
			}
		});

		btnEspada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(btnEspada.isSelected()){
					btnDragao.setSelected(false);
					btnParede.setSelected(false);
					btnChao.setSelected(false);
					btnHeroi.setSelected(false);
					btnEscudo.setSelected(false); 
					btnDardo.setSelected(false); 
					btnSaida.setSelected(false);
					if(painelDesenho.verificaVezes("espada")==0)
						painelDesenho.setConteudo("espada");
					else{
						JOptionPane.showMessageDialog(null,"Só pode ter uma Espada.\nSubstitua a espada antiga e tente novamente","Excesso",JOptionPane.CLOSED_OPTION);
					}
					btnEspada.setSelected(false);
				}
				else
					painelDesenho.setConteudo("nada");
			}
		});
		btnEscudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnEscudo.isSelected()){
					btnDragao.setSelected(false);
					btnParede.setSelected(false);
					btnChao.setSelected(false);
					btnHeroi.setSelected(false);
					btnEspada.setSelected(false); 
					btnDardo.setSelected(false); 
					btnSaida.setSelected(false);
					if(painelDesenho.verificaVezes("escudo")==0)
						painelDesenho.setConteudo("escudo");
					else{
						JOptionPane.showMessageDialog(null,"Só pode ter um Escudo.\nSubstitua o antigo escudo e tente novamente","Excesso",JOptionPane.CLOSED_OPTION);
					}
					btnEscudo.setSelected(false);
				}
				else
					painelDesenho.setConteudo("nada");
			}
		});

		btnDardo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnDardo.isSelected()){
					btnHeroi.setSelected(false);
					btnDragao.setSelected(false);
					btnParede.setSelected(false);
					btnEspada.setSelected(false);
					btnEscudo.setSelected(false); 
					btnChao.setSelected(false); 
					btnSaida.setSelected(false);
					painelDesenho.setConteudo("dardo");

				}
				else
					painelDesenho.setConteudo("nada");
			}
		});
		btnSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnSaida.isSelected()){
					btnDragao.setSelected(false);
					btnParede.setSelected(false);
					btnChao.setSelected(false);
					btnHeroi.setSelected(false);
					btnEspada.setSelected(false); 
					btnDardo.setSelected(false); 
					btnEscudo.setSelected(false);
					if(painelDesenho.verificaVezes("saida")==0)
						painelDesenho.setConteudo("saida");
					else{
						JOptionPane.showMessageDialog(null,"Só pode ter uma Saida.\nSubstitua a antiga saida e tente novamente","Excesso",JOptionPane.CLOSED_OPTION);
					}
					btnSaida.setSelected(false);
				}
				else
					painelDesenho.setConteudo("nada");
			}
		});





		frame.getContentPane().add(painelOK, BorderLayout.NORTH);
		painelOK.setLayout(new CardLayout(0, 0));





		JPanel painelMenuClose = new JPanel();
		painelOK.add(painelMenuClose, "name_5833571883401");
		painelMenuClose.setFocusable(false);
		painelMenuClose.setBackground(Color.DARK_GRAY);

		JButton close = new JButton("Fechar");
		close.setFocusable(false);
		close.setForeground(Color.BLACK);
		close.setBackground(UIManager.getColor("Button.background"));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		JButton menu = new JButton("Menu");
		menu.setFocusable(false);
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

		painelConfirmar.setBackground(Color.DARK_GRAY);
		painelOK.add(painelConfirmar, "name_5841899527671");

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				painelDesenho.setCospe(dialog.getCospe());
				painelDesenho.setDorme(dialog.getDorme());
				painelDesenho.setAnda(dialog.getAnda());
				painelDesenho.finaliza();
				
				painelJogo.newGameConstruido(painelDesenho.getLabirinto(),painelDesenho.getTamanho(),painelDesenho.getNumDrag(),
						painelDesenho.getDragoes(),painelDesenho.getNumDardos(),painelDesenho.getDardos(),
						painelDesenho.getEscudo(),painelDesenho.getHeroi(),painelDesenho.getEspada(),dialog.getCospe(),
						dialog.getDorme(),dialog.getAnda());

				painelJogo.setKey(dialog.getKeyCima(), dialog.getKeyEsquerda(), dialog.getKeyDireita(), dialog.getKeyBaixo());
				
				painelOK.removeAll();
				painelOK.add(painelMenuClose);
				painelOK.repaint();
				painelOK.revalidate();


				painelAvo.removeAll();
				painelAvo.add(painelJogo);
				painelAvo.repaint();
				painelAvo.revalidate();
				painelJogo.requestFocus();
				jogoIniciado=true;
			}
		});
		painelConfirmar.add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		painelConfirmar.add(btnCancelar);






	}
}
