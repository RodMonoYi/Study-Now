package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Aplicacao;
import visao.Frame;
import visao.TelaPerfil;
import visao.TelaPerguntaADM;
import visao.TelaSeletorDificuldade;
import visao.TelaWelcome;

public class ControllerTelaWelcome implements ActionListener{

	private TelaWelcome telaWelcome;
	
	public ControllerTelaWelcome(TelaWelcome welcome) {
		telaWelcome = welcome;
		Frame.controle=0;
		addEventos();
	}
	
	public TelaWelcome getTelaWelcome() {
		return telaWelcome;
	}

	private void addEventos() {
		telaWelcome.getBtPerfil().addActionListener(this);
		telaWelcome.getBtAtividade().addActionListener(this);
		telaWelcome.getBtConfig().addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==telaWelcome.getBtPerfil()) {
			Aplicacao.janela.getContentPane().removeAll();
			Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
			TelaPerfil telaPerfil = new TelaPerfil(telaWelcome.getAluno());
			ControllerTelaPerfil ctlTelaPerfil = new ControllerTelaPerfil(telaPerfil);
			Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
			Aplicacao.janela.getContentPane().add(ctlTelaPerfil.getTelaPerfil());
			Aplicacao.janela.repaint();
			Aplicacao.janela.revalidate();
			Aplicacao.janela.setVisible(true);
		}
		if(e.getSource()==telaWelcome.getBtAtividade()) {
			Aplicacao.janela.getContentPane().removeAll();
			Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
			TelaSeletorDificuldade telaSeletor = new TelaSeletorDificuldade(telaWelcome.getAluno());
			ControllerTelaSeletor ctlTelaSeletor = new ControllerTelaSeletor(telaSeletor);
			Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
			Aplicacao.janela.getContentPane().add(ctlTelaSeletor.getTelaSeletor());
			Aplicacao.janela.repaint();
			Aplicacao.janela.revalidate();
			Aplicacao.janela.setVisible(true);
		}
		if(e.getSource()==telaWelcome.getBtConfig()) {
			if(telaWelcome.getAluno().getMatricula().equals("admin") && telaWelcome.getAluno().getSenha().equals("admin")) {
				Aplicacao.janela.getContentPane().removeAll();
				TelaPerguntaADM telaPerguntaADM = new TelaPerguntaADM();
				ControllerPerguntaADM ctlTelaPerguntaADM = new ControllerPerguntaADM(telaPerguntaADM);
				Aplicacao.janela.getContentPane().add(ctlTelaPerguntaADM.getTelaPerguntaADM());
				Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
				Aplicacao.janela.repaint();
				Aplicacao.janela.revalidate();
				Aplicacao.janela.setVisible(true);
			}else {
				
			}
		}
	}
}
