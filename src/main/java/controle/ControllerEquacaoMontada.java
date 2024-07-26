package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app.Aplicacao;
import visao.Frame;
import visao.TelaConclusaoPergunta;
import visao.TelaEnunciado;
import visao.TelaEquacaoMontada;

public class ControllerEquacaoMontada implements ActionListener{

	public TelaEquacaoMontada telaEquacaoMontada;
	
	public ControllerEquacaoMontada(TelaEquacaoMontada telaEquacaoMontada) {
		this.telaEquacaoMontada = telaEquacaoMontada;
		Frame.controle = 5;
		TelaEnunciado.potErro=0;
		addEventos();
	}

	private void addEventos() {
		telaEquacaoMontada.getBtnEnviar().addActionListener(this);
		telaEquacaoMontada.getBtnAjuda().addActionListener(this);
	}
	
	public JPanel getTela(){
		return telaEquacaoMontada;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaEquacaoMontada.getBtnEnviar()) {
			if(verificarTfResposta()) {
				if(verificarRespostasCorretas()) {
					if(TelaEnunciado.pontuacao<100) {
						TelaEnunciado.pontuacao=TelaEnunciado.pontuacao+10;
					}
					telaConclusao();
				} else {
					telaEquacaoMontada.getLblRespostaErrada().setVisible(true);
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
				}
			}
		}
		
		if (e.getSource() == telaEquacaoMontada.getBtnAjuda()) {
			TelaEnunciado.potErro=TelaEnunciado.potErro+10;
			JOptionPane.showMessageDialog(getTela(),
				    "<html><body style='text-align: justify; width: 300px;'>"
				    + "<p>Uma Cadeia de Markov se traduz como uma sequência de configurações de estados variáveis de um determinado fenômeno, representada pela expressão {Xn, n ≥ 0}, onde o Xn indica o estado do fenômeno que está sendo estudado no tempo n, ou seja, em qual patamar está a variável estudada no tempo n, e n ≥ 0 significa a independência do tempo passado para a determinação da situação futura deste determinado estado, característica principal das cadeias markovianas denominada de propriedade sem memória.</p>"
				    + "<p>Tomamos como exemplo o clima local, este será o parâmetro estudado, representado por X, a sequência de configurações de parâmetros formará, portanto a cadeia de Markov {X0, X1,...}. O índice do parâmetro representa a quantidade de espaços de tempo ocorrida (n), se estivermos considerando um tempo de transição de uma semana entre cada elemento da cadeia, por exemplo, então, quando n = 3, significa que decorreram três semanas do início do fenômeno em estudo, sendo observado o estado X3, ou seja, o clima local na terceira semana observada.</p>"
				    + "</body></html>",
				    null, JOptionPane.INFORMATION_MESSAGE);

		}
	}
	
	private void telaConclusao() {
		Aplicacao.janela.getContentPane().removeAll();
		TelaConclusaoPergunta telaConclusaoPergunta = new TelaConclusaoPergunta();
		ControllerTelaConclusao ctlTelaEquacaoMontada = new ControllerTelaConclusao(telaConclusaoPergunta);
		Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
		Aplicacao.janela.getContentPane().add(ctlTelaEquacaoMontada.getTela());
		Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
		Aplicacao.janela.repaint();
		Aplicacao.janela.revalidate();
		Aplicacao.janela.setVisible(true);
	}

	private boolean verificarRespostasCorretas() {
		boolean todasCorretas = true;
		if(TelaEnunciado.perguntaAtual.getQtdEstados()==2) {
			if(!telaEquacaoMontada.getTfResposta1().getText().equals(telaEquacaoMontada.separarStringPorVirgula(TelaEnunciado.perguntaAtual.getEstadoFinal(), 1))) {
				todasCorretas = false;
			}
			if(!telaEquacaoMontada.getTfResposta2().getText().equals(telaEquacaoMontada.separarStringPorVirgula(TelaEnunciado.perguntaAtual.getEstadoFinal(), 2))) {
				todasCorretas = false;
			}
			return todasCorretas;
		}else if(TelaEnunciado.perguntaAtual.getQtdEstados()==3) {
			if(!telaEquacaoMontada.getTfResposta1().getText().equals(telaEquacaoMontada.separarStringPorVirgula(TelaEnunciado.perguntaAtual.getEstadoFinal(), 1))) {
				todasCorretas = false;
			}
			if(!telaEquacaoMontada.getTfResposta2().getText().equals(telaEquacaoMontada.separarStringPorVirgula(TelaEnunciado.perguntaAtual.getEstadoFinal(), 2))) {
				todasCorretas = false;
			}
			if(!telaEquacaoMontada.getTfResposta3().getText().equals(telaEquacaoMontada.separarStringPorVirgula(TelaEnunciado.perguntaAtual.getEstadoFinal(), 3))) {
				todasCorretas = false;
			}
			return todasCorretas;
		}else {
			if(!telaEquacaoMontada.getTfResposta1().getText().equals(telaEquacaoMontada.separarStringPorVirgula(TelaEnunciado.perguntaAtual.getEstadoFinal(), 1))) {
				todasCorretas = false;
			}
			if(!telaEquacaoMontada.getTfResposta2().getText().equals(telaEquacaoMontada.separarStringPorVirgula(TelaEnunciado.perguntaAtual.getEstadoFinal(), 2))) {
				todasCorretas = false;
			}
			if(!telaEquacaoMontada.getTfResposta3().getText().equals(telaEquacaoMontada.separarStringPorVirgula(TelaEnunciado.perguntaAtual.getEstadoFinal(), 3))) {
				todasCorretas = false;
			}
			if(!telaEquacaoMontada.getTfResposta4().getText().equals(telaEquacaoMontada.separarStringPorVirgula(TelaEnunciado.perguntaAtual.getEstadoFinal(), 4))) {
				todasCorretas = false;
			}
			return todasCorretas;
		}	
	}

	public boolean verificarTfResposta() {
	    boolean todosPreenchidos = true;
	    if(TelaEnunciado.perguntaAtual.getQtdEstados()==2) {
	    	if (telaEquacaoMontada.getTfResposta1().getText().trim().isEmpty()) {
		        todosPreenchidos = false;
		    }

		    if (telaEquacaoMontada.getTfResposta2().getText().trim().isEmpty()) {
		        todosPreenchidos = false;
		    }
		    return todosPreenchidos;
	    } else if(TelaEnunciado.perguntaAtual.getQtdEstados()==3) {
	    	if (telaEquacaoMontada.getTfResposta1().getText().trim().isEmpty()) {
		        todosPreenchidos = false;
		    }

		    if (telaEquacaoMontada.getTfResposta2().getText().trim().isEmpty()) {
		        todosPreenchidos = false;
		    }

		    if (telaEquacaoMontada.getTfResposta3().isVisible() && telaEquacaoMontada.getTfResposta3().getText().trim().isEmpty()) {
		        todosPreenchidos = false;
		    }
		    return todosPreenchidos;
	    } else {
	    	if (telaEquacaoMontada.getTfResposta1().getText().trim().isEmpty()) {
		        todosPreenchidos = false;
		    }

		    if (telaEquacaoMontada.getTfResposta2().getText().trim().isEmpty()) {
		        todosPreenchidos = false;
		    }

		    if (telaEquacaoMontada.getTfResposta3().isVisible() && telaEquacaoMontada.getTfResposta3().getText().trim().isEmpty()) {
		        todosPreenchidos = false;
		    }

		    if (telaEquacaoMontada.getTfResposta4().isVisible() && telaEquacaoMontada.getTfResposta4().getText().trim().isEmpty()) {
		        todosPreenchidos = false;
		    }
		    if(todosPreenchidos==false) {
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
		    }
		    return todosPreenchidos;
	    }
	}

}
