package visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.Aplicacao;
import modelo.Pergunta;
import javax.swing.JComboBox;
import java.awt.Color;

public class TelaEnunciado extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static Pergunta perguntaAtual;
	public static int qtdAjudas;
	public static int pontuacao;
	public static int potErro;
	
	JLabel lblPergunta;
	JLabel lblPergunta2;
	JLabel lblFalaRobo;
	JLabel lblEnunciado;
	JLabel lblBackground;
	JButton btnSim;
	JButton btnNao;
	JButton btnAjuda;
	//JButton btnNao;
	JButton btnEnviar;
	JTextField tfResposta;
	JComboBox<String> comboBoxPergunta2;
	JLabel lblRespostaErrada;
	public int controlador = 1;
	
	public TelaEnunciado(Pergunta perguntaMonitorada) {
		setLayout(null);
		Aplicacao.alterarTamanho(707, 560);
		Aplicacao.janela.setLocationRelativeTo(null);
		setBounds(0, 20, 690, 500);
		perguntaAtual=perguntaMonitorada;
		qtdAjudas=0;
		pontuacao=100;
		potErro=0;
		addItens();
		setVisible(true);
	}
	
	public void addItens() {
		
		controlador = 1;
		add (getLblRespostaErrada());
		add(getComboBoxPergunta2());
		add(getLblPergunta());
		add(getLblPergunta2());
		add(getBtnEnviar());
		add(getTfResposta());
		add(getBtnNao());
		add(getBtnAjuda());
		//add(getBtnCadastro());
		add(getLblPergunta());
		add(getLblFalaRobo());
		add(getLblEnunciado());
		add(getBtnSim());
		//add(getBtnNao());
		add(getLblBackground());
	}
	
	public TelaEnunciado getTela() {
		return this;
	}
	public Pergunta getPerguntaAtual() {
		return perguntaAtual;
	}
	
	public JButton getBtnEnviar() {
		if(btnEnviar==null) {
			btnEnviar = new JButton("Enviar");
			btnEnviar.setBounds(463, 430, 89, 23);
			btnEnviar.setVisible(false);
		}
		return btnEnviar;
	}
	
	public JComboBox<String> getComboBoxPergunta2() {
		if (comboBoxPergunta2== null) {
			comboBoxPergunta2 = new JComboBox<String>();
			comboBoxPergunta2.setBounds(270, 430, 250, 22);
			comboBoxPergunta2.setVisible(false);
		}
		return comboBoxPergunta2;
	}
	
	public JLabel getLblPergunta() {
		if (lblPergunta== null) {
			lblPergunta = new JLabel();
			lblPergunta.setVerticalAlignment(SwingConstants.TOP);
			lblPergunta.setFont(new Font("Arial", Font.PLAIN, 12));
			lblPergunta.setText("Qual a quantidade de estados da questão?");
			lblPergunta.setBounds(270, 400, 300, 25);
			lblPergunta.setVisible(false);
		}
		return lblPergunta;
	}
	public JLabel getLblPergunta2() {
		if (lblPergunta2== null) {
			lblPergunta2 = new JLabel();
			lblPergunta2.setVerticalAlignment(SwingConstants.TOP);
			lblPergunta2.setFont(new Font("Arial", Font.PLAIN, 12));
			lblPergunta2.setText("Faça a identificação dos estados");
			lblPergunta2.setBounds(270, 400, 300, 25);
			lblPergunta2.setVisible(false);
		}
		return lblPergunta2;
	}
	
	public JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel();
			lblBackground.setIcon(new ImageIcon(TelaEnunciado.class.getResource("/assets/Design sem nome (2).png")));
			lblBackground.setBounds(0, 0, 690, 500);
		}
		return lblBackground;
	}
	
	public JLabel getLblEnunciado() {
	    if (lblEnunciado == null) {
	        lblEnunciado = new JLabel();
	        lblEnunciado.setVerticalAlignment(SwingConstants.TOP);
	        lblEnunciado.setFont(new Font("Arial", Font.PLAIN, 12));
	        lblEnunciado.setText("<html><body style='text-align: justify;'> " + perguntaAtual.getEnunciado() + "</body></html>");
	        lblEnunciado.setBounds(260, 55, 420, 340);
	    }
	    return lblEnunciado;
	}

	public JLabel getLblRespostaErrada() {
	    if (lblRespostaErrada == null) {
	    	lblRespostaErrada = new JLabel();
	    	lblRespostaErrada.setForeground(Color.RED);
	    	lblRespostaErrada.setVerticalAlignment(SwingConstants.TOP);
	    	lblRespostaErrada.setFont(new Font("Arial", Font.PLAIN, 10));
	    	lblRespostaErrada.setText("*Você errou. Tente novamente ou peça ajuda!");
	    	lblRespostaErrada.setBounds(297, 460, 255, 14);
	    	lblRespostaErrada.setVisible(false);
	    }
	    return lblRespostaErrada;
	}
	
	public JLabel getLblFalaRobo() {
		if (lblFalaRobo == null) {
			lblFalaRobo = new JLabel("Você entendeu?");
			lblFalaRobo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblFalaRobo.setBounds(56, 78, 129, 25);
		}
		return lblFalaRobo;
	}
	
	public JButton getBtnSim() {
		if (btnSim == null) {
			btnSim = new JButton("Sim");
			btnSim.setBounds(30, 320, 70, 25);
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
	
	public JButton getBtnNao() {
		if (btnNao == null) {
			btnNao = new JButton("Não");
			btnNao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (controlador == 1) {
						JOptionPane.showMessageDialog(
							    getTela(),
							    "<html><body style='text-align: justify; width: 300px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Uma Cadeia de Markov se traduz como uma sequência de configurações de estados variáveis de um determinado fenômeno, representada pela expressão {Xn, n ≥ 0}"
							    + ", onde o Xn indica o estado do fenômeno que está sendo estudado no tempo n, ou seja, em qual patamar está a variável estudada no tempo n, e n ≥ 0 significa a independência do tempo passado"
							    + " para a determinação da situação futura deste determinado estado, característica principal das cadeias markovianas denominada de propriedade sem memória.<br>"
							    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tomamos como exemplo o clima local, este será o parâmetro estudado, representado por X, a sequência de configurações de parâmetros formará, portanto a cadeia de Markov {X0, X1,...}. O índice"
							    + " do parâmetro representa a quantidade de espaços de tempo ocorrida (n), se estivermos considerando um tempo de transição de uma semana entre cada elemento da cadeia, por exemplo, então, quando"
							    + " n = 3, significa que decorreram três semanas do início do fenômeno em estudo, sendo observado o estado X3, ou seja, o clima local na terceira semana observada.</body></html>",
							    null,
							    JOptionPane.INFORMATION_MESSAGE);

					}
					else if (controlador == 2){
						JOptionPane.showMessageDialog(
							    getTela(),
							    "<html><body style='text-align: justify; width: 300px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O espaço de estados é um conjunto de configurações que o parâmetro pode assumir, geralmente representado pela expressão S = {1, 2, 3,..., N}, teremos"
							    + " sempre no mínimo um e no máximo N estados para cada problema. <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;No exemplo sobre o clima, por exemplo, podemos ter um espaço de estados contando com os seguintes elementos: S = {chuvoso,"
							    + " nublado, ensolarado}, neste caso N = 3, que representa a quantidade de estados possíveis.</body></html>",
							    null,
							    JOptionPane.INFORMATION_MESSAGE
							);


					}else {
						JOptionPane.showMessageDialog(getTela(), "teste", null, JOptionPane.INFORMATION_MESSAGE);
					}
						
				}
			});
			btnNao.setBounds(115, 320, 70, 25);
		}
		return btnNao;
	}
	
	public JTextField getTfResposta() {
	    if (tfResposta == null) {
	        tfResposta = new JTextField();
	        tfResposta.setBounds(270, 430, 186, 20);
	        tfResposta.setColumns(10);
	        tfResposta.setVisible(false);

	        tfResposta.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyTyped(KeyEvent e) {
	                char aux = e.getKeyChar();
	                if (!Character.isDigit(aux)) {
	                    e.consume();
	                }
	            }
	        });
	    }
	    return tfResposta;
	}

	public void geraListaEstados() {
		 Random random = new Random();
	     int numeroAleatorio = random.nextInt(4);
	     if(numeroAleatorio==0) {
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoCorreto());
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoErrado1());
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoErrado2());
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoErrado3());
	     }else if(numeroAleatorio==1) {
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoErrado3());
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoCorreto());
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoErrado1());
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoErrado2());
	     }else if(numeroAleatorio==2) {
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoErrado2());
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoErrado1());
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoCorreto());
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoErrado3());
	     }else {
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoErrado3());
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoErrado2());
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoErrado1());
	    	 getComboBoxPergunta2().addItem(perguntaAtual.getIdentEstadoCorreto());
	     }
	}
	
	public void addQtdAjudas() {
		pontuacao--;
		qtdAjudas++;
	}
	
	
}
