package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.Aplicacao;
import modelo.ImagemPergunta;
import modelo.Pergunta;
import monitorar.DAOImagem;
import monitorar.DAOPergunta;
import visao.Frame;
import visao.TelaPerguntaADM;
import visao.TelaWelcome;

public class ControllerPerguntaADM implements ActionListener {

	public TelaPerguntaADM telaPerguntaADM;

	byte[] diagrama;
	byte[] equacao;

	public ControllerPerguntaADM(TelaPerguntaADM perguntaADM) {
		telaPerguntaADM = perguntaADM;
		Frame.controle = 0;
		addEventos();
	}

	private void addEventos() {
		telaPerguntaADM.getBtCadastrar().addActionListener(this);
		telaPerguntaADM.getBtCarregarDiagrama().addActionListener(this);
		telaPerguntaADM.getBtCarregarEquacao().addActionListener(this);
		telaPerguntaADM.getCbxQtdEstados().addActionListener(this);
		telaPerguntaADM.getBtVoltar().addActionListener(this);
	}

	public JPanel getTelaPerguntaADM() {
		return telaPerguntaADM;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == telaPerguntaADM.getBtCadastrar()) {
			if (componentesPreenchidos()) {
				Pergunta perguntaAtual = new Pergunta();
				perguntaAtual = addDadosPergunta();
				DAOPergunta entityEstudante = new DAOPergunta();
				try {
					entityEstudante.SalvarPergunta(perguntaAtual);
					JOptionPane.showMessageDialog(telaPerguntaADM, "Pergunta Cadastrada com Sucesso!!", null,
							JOptionPane.INFORMATION_MESSAGE);
					limparComponentes();
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(telaPerguntaADM, "Esta pergunta já foi cadastrada", null,
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		if (e.getSource() == telaPerguntaADM.getBtCarregarDiagrama()) {
			diagrama = carregarImagemDiagrama();
		}
		if (e.getSource() == telaPerguntaADM.getBtCarregarEquacao()) {
			equacao = carregarImagemEquacao();
		}
		if(e.getSource() == telaPerguntaADM.getCbxQtdEstados()) {
			String selectedText = (String) telaPerguntaADM.getCbxQtdEstados().getSelectedItem();
		    
		    if (selectedText != null && selectedText.equals("2")) {
		    	telaPerguntaADM.getLblProbabilidadeTransicao().setText("Probabilidades de Transição (Modelo: ' A-A, A-B, B-A, B-B ')");
		    }else if(selectedText != null && selectedText.equals("3")) {
		    	telaPerguntaADM.getLblProbabilidadeTransicao().setText("Probabilidades de Transição (Modelo:  ' A-A, A-B, A-C, B-A, B-B, B-C, C-A, C-B, C-C ')");
		    }else {
		    	telaPerguntaADM.getLblProbabilidadeTransicao().setText("Probabilidades de Transição (Modelo: )");
		    }
		}
		if(e.getSource() == telaPerguntaADM.getBtVoltar()) {
			Aplicacao.retornarTamanho();
			Aplicacao.janela.setLocationRelativeTo(null);
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
	}

	private void limparComponentes() {
		telaPerguntaADM.getTextEnunciado().setText("");
		telaPerguntaADM.getTfIdentEstadoCorreto().setText("");
		telaPerguntaADM.getTfIdentEstadoIncorreto1().setText("");
		telaPerguntaADM.getTfIdentEstadoIncorreto2().setText("");
		telaPerguntaADM.getTfIdentEstadoIncorreto3().setText("");
		telaPerguntaADM.getTfPerguntaCorreta().setText("");
		telaPerguntaADM.getTfPerguntaIncorreta1().setText("");
		telaPerguntaADM.getTfPerguntaIncorreta2().setText("");
		telaPerguntaADM.getTfPerguntaIncorreta3().setText("");
		telaPerguntaADM.getTfProbabilidadeTransicao().setText("");
		telaPerguntaADM.getTfEstadoInicial().setText("");
		telaPerguntaADM.getTfEstadoFinal().setText("");
		telaPerguntaADM.getTfValorAdicionado().setText("");
		telaPerguntaADM.getCbxCategoria().setSelectedIndex(0);
		telaPerguntaADM.getCbxDificuldade().setSelectedIndex(0);
		telaPerguntaADM.getCbxQtdEstados().setSelectedIndex(0);
		telaPerguntaADM.getBtCarregarDiagrama().setIcon(new ImageIcon(TelaPerguntaADM.class.getResource("/assets/IconArquivo.png")));
		telaPerguntaADM.getBtCarregarEquacao().setIcon(new ImageIcon(TelaPerguntaADM.class.getResource("/assets/IconArquivo.png")));
	}

	private Pergunta addDadosPergunta() {
		ImagemPergunta imgP;
		if (diagrama != null && equacao != null) {
			imgP = new ImagemPergunta();
			imgP.setImagemDiagrama(diagrama);
			imgP.setImagemEquacao(equacao);
			DAOImagem emImagem = new DAOImagem();
			emImagem.salvarImagem(imgP);
			Pergunta p = new Pergunta();
			p.setEnunciado(telaPerguntaADM.getTextEnunciado().getText());
			p.setCategoria(categoriaSelecionada(telaPerguntaADM.getCbxCategoria()));
			p.setDificuldade(dificuldadeSelecionada(telaPerguntaADM.getCbxDificuldade()));
			p.setQtdEstados(qtdEstadosSelecionado(telaPerguntaADM.getCbxQtdEstados()));
			p.setIdentEstadoCorreto(telaPerguntaADM.getTfIdentEstadoCorreto().getText());
			p.setIdentEstadoErrado1(telaPerguntaADM.getTfIdentEstadoIncorreto1().getText());
			p.setIdentEstadoErrado2(telaPerguntaADM.getTfIdentEstadoIncorreto2().getText());
			p.setIdentEstadoErrado3(telaPerguntaADM.getTfIdentEstadoIncorreto3().getText());
			p.setpTransicao(telaPerguntaADM.getTfProbabilidadeTransicao().getText());
			p.setPerguntaCorreta(telaPerguntaADM.getTfPerguntaCorreta().getText());
			p.setPerguntaErrada1(telaPerguntaADM.getTfPerguntaIncorreta1().getText());
			p.setPerguntaErrada2(telaPerguntaADM.getTfPerguntaIncorreta2().getText());
			p.setPerguntaErrada3(telaPerguntaADM.getTfPerguntaIncorreta3().getText());
			p.setEstadoInicial(telaPerguntaADM.getTfEstadoInicial().getText());
			p.setEstadoFinal(telaPerguntaADM.getTfEstadoFinal().getText());
			p.setValorAdd(Integer.parseInt(telaPerguntaADM.getTfValorAdicionado().getText()));
			p.setImgPergunta(imgP);
			return p;
		}
		return null;
	}

	private byte[] carregarImagemDiagrama() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif"));
		int result = fileChooser.showOpenDialog(telaPerguntaADM);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try {
				byte[] imagemBytes = convertFileToBytes(selectedFile);
				telaPerguntaADM.getBtCarregarDiagrama()
						.setIcon(new ImageIcon(TelaPerguntaADM.class.getResource("/assets/carregarImgExito.png")));
				return imagemBytes;
			} catch (IOException ex) {
				telaPerguntaADM.getBtCarregarDiagrama()
						.setIcon(new ImageIcon(TelaPerguntaADM.class.getResource("/assets/carregarImgFalha.png")));
			}
		}
		return null;
	}

	private byte[] carregarImagemEquacao() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif"));
		int result = fileChooser.showOpenDialog(telaPerguntaADM);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try {
				byte[] imagemBytes = convertFileToBytes(selectedFile);
				telaPerguntaADM.getBtCarregarEquacao()
						.setIcon(new ImageIcon(TelaPerguntaADM.class.getResource("/assets/carregarImgExito.png")));
				return imagemBytes;
			} catch (IOException ex) {
				telaPerguntaADM.getBtCarregarEquacao()
						.setIcon(new ImageIcon(TelaPerguntaADM.class.getResource("/assets/carregarImgFalha.png")));
			}
		}
		return null;
	}

	private byte[] convertFileToBytes(File file) throws IOException {
		try (FileInputStream fis = new FileInputStream(file)) {
			byte[] bytes = new byte[(int) file.length()];
			fis.read(bytes);
			return bytes;
		}
	}

	private boolean componentesPreenchidos() {
		return !(telaPerguntaADM.getTextEnunciado().getText().isEmpty()
				|| telaPerguntaADM.getTfIdentEstadoCorreto().getText().isEmpty()
				|| telaPerguntaADM.getTfIdentEstadoIncorreto1().getText().isEmpty()
				|| telaPerguntaADM.getTfIdentEstadoIncorreto2().getText().isEmpty()
				|| telaPerguntaADM.getTfIdentEstadoIncorreto3().getText().isEmpty()
				|| telaPerguntaADM.getTfPerguntaCorreta().getText().isEmpty()
				|| telaPerguntaADM.getTfPerguntaIncorreta1().getText().isEmpty()
				|| telaPerguntaADM.getTfPerguntaIncorreta2().getText().isEmpty()
				|| telaPerguntaADM.getTfPerguntaIncorreta3().getText().isEmpty()
				|| telaPerguntaADM.getTfProbabilidadeTransicao().getText().isEmpty()
				|| telaPerguntaADM.getTfEstadoInicial().getText().isEmpty()
				|| telaPerguntaADM.getTfEstadoFinal().getText().isEmpty()
				|| telaPerguntaADM.getTfValorAdicionado().getText().isEmpty());
	}

	public int categoriaSelecionada(JComboBox<String> comboBox) {
		String selectedItem = (String) comboBox.getSelectedItem();
		if ("Esperança".equals(selectedItem)) {
			return 1;
		} else if ("Estabilidade".equals(selectedItem)) {
			return 2;
		} else if ("Custo".equals(selectedItem)) {
			return 3;
		} else {
			return 4;
		}
	}

	public int dificuldadeSelecionada(JComboBox<String> comboBox) {
		String selectedItem = (String) comboBox.getSelectedItem();
		if ("Básica".equals(selectedItem)) {
			return 1;
		} else if ("Intermediária".equals(selectedItem)) {
			return 2;
		} else {
			return 3;
		}
	}

	public int qtdEstadosSelecionado(JComboBox<String> comboBox) {
		String selectedItem = (String) comboBox.getSelectedItem();
		if ("2".equals(selectedItem)) {
			return 2;
		} else if ("3".equals(selectedItem)) {
			return 3;
		} else {
			return 4;
		}
	}

}
