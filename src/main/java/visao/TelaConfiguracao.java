package visao;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Estudante;

public class TelaConfiguracao extends JPanel {
	
	private static final long serialVersionUID = 1L;

	static Estudante aluno;
	
	JLabel lblBackground;
	
	public TelaConfiguracao(Estudante alunoPersist) {
		setLayout(null);
		aluno=alunoPersist;
		setBounds(0, 20, 690, 350);
		addItens();
		setVisible(true);
	}
	
	private void addItens() {
		add(getLblBackground());
	}

	public JLabel getLblBackground() {
		if(lblBackground==null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon(TelaInicial.class.getResource("/assets/Background.png")));
			lblBackground.setBounds(0, 0, 690, 350);
		}
		return lblBackground;
	}

	
}
