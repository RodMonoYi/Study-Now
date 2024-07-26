package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import app.Aplicacao;
import visao.Frame;
import visao.TelaCadastro;
import visao.TelaInicial;
import visao.TelaLogin;

public class ControllerTelaInicial implements ActionListener {

	public TelaInicial telaHome;

	public ControllerTelaInicial(TelaInicial home) {
		telaHome=home;
		Frame.controle=1;
		addEventos();
	}

	private void addEventos() {
		telaHome.getBtnLogin().addActionListener(this);
		telaHome.getBtnCadastro().addActionListener(this);
	}

	public JPanel getTelaHome() {
		return telaHome;
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaHome.getBtnLogin()) {
			Aplicacao.janela.getContentPane().removeAll();
			TelaLogin telaLogin = new TelaLogin();
			ControllerTelaLogin ctlTelaLogin = new ControllerTelaLogin(telaLogin);
			Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
			Aplicacao.janela.getContentPane().add(ctlTelaLogin.getTelaLogin());
			Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
			Aplicacao.janela.repaint();
			Aplicacao.janela.revalidate();
			Aplicacao.janela.setVisible(true);
		}
		if (e.getSource() == telaHome.getBtnCadastro()) {
			
			Aplicacao.janela.getContentPane().removeAll();
			TelaCadastro telaCadastro = new TelaCadastro();
			ControllerTelaCadastro ctlTelaCadastro = new ControllerTelaCadastro(telaCadastro);
			Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
			Aplicacao.janela.getContentPane().add(ctlTelaCadastro.getTelaCadastro());
			Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
			Aplicacao.janela.repaint();
			Aplicacao.janela.revalidate();
			Aplicacao.janela.setVisible(true);
			
			
			
		}
	}
}
