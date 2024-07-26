package modelo;

import java.io.Serializable;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.validation.constraints.Size;

@Entity
@Table(name="Estudante")
public class Estudante implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idEstudante")
	private int id;
	@Column(length=50)
	@Size(max=49)
	private String nome;
	@Column(length=50)
	@Size(max=49)
	private String matricula;
	private Date dataNascimento;
	@Column(length=12)
	@Size(min=6, max=11)
	private String senha;
	private double score;
	@Column(name="qtdPergunta")
	private int perguntasFeitas;
	@Column(name="qtdResposta")
	private int respostasAcertadas;
	@Column(name="qtdAjuda")
	private int ajudasPedidas;
	
	public Estudante(){
		this.score=0.0;
		this.perguntasFeitas=0;
		this.respostasAcertadas=0;
		this.ajudasPedidas=0;
	}
	public Estudante(String nome, String matricula, String dataNascimento) throws ParseException{
		this.score=0.0;
		this.perguntasFeitas=0;
		this.respostasAcertadas=0;
		this.ajudasPedidas=0;
		this.nome=nome;
		this.matricula=matricula;
		SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
		this.dataNascimento= formatter.parse(dataNascimento);
	}
	
	public String getNome(){
		return this.nome;
	}
	public void setNome(String str) {
			this.nome = removerAcentos(str);
	}
	public String getMatricula(){
		return this.matricula;
	}
	public void setMatricula(String str) {
		this.matricula = removerAcentos(str);
	}
	public String getDataNascimento() {
		SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(this.dataNascimento);
	}
	public void setDataNascimento(String str) throws ParseException {
		SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
		this.dataNascimento = formatter.parse(str);
	}
	public int getID() {
		return this.id;
	}
	
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String strSenha){
		this.senha = strSenha;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getPerguntasFeitas() {
		return perguntasFeitas;
	}
	public void setPerguntasFeitas(int perguntasFeitas) {
		this.perguntasFeitas = perguntasFeitas;
	}
	public int getRespostasAcertadas() {
		return respostasAcertadas;
	}
	public void setRespostasAcertadas(int respostasAcertadas) {
		this.respostasAcertadas = respostasAcertadas;
	}
	public int getAjudasPedidas() {
		return ajudasPedidas;
	}
	public void setAjudasPedidas(int ajudasPedidas) {
		this.ajudasPedidas = ajudasPedidas;
	}
	public static String removerAcentos(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		return nfdNormalizedString;
	}
	public String geraID() {
		Random r = new Random();
		int v = r.nextInt(999)+100;
		String id = this.nome.split(" ")[0] + "." +String.valueOf(v);
		return id;
	}	
}
