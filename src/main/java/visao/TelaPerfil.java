package visao;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modelo.Estudante;
import java.awt.Color;

public class TelaPerfil extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Estudante aluno;
	
	JButton btnVoltar;
	JButton btnSairConta;
	JLabel lblSairConta;
	JLabel lblScore;
	JLabel lblPerguntas;
	JLabel lblRespostas;
	JLabel lblAjudas;
	JLabel lblNomeUsuario;
	JLabel lblBackground;
	
	public TelaPerfil(Estudante alunoPersist) {
		setLayout(null);
		aluno=alunoPersist;
		setBounds(0, 20, 690, 350);
		addItens();
		setVisible(true);
	}

	private void addItens() {
		add(getBtnSairConta());
		add(getBtnVoltar());
		add(getLblSairConta());
		add(getLblScore());
		add(getLblPerguntas());
		add(getLblRespostas());
		add(getLblAjudas());
		add(getLblNomeUsuario());
		add(getLblBackground());
	}
	
	public Estudante getAluno() {
		return aluno;
	}

	public JButton getBtnVoltar() {
		if(btnVoltar == null) {
			btnVoltar = new JButton();
			btnVoltar.setIcon(new ImageIcon(TelaPerfil.class.getResource("/assets/Skipar Frame (1).png")));
			btnVoltar.setBounds(325, 270, 40, 40);
			btnVoltar.setContentAreaFilled(false);
			btnVoltar.setFocusPainted(false);
		}
		return btnVoltar;
	}
	
	public JButton getBtnSairConta() {
		if(btnSairConta == null) {
			btnSairConta = new JButton();
			btnSairConta.setBounds(560, 290, 100, 30);
			btnSairConta.setContentAreaFilled(false);
			btnSairConta.setFocusPainted(false);
		}
		return btnSairConta;
	}
	
	public JLabel getLblSairConta() {
		if(lblSairConta == null) {
			lblSairConta = new JLabel("Sair da Conta");
			lblSairConta.setForeground(new Color(255, 255, 255));
			lblSairConta.setHorizontalAlignment(SwingConstants.CENTER);
			lblSairConta.setFont(new Font("Century Gothic", Font.BOLD, 15));
			lblSairConta.setBounds(560, 290, 100, 30);
		}
		return lblSairConta;
	}

	public JLabel getLblScore() {
		if(lblScore == null) {
			lblScore = new JLabel("<html><body>Score<br>0/10</body></html>");
			lblScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblScore.setFont(new Font("Century Gothic", Font.PLAIN, 14));
			lblScore.setBounds(521, 156, 75, 64);
		}
		return lblScore;
	}

	public JLabel getLblPerguntas() {
		if(lblPerguntas == null) {
			lblPerguntas = new JLabel("Perguntas Respondidas: " + aluno.getPerguntasFeitas());
			lblPerguntas.setVerticalAlignment(SwingConstants.BOTTOM);
			lblPerguntas.setHorizontalAlignment(SwingConstants.LEFT);
			lblPerguntas.setFont(new Font("Barlow Condensed Light", Font.PLAIN, 13));
			lblPerguntas.setBounds(345, 158, 170, 14);
		}
		return lblPerguntas;
	}

	public JLabel getLblRespostas() {
		if(lblRespostas == null) {
			lblRespostas = new JLabel("Respostas Acertadas: " + aluno.getRespostasAcertadas());
			lblRespostas.setVerticalAlignment(SwingConstants.BOTTOM);
			lblRespostas.setHorizontalAlignment(SwingConstants.LEFT);
			lblRespostas.setFont(new Font("Barlow Condensed Light", Font.PLAIN, 13));
			lblRespostas.setBounds(345, 183, 170, 14);
		}
		return lblRespostas;
	}

	public JLabel getLblAjudas() {
		if(lblAjudas == null) {
			lblAjudas = new JLabel("Ajudas:" + aluno.getAjudasPedidas());
			lblAjudas.setVerticalAlignment(SwingConstants.BOTTOM);
			lblAjudas.setHorizontalAlignment(SwingConstants.LEFT);
			lblAjudas.setFont(new Font("Barlow Condensed Light", Font.PLAIN, 13));
			lblAjudas.setBounds(345, 208, 130, 14);
		}
		return lblAjudas;
	}

	public JLabel getLblNomeUsuario() {
		if(lblNomeUsuario == null) {
			lblNomeUsuario = new JLabel();
			lblNomeUsuario.setText(aluno.getNome());
			lblNomeUsuario.setVerticalAlignment(SwingConstants.BOTTOM);
			lblNomeUsuario.setFont(new Font("Barlow Condensed Light", Font.PLAIN, 17));
			lblNomeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			lblNomeUsuario.setBounds(290, 82, 380, 29);
		}
		return lblNomeUsuario;
	}

	public JLabel getLblBackground() {
		if(lblBackground == null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon(TelaInicial.class.getResource("/assets/Background.png")));
			lblBackground.setBounds(0, 0, 690, 350);
		}
		return lblBackground;
	}

}
