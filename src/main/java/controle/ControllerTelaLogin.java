package controle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JPanel;

import app.Aplicacao;
import modelo.Estudante;
import monitorar.DAOEstudante;
import visao.Frame;
import visao.TelaLogin;
import visao.TelaWelcome;

public class ControllerTelaLogin implements ActionListener{

	public TelaLogin telaLogin;
	
	public ControllerTelaLogin(TelaLogin login) {
		telaLogin = login;
		Frame.controle=2;
		addEventos();
	}

	private void addEventos() {
		adaptarLogin();
		adaptarSenha();
		telaLogin.getBtnLogar().addActionListener(this);
	}

	public JPanel getTelaLogin() {
		return telaLogin;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaLogin.getBtnLogar()) {
			if (verificarCampos()) {
				if (testeUsuario()) {
					telaLogin.getAviso().setText("");
					Aplicacao.janela.getContentPane().removeAll();
					DAOEstudante daoe = new DAOEstudante();
					TelaWelcome telaWelcome = new TelaWelcome(daoe.BuscarEstudante(telaLogin.getTxtLogin().getText()));
					ControllerTelaWelcome ctlTelaWelcome = new ControllerTelaWelcome(telaWelcome);
					Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
					Aplicacao.janela.getContentPane().add(ctlTelaWelcome.getTelaWelcome());
					Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
					Aplicacao.janela.repaint();
					Aplicacao.janela.revalidate();
					Aplicacao.janela.setVisible(true);
				} else {
					telaLogin.getAviso().setText("Usuário ou senha incorretos!!");
				}
			}
		}
	}

	public void adaptarLogin() {
		
		
		telaLogin.getTxtLogin().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(telaLogin.getTxtLogin().getText().trim().compareTo("Usuário") == 0) {
					telaLogin.getTxtLogin().setText("");
					telaLogin.getTxtLogin().setForeground(new Color(0, 0, 0));
				}
			}
			public void focusLost(FocusEvent e) {
				if (telaLogin.getTxtLogin().getText().trim().isEmpty()) {
					telaLogin.getTxtLogin().setText("Usuário");
					telaLogin.getTxtLogin().setForeground(new Color(192, 192, 192));
				}				
			}
		});
		
			}

	public void adaptarSenha() {
		
		telaLogin.getTxtSenha().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(telaLogin.getTxtSenha().getPassword()).trim().compareTo("senhaaaa") == 0) {
					telaLogin.getTxtSenha().setText("");
					telaLogin.getTxtSenha().setForeground(new Color(0, 0, 0));
				}
			}
			public void focusLost(FocusEvent e) {
				if (String.valueOf(telaLogin.getTxtSenha().getPassword()).trim().isEmpty()) {
					telaLogin.getTxtSenha().setText("senhaaaa");
					telaLogin.getTxtSenha().setForeground(new Color(192, 192, 192));
				}				
			}
		});		
	}

	private boolean verificarCampos() {
		if (telaLogin.getTxtLogin().getText().trim().isEmpty()
				|| String.valueOf(telaLogin.getTxtSenha().getPassword()).trim().isEmpty()) {
			telaLogin.getAviso().setText("Por favor, preencha todos os campos!");
			return false;
		}
		return true;
	}

	private boolean testeUsuario() {
		Estudante teste = new Estudante();
		teste.setMatricula(telaLogin.getTxtLogin().getText());
		teste.setSenha(String.valueOf(telaLogin.getTxtSenha().getPassword()));
		DAOEstudante entityEstudante = new DAOEstudante();
		if (entityEstudante.BuscarUsuarioSenha(teste.getMatricula(), teste.getSenha()) != null) {
			return true;
		} else {
			return false;
		}
	}
}
