package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaDiagrama extends JPanel {
	private static final long serialVersionUID = 1L;

	JLabel lblBackground;
	JLabel infoDiagrama;
	JLabel lblDiagrama;
	JLabel lblFalaRobo;
	JLabel lblEnunciado;
	JLabel lblIdentificacao1;
	JLabel lblIdentificacao2;
	JLabel lblIdentificacao3;
	JButton btnAjuda;
	JButton btnSim;
	JButton btnNao;
	JLabel lblRespostaErrada;
	private JTextField tfAPA;
	private JTextField tfAPB;
	private JTextField tfAPC;
	private JTextField tfBPA;
	private JTextField tfBPB;
	private JTextField tfBPC;
	private JTextField tfCPA;
	private JTextField tfCPB;
	private JTextField tfCPC;
	private JButton btnAvancar;
	private JLabel lblpreenchaOsCampos;

	public TelaDiagrama() {
		setLayout(null);
		setBounds(0, 20, 690, 350);
		addItens();
		setVisible(true);
	}

	public void addItens() {
		add(getLblRespostaErrada());
		add(getLblpreenchaOsCampos());
		add(getLblIdentificacao3());
		add(getLblIdentificacao2());
		add(getLblIdentificacao1());
		add(getBtnAvancar());
		add(getLblFalaRobo());
		add(getLblEnunciado());
		add(getBtnSim());
		add(getBtnNao());
		add(getBtnAjuda());
		add(getInfoDiagrama());
		add(getTfAPA());
		add(getTfAPB());
		add(getTfAPC());
		add(getTfBPA());
		add(getTfBPB());
		add(getTfBPC());
		add(getTfCPA());
		add(getTfCPB());
		add(getTfCPC());
		add(getLblDiagrama());
		add(getLblBackground());
	}

	public JLabel getLblDiagrama() {
		if (lblDiagrama == null) {
			lblDiagrama = new JLabel("");
			lblDiagrama.setIcon(new ImageIcon(TelaDiagrama.class.getResource("/assets/Diagrama2EstadosRedimensionado.jpg")));
			lblDiagrama.setBounds(296, 90, 350, 200);
		}
		return lblDiagrama;
	}

	public TelaDiagrama getTela() {
		return this;
	}

	public JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon(TelaDiagrama.class.getResource("/assets/Design sem nome.png")));
			lblBackground.setBounds(0, 0, 690, 350);
		}
		return lblBackground;
	}

	public JLabel getInfoDiagrama() {
		if (infoDiagrama == null) {
			infoDiagrama = new JLabel();
			infoDiagrama.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(getTela(),
							"<html><body style='text-align: justify; width: 300px; '>"
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

	public JLabel getLblFalaRobo() {
		if (lblFalaRobo == null) {
			lblFalaRobo = new JLabel("Você entendeu?");
			lblFalaRobo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblFalaRobo.setBounds(56, 28, 129, 25);
		}
		return lblFalaRobo;
	}

	public JLabel getLblEnunciado() {
		if (lblEnunciado == null) {
			lblEnunciado = new JLabel("Clique para ler o enunciado!");

			lblEnunciado.setVerticalAlignment(SwingConstants.TOP);
	        lblEnunciado.setFont(new Font("Arial", Font.PLAIN, 12));
	        lblEnunciado.setBounds(295, 46, 370, 30);
		}
		return lblEnunciado;
	}

	public JButton getBtnAjuda() {
		if (btnAjuda == null) {
			btnAjuda = new JButton("O que é cadeia de Markov?");
			btnAjuda.setBounds(510, 15, 170, 25);
		}
		return btnAjuda;
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

	
	public JButton getBtnAvancar() {
		if (btnAvancar == null) {
			btnAvancar = new JButton("Avançar");
			btnAvancar.setBounds(548, 296, 101, 35);
		}
		return btnAvancar;
	}

	public JLabel getLblIdentificacao1() {
		if (lblIdentificacao1 == null) {
			lblIdentificacao1 = new JLabel();
			lblIdentificacao1.setText("<html><center>" + separarStringPorVirgula(TelaEnunciado.perguntaAtual.getIdentEstadoCorreto(), 1) + "</center></html>");
	        lblIdentificacao1.setFont(new Font("Arial", Font.PLAIN, 12));
	        lblIdentificacao1.setHorizontalAlignment(JLabel.CENTER);
	        lblIdentificacao1.setVerticalAlignment(JLabel.CENTER);
			lblIdentificacao1.setBounds(355, 145, 70, 50);
		}
		return lblIdentificacao1;
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
	public String separarStringPorVirgula(String entrada, int numero) {
        String[] partes = entrada.split("\\s*,\\s*");
        if (numero >= 1 && numero <= partes.length) {
            return partes[numero - 1];
        }
        return null;
    }

	public JLabel getLblIdentificacao2() {
	    if (lblIdentificacao2 == null) {
	        lblIdentificacao2 = new JLabel();
	        lblIdentificacao2.setText("<html><center>" + separarStringPorVirgula(TelaEnunciado.perguntaAtual.getIdentEstadoCorreto(), 2) + "<center/><html/>");
	        lblIdentificacao2.setFont(new Font("Arial", Font.PLAIN, 12));
	        lblIdentificacao2.setHorizontalAlignment(JLabel.CENTER);
	        lblIdentificacao2.setVerticalAlignment(JLabel.CENTER);
	        lblIdentificacao2.setBounds(512, 110, 70, 50);
	    }
	    return lblIdentificacao2;
	}

	public JLabel getLblIdentificacao3() {
	    if (lblIdentificacao3 == null) {
	        lblIdentificacao3 = new JLabel();
	        lblIdentificacao3.setText("<html><center>" + separarStringPorVirgula(TelaEnunciado.perguntaAtual.getIdentEstadoCorreto(), 3) + "</center></html>");
	        lblIdentificacao3.setFont(new Font("Arial", Font.PLAIN, 12));
	        lblIdentificacao3.setHorizontalAlignment(JLabel.CENTER);
	        lblIdentificacao3.setVerticalAlignment(JLabel.CENTER);
	        lblIdentificacao3.setBounds(480, 210, 70, 50);
	    }
	    return lblIdentificacao3;
	}


	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	public JTextField getTfAPA() {
		if (tfAPA == null) {
			tfAPA = new JTextField();
			tfAPA.setBounds(275, 180, 50, 20);
			//tfAPA.setBounds(230, 180, 86, 20);
			tfAPA.setColumns(10);
		}
		return tfAPA;
	}

	public JTextField getTfAPB() {
		if (tfAPB == null) {
			tfAPB = new JTextField();
			tfAPB.setColumns(10);
			tfAPB.setBounds(417, 90, 50, 20);
			//tfAPB.setBounds(417, 90, 86, 20);
		}
		return tfAPB;
	}

	public JTextField getTfAPC() {
		if (tfAPC == null) {
			tfAPC = new JTextField();
			tfAPC.setColumns(10);
			tfAPC.setBounds(417, 90, 86, 20);
		}
		return tfAPC;
	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	public JTextField getTfBPA() {
		if (tfBPA == null) {
			tfBPA = new JTextField();
			tfBPA.setColumns(10);
			tfBPA.setBounds(440, 268, 50, 20);
			//tfBPA.setBounds(417, 270, 86, 20);
		}
		return tfBPA;
	}

	public JTextField getTfBPB() {
		if (tfBPB == null) {
			tfBPB = new JTextField();
			tfBPB.setColumns(10);
			tfBPB.setBounds(600, 180, 50, 20);
			//tfBPB.setBounds(605, 175, 86, 20);
		}
		return tfBPB;
	}

	public JTextField getTfBPC() {
		if (tfBPC == null) {
			tfBPC = new JTextField();
			tfBPC.setColumns(10);
			tfBPC.setBounds(630, 175, 86, 20);
		}
		return tfBPC;
	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	public JTextField getTfCPA() {
		if (tfCPA == null) {
			tfCPA = new JTextField();
			tfCPA.setColumns(10);
			tfCPA.setBounds(630, 175, 86, 20);
		}
		return tfCPA;
	}

	public JTextField getTfCPB() {
		if (tfCPB == null) {
			tfCPB = new JTextField();
			tfCPB.setColumns(10);
			tfCPB.setBounds(630, 175, 86, 20);
		}
		return tfCPB;
	}

	public JTextField getTfCPC() {
		if (tfCPC == null) {
			tfCPC = new JTextField();
			tfCPC.setColumns(10);
			tfCPC.setBounds(630, 175, 86, 20);
		}
		return tfCPC;
	}

	public void verificar(){
		
	}
	public JLabel getLblpreenchaOsCampos() {
		if (lblpreenchaOsCampos == null) {
			lblpreenchaOsCampos = new JLabel("*Preencha os campos com sua probabilidade de transição");
			lblpreenchaOsCampos.setVerticalAlignment(SwingConstants.TOP);
			lblpreenchaOsCampos.setFont(new Font("Arial", Font.BOLD, 10));
			lblpreenchaOsCampos.setBounds(295, 332, 370, 30);
		}
		return lblpreenchaOsCampos;
	}
}
