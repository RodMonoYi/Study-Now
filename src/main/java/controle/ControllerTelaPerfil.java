package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Aplicacao;
import visao.Frame;
import visao.TelaPerfil;
import visao.TelaWelcome;

public class ControllerTelaPerfil implements ActionListener{
	
private TelaPerfil telaPerfil;
	
	public ControllerTelaPerfil(TelaPerfil perfil) {
		telaPerfil = perfil;
		Frame.controle=0;
		addEventos();
	}
	
	public TelaPerfil getTelaPerfil() {
		return telaPerfil;
	}

	private void addEventos() {
		telaPerfil.getBtnVoltar().addActionListener(this);
		telaPerfil.getBtnSairConta().addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==telaPerfil.getBtnVoltar()) {
			Aplicacao.janela.getContentPane().removeAll();
			TelaWelcome telaWelcome = new TelaWelcome(telaPerfil.getAluno());
			ControllerTelaWelcome ctlTelaWelcome = new ControllerTelaWelcome(telaWelcome);
			Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
			Aplicacao.janela.getContentPane().add(ctlTelaWelcome.getTelaWelcome());
			Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
			Aplicacao.janela.repaint();
			Aplicacao.janela.revalidate();
			Aplicacao.janela.setVisible(true);
		}
		if(e.getSource()==telaPerfil.getBtnSairConta()) {
			Aplicacao.ReiniciarPanel();
		}
	}
	
}
