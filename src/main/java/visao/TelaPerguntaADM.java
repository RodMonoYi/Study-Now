package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import app.Aplicacao;

public class TelaPerguntaADM extends JPanel {

	private static final long serialVersionUID = 1L;

	JPanel formPanelEnunciado;
	JTextArea textEnunciado;
	JComboBox<String> cbxCategoria;
	JComboBox<String> cbxDificuldade;
	JComboBox<String> cbxQtdEstados;
	JTextField tfIdentEstadoCorreto;
	JTextField tfIdentEstadoIncorreto1;
	JTextField tfIdentEstadoIncorreto2;
	JTextField tfIdentEstadoIncorreto3;
	JTextField tfPerguntaCorreta;
	JTextField tfPerguntaIncorreta1;
	JTextField tfPerguntaIncorreta2;
	JTextField tfPerguntaIncorreta3;
	JTextField tfProbabilidadeTransicao;
	JTextField tfEstadoInicial;
	JTextField tfEstadoFinal;
	JTextField tfValorAdicionado;
	JLabel lblTitulo;
	JLabel lblEnunciado;
	JLabel linha;
	JLabel lblCategoria;
	JLabel lblDificuldade;
	JLabel lblQtdEstados;
	JLabel lblIdentEstadoCorreto;
	JLabel lblIdentEstadoIncorreto1;
	JLabel lblIdentEstadoIncorreto2;
	JLabel lblIdentEstadoIncorreto3;
	JLabel lblPerguntaCorreta;
	JLabel lblPerguntaIncorreta1;
	JLabel lblPerguntaIncorreta2;
	JLabel lblPerguntaIncorreta3;
	JLabel lblEstadoInicial;
	JLabel lblEstadoFinal;
	JLabel lblProbabilidadeTransicao;
	JLabel lblCarregarDiagrama;
	JLabel lblCarregarEquacao;
	JLabel lblValorAdicionado;
	JLabel lblBackground;
	JButton btCadastrar;
	JButton btCarregarDiagrama;
	JButton btCarregarEquacao;
	JButton btVoltar;

	public TelaPerguntaADM() {
		setLayout(null);
		Aplicacao.alterarTamanho(707, 600);
		Aplicacao.janela.setLocationRelativeTo(null);
		setBounds(0, 20, 690, 540);
		addItens();
		setVisible(true);
	}

	private void addItens() {
		add(getFormPanelEnunciado(), BorderLayout.CENTER);
		add(getTfIdentEstadoCorreto());
		add(getTfIdentEstadoIncorreto1());
		add(getTfIdentEstadoIncorreto2());
		add(getTfIdentEstadoIncorreto3());
		add(getTfPerguntaCorreta());
		add(getTfPerguntaIncorreta1());
		add(getTfPerguntaIncorreta2());
		add(getTfPerguntaIncorreta3());
		add(getTfProbabilidadeTransicao());
		add(getTfEstadoInicial());
		add(getTfEstadoFinal());
		add(getTfValorAdicionado());
		add(getCbxCategoria());
		add(getCbxDificuldade());
		add(getCbxQtdEstados());
		add(getLblTitulo());
		add(getLblEnunciado());
		add(getLinha());
		add(getLblCategoria());
		add(getLblDificuldade());
		add(getLblQtdEstados());
		add(getLblIdentEstadoCorreto());
		add(getLblIdentEstadoIncorreto1());
		add(getLblIdentEstadoIncorreto2());
		add(getLblIdentEstadoIncorreto3());
		add(getLblPerguntaCorreta());
		add(getLblPerguntaIncorreta1());
		add(getLblPerguntaIncorreta2());
		add(getLblPerguntaIncorreta3());
		add(getLblEstadoInicial());
		add(getLblEstadoFinal());
		add(getLblProbabilidadeTransicao());
		add(getLblCarregarDiagrama());
		add(getLblCarregarEquacao());
		add(getLblValorAdicionado());
		add(getBtCadastrar());
		add(getBtCarregarDiagrama());
		add(getBtCarregarEquacao());
		add(getBtVoltar());
		add(getLblBackground());
	}

	public TelaPerguntaADM getTela() {
		return this;
	}

	public JPanel getFormPanelEnunciado() {
		if (formPanelEnunciado == null) {
			formPanelEnunciado = new JPanel();
			formPanelEnunciado.setLayout(new BorderLayout());

			JPanel enunciadoPanel = new JPanel();
			enunciadoPanel.setLayout(new BorderLayout());

			textEnunciado = new JTextArea();
			textEnunciado.setLineWrap(true);
			textEnunciado.setWrapStyleWord(true);
			textEnunciado.setBorder(BorderFactory.createLineBorder(Color.GRAY));

			JScrollPane scrollPane = new JScrollPane(textEnunciado);
			enunciadoPanel.add(scrollPane, BorderLayout.CENTER);

			formPanelEnunciado.add(enunciadoPanel, BorderLayout.CENTER);
			formPanelEnunciado.setBounds(163, 50, 470, 100);
		}
		return formPanelEnunciado;
	}

	public JTextArea getTextEnunciado() {
		return textEnunciado;
	}

	public JTextField getTfIdentEstadoCorreto() {
		if (tfIdentEstadoCorreto == null) {
			tfIdentEstadoCorreto = new JTextField();
			tfIdentEstadoCorreto.setBounds(74, 239, 219, 20);
			tfIdentEstadoCorreto.setColumns(10);
		}
		return tfIdentEstadoCorreto;
	}

	public JTextField getTfIdentEstadoIncorreto1() {
		if (tfIdentEstadoIncorreto1 == null) {
			tfIdentEstadoIncorreto1 = new JTextField();
			tfIdentEstadoIncorreto1.setColumns(10);
			tfIdentEstadoIncorreto1.setBounds(74, 287, 219, 20);
		}
		return tfIdentEstadoIncorreto1;
	}

	public JTextField getTfIdentEstadoIncorreto2() {
		if (tfIdentEstadoIncorreto2 == null) {
			tfIdentEstadoIncorreto2 = new JTextField();
			tfIdentEstadoIncorreto2.setColumns(10);
			tfIdentEstadoIncorreto2.setBounds(74, 335, 219, 20);
		}
		return tfIdentEstadoIncorreto2;
	}

	public JTextField getTfIdentEstadoIncorreto3() {
		if (tfIdentEstadoIncorreto3 == null) {
			tfIdentEstadoIncorreto3 = new JTextField();
			tfIdentEstadoIncorreto3.setColumns(10);
			tfIdentEstadoIncorreto3.setBounds(74, 383, 219, 20);
		}
		return tfIdentEstadoIncorreto3;
	}

	public JTextField getTfPerguntaCorreta() {
		if (tfPerguntaCorreta == null) {
			tfPerguntaCorreta = new JTextField();
			tfPerguntaCorreta.setColumns(10);
			tfPerguntaCorreta.setBounds(311, 239, 320, 20);
		}
		return tfPerguntaCorreta;
	}

	public JTextField getTfPerguntaIncorreta1() {
		if (tfPerguntaIncorreta1 == null) {
			tfPerguntaIncorreta1 = new JTextField();
			tfPerguntaIncorreta1.setColumns(10);
			tfPerguntaIncorreta1.setBounds(310, 287, 320, 20);
		}
		return tfPerguntaIncorreta1;
	}

	public JTextField getTfPerguntaIncorreta2() {
		if (tfPerguntaIncorreta2 == null) {
			tfPerguntaIncorreta2 = new JTextField();
			tfPerguntaIncorreta2.setColumns(10);
			tfPerguntaIncorreta2.setBounds(313, 336, 320, 20);
		}
		return tfPerguntaIncorreta2;
	}

	public JTextField getTfPerguntaIncorreta3() {
		if (tfPerguntaIncorreta3 == null) {
			tfPerguntaIncorreta3 = new JTextField();
			tfPerguntaIncorreta3.setColumns(10);
			tfPerguntaIncorreta3.setBounds(311, 383, 320, 20);
		}
		return tfPerguntaIncorreta3;
	}

	public JTextField getTfProbabilidadeTransicao() {
		if (tfProbabilidadeTransicao == null) {
			tfProbabilidadeTransicao = new JTextField();
			tfProbabilidadeTransicao.setColumns(10);
			tfProbabilidadeTransicao.setBounds(74, 437, 435, 20);
		}
		return tfProbabilidadeTransicao;
	}

	public JTextField getTfEstadoInicial() {
		if (tfEstadoInicial == null) {
			tfEstadoInicial = new JTextField();
			tfEstadoInicial.setBounds(397, 180, 100, 40);
			tfEstadoInicial.setColumns(3);
		}
		return tfEstadoInicial;
	}

	public JTextField getTfEstadoFinal() {
		if (tfEstadoFinal == null) {
			tfEstadoFinal = new JTextField();
			tfEstadoFinal.setColumns(10);
			tfEstadoFinal.setBounds(518, 179, 100, 40);
		}
		return tfEstadoFinal;
	}

	public JTextField getTfValorAdicionado() {
		if (tfValorAdicionado == null) {
			tfValorAdicionado = new JTextField();
			tfValorAdicionado.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char aux = e.getKeyChar();
					if (!Character.isDigit(aux) && (aux != '.' || tfValorAdicionado.getText().contains("."))) {
						e.consume();
					}
				}
			});
			tfValorAdicionado.setColumns(10);
			tfValorAdicionado.setBounds(310, 488, 200, 30);
		}
		return tfValorAdicionado;
	}

	public JComboBox<String> getCbxCategoria() {
		if (cbxCategoria == null) {
			cbxCategoria = new JComboBox<String>();
			cbxCategoria.setFont(new Font("Verdana", Font.PLAIN, 13));
			cbxCategoria.setModel(new DefaultComboBoxModel<String>(
					new String[] { "Esperança", "Estabilidade", "Custo", "Permanência" }));
			cbxCategoria.setBounds(77, 188, 100, 22);
		}
		return cbxCategoria;
	}

	public JComboBox<String> getCbxDificuldade() {
		if (cbxDificuldade == null) {
			cbxDificuldade = new JComboBox<String>();
			cbxDificuldade.setFont(new Font("Verdana", Font.PLAIN, 13));
			cbxDificuldade
					.setModel(new DefaultComboBoxModel<String>(new String[] { "Básica", "Intermediária", "Avançada" }));
			cbxDificuldade.setBounds(193, 188, 100, 22);
		}
		return cbxDificuldade;
	}

	public JComboBox<String> getCbxQtdEstados() {
		if (cbxQtdEstados == null) {
			cbxQtdEstados = new JComboBox<String>();
			cbxQtdEstados.setFont(new Font("Verdana", Font.PLAIN, 13));
			cbxQtdEstados.setModel(new DefaultComboBoxModel<String>(new String[] { "2", "3", "4" }));
			cbxQtdEstados.setBounds(310, 188, 55, 22);
		}
		return cbxQtdEstados;
	}

	public JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("<html>Cadastro de<br>Pergunta</html>");
			lblTitulo.setForeground(new Color(0, 0, 0));
			lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
			lblTitulo.setBounds(30, 11, 120, 60);
		}
		return lblTitulo;
	}

	public JLabel getLblEnunciado() {
		if (lblEnunciado == null) {
			lblEnunciado = new JLabel("Enunciado:");
			lblEnunciado.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnunciado.setBounds(77, 93, 76, 14);
		}
		return lblEnunciado;
	}

	public JLabel getLinha() {
		if (linha == null) {
			linha = new JLabel(
					"______________________________________________________________________________________________");
			linha.setForeground(Color.GRAY);
			linha.setBounds(74, 145, 570, 14);
		}
		return linha;
	}

	public JLabel getLblCategoria() {
		if (lblCategoria == null) {
			lblCategoria = new JLabel("Categoria");
			lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCategoria.setBounds(77, 167, 58, 18);
		}
		return lblCategoria;
	}

	public JLabel getLblDificuldade() {
		if (lblDificuldade == null) {
			lblDificuldade = new JLabel("Dificuldade");
			lblDificuldade.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDificuldade.setBounds(193, 167, 70, 18);
		}
		return lblDificuldade;
	}

	public JLabel getLblQtdEstados() {
		if (lblQtdEstados == null) {
			lblQtdEstados = new JLabel("<html>Quantidade<br>de estados</html>");
			lblQtdEstados.setBounds(310, 160, 60, 30);
		}
		return lblQtdEstados;
	}

	public JLabel getLblIdentEstadoCorreto() {
		if (lblIdentEstadoCorreto == null) {
			lblIdentEstadoCorreto = new JLabel("Identificação de Estado (Correto)");
			lblIdentEstadoCorreto.setBounds(73, 221, 166, 14);
		}
		return lblIdentEstadoCorreto;
	}

	public JLabel getLblIdentEstadoIncorreto1() {
		if (lblIdentEstadoIncorreto1 == null) {
			lblIdentEstadoIncorreto1 = new JLabel("Identificação de Estado (Incorreto)");
			lblIdentEstadoIncorreto1.setBounds(74, 270, 176, 14);
		}
		return lblIdentEstadoIncorreto1;
	}

	public JLabel getLblIdentEstadoIncorreto2() {
		if (lblIdentEstadoIncorreto2 == null) {
			lblIdentEstadoIncorreto2 = new JLabel("Identificação de Estado (Incorreto)");
			lblIdentEstadoIncorreto2.setBounds(74, 318, 176, 14);
		}
		return lblIdentEstadoIncorreto2;
	}

	public JLabel getLblIdentEstadoIncorreto3() {
		if (lblIdentEstadoIncorreto3 == null) {
			lblIdentEstadoIncorreto3 = new JLabel("Identificação de Estado (Incorreto)");
			lblIdentEstadoIncorreto3.setBounds(74, 366, 176, 14);
		}
		return lblIdentEstadoIncorreto3;
	}

	public JLabel getLblPerguntaCorreta() {
		if (lblPerguntaCorreta == null) {
			lblPerguntaCorreta = new JLabel("Pergunta (Correta)");
			lblPerguntaCorreta.setBounds(310, 221, 166, 14);
		}
		return lblPerguntaCorreta;
	}

	public JLabel getLblPerguntaIncorreta1() {
		if (lblPerguntaIncorreta1 == null) {
			lblPerguntaIncorreta1 = new JLabel("Pergunta (Incorreta)");
			lblPerguntaIncorreta1.setBounds(312, 270, 166, 14);
		}
		return lblPerguntaIncorreta1;
	}

	public JLabel getLblPerguntaIncorreta2() {
		if (lblPerguntaIncorreta2 == null) {
			lblPerguntaIncorreta2 = new JLabel("Pergunta (Incorreta)");
			lblPerguntaIncorreta2.setBounds(312, 318, 166, 14);
		}
		return lblPerguntaIncorreta2;
	}

	public JLabel getLblPerguntaIncorreta3() {
		if (lblPerguntaIncorreta3 == null) {
			lblPerguntaIncorreta3 = new JLabel("Pergunta (Incorreta)");
			lblPerguntaIncorreta3.setBounds(310, 365, 166, 14);
		}
		return lblPerguntaIncorreta3;
	}

	public JLabel getLblEstadoInicial() {
		if (lblEstadoInicial == null) {
			lblEstadoInicial = new JLabel("Estado Inicial");
			lblEstadoInicial.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEstadoInicial.setBounds(397, 161, 100, 18);
		}
		return lblEstadoInicial;
	}

	public JLabel getLblEstadoFinal() {
		if (lblEstadoFinal == null) {
			lblEstadoFinal = new JLabel("Estado Final");
			lblEstadoFinal.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEstadoFinal.setBounds(518, 160, 100, 18);
		}
		return lblEstadoFinal;
	}

	public JLabel getLblProbabilidadeTransicao() {
		if (lblProbabilidadeTransicao == null) {
			lblProbabilidadeTransicao = new JLabel("Probabilidades de Transição (Modelo: ' A-A, A-B, B-A, B-B ')");
			lblProbabilidadeTransicao.setBounds(74, 420, 420, 14);
		}
		return lblProbabilidadeTransicao;
	}

	public JLabel getLblCarregarDiagrama() {
		if (lblCarregarDiagrama == null) {
			lblCarregarDiagrama = new JLabel("<html>Carregar<br>Diagrama</html>");
			lblCarregarDiagrama.setBounds(85, 477, 50, 30);
		}
		return lblCarregarDiagrama;
	}

	public JLabel getLblCarregarEquacao() {
		if (lblCarregarEquacao == null) {
			lblCarregarEquacao = new JLabel("<html>Carregar<br>Equação</html>");
			lblCarregarEquacao.setBounds(193, 477, 50, 30);
		}
		return lblCarregarEquacao;
	}

	public JLabel getLblValorAdicionado() {
		if (lblValorAdicionado == null) {
			lblValorAdicionado = new JLabel("Valor Adicionado\r\n");
			lblValorAdicionado.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblValorAdicionado.setBounds(310, 468, 100, 18);
		}
		return lblValorAdicionado;
	}

	public JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon(TelaPerguntaADM.class.getResource("/assets/backgoundAdm.jpg")));
			lblBackground.setBounds(0, 0, 690, 540);
		}
		return lblBackground;
	}

	public JButton getBtCadastrar() {
		if (btCadastrar == null) {
			btCadastrar = new JButton();
			btCadastrar.setIcon(new ImageIcon(TelaPerguntaADM.class.getResource("/assets/button_cadastro.png")));
			btCadastrar.setBounds(530, 440, 115, 53);
			btCadastrar.setContentAreaFilled(false);
			btCadastrar.setFocusPainted(false);
		}
		return btCadastrar;
	}

	public JButton getBtCarregarDiagrama() {
		if (btCarregarDiagrama == null) {
			btCarregarDiagrama = new JButton("");
			btCarregarDiagrama.setIcon(new ImageIcon(TelaPerguntaADM.class.getResource("/assets/IconArquivo.png")));
			btCarregarDiagrama.setBounds(137, 473, 40, 40);
			btCarregarDiagrama.setContentAreaFilled(false);
			btCarregarDiagrama.setFocusPainted(false);
		}
		return btCarregarDiagrama;
	}

	public JButton getBtCarregarEquacao() {
		if (btCarregarEquacao == null) {
			btCarregarEquacao = new JButton("");
			btCarregarEquacao.setIcon(new ImageIcon(TelaPerguntaADM.class.getResource("/assets/IconArquivo.png")));
			btCarregarEquacao.setBounds(245, 473, 40, 40);
			btCarregarEquacao.setContentAreaFilled(false);
			btCarregarEquacao.setFocusPainted(false);
		}
		return btCarregarEquacao;
	}

	public JButton getBtVoltar() {
		if (btVoltar == null) {
			btVoltar = new JButton("");
			btVoltar.setIcon(new ImageIcon(TelaPerguntaADM.class.getResource("/assets/Skipar Frame (1).png")));
			btVoltar.setBounds(640, 10, 32, 30);
			btVoltar.setContentAreaFilled(false);
			btVoltar.setFocusPainted(false);
		}
		return btVoltar;
	}

}
