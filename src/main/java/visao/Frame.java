package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app.Aplicacao;
import controle.ControllerTelaInicial;
import controle.ControllerTelaPerfil;
import controle.ControllerTelaWelcome;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel BarraPane;

	JMenuItem menuItemInformacoes = new JMenuItem("Informações");
	JMenuItem menuItemPerfil = new JMenuItem("Perfil");
	JMenuItem menuItemSair = new JMenuItem("Sair Da Conta");
	JMenuItem menuItemHome = new JMenuItem("Home");
	JMenuItem menuItemFechar = new JMenuItem("Fechar");

	public static TelaInicial home;

	ImageIcon imgRobo;
	JLabel lblRobo;
	
	public static int controle;

	public Frame() {
		controle=0;
		setTitle("Markov");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(707, 410);
		getContentPane().setLayout(null);
		getContentPane().add(getRobo());
		addPanel();
		getContentPane().add(getBarraPane());
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void addPanel() {
		home = new TelaInicial();
		home.getBtnCadastro().setLocation(398, 188);
		home.getBtnLogin().setLocation(398, 124);
		home.getLblTitulo().setLocation(221, 72);
		ControllerTelaInicial controleTelaInicial = new ControllerTelaInicial(home);
		this.getContentPane().add(controleTelaInicial.getTelaHome());
	}
	
	public JLabel getRobo() {
		if(lblRobo==null) {
			imgRobo = new ImageIcon(this.getClass().getResource("/assets/Robo.gif"));
			lblRobo = new JLabel(new ImageIcon(Frame.class.getResource("/assets/Robo.gif")));
			lblRobo.setBounds(40, 80, 150, 200);
		}
		return lblRobo;
	}

	public JPanel getBarraPane() {
		if (BarraPane == null) {
			BarraPane = new JPanel();

			BarraPane.setLayout(null);
			BarraPane.setBounds(0, 0, 690, 20);

			JMenu menuAjuda = new JMenu("Ajuda");
			JMenu menuConta = new JMenu("Conta");
			JMenu menuInicio = new JMenu("Inicio");

			JMenuBar menuBar = new JMenuBar();

			menuBar.setBounds(0, 0, 690, 22);
			menuAjuda.add(menuItemInformacoes);

			menuItemPerfil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(controle==5){
						JOptionPane.showMessageDialog(null, "Não é possível ir para o seu perfil!", "Interferência", JOptionPane.INFORMATION_MESSAGE);
					}else if(controle!=0) {
						JOptionPane.showMessageDialog(null, "Não há conta conectada!", "Interferência", JOptionPane.INFORMATION_MESSAGE);
					}else  {
						Aplicacao.janela.getContentPane().removeAll();
						Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
						TelaPerfil telaPerfil = new TelaPerfil(TelaWelcome.aluno);
						ControllerTelaPerfil ctlTelaPerfil = new ControllerTelaPerfil(telaPerfil);
						Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
						Aplicacao.janela.getContentPane().add(ctlTelaPerfil.getTelaPerfil());
						Aplicacao.janela.repaint();
						Aplicacao.janela.revalidate();
						Aplicacao.janela.setVisible(true);
					}
				}
			});
			menuConta.add(menuItemPerfil);

			menuItemSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(controle==5){
						JOptionPane.showMessageDialog(null, "Não é possível ir para o seu Sair da Conta!", "Interferência", JOptionPane.INFORMATION_MESSAGE);
					}else if(controle!=0) {
						JOptionPane.showMessageDialog(null, "Não há conta conectada!", "Interferência", JOptionPane.INFORMATION_MESSAGE);
					}else {
						Aplicacao.ReiniciarPanel();
					}
				}
			});
			menuConta.add(menuItemSair);

			menuItemHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(controle==0) {
						Aplicacao.janela.getContentPane().removeAll();
						TelaWelcome telaWelcome = new TelaWelcome(TelaWelcome.aluno);
						ControllerTelaWelcome ctlTelaWelcome = new ControllerTelaWelcome(telaWelcome);
						Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
						Aplicacao.janela.getContentPane().add(ctlTelaWelcome.getTelaWelcome());
						Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
						Aplicacao.janela.repaint();
						Aplicacao.janela.revalidate();
						Aplicacao.janela.setVisible(true);
					}else if(controle==5){
						JOptionPane.showMessageDialog(null, "Não é possível ir para a Tela Inicial!", "Interferência", JOptionPane.INFORMATION_MESSAGE);
					}else {
						Aplicacao.ReiniciarPanel();
					}
				}
			});
			menuInicio.add(menuItemHome);

			menuItemFechar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Aplicacao.fecharSistema();
				}
			});
			menuInicio.add(menuItemFechar);

			menuBar.add(menuInicio);
			menuBar.add(menuConta);
			menuBar.add(menuAjuda);

			BarraPane.add(menuBar);
			BarraPane.setVisible(true);
		}
		return BarraPane;
	}

	public JMenuItem getMenuItemInformacoes() {
		return menuItemInformacoes;
	}

	public JMenuItem getMenuItemPerfil() {
		return menuItemPerfil;
	}

	public JMenuItem getMenuItemSair() {
		return menuItemSair;
	}

	public JMenuItem getMenuItemHome() {
		return menuItemHome;
	}

	public JMenuItem getMenuItemFechar() {
		return menuItemFechar;
	}

}
