package visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;

	JLabel lblTitulo;
	JLabel lblBackground;
	JLabel lblLogin;
	JLabel lblSenha;
	JLabel aviso;
	JTextField txtLogin;
	JPasswordField txtSenha;
	JButton btnLogar;

	public TelaLogin() {
		setLayout(null);
		setBounds(0, 20, 690, 350);
		addItens();
		setVisible(true);
	}

	private void addItens() {
		add(getTxtLogin());
		add(getTxtSenha());
		add(getBtnLogar());
		add(getLblLogin());
		add(getLblTitulo());
		add(getLblSenha());
		add(getAviso());
		add(getLblBackground());
	}
	
	public TelaLogin getTela() {
		return this;
	}

	public JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel();
			lblTitulo.setText("Markov");
			lblTitulo.setFont(new Font("Barlow Condensed Light", Font.PLAIN, 24));
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setBounds(344, 48, 197, 31);
		}
		return lblTitulo;
	}

	private JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon(TelaInicial.class.getResource("/assets/Background.png")));
			lblBackground.setBounds(0, 0, 690, 350);
		}
		return lblBackground;
	}

	public JTextField getTxtLogin() {
		if (txtLogin == null) {
			txtLogin = new JTextField();
			
			
			txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtLogin.setText("Usuário");
			txtLogin.setForeground(new Color(192, 192, 192));
			txtLogin.setBounds(359, 113, 223, 42);
		}
		return txtLogin;
	}

	public JPasswordField getTxtSenha() {
		if (txtSenha == null) {
			txtSenha = new JPasswordField();
			txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtSenha.setText("senhaaaa");
			txtSenha.setForeground(new Color(192, 192, 192));
			txtSenha.setBounds(359, 182, 223, 42);
		}
		return txtSenha;
	}

	public JButton getBtnLogar() {
		if (btnLogar == null) {
			btnLogar = new JButton();
			btnLogar.setIcon(new ImageIcon(TelaLogin.class.getResource("/assets/button_login.png")));
			btnLogar.setBounds(553, 275, 115, 53);
			btnLogar.setContentAreaFilled(false);
			btnLogar.setFocusPainted(false);
		}
		return btnLogar;
	}

	public JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel();
			lblLogin.setIcon(new ImageIcon(TelaLogin.class.getResource("/assets/IconeLogin (2).png")));
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblLogin.setBounds(315, 119, 30, 30);
		}
		return lblLogin;
	}

	public JLabel getLblSenha() {
		if (lblSenha == null) {
			lblSenha = new JLabel();
			lblSenha.setIcon(new ImageIcon(TelaLogin.class.getResource("/assets/IconSenha (1).png")));
			lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblSenha.setBounds(315, 188, 30, 30);
		}
		return lblSenha;
	}

	public JLabel getAviso() {
		if(aviso == null) {
			aviso = new JLabel();
			aviso.setForeground(new Color(255, 0, 0));
			aviso.setFont(new Font("Tahoma", Font.BOLD, 12));
			aviso.setText("");
			aviso.setBounds(301, 246, 255, 20);
		}
		return aviso;
	}
}
