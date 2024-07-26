package modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Historico")
public class Historico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTransacao")
	private int idHistorico;
	@ManyToOne
	@JoinColumn(name="idQuestao") 
	private Pergunta pergunta;
	@ManyToOne
	@JoinColumn(name="idEstudante")
	private Estudante estudante;
	@Column(name="finalizado")
	private boolean finalizado;
	@Column(name="dataHoraTransacao")
	private LocalDateTime dataRegistro;
	@Column(name="pontuacao")
	private int pontuacao;
	@Column(name="qtdAjuda")
	private int qtdAjuda;
	
	public Historico( ) {}
	public Historico(Pergunta pergunta, Estudante estudante, boolean finalizado, LocalDateTime dataRegistro, int pontuacao) {
		super();
		this.pergunta = pergunta;
		this.estudante = estudante;
		this.finalizado = finalizado;
		this.dataRegistro = dataRegistro;
		this.pontuacao = pontuacao;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	public int getQtdAjuda() {
		return qtdAjuda;
	}
	
	public void setQtdAjuda(int qtdAjuda) {
		this.qtdAjuda = qtdAjuda;
	}

	
	
}
