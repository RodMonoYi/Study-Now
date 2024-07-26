package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JPanel;

import app.Aplicacao;
import modelo.Historico;
import monitorar.DAOHistorico;
import visao.Frame;
import visao.TelaConclusaoPergunta;
import visao.TelaEnunciado;
import visao.TelaSeletorDificuldade;
import visao.TelaWelcome;

public class ControllerTelaConclusao implements ActionListener {

	TelaConclusaoPergunta telaConclusaoPergunta;

	public ControllerTelaConclusao(TelaConclusaoPergunta telaPergunta) {
		this.telaConclusaoPergunta = telaPergunta;
		Frame.controle = 0;
		addEventos();
	}

	private void addEventos() {
		telaConclusaoPergunta.getBtnSim().addActionListener(this);
		telaConclusaoPergunta.getBtnNao().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaConclusaoPergunta.getBtnSim()) {
			salvarHistorico();
			carregarPainelSeletor();
		}
		if(e.getSource() == telaConclusaoPergunta.getBtnNao()) {
			salvarHistorico();
			carregarTelaHome();
		}
	}

	public JPanel getTela() {
		return telaConclusaoPergunta;
	}
	
	private void carregarTelaHome() {
		Aplicacao.janela.getContentPane().removeAll();
		TelaWelcome telaWelcome = new TelaWelcome(TelaWelcome.aluno);
		ControllerTelaWelcome ctlTelaWelcome = new ControllerTelaWelcome(telaWelcome);
		Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
		Aplicacao.janela.getContentPane().add(ctlTelaWelcome.getTelaWelcome());
		Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
		Aplicacao.janela.repaint();
		Aplicacao.janela.revalidate();
		Aplicacao.janela.setVisible(true);
	}

	private void carregarPainelSeletor() {
		Aplicacao.janela.getContentPane().removeAll();
		Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
		TelaSeletorDificuldade telaSeletor = new TelaSeletorDificuldade(TelaWelcome.aluno);
		ControllerTelaSeletor ctlTelaSeletor = new ControllerTelaSeletor(telaSeletor);
		Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
		Aplicacao.janela.getContentPane().add(ctlTelaSeletor.getTelaSeletor());
		Aplicacao.janela.repaint();
		Aplicacao.janela.revalidate();
		Aplicacao.janela.setVisible(true);
	}
	private void salvarHistorico() {
		DAOHistorico emHistorico = new DAOHistorico();
		TelaWelcome.aluno.setPerguntasFeitas(TelaWelcome.aluno.getPerguntasFeitas()+1);
		TelaWelcome.aluno.setRespostasAcertadas(TelaWelcome.aluno.getRespostasAcertadas()+1);
		TelaWelcome.aluno.setAjudasPedidas(TelaWelcome.aluno.getAjudasPedidas()+TelaEnunciado.qtdAjudas);
		Historico h = new Historico();
		h.setPergunta(TelaEnunciado.perguntaAtual);
		h.setEstudante(TelaWelcome.aluno);
		h.setFinalizado(true);
		h.setDataRegistro(LocalDateTime.now());
		h.setPontuacao(TelaEnunciado.pontuacao);
		h.setQtdAjuda(TelaEnunciado.qtdAjudas);
		emHistorico.salvarHistorico(h);
		TelaWelcome.aluno.setScore(calcularHistorico(emHistorico));
	}

	private double calcularHistorico(DAOHistorico emHistorico) {
		List<Historico> historicos = emHistorico.ListaHistoricoPorEstudante(TelaWelcome.aluno.getID());
		int somaPontuacao=0;
		int i=0;
		while(i<historicos.size()) {
			somaPontuacao = somaPontuacao + historicos.get(i).getPontuacao();
		}
		return (somaPontuacao/historicos.size())/10;
	}
}
