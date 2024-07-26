package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app.Aplicacao;
import visao.Frame;
import visao.TelaDiagrama;
import visao.TelaEnunciado;

public class ControllerTelaEnunciado implements ActionListener {

	public TelaEnunciado telaEnunciado;
	public int contadorEstagios = 1;

	public ControllerTelaEnunciado(TelaEnunciado enunciado) {
		telaEnunciado = enunciado;
		Frame.controle = 5;
		TelaEnunciado.potErro=0;
		addEventos();
	}

	public JPanel getTelaEnunciado() {
		return telaEnunciado;
	}

	private void addEventos() {
		telaEnunciado.getBtnNao().addActionListener(this);
		telaEnunciado.getBtnSim().addActionListener(this);
		telaEnunciado.getBtnEnviar().addActionListener(this);
		telaEnunciado.getBtnAjuda().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaEnunciado.getBtnNao()) {
			TelaEnunciado.potErro=TelaEnunciado.potErro+10;
		}
		if (e.getSource() == telaEnunciado.getBtnSim()) {
			if (telaEnunciado.controlador == 1) {
				telaEnunciado.getLblPergunta().setVisible(true);
				telaEnunciado.getTfResposta().setVisible(true);
				telaEnunciado.getBtnEnviar().setVisible(true);
				telaEnunciado.getBtnSim().setEnabled(false);
				JOptionPane.showMessageDialog(getTelaEnunciado(), "Ótimo! No campo de texto responda com a quantidade de estados.", null, JOptionPane.INFORMATION_MESSAGE);
				telaEnunciado.controlador += 1;
			} else if (telaEnunciado.controlador == 2) {
				JOptionPane.showMessageDialog(getTelaEnunciado(), "Excelente! Agora no campo de alternativas, selecione a opção que mais se adequa a questão.", null, JOptionPane.INFORMATION_MESSAGE);
				telaEnunciado.getBtnSim().setEnabled(false);
			} else {
				telaEnunciado.getLblPergunta().setVisible(false);
			}
		}
		if (e.getSource() == telaEnunciado.getBtnEnviar()) {
			if (contadorEstagios == 1) {
				if (!telaEnunciado.getTfResposta().getText().trim().isEmpty()) {
					if (Integer.parseInt(telaEnunciado.getTfResposta().getText()) == telaEnunciado.getPerguntaAtual()
							.getQtdEstados()) {
						if(TelaEnunciado.pontuacao<100) {
							TelaEnunciado.pontuacao=TelaEnunciado.pontuacao+10;
						}
						carregaEstagio1();
						telaEnunciado.getLblRespostaErrada().setVisible(false);
						telaEnunciado.getBtnSim().setEnabled(true);
					} else {
						if(TelaEnunciado.pontuacao>0) {
							if(TelaEnunciado.potErro!=0) {
								TelaEnunciado.pontuacao=TelaEnunciado.pontuacao-TelaEnunciado.potErro;
							}else {
								TelaEnunciado.pontuacao=TelaEnunciado.pontuacao-10;
							}
							if(TelaEnunciado.pontuacao<0) {
								TelaEnunciado.pontuacao=0;
							}
						}
						telaEnunciado.getLblRespostaErrada().setVisible(true);
					}

				}
			} else if (contadorEstagios == 2) {
				String aux = (String) telaEnunciado.getComboBoxPergunta2().getSelectedItem();
				if (aux.equals(telaEnunciado.getPerguntaAtual().getIdentEstadoCorreto())) {
					if(TelaEnunciado.pontuacao<100) {
						TelaEnunciado.pontuacao=TelaEnunciado.pontuacao+10;
					}
					carregaEstagio2();
				} else {
					if(TelaEnunciado.pontuacao>0) {
						if(TelaEnunciado.potErro!=0) {
							TelaEnunciado.pontuacao=TelaEnunciado.pontuacao-TelaEnunciado.potErro;
						}else {
							TelaEnunciado.pontuacao=TelaEnunciado.pontuacao-10;
						}
						if(TelaEnunciado.pontuacao<0) {
							TelaEnunciado.pontuacao=0;
						}
					}
					telaEnunciado.getLblRespostaErrada().setVisible(true);
				}
			}
		}

		if (e.getSource() == telaEnunciado.getBtnAjuda()) {
			TelaEnunciado.potErro=TelaEnunciado.potErro+10;
			JOptionPane.showMessageDialog(getTelaEnunciado(),
				    "<html><body style='text-align: justify; width: 300px;'>"
				    + "<p>Uma Cadeia de Markov se traduz como uma sequência de configurações de estados variáveis de um determinado fenômeno, representada pela expressão {Xn, n ≥ 0}, onde o Xn indica o estado do fenômeno que está sendo estudado no tempo n, ou seja, em qual patamar está a variável estudada no tempo n, e n ≥ 0 significa a independência do tempo passado para a determinação da situação futura deste determinado estado, característica principal das cadeias markovianas denominada de propriedade sem memória.</p>"
				    + "<p>Tomamos como exemplo o clima local, este será o parâmetro estudado, representado por X, a sequência de configurações de parâmetros formará, portanto a cadeia de Markov {X0, X1,...}. O índice do parâmetro representa a quantidade de espaços de tempo ocorrida (n), se estivermos considerando um tempo de transição de uma semana entre cada elemento da cadeia, por exemplo, então, quando n = 3, significa que decorreram três semanas do início do fenômeno em estudo, sendo observado o estado X3, ou seja, o clima local na terceira semana observada.</p>"
				    + "</body></html>",
				    null, JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public void carregaEstagio1() {
		telaEnunciado.getLblPergunta().setVisible(false);
		telaEnunciado.getTfResposta().setVisible(false);
		telaEnunciado.getLblPergunta2().setVisible(true);
		telaEnunciado.geraListaEstados();
		telaEnunciado.getComboBoxPergunta2().setVisible(true);
		telaEnunciado.getBtnEnviar().setBounds(528, 430, 89, 23);
		contadorEstagios++;
	}

	public void carregaEstagio2() {
		Aplicacao.janela.getContentPane().removeAll();
		Aplicacao.retornarTamanho();
		Aplicacao.janela.setLocationRelativeTo(null);
		TelaDiagrama telaDiagrama = new TelaDiagrama();
		ControllerTelaDiagrama ctlTelaDiagrama = new ControllerTelaDiagrama(telaDiagrama);
		Aplicacao.janela.getRobo().setLocation(40, 80);
		Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
		Aplicacao.janela.getContentPane().add(ctlTelaDiagrama.getTela());
		Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
		Aplicacao.janela.repaint();
		Aplicacao.janela.revalidate();
		Aplicacao.janela.setVisible(true);
	}
}
