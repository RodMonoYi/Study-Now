package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaEquacaoMontada extends JPanel {
	
	private static final long serialVersionUID = 1L;
	JTextField tfResposta1;
	JTextField tfResposta2;
	JTextField tfResposta3;
	JTextField tfResposta4;
	JButton btnAjuda;
	JButton btnEnviar;
	JLabel lblResposta1;
	JLabel lblResposta2;
	JLabel lblResposta3;
	JLabel lblResposta4;
	JLabel lblEquacao;
	JLabel lblBackground;
	JLabel lblNewLabel;
	JLabel lblRespostaErrada;
	
	public TelaEquacaoMontada() {
		setLayout(null);
		setBounds(0, 20, 690, 350);
		addItens();
		setVisible(true);
	}

	private void addItens() {
		add(getLblRespostaErrada());
		add(getLblNewLabel());
		add(getTfResposta1());
		add(getTfResposta2());
		add(getTfResposta3());
		add(getTfResposta4());
		add(getBtnAjuda());
		add(getBtnEnviar());
		add(getLblResposta1());
		add(getLblResposta2());
		add(getLblResposta3());
		add(getLblResposta4());
		add(getLblEquacao());
		add(getLblBackground());
	}

	public JTextField getTfResposta1() {
		if(tfResposta1==null) {
			tfResposta1 = new JTextField();
			tfResposta1.setBounds(300, 171, 134, 20);
			tfResposta1.setVisible(true);
		}
		return tfResposta1;
	}

	public JTextField getTfResposta2() {
		if(tfResposta2==null) {
			tfResposta2 = new JTextField();
			tfResposta2.setBounds(300, 211, 134, 20);
			tfResposta2.setVisible(true);
		}
		return tfResposta2;
	}

	public JTextField getTfResposta3() {
		if(tfResposta3==null) {
			tfResposta3 = new JTextField();
			tfResposta3.setBounds(300, 251, 134, 20);
			tfResposta3.setVisible(false);
			if(TelaEnunciado.perguntaAtual.getQtdEstados()!=2) {
				tfResposta3.setVisible(true);
			}
		}
		return tfResposta3;
	}

	public JTextField getTfResposta4() {
		if(tfResposta4==null) {
			tfResposta4 = new JTextField();
			tfResposta4.setBounds(300, 291, 134, 20);
			tfResposta4.setVisible(false);
			if(TelaEnunciado.perguntaAtual.getQtdEstados()>3) {
				tfResposta4.setVisible(true);
			}
		}
		return tfResposta4;
	}

	public JButton getBtnAjuda() {
		if (btnAjuda == null) {
			btnAjuda = new JButton("O que é cadeia de Markov?");
			btnAjuda.setBounds(510, 11, 170, 25);
		}
		return btnAjuda;
	}

	public JButton getBtnEnviar() {
		if (btnEnviar == null) {
			btnEnviar = new JButton("Enviar");
			btnEnviar.setBounds(590, 280, 70, 23);
		}
		return btnEnviar;
	}
	
	public String separarStringPorVirgula(String entrada, int numero) {
        String[] partes = entrada.split("\\s*,\\s*");
        if (numero >= 1 && numero <= partes.length) {
            return partes[numero - 1];
        }
        return null;
    }
	
	public JLabel getLblResposta1() {
		if(lblResposta1==null) {
			lblResposta1 = new JLabel();
			lblResposta1.setBounds(300, 151, 300, 20);
			lblResposta1.setText(separarStringPorVirgula(TelaEnunciado.perguntaAtual.getIdentEstadoCorreto(), 1));
			lblResposta1.setVisible(true);
		}
		return lblResposta1;
	}

	public JLabel getLblResposta2() {
		if(lblResposta2==null) {
			lblResposta2 = new JLabel();
			lblResposta2.setBounds(300, 191, 300, 20);
			lblResposta2.setText(separarStringPorVirgula(TelaEnunciado.perguntaAtual.getIdentEstadoCorreto(), 2));
			lblResposta2.setVisible(true);
		}
		return lblResposta2;
	}

	public JLabel getLblResposta3() {
		if(lblResposta3==null) {
			lblResposta3 = new JLabel();
			lblResposta3.setBounds(300, 231, 300, 20);
			lblResposta3.setVisible(false);
			if(TelaEnunciado.perguntaAtual.getQtdEstados()!=2) {
				lblResposta3.setText(separarStringPorVirgula(TelaEnunciado.perguntaAtual.getIdentEstadoCorreto(), 3));
				lblResposta3.setVisible(true);
			}
		}
		return lblResposta3;
	}

	public JLabel getLblResposta4() {
		if(lblResposta4==null) {
			lblResposta4 = new JLabel();
			lblResposta4.setBounds(300, 271, 300, 20);
			lblResposta4.setVisible(false);
			if(TelaEnunciado.perguntaAtual.getQtdEstados()>3) {
				lblResposta4.setText(separarStringPorVirgula(TelaEnunciado.perguntaAtual.getIdentEstadoCorreto(), 4));
				lblResposta4.setVisible(true);
			}
		}
		return lblResposta4;
	}
	
	public JLabel getLblEquacao() {
		if (lblEquacao == null) {
			lblEquacao = new JLabel();
			lblEquacao.setBounds(246, 63, 420, 88);
			lblEquacao.setIcon(iconRedimensionadoEquacao(
					new ImageIcon(TelaEnunciado.perguntaAtual.getImgPergunta().getImagemEquacao())));
		}
		return lblEquacao;
	}
	
	private ImageIcon iconRedimensionadoEquacao(ImageIcon icon) {
		Image imagem = icon.getImage();
		Image imagemRedimensionada = imagem.getScaledInstance(420, 68, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(imagemRedimensionada);
	}
	
	public JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon(TelaInicial.class.getResource("/assets/Background.png")));
			lblBackground.setBounds(0, 0, 690, 350);
		}
		return lblBackground;
	}
	
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("<html><body>Agora baseado na equação a seguir, informe os valores dos estados finais trabalhados<body/><html/>");
			lblNewLabel.setBounds(246, 40, 353, 25);
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
	    	lblRespostaErrada.setBounds(300, 325, 255, 14);
	    	lblRespostaErrada.setVisible(false);
	    }
	    return lblRespostaErrada;
	}
}
