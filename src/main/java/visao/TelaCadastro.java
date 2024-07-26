package visao;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

public class TelaCadastro extends JPanel {
	private static final long serialVersionUID = 1L;

	JLabel lblBackground;
	JLabel lblTitulo;
	JLabel lblNome;
	JLabel lblMatricula;
	JLabel lblDataNasc;
	JLabel lblSenha;
	JLabel lblSenhaConfirmar;
	JLabel aviso;
	JLabel infoMatricula;
	JLabel infoSenha;
	JTextField tfNome;
	JTextField tfMatricula;
	JFormattedTextField tfDataNasc;
	JPasswordField tfSenha;
	JPasswordField tfSenhaConfirmar;
	JButton btCadastrar;
	
	MaskFormatter mascaraDTNasc;

	public TelaCadastro() {
		setLayout(null);
		setBounds(0, 20, 690, 350);
		addItens();
		setVisible(true);
	}

	private void addItens() {
		add(getTfNome());
		add(getTfMatricula());
		add(getTfDataNasc());
		add(getTfSenha());
		add(getTfSenhaConfirmar());
		add(getBtCadastrar());
		add(getLblNome());
		add(getLblTitulo());
		add(getLblMatricula());
		add(getLblDataNasc());
		add(getLblSenha());
		add(getLblSenhaConfirmar());
		add(getAviso());
		add(getInfoMatricula());
		add(getInfoSenha());
		add(getLblBackground());
	}

	public TelaCadastro getTela() {
		return this;
	}
	public JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon(TelaInicial.class.getResource("/assets/Background.png")));
			lblBackground.setBounds(0, 0, 690, 350);
		}
		return lblBackground;
	}

	public JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel();
			lblTitulo.setText("Cadastro");
			lblTitulo.setFont(new Font("Barlow Condensed Light", Font.PLAIN, 24));
	 		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	 		lblTitulo.setBounds(339, 26, 197, 31);
		}
		return lblTitulo;
	}

	public JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel();
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNome.setBounds(327, 80, 40, 14);
			lblNome.setText("Nome");
		}
		return lblNome;
	}

	public JLabel getLblMatricula() {
		if (lblMatricula == null) {
			lblMatricula = new JLabel();
			lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMatricula.setBounds(307, 110, 57, 14);
			lblMatricula.setText("Matricula");
		}
		return lblMatricula;
	}

	public JLabel getLblDataNasc() {
		if (lblDataNasc == null) {
			lblDataNasc = new JLabel();
			lblDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDataNasc.setBounds(290, 135, 133, 30);
			lblDataNasc.setText("Data de Nascimento");
		}
		return lblDataNasc;
	}

	public JLabel getLblSenha() {
		if (lblSenha == null) {
			lblSenha = new JLabel();
			lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSenha.setBounds(330, 165, 40, 30);
			lblSenha.setText("Senha");
		}
		return lblSenha;
	}
	
	public JLabel getLblSenhaConfirmar() {
		if (lblSenhaConfirmar == null) {
			lblSenhaConfirmar = new JLabel();
			lblSenhaConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSenhaConfirmar.setBounds(280, 195, 100, 30);
			lblSenhaConfirmar.setText("Confirmar Senha");
		}
		return lblSenhaConfirmar;
	}
	
	public JLabel getAviso() {
		if(aviso == null) {
			aviso = new JLabel();
			aviso.setForeground(new Color(255, 0, 0));
			aviso.setFont(new Font("Tahoma", Font.BOLD, 12));
			aviso.setText("");
			aviso.setBounds(302, 240, 255, 20);
		}
		return aviso;
	}
	
	public JLabel getInfoMatricula() {
		if(infoMatricula == null) {
			infoMatricula = new JLabel();
			infoMatricula.setToolTipText("A sua Matricula servirá como seu UserName no processo de login");
			infoMatricula.setIcon(new ImageIcon(TelaCadastro.class.getResource("/assets/iconInfo (1).png")));
			infoMatricula.setForeground(new Color(0, 0, 0));
			infoMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
			infoMatricula.setText("");
			infoMatricula.setBounds(560, 110, 20, 20);
		}
		return infoMatricula;
	}
	
	public JLabel getInfoSenha() {
		if(infoSenha == null) {
			infoSenha = new JLabel();
			infoSenha.setToolTipText("A sua senha deverá ter, no mínimo 6 caracteres, e no máximo 10");
			infoSenha.setIcon(new ImageIcon(TelaCadastro.class.getResource("/assets/iconInfo (1).png")));
			infoSenha.setForeground(new Color(0, 0, 0));
			infoSenha.setFont(new Font("Tahoma", Font.BOLD, 12));
			infoSenha.setText("");
			infoSenha.setBounds(560, 170, 20, 20);
		}
		return infoSenha;
	}
	

	public JTextField getTfNome() {
		if (tfNome == null) {
			tfNome = new JTextField();
			tfNome.setToolTipText("Insira seu nome completo");
			tfNome.setBounds(377, 80, 180, 20);
		}
		return tfNome;
	}

	public JTextField getTfMatricula() {
		if (tfMatricula == null) {
			tfMatricula = new JTextField();
			tfMatricula.setBounds(377, 110, 180, 20);
		}
		return tfMatricula;
	}

	public JFormattedTextField getTfDataNasc() {
		if (tfDataNasc == null) {
			try {
				mascaraDTNasc = new MaskFormatter("##/##/####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			tfDataNasc = new JFormattedTextField(mascaraDTNasc);
			tfDataNasc.setToolTipText("     /     /");
			tfDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 15));
			tfDataNasc.setBounds(430, 140, 80, 20);
		}
		return tfDataNasc;
	}

	public JPasswordField getTfSenha() {
		if (tfSenha == null) {
			tfSenha = new JPasswordField();
			tfSenha.setBounds(387, 170, 170, 20);
		}
		return tfSenha;
	}
	
	public JPasswordField getTfSenhaConfirmar() {
		if (tfSenhaConfirmar == null) {
			tfSenhaConfirmar = new JPasswordField();
			tfSenhaConfirmar.setBounds(387, 200, 170, 20);
		}
		return tfSenhaConfirmar;
	}

	public JButton getBtCadastrar() {
		if(btCadastrar==null) {
			btCadastrar = new JButton();
			btCadastrar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/assets/button_cadastro.png")));
			btCadastrar.setBounds(537, 274, 115, 53);
			btCadastrar.setContentAreaFilled(false);
			btCadastrar.setFocusPainted(false);
		}
		return btCadastrar;
	}
	
}
