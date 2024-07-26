package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Aplicacao;
import modelo.Pergunta;
import monitorar.DAOPergunta;
import visao.Frame;
import visao.TelaEnunciado;
import visao.TelaSeletorDificuldade;
import visao.TelaWelcome;

public class ControllerTelaSeletor implements ActionListener {

	private TelaSeletorDificuldade telaSeletor;
	
	public static Pergunta perguntaMonitorada;
	
	DAOPergunta emPergunta;

	public ControllerTelaSeletor(TelaSeletorDificuldade seletor) {
		emPergunta= new DAOPergunta();
		telaSeletor = seletor;
		Frame.controle=0;
		addEventos();
	}

	private void addEventos() {
		telaSeletor.getChbxEsperanca().addActionListener(this);
		telaSeletor.getChbxEstabilidade().addActionListener(this);
		telaSeletor.getChbxCustos().addActionListener(this);
		telaSeletor.getChbxPermanencia().addActionListener(this);
		telaSeletor.getBtVoltar().addActionListener(this);
		telaSeletor.getBtSelecionar().addActionListener(this);
	}
	
	public TelaSeletorDificuldade getTelaSeletor() {
		return telaSeletor;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaSeletor.getChbxEsperanca()) {
			telaSeletor.checagem(telaSeletor.getChbxEsperanca());
			telaSeletor.getLblAviso().setText("");
		}
		
		if (e.getSource() == telaSeletor.getChbxEstabilidade()) {
			telaSeletor.checagem(telaSeletor.getChbxEstabilidade());
			telaSeletor.getLblAviso().setText("");
		}

		if (e.getSource() == telaSeletor.getChbxCustos()) {
			telaSeletor.checagem(telaSeletor.getChbxCustos());
			telaSeletor.getLblAviso().setText("");
		}

		if (e.getSource() == telaSeletor.getChbxPermanencia()) {
			telaSeletor.checagem(telaSeletor.getChbxPermanencia());
			telaSeletor.getLblAviso().setText("");
		}

		if (e.getSource() == telaSeletor.getBtVoltar()) {
			voltarTelaWelcome();
		}
		
		if (e.getSource() == telaSeletor.getBtSelecionar()) {
			
			selecaoPergunta();
			
			if(perguntaMonitorada!=null) {
				Aplicacao.janela.getContentPane().removeAll();
				TelaEnunciado telaEnunciado = new TelaEnunciado(perguntaMonitorada);
				ControllerTelaEnunciado ctlTelaEnunciado = new ControllerTelaEnunciado(telaEnunciado);
				Aplicacao.janela.getRobo().setLocation(40, 130);
				Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
				Aplicacao.janela.getContentPane().add(ctlTelaEnunciado.getTelaEnunciado());
				Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
				Aplicacao.janela.repaint();
				Aplicacao.janela.revalidate();
				Aplicacao.janela.setVisible(true);
			}
		 }
	}
	
	public void selecaoPergunta() {
		perguntaMonitorada = null;
		telaSeletor.getLblAviso().setVisible(false);
		if(telaSeletor.getChbxEsperanca().isSelected()) { // Apenas Esperança
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaSingular(1, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis da categoria Esperança");
					telaSeletor.getLblAviso().setVisible(true);
					}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaSingular(1, 1, TelaWelcome.aluno.getID());
					
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaSingular(1, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares da categoria Esperança");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaSingular(1, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaSingular(1, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis da categoria Esperança");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaSingular(1, 3, TelaWelcome.aluno.getID());
				}
			}
		}else if(telaSeletor.getChbxEstabilidade().isSelected()) { // Apenas Estabilidade
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaSingular(2, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis da categoria Estabilidade");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaSingular(2, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaSingular(2, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares da categoria Estabilidade");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaSingular(2, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaSingular(2, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis da categoria Estabilidade");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaSingular(2, 3, TelaWelcome.aluno.getID());
				}
			}
		}else if(telaSeletor.getChbxCustos().isSelected()) { // Apenas Custo
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaSingular(3, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis da categoria Custo");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaSingular(3, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaSingular(3, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares da categoria Custo");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaSingular(3, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaSingular(3, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis da categoria Custo");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaSingular(3, 3, TelaWelcome.aluno.getID());
				}
			}
		}else if(telaSeletor.getChbxPermanencia().isSelected()){ // Apenas Permanencia
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaSingular(4, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis da categoria Permanencia");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaSingular(4, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaSingular(4, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares da categoria Permanencia");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaSingular(4, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaSingular(4, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis da categoria Permanencia");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaSingular(4, 3, TelaWelcome.aluno.getID());
				}
			}
		}else if(telaSeletor.getChbxEsperanca().isSelected() && telaSeletor.getChbxEstabilidade().isSelected()) {
			// Esperança e Estabilidade
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaDupla(1, 2, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis das categorias Esperança e Estabilidade");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(1, 2, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaDupla(1, 2, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares das categorias Esperança e Estabilidade");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(1, 2, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaDupla(1, 2, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis das categorias Esperança e Estabilidade");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(1, 2, 3, TelaWelcome.aluno.getID());
				}
			}
			
		}else if(telaSeletor.getChbxEsperanca().isSelected() && telaSeletor.getChbxCustos().isSelected()) {
			// Esperança e Custo
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaDupla(1, 3, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis das categorias Esperança e Custo");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(1, 3, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaDupla(1, 3, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares das categorias Esperança e Custo");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(1, 3, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaDupla(1, 3, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis das categorias Esperança e Custo");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(1, 3, 3, TelaWelcome.aluno.getID());
				}
			}
			
		}else if(telaSeletor.getChbxEsperanca().isSelected() && telaSeletor.getChbxPermanencia().isSelected()) {
			// Esperança e Permanencia
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaDupla(1, 4, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis das categorias Esperança e Permanência");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(1, 4, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaDupla(1, 4, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares das categorias Esperança e Permanência");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(1, 4, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaDupla(1, 4, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis das categorias Esperança e Permanência");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(1, 4, 3, TelaWelcome.aluno.getID());
				}
			}
			
		}else if(telaSeletor.getChbxEstabilidade().isSelected() && telaSeletor.getChbxCustos().isSelected()) {
			// Estabilidade e Custo
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaDupla(2, 3, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis das categorias Estabilidade e Custo");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(2, 3, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaDupla(2, 3, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares das categorias Estabilidade e Custo");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(2, 3, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaDupla(2, 3, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis das categorias Estabilidade e Custo");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(2, 3, 3, TelaWelcome.aluno.getID());
				}
			}
			
		}else if(telaSeletor.getChbxEstabilidade().isSelected() && telaSeletor.getChbxPermanencia().isSelected()) {
			// Estabilidade e Permanencia
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaDupla(2, 4, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis das categorias Estabilidade e Permanência");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(2, 4, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaDupla(2, 4, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares das categorias Estabilidade e Permanência");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(2, 4, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaDupla(2, 4, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis das categorias Estabilidade e Permanência");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(2, 4, 3, TelaWelcome.aluno.getID());
				}
			}
			
		}else if(telaSeletor.getChbxCustos().isSelected() && telaSeletor.getChbxPermanencia().isSelected()){
			// Custo e Permanencia
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaDupla(3, 4, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis das categorias Custo e Permanência");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(3, 4, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaDupla(3, 4, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares das categorias Custo e Permanência");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(3, 4, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaDupla(3, 4, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis das categorias Custo e Permanência");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaDupla(3, 4, 3, TelaWelcome.aluno.getID());
				}
			}
			
		}else if(telaSeletor.getChbxEsperanca().isSelected() && telaSeletor.getChbxEstabilidade().isSelected() && telaSeletor.getChbxCustos().isSelected()) {
			// Esperança, Estabilidade e Custo 
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaTripla(1, 2, 3, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis dessas Categorias");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaTripla(1, 2, 3, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaTripla(1, 2, 3, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares dessas Categorias");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaTripla(1, 2, 3, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaTripla(1, 2, 3, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis dessas Categorias");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaTripla(1, 2, 3, 3, TelaWelcome.aluno.getID());
				}
			}
			
		}else if(telaSeletor.getChbxEsperanca().isSelected() && telaSeletor.getChbxEstabilidade().isSelected() && telaSeletor.getChbxPermanencia().isSelected()) {
			// Esperança, Estabilidade e Permanencia
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaTripla(1, 2, 4, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis dessas Categorias");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaTripla(1, 2, 4, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaTripla(1, 2, 4, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares dessas Categorias");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaTripla(1, 2, 4, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaTripla(1, 2, 4, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis dessas Categorias");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaTripla(1, 2, 4, 3, TelaWelcome.aluno.getID());
				}
			}
			
		}else if(telaSeletor.getChbxEsperanca().isSelected() && telaSeletor.getChbxCustos().isSelected() && telaSeletor.getChbxPermanencia().isSelected()) {
			// Esperança, Custo e Permanencia
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaTripla(1, 3, 4, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis dessas Categorias");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaTripla(1, 3, 4, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaTripla(1, 3, 4, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares dessas Categorias");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaTripla(1, 3, 4, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaTripla(1, 3, 4, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis dessas Categorias");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaTripla(1, 3, 4, 3, TelaWelcome.aluno.getID());
				}
			}
			
		}else if(telaSeletor.getChbxEstabilidade().isSelected() && telaSeletor.getChbxCustos().isSelected() && telaSeletor.getChbxPermanencia().isSelected()) {
			// Estabilidade, Custo e Permanencia
			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaTripla(2, 3, 4, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis dessas Categorias");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaTripla(2, 3, 4, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaTripla(2, 3, 4, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulates dessas Categorias");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaTripla(2, 3, 4, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaTripla(2, 3, 4, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis dessas Categorias");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaTripla(2, 3, 4, 3, TelaWelcome.aluno.getID());
				}
			}
			
		}else {
			// Esperança, Estabilidade, Custo e Permanencia

			if(identificacaoDif()==1) {
				if(emPergunta.BuscarPerguntaGeral(1, 2, 3, 4, 1, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas fáceis");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaGeral(1, 2, 3, 4, 1, TelaWelcome.aluno.getID());
				}
			}
			else if(identificacaoDif()==2) {
				if(emPergunta.BuscarPerguntaGeral(1, 2, 3, 4, 2, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas regulares");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaGeral(1, 2, 3, 4, 2, TelaWelcome.aluno.getID());
				}
			}
			else {
				if(emPergunta.BuscarPerguntaGeral(1, 2, 3, 4, 3, TelaWelcome.aluno.getID())==null) {
					telaSeletor.getLblAviso().setText("Não há mais perguntas difíceis");
					telaSeletor.getLblAviso().setVisible(true);
				}else {
					perguntaMonitorada = emPergunta.BuscarPerguntaGeral(1, 2, 3, 4, 3, TelaWelcome.aluno.getID());
				}
			}
			
		}
	}

	public int identificacaoDif() {
		String dificuldadeSelecionada = (String) telaSeletor.getCbDificuldade().getSelectedItem();
		if("Básica".equals(dificuldadeSelecionada)){
			return 1;
		}else if("Intermediária".equals(dificuldadeSelecionada)){
			return 2;
		}else{
			return 3;
		}
	}
	
	public void voltarTelaWelcome() {
		Aplicacao.janela.getContentPane().removeAll();
		Aplicacao.retornarTamanho();
		Aplicacao.janela.setLocationRelativeTo(null);
		TelaWelcome telaWelcome = new TelaWelcome(TelaWelcome.aluno);
		ControllerTelaWelcome ctlTelaWelcome = new ControllerTelaWelcome(telaWelcome);
		Aplicacao.janela.getRobo().setLocation(40, 80);
		Aplicacao.janela.getContentPane().add(Aplicacao.janela.getRobo());
		Aplicacao.janela.getContentPane().add(ctlTelaWelcome.getTelaWelcome());
		Aplicacao.janela.getContentPane().add(Aplicacao.janela.getBarraPane());
		Aplicacao.janela.repaint();
		Aplicacao.janela.revalidate();
		Aplicacao.janela.setVisible(true);
	}
	
}
