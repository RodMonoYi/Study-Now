package visao;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class TelaDiagramaRespondido extends JPanel {

	private static final long serialVersionUID = 1L;

	JComboBox<String> cbxListaPergunta;
	JLabel lblDiagramaRespondido;
	JLabel lblFalaRobo;
	JButton btnSim;
	JButton btnNao;
	JButton btnAjuda;
	JButton btnEnviar;
	JLabel lblBackground;
	private JLabel lblNewLabel;
	JLabel infoDiagrama;
	JLabel lblRespostaErrada;

	public TelaDiagramaRespondido() {
		setLayout(null);
		setBounds(0, 20, 690, 350);
		addItens();
		setVisible(true);
	}

	private void addItens() {
		add(getLblRespostaErrada());
		add(getInfoDiagrama());
		add(getLblNewLabel());
		add(getLblDiagramaRespondido());
		add(getLblFalaRobo());
		add(getCbxListaPergunta());
		add(getBtnNao());
		add(getBtnSim());
		add(getBtnAjuda());
		add(getBtnEnviar());
		add(getLblBackground());
	}

	public JLabel getLblDiagramaRespondido() {
		if (lblDiagramaRespondido == null) {
			lblDiagramaRespondido = new JLabel();
			lblDiagramaRespondido.setBounds(289, 80, 350, 200);
			lblDiagramaRespondido.setIcon(iconRedimensionadoDiagrama(
					new ImageIcon(TelaEnunciado.perguntaAtual.getImgPergunta().getImagemDiagrama())));
		}
		return lblDiagramaRespondido;
	}

	public JLabel getLblFalaRobo() {
		if (lblFalaRobo == null) {
			lblFalaRobo = new JLabel("Você entendeu?");
			lblFalaRobo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblFalaRobo.setBounds(56, 28, 129, 25);
		}
		return lblFalaRobo;
	}

	private ImageIcon iconRedimensionadoDiagrama(ImageIcon icon) {
		Image imagem = icon.getImage();
		Image imagemRedimensionada = imagem.getScaledInstance(350, 200, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(imagemRedimensionada);
	}

	public JButton getBtnNao() {
		if (btnNao == null) {
			btnNao = new JButton("Não");
			btnNao.setBounds(115, 270, 70, 25);
		}
		return btnNao;
	}

	public JButton getBtnSim() {
		if (btnSim == null) {
			btnSim = new JButton("Sim");
			btnSim.setBounds(30, 270, 70, 25);
		}
		return btnSim;
	}

	public JButton getBtnAjuda() {
		if (btnAjuda == null) {
			btnAjuda = new JButton("O que é cadeia de Markov?");
			btnAjuda.setBounds(510, 15, 170, 25);
		}
		return btnAjuda;
	}

	public JButton getBtnEnviar() {
		if (btnEnviar == null) {
			btnEnviar = new JButton("Enviar");
			btnEnviar.setBounds(600, 310, 70, 23);
			btnEnviar.setVisible(false);
		}
		return btnEnviar;
	}

	public JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon(TelaDiagramaRespondido.class.getResource("/assets/Design sem nome.png")));
			lblBackground.setBounds(0, 0, 690, 350);
		}
		return lblBackground;
	}
	
	public TelaDiagramaRespondido getTela() {
		return this;
	}
	
	public JLabel getInfoDiagrama() {
		if (infoDiagrama == null) {
			infoDiagrama = new JLabel();
			infoDiagrama.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(getTela(),
							"<html><body style='text-align: justify; width: 200px; '>"
									+ TelaEnunciado.perguntaAtual.getEnunciado() + "</body></html>",
							null, JOptionPane.INFORMATION_MESSAGE);
				}
			});
			infoDiagrama.setToolTipText("Clique para ler o enunciado");
			infoDiagrama.setIcon(new ImageIcon(TelaCadastro.class.getResource("/assets/iconInfo (1).png")));
			infoDiagrama.setForeground(new Color(0, 0, 0));
			infoDiagrama.setFont(new Font("Tahoma", Font.BOLD, 12));
			infoDiagrama.setText("");
			infoDiagrama.setBounds(266, 43, 20, 20);
		}
		return infoDiagrama;
	}

	public JComboBox<String> getCbxListaPergunta() {
		if (cbxListaPergunta == null) {
			cbxListaPergunta = new JComboBox<String>();
			cbxListaPergunta.setBounds(200, 280, 460, 22);
			geraListaPerguntas(cbxListaPergunta);
			cbxListaPergunta.setVisible(true);
			cbxListaPergunta.setVisible(false);
		}
		return cbxListaPergunta;
	}

	public void geraListaPerguntas(JComboBox<String> comboBox) {
		Random random = new Random();
		int numeroAleatorio = random.nextInt(4);
		if (numeroAleatorio == 0) {
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaCorreta());
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaErrada1());
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaErrada2());
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaErrada3());
		} else if (numeroAleatorio == 1) {
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaErrada3());
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaCorreta());
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaErrada1());
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaErrada2());
		} else if (numeroAleatorio == 2) {
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaErrada2());
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaErrada1());
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaCorreta());
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaErrada3());
		} else {
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaErrada3());
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaErrada2());
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaErrada1());
			getCbxListaPergunta().addItem(TelaEnunciado.perguntaAtual.getPerguntaCorreta());
		}
		getCbxListaPergunta().setVisible(true);
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("<html><body>Parabéns!!! Seu diagrama ficou ótimo. Mas você sabe o que a questão pede?<body/><html/>");
			lblNewLabel.setBounds(294, 34, 305, 34);
		}
		return lblNewLabel;
	}
	
	public JLabel getLblRespostaErrada() {
	    if (lblRespostaErrada == null) {
	    	lblRespostaErrada = new JLabel();
	    	lblRespostaErrada.setForeground(Color.RED);
	    	lblRespostaErrada.setVerticalAlignment(SwingConstants.TOP);
	    	lblRespostaErrada.setFont(new Font("Arial", Font.PLAIN, 10));
	    	lblRespostaErrada.setText("*Você errou. Tente novamente ou peça ajuda!");
	    	lblRespostaErrada.setBounds(297, 307, 255, 14);
	    	lblRespostaErrada.setVisible(false);
	    }
	    return lblRespostaErrada;
	}
}
