package visao;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modelo.Estudante;

public class TelaWelcome extends JPanel {

	private static final long serialVersionUID = 1L;

	public static Estudante aluno;
	
	JButton btConfig;
	JButton btAtividade;
	JButton btPerfil;
	JLabel lblTitulo;
	JLabel lblIconeSeletivo;
	JLabel lblBackground;

	public TelaWelcome() {
		if(aluno==null)aluno=new Estudante();
		setLayout(null);
		setBounds(0, 20, 690, 350);
		addItens();
		setVisible(true);
	}
	public TelaWelcome(Estudante alunoPersist) {
		setLayout(null);
		aluno=alunoPersist;
		setBounds(0, 20, 690, 350);
		addItens();
		setVisible(true);
	}

	private void addItens() {
		add(getBtConfig());
		add(getBtAtividade());
		add(getBtPerfil());
		add(getLblTitulo());
		add(getLblIconeSeletivo());
		add(getLblBackground());
	}
	
	public Estudante getAluno() {
		return aluno;
	}

	public JButton getBtConfig() {
		if (btConfig == null) {
			btConfig = new JButton();
			btConfig.setBounds(505, 130, 85, 77);
			btConfig.setContentAreaFilled(false);
			btConfig.setFocusPainted(false);
		}
		return btConfig;
	}

	public JButton getBtAtividade() {
		if (btAtividade == null) {
			btAtividade = new JButton();
			btAtividade.setBounds(435, 130, 50, 77);
			btAtividade.setContentAreaFilled(false);
			btAtividade.setFocusPainted(false);
		}
		return btAtividade;
	}

	public JButton getBtPerfil() {
		if (btPerfil == null) {
			btPerfil = new JButton();
			btPerfil.setBounds(340, 130, 57, 77);
			btPerfil.setContentAreaFilled(false);
			btPerfil.setFocusPainted(false);
		}
		return btPerfil;
	}

	public JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel();
			lblTitulo.setText("Seja bem vindo " + obterPrimeiroNome(aluno.getNome()));
			lblTitulo.setFont(new Font("Barlow Condensed Light", Font.PLAIN, 24));
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setBounds(310, 60, 300, 31);
		}
		return lblTitulo;
	}
	public String obterPrimeiroNome(String nomeCompleto) {
	    if (nomeCompleto == null || nomeCompleto.isEmpty()) {
	        return ""; 
	    }
	    String[] partesNome = nomeCompleto.split("\\s+");

	    if (partesNome.length > 0) {
	        return partesNome[0];
	    } else {
	        return ""; 
	    }
	}


	public JLabel getLblIconeSeletivo() {
		if (lblIconeSeletivo == null) {
			lblIconeSeletivo = new JLabel();
			lblIconeSeletivo.setBounds(330, 120, 262, 88);
			lblIconeSeletivo.setIcon(new ImageIcon(TelaWelcome.class.getResource("/assets/Icones do PanelWelcome.png")));
		}
		return lblIconeSeletivo;
	}

	public JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon(TelaInicial.class.getResource("/assets/Background.png")));
			lblBackground.setBounds(0, 0, 690, 350);
		}
		return lblBackground;
	}
}
