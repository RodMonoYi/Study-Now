package visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modelo.Estudante;

public class TelaSeletorDificuldade extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Estudante aluno;
	
	JCheckBox chbxEsperanca;
	JCheckBox chbxEstabilidade;
	JCheckBox chbxCustos;
	JCheckBox chbxPermanencia;
	
	JComboBox<String> cbDificuldade;
	
	JButton btSelecionar;
	JButton btVoltar;
	JLabel lblTitulo;
	JLabel lblAviso;
	JLabel lblBackground;
	
	int checar;
	
	public TelaSeletorDificuldade(Estudante alunoPersist) {
		setLayout(null);
		aluno=alunoPersist;
		setBounds(0, 20, 690, 350);
		addItens();
		setVisible(true);
	}

	private void addItens() {
		checar=0;
		add(getLblAviso());
		add(getChbxEsperanca());
		add(getChbxEstabilidade());
		add(getChbxCustos());
		add(getChbxPermanencia());
		add(getCbDificuldade());
		add(getBtSelecionar());
		add(getBtVoltar());
		add(getLblTitulo());
		add(getLblBackground());
	}
	
	public Estudante getAluno() {
		return aluno;
	}
	
	public JCheckBox getChbxEsperanca() {
		if (chbxEsperanca == null) {
			chbxEsperanca = new JCheckBox("Esperança");
			chbxEsperanca.setBackground(new Color(255, 255, 255));
			chbxEsperanca.setBounds(344, 133, 97, 23);
		}
		return chbxEsperanca;
	}
	
	public JCheckBox getChbxEstabilidade() {
		if (chbxEstabilidade == null) {
			chbxEstabilidade = new JCheckBox("Estabilidade");
			chbxEstabilidade.setBackground(Color.WHITE);
			chbxEstabilidade.setBounds(344, 159, 97, 23);
		}
		return chbxEstabilidade;
	}
	
	public JCheckBox getChbxCustos() {
		if (chbxCustos == null) {
			chbxCustos = new JCheckBox("Custos");
			chbxCustos.setBackground(Color.WHITE);
			chbxCustos.setBounds(344, 185, 97, 23);
		}
		return chbxCustos;
	}
	
	public JCheckBox getChbxPermanencia() {
		if (chbxPermanencia == null) {
			chbxPermanencia = new JCheckBox("Permanência");
			chbxPermanencia.setBackground(Color.WHITE);
			chbxPermanencia.setBounds(344, 211, 97, 23);
		}
		return chbxPermanencia;
	}
	
	public JComboBox<String> getCbDificuldade() {
		if (cbDificuldade == null) {
			cbDificuldade = new JComboBox<String>();
			cbDificuldade.setFont(new Font("Verdana", Font.PLAIN, 13));
			cbDificuldade.setModel(new DefaultComboBoxModel<String>(new String[] {"Básica", "Intermediária","Avançada"}));
			cbDificuldade.setBounds(507, 133, 110, 30);
		}
		return cbDificuldade;
	}
	
	public JButton getBtSelecionar() {
		if (btSelecionar == null) {
			btSelecionar = new JButton("");
			btSelecionar.setIcon(new ImageIcon(TelaSeletorDificuldade.class.getResource("/assets/download (1).gif")));
			btSelecionar.setContentAreaFilled(false);
			btSelecionar.setBorder(null);
			btSelecionar.setBorderPainted(false);
			btSelecionar.setBounds(490, 180, 120, 50);
			btSelecionar.setVisible(false);
		}
		return btSelecionar;
	}
	
	public JButton getBtVoltar() {
		if(btVoltar == null) {
			btVoltar = new JButton("");
			btVoltar.setIcon(new ImageIcon(TelaSeletorDificuldade.class.getResource("/assets/Skipar Frame (1).png")));
			btVoltar.setContentAreaFilled(false);
			btVoltar.setBorder(null);
			btVoltar.setBorderPainted(false);
			btVoltar.setBounds(340, 270, 40, 40);
		}
		return btVoltar;
	}
	
	public JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("<html><body>Agora filtre as questões<br>que você quer resolver!</body></html>" );
			lblTitulo.setLocation(349, 72);
			lblTitulo.setSize(202, 54);
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Barlow Condensed Light", Font.PLAIN, 19));
		}
		return lblTitulo;
	}
	
	public JLabel getLblAviso() {
		if (lblAviso == null) {
			lblAviso = new JLabel();
			lblAviso.setForeground(new Color(255, 0, 0));
			lblAviso.setLocation(300, 245);
			lblAviso.setSize(380, 20);
			lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
			lblAviso.setFont(new Font("Dialog", Font.BOLD, 12));
			lblAviso.setVisible(false);
		}
		return lblAviso;
	}
	
	public JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon(TelaInicial.class.getResource("/assets/Background.png")));
			lblBackground.setBounds(0, 0, 690, 350);
		}
		return lblBackground;
	}
	
	public void checagem(JCheckBox cb) {
		if(cb.isSelected())
			checar++;
		else
			checar--;
		
		if (checar >= 1)
			btSelecionar.setVisible(true);
		else
			btSelecionar.setVisible(false);
	}

}
