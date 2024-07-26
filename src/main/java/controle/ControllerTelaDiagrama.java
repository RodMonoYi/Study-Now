package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import app.Aplicacao;
import visao.Frame;
import visao.TelaDiagrama;
import visao.TelaDiagramaRespondido;
import visao.TelaEnunciado;

public class ControllerTelaDiagrama implements ActionListener {

	public TelaDiagrama telaDiagrama;

	public ControllerTelaDiagrama(TelaDiagrama diagrama) {
		telaDiagrama = diagrama;
		Frame.controle = 5;
		TelaEnunciado.potErro=0;
		addEventos();
		

		if (TelaEnunciado.perguntaAtual.getQtdEstados() == 2) {

			telaDiagrama.getLblDiagrama().setBounds(296, 90, 350, 200);
			telaDiagrama.getLblDiagrama().setIcon(
					new ImageIcon(TelaDiagrama.class.getResource("/assets/Diagrama2EstadosRedimensionado.jpg")));

			telaDiagrama.getTfAPA().setBounds(275, 185, 50, 20);
			telaDiagrama.getTfAPB().setBounds(441, 265, 50, 20);
			telaDiagrama.getTfBPA().setBounds(438, 95, 50, 20);
			telaDiagrama.getTfBPB().setBounds(600, 190, 50, 20);

			telaDiagrama.getTfAPA().setVisible(true);
			telaDiagrama.getTfAPB().setVisible(true);
			telaDiagrama.getTfBPA().setVisible(true);
			telaDiagrama.getTfBPB().setVisible(true);
			telaDiagrama.getLblIdentificacao1().setVisible(true);
			telaDiagrama.getLblIdentificacao1().setBounds(362, 165, 70, 50);
			telaDiagrama.getLblIdentificacao2().setVisible(true);
			telaDiagrama.getLblIdentificacao2().setBounds(492, 165, 70, 50);

			telaDiagrama.getTfAPC().setVisible(false);
			telaDiagrama.getTfBPC().setVisible(false);
			telaDiagrama.getTfCPA().setVisible(false);
			telaDiagrama.getTfCPB().setVisible(false);
			telaDiagrama.getTfCPC().setVisible(false);
			telaDiagrama.getLblIdentificacao3().setVisible(false);
		} else if (TelaEnunciado.perguntaAtual.getQtdEstados() == 3) {

			telaDiagrama.getLblDiagrama().setBounds(280, 75, 377, 227);
			telaDiagrama.getLblDiagrama().setIcon(
					new ImageIcon(TelaDiagrama.class.getResource("/assets/Diagrama3EstadosRedimensionadoTeste.jpg")));

			telaDiagrama.getTfAPA().setVisible(true);
			telaDiagrama.getTfAPB().setVisible(true);
			telaDiagrama.getTfBPA().setVisible(true);
			telaDiagrama.getTfBPB().setVisible(true);
			telaDiagrama.getTfAPC().setVisible(true);
			telaDiagrama.getTfBPC().setVisible(true);
			telaDiagrama.getTfCPA().setVisible(true);
			telaDiagrama.getTfCPB().setVisible(true);
			telaDiagrama.getTfCPC().setVisible(true);
			telaDiagrama.getLblIdentificacao1().setVisible(true);
			telaDiagrama.getLblIdentificacao1().setBounds(340, 140, 70, 50);
			telaDiagrama.getLblIdentificacao2().setVisible(true);
			telaDiagrama.getLblIdentificacao2().setBounds(497, 90, 70, 50);
			telaDiagrama.getLblIdentificacao3().setVisible(true);
			telaDiagrama.getLblIdentificacao3().setBounds(465, 205, 70, 50);

			telaDiagrama.getTfAPA().setBounds(278, 157, 30, 20);
			telaDiagrama.getTfAPB().setBounds(435, 127, 30, 20);
			telaDiagrama.getTfAPC().setBounds(395, 231, 30, 20);

			telaDiagrama.getTfBPA().setBounds(400, 80, 30, 20);
			telaDiagrama.getTfBPB().setBounds(600, 105, 30, 20);
			telaDiagrama.getTfBPC().setBounds(485, 166, 30, 20);

			telaDiagrama.getTfCPA().setBounds(426, 166, 30, 20);
			telaDiagrama.getTfCPB().setBounds(536, 185, 30, 20);
			telaDiagrama.getTfCPC().setBounds(483, 286, 30, 20);
		} else {
		}
	}

	public JPanel getTela() {
		return telaDiagrama;
	}

	private void addEventos() {
		telaDiagrama.getBtnAjuda().addActionListener(this);
		telaDiagrama.getBtnAvancar().addActionListener(this);
		telaDiagrama.getBtnSim().addActionListener(this);
		telaDiagrama.getBtnNao().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaDiagrama.getBtnAvancar()) {
			if(TelaEnunciado.perguntaAtual.getQtdEstados()==2) {
				if (telaDiagrama.getTfAPA().getText().trim().isEmpty() 
						&& telaDiagrama.getTfAPB().getText().trim().isEmpty()
						&& telaDiagrama.getTfBPA().getText().trim().isEmpty()
						&& telaDiagrama.getTfBPB().getText().trim().isEmpty()) {
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
				} else {
					String valorOriginal = TelaEnunciado.perguntaAtual.getpTransicao();
					String[] partes = valorOriginal.split(",");
					String[] valores = new String[partes.length];
					for (int i = 0; i < partes.length; i++) {
						valores[i] = partes[i].trim();
					}
					int cont = 0;
					for (String numero : valores) {
						if (cont == 0 && numero.equals(telaDiagrama.getTfAPA().getText())) {
							cont++;
						}
						if (cont == 1 && numero.equals(telaDiagrama.getTfAPB().getText())) {
							cont++;
						}
						if (cont == 2 && numero.equals(telaDiagrama.getTfBPA().getText())) {
							cont++;
						}
						if (cont == 3 && numero.equals(telaDiagrama.getTfBPB().getText())) {
							cont++;
						}
					}
					if (cont == 4) {
						if(TelaEnunciado.pontuacao<100) {
							TelaEnunciado.pontuacao=TelaEnunciado.pontuacao+10;
						}
						Aplicacao.janela.getContentPane().removeAll();
						TelaDiagramaRespondido telaDiagramaRespondido = new TelaDiagramaRespondido();
						ControllerDiagramaRespondido ctlTelaDiagramaRespondido = new ControllerDiagramaRespondido(telaDiagramaRespondido);
						Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
						Aplicacao.janela.getContentPane().add(ctlTelaDiagramaRespondido.getTela());
						Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
						Aplicacao.janela.repaint();
						Aplicacao.janela.revalidate();
						Aplicacao.janela.setVisible(true);
					} else {
						telaDiagrama.getLblRespostaErrada().setVisible(true);
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
			} else if(TelaEnunciado.perguntaAtual.getQtdEstados()==3) {
				if (telaDiagrama.getTfAPA().getText().trim().isEmpty() 
						&& telaDiagrama.getTfAPB().getText().trim().isEmpty()
						&& telaDiagrama.getTfAPC().getText().trim().isEmpty()
						&& telaDiagrama.getTfBPA().getText().trim().isEmpty()
						&& telaDiagrama.getTfBPB().getText().trim().isEmpty()
						&& telaDiagrama.getTfBPC().getText().trim().isEmpty()
						&& telaDiagrama.getTfCPA().getText().trim().isEmpty()
						&& telaDiagrama.getTfCPB().getText().trim().isEmpty()
						&& telaDiagrama.getTfCPC().getText().trim().isEmpty()){
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
				} else {
					String valorOriginal = TelaEnunciado.perguntaAtual.getpTransicao();
					String[] partes = valorOriginal.split(",");
					String[] valores = new String[partes.length];
					for (int i = 0; i < partes.length; i++) {
						valores[i] = partes[i].trim();
					}
					int cont = 0;
					for (String numero : valores) {
						if (cont == 0 && numero.equals(telaDiagrama.getTfAPA().getText())) {
							cont++;
						}
						if (cont == 1 && numero.equals(telaDiagrama.getTfAPB().getText())) {
							cont++;
						}
						if (cont == 2 && numero.equals(telaDiagrama.getTfAPC().getText())) {
							cont++;
						}
						if (cont == 3 && numero.equals(telaDiagrama.getTfBPA().getText())) {
							cont++;
						}
						if (cont == 4 && numero.equals(telaDiagrama.getTfBPB().getText())) {
							cont++;
						}
						if (cont == 5 && numero.equals(telaDiagrama.getTfBPC().getText())) {
							cont++;
						}
						if (cont == 6 && numero.equals(telaDiagrama.getTfCPA().getText())) {
							cont++;
						}
						if (cont == 7 && numero.equals(telaDiagrama.getTfCPB().getText())) {
							cont++;
						}
						if (cont == 8 && numero.equals(telaDiagrama.getTfCPC().getText())) {
							cont++;
						}
					}
					if (cont == 9) {
						if(TelaEnunciado.pontuacao<100) {
							TelaEnunciado.pontuacao=TelaEnunciado.pontuacao+10;
						}
						Aplicacao.janela.getContentPane().removeAll();
						TelaDiagramaRespondido telaDiagramaRespondido = new TelaDiagramaRespondido();
						ControllerDiagramaRespondido ctlTelaDiagramaRespondido = new ControllerDiagramaRespondido(telaDiagramaRespondido);
						Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
						Aplicacao.janela.getContentPane().add(ctlTelaDiagramaRespondido.getTela());
						Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
						Aplicacao.janela.repaint();
						Aplicacao.janela.revalidate();
						Aplicacao.janela.setVisible(true);
					} else {
						telaDiagrama.getLblRespostaErrada().setVisible(true);
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
			}else {
				
			}
			
		}
		if (e.getSource() == telaDiagrama.getBtnAjuda()) {
			TelaEnunciado.qtdAjudas++;
			TelaEnunciado.potErro=TelaEnunciado.potErro+10;
			JOptionPane.showMessageDialog(getTela(),
				    "<html><body style='text-align: justify; width: 300px;'>"
				    + "<p>Uma Cadeia de Markov se traduz como uma sequência de configurações de estados variáveis de um determinado fenômeno, representada pela expressão {Xn, n ≥ 0}, onde o Xn indica o estado do fenômeno que está sendo estudado no tempo n, ou seja, em qual patamar está a variável estudada no tempo n, e n ≥ 0 significa a independência do tempo passado para a determinação da situação futura deste determinado estado, característica principal das cadeias markovianas denominada de propriedade sem memória.</p>"
				    + "<p>Tomamos como exemplo o clima local, este será o parâmetro estudado, representado por X, a sequência de configurações de parâmetros formará, portanto a cadeia de Markov {X0, X1,...}. O índice do parâmetro representa a quantidade de espaços de tempo ocorrida (n), se estivermos considerando um tempo de transição de uma semana entre cada elemento da cadeia, por exemplo, então, quando n = 3, significa que decorreram três semanas do início do fenômeno em estudo, sendo observado o estado X3, ou seja, o clima local na terceira semana observada.</p>"
				    + "</body></html>",
				    null, JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (e.getSource() == telaDiagrama.getBtnSim()) {
			JOptionPane.showMessageDialog(getTela(),
					"Parabéns, então preencha os campos com as probabilidades de transição",
					null, JOptionPane.INFORMATION_MESSAGE);
			telaDiagrama.getBtnSim().setEnabled(false);
		}
		
		if (e.getSource() == telaDiagrama.getBtnNao()) {
			TelaEnunciado.qtdAjudas++;
			TelaEnunciado.potErro=TelaEnunciado.potErro+10;
			JOptionPane.showMessageDialog(getTela(),
				    "<html><body style='text-align: justify; width: 300px;'>" +
				    "<p>Em uma Cadeia de Markov, o diagrama de transição de espaços é uma ferramenta visual que mapeia as probabilidades de um sistema mudar entre diferentes estados ao longo do tempo. Cada estado representa uma configuração possível do sistema, e as flechas entre os estados indicam as possíveis transições. As probabilidades de cada transição são rotuladas nas flechas.</p>",
				    null,
				    JOptionPane.INFORMATION_MESSAGE);

		}
	}

	
}
