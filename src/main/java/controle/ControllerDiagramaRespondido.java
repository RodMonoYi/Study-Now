package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app.Aplicacao;
import visao.Frame;
import visao.TelaDiagramaRespondido;
import visao.TelaEnunciado;
import visao.TelaEquacaoMontada;

public class ControllerDiagramaRespondido implements ActionListener {

	public TelaDiagramaRespondido telaDiagramaRespondido;
	public int controlador = 0;

	public ControllerDiagramaRespondido(TelaDiagramaRespondido telaDiagramaRespondido) {
		this.telaDiagramaRespondido = telaDiagramaRespondido;
		Frame.controle = 5;
		TelaEnunciado.potErro=0;
		addEventos();
	}

	private void addEventos() {
		telaDiagramaRespondido.getBtnSim().addActionListener(this);
		telaDiagramaRespondido.getBtnEnviar().addActionListener(this);
		telaDiagramaRespondido.getBtnAjuda().addActionListener(this);
		telaDiagramaRespondido.getBtnNao().addActionListener(this);
	}

	public JPanel getTela() {
		return telaDiagramaRespondido;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaDiagramaRespondido.getBtnEnviar()) {
			if (telaDiagramaRespondido.getCbxListaPergunta().getSelectedItem() == TelaEnunciado.perguntaAtual.getPerguntaCorreta()) {
				if(controlador == 0) {
					if(TelaEnunciado.pontuacao<100) {
						TelaEnunciado.pontuacao=TelaEnunciado.pontuacao+10;
					}
					telaDiagramaRespondido.getCbxListaPergunta().setVisible(false);
					telaDiagramaRespondido.getLblRespostaErrada().setVisible(false);
					telaDiagramaRespondido.getBtnEnviar().setText("Terminei. Pode avançar.");
					telaDiagramaRespondido.getBtnEnviar().setBounds(400, 310, 200, 23);
					telaDiagramaRespondido.getLblNewLabel().setText("<html><body>Agora vou dar um tempo pra você montar a equação. Você pode visitar o enunciado a qualquer momento aqui do lado.<body/><html/>");
					controlador++;
				}
				else {					
					carregarTelaEquacao();
				}
			} else {
				telaDiagramaRespondido.getLblRespostaErrada().setVisible(true);
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
		if (e.getSource() == telaDiagramaRespondido.getBtnSim()) {
			JOptionPane.showMessageDialog(getTela(),
					"Ótimo, agora escolha a alternativa que mais se adequa com a questão!",
					null, JOptionPane.INFORMATION_MESSAGE);
			telaDiagramaRespondido.getBtnSim().setEnabled(false);
			telaDiagramaRespondido.getBtnEnviar().setVisible(true);
			telaDiagramaRespondido.getCbxListaPergunta().setVisible(true);
		}
		if (e.getSource() == telaDiagramaRespondido.getBtnNao()) {
			TelaEnunciado.potErro=TelaEnunciado.potErro+10;
			JOptionPane.showMessageDialog(getTela(),
					"Para a identificação da questão, basta verificar o tipo de questionamento que é realizado, ou seja:\n" +
							"\n1.\tNesta questão é solicitado o estado esperado do fenômeno em um tempo t específico?\n" +
							"\n2.\tNesta questão é solicitada a estabilidade do fenômeno?\n" +
							"\n3.\tNesta questão é solicitado o tempo de permanência em um determinado estado num tempo t específico?\n" +
							"\n4.\tNesta questão é solicitado o custo do fenômeno num tempo t específico?\n" +
							"\n5.\tNesta questão é solicitada a ocupância do fenômeno num tempo t específico?\n" +
							"\nCaso seja necessária a indicação do tempo t específico, será solicitado posteriormente esta informação através do teclado numérico.",
					null, JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == telaDiagramaRespondido.getBtnAjuda()) { 
			TelaEnunciado.potErro=TelaEnunciado.potErro+10;
			JOptionPane.showMessageDialog(getTela(),
				    "<html><body style='text-align: justify; width: 300px;'>"
				    + "<p>Uma Cadeia de Markov se traduz como uma sequência de configurações de estados variáveis de um determinado fenômeno, representada pela expressão {Xn, n ≥ 0}, onde o Xn indica o estado do fenômeno que está sendo estudado no tempo n, ou seja, em qual patamar está a variável estudada no tempo n, e n ≥ 0 significa a independência do tempo passado para a determinação da situação futura deste determinado estado, característica principal das cadeias markovianas denominada de propriedade sem memória.</p>"
				    + "<p>Tomamos como exemplo o clima local, este será o parâmetro estudado, representado por X, a sequência de configurações de parâmetros formará, portanto a cadeia de Markov {X0, X1,...}. O índice do parâmetro representa a quantidade de espaços de tempo ocorrida (n), se estivermos considerando um tempo de transição de uma semana entre cada elemento da cadeia, por exemplo, então, quando n = 3, significa que decorreram três semanas do início do fenômeno em estudo, sendo observado o estado X3, ou seja, o clima local na terceira semana observada.</p>"
				    + "</body></html>",
				    null, JOptionPane.INFORMATION_MESSAGE);

		}
	}

	private void carregarTelaEquacao() {
		// TODO Auto-generated method stub
		Aplicacao.janela.getContentPane().removeAll();
		TelaEquacaoMontada telaEquacaoMontada = new TelaEquacaoMontada();
		ControllerEquacaoMontada ctlTelaEquacaoMontada = new ControllerEquacaoMontada(telaEquacaoMontada);
		Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
		Aplicacao.janela.getContentPane().add(ctlTelaEquacaoMontada.getTela());
		Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
		Aplicacao.janela.repaint();
		Aplicacao.janela.revalidate();
		Aplicacao.janela.setVisible(true);
	}

}
