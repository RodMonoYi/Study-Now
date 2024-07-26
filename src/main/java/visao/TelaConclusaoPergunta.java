package visao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class TelaConclusaoPergunta extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JLabel lblMensagemFinal;
	JButton btnSim;
	JButton btnNao;
	JLabel lblBackground;
	JLabel lblFalaRobo;
	JLabel lblResultado;
	private JLabel lblConfete;
	private JLabel lblConfete_1;
	private JLabel lblConfete_1_1;
	private JLabel lblConfete_2;
	
	public TelaConclusaoPergunta() {
		setLayout(null);
		setBounds(0, 20, 690, 350);
		addItens();
		setVisible(true);
	}

	private void addItens() {
		add(getLblConfete_2());
		add(getLblConfete_1_1());
		add(getLblConfete_1());
		add(getLblConfete());
		add(getLblResultado());
		add(getLblFalaRobo());
		add(getLblMensagemFinal());
		add(getBtnNao());
		add(getBtnSim());
		add(getLblBackground());
	}
	
	

	public JLabel getLblMensagemFinal() {
		if(lblMensagemFinal==null) {
			lblMensagemFinal = new JLabel();
			lblMensagemFinal.setBounds(310, 130, 290, 50);
		}
		return lblMensagemFinal;
	}

	public JButton getBtnSim() {
		if (btnSim == null) {
			btnSim = new JButton("Sim");
			btnSim.setBounds(30, 270, 70, 25);
		}
		return btnSim;
	}

	public JButton getBtnNao() {
		if (btnNao == null) {
			btnNao = new JButton("Não");
			btnNao.setBounds(115, 270, 70, 25);
		}
		return btnNao;
	}

	public JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon(TelaInicial.class.getResource("/assets/Background.png")));
			lblBackground.setBounds(0, 0, 690, 350);
		}
		return lblBackground;
	}
	
	public JLabel getLblResultado() {
		if (lblResultado == null) {
			lblResultado = new JLabel("Parabéns, você acertou!");
			lblResultado.setForeground(new Color(0, 255, 0));
			lblResultado.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 28));
			lblResultado.setBounds(299, 138, 381, 66);
		}
		return lblResultado;
	}
	
	public JLabel getLblFalaRobo() {
		if (lblFalaRobo == null) {
			lblFalaRobo = new JLabel("Gostaria de ir para outra questão?");
			lblFalaRobo.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblFalaRobo.setBounds(36, 29, 269, 25);
		}
		return lblFalaRobo;
	}
	
	public JLabel getLblConfete() {
		if (lblConfete == null) {
			lblConfete = new JLabel("");
			lblConfete.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblConfete.setIcon(new ImageIcon(TelaConclusaoPergunta.class.getResource("/assets/confete.gif")));
			lblConfete.setBounds(241, 0, 280, 280);
		}
		return lblConfete;
	}
	public JLabel getLblConfete_1() {
		if (lblConfete_1 == null) {
			lblConfete_1 = new JLabel("");
			lblConfete_1.setIcon(new ImageIcon(TelaConclusaoPergunta.class.getResource("/assets/confete.gif")));
			lblConfete_1.setBounds(521, 0, 280, 280);
		}
		return lblConfete_1;
	}
	public JLabel getLblConfete_1_1() {
		if (lblConfete_1_1 == null) {
			lblConfete_1_1 = new JLabel("");
			lblConfete_1_1.setIcon(new ImageIcon(TelaConclusaoPergunta.class.getResource("/assets/confete.gif")));
			lblConfete_1_1.setBounds(521, 197, 280, 280);
		}
		return lblConfete_1_1;
	}
	public JLabel getLblConfete_2() {
		if (lblConfete_2 == null) {
			lblConfete_2 = new JLabel("");
			lblConfete_2.setIcon(new ImageIcon(TelaConclusaoPergunta.class.getResource("/assets/confete.gif")));
			lblConfete_2.setBounds(241, 197, 280, 280);
		}
		return lblConfete_2;
	}
}
