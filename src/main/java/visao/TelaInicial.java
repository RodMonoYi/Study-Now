package visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TelaInicial extends JPanel {

	private static final long serialVersionUID = 1L;

	JLabel lblTitulo;
	JLabel lblBackground;
	JButton btnLogin;
	JButton btnCadastro;

	public TelaInicial() {
		setLayout(null);
		setBounds(0, 20, 690, 350);
		addItens();
		setVisible(true);
	}

	public void addItens() {
		add(getBtnCadastro());
		add(getBtnLogin());
		add(getLblTitulo());
		add(getLblBackground());
	}
	
	public TelaInicial getTela() {
		return this;
	}

	public JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Markov");
			lblTitulo.setFont(new Font("Barlow Condensed Light", Font.PLAIN, 24));
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setBounds(221, 72, 469, 31);
		}
		return lblTitulo;
	}

	public JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon(TelaInicial.class.getResource("/assets/Background.png")));
			lblBackground.setBounds(0, 0, 690, 350);
		}
		return lblBackground;
	}

	public JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("");
			btnLogin.setIcon(new ImageIcon(TelaInicial.class.getResource("/assets/button_login.png")));
			btnLogin.setContentAreaFilled(false);
			btnLogin.setFocusPainted(false);
			btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
			btnLogin.setBackground(new Color(255, 255, 255));
			btnLogin.setFont(new Font("Barlow Condensed Light", Font.PLAIN, 19));
			btnLogin.setFocusPainted(false);
			btnLogin.setBorder(null);
			btnLogin.setBounds(398, 124, 115, 53);
		}
		return btnLogin;
	}

	public JButton getBtnCadastro() {
		if (btnCadastro == null) {
			btnCadastro = new JButton("");
			btnCadastro.setIcon(new ImageIcon(TelaInicial.class.getResource("/assets/button_cadastro.png")));
			btnCadastro.setContentAreaFilled(false);
			btnCadastro.setFocusPainted(false);
			btnCadastro.setHorizontalAlignment(SwingConstants.LEFT);
			btnCadastro.setBackground(new Color(255, 255, 255));
			btnCadastro.setFont(new Font("Barlow Condensed Light", Font.PLAIN, 19));
			btnCadastro.setBorder(null);
			btnCadastro.setBounds(398, 188, 115, 53);
		}
		return btnCadastro;
	}

}
