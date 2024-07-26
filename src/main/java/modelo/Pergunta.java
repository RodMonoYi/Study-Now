package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pergunta")
public class Pergunta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPergunta")
	private int id;
	@Column(name = "enunciadoPergunta")
	private String enunciado;
	@Column(name = "categoriaPergunta")
	private int categoria;
	@Column(name = "dificuldadePergunta")
	private int dificuldade;
	@Column(name = "quantidadeEstados")
	private int qtdEstados;
	@Column(name = "identificacaoDeEstadoCorreto", length = 100)
	private String identEstadoCorreto;
	@Column(name = "identificacaoDeEstadoErrado1", length = 100)
	private String identEstadoErrado1;
	@Column(name = "identificacaoDeEstadoErrado2", length = 100)
	private String identEstadoErrado2;
	@Column(name = "identificacaoDeEstadoErrado3", length = 100)
	private String identEstadoErrado3;
	@Column(name = "probabilidadeTransicao", length = 100)
	private String pTransicao;
	@Column(name = "perguntaCorreta", length = 255)
	private String perguntaCorreta;
	@Column(name = "perguntaErrada1", length = 255)
	private String perguntaErrada1;
	@Column(name = "perguntaErrada2", length = 255)
	private String perguntaErrada2;
	@Column(name = "perguntaErrada3", length = 255)
	private String perguntaErrada3;
	@Column(name = "estadoInicial", length = 100)
	private String estadoInicial;
	@Column(name = "estadoFinal", length = 100)
	private String estadoFinal;
	@Column(name = "valorAdicionado")
	private int valorAdd;
	@ManyToOne
	@JoinColumn(name = "idImagemPergunta")
	private ImagemPergunta imgPergunta;
	// private String ajudas[];

	public Pergunta() {
	}
	public Pergunta(String enunciado, int categoria, int dificuldade, int qtdEstados, String identEstadoCorreto,
			String identEstadoErrado1, String identEstadoErrado2, String identEstadoErrado3, String pTransicao,
			String perguntaCorreta, String perguntaErrada1, String perguntaErrada2, String perguntaErrada3,
			String estadoInicial, String estadoFinal, int valorAdd, ImagemPergunta imgPergunta) {
		super();
		this.enunciado = enunciado;
		this.categoria = categoria;
		this.dificuldade = dificuldade;
		this.qtdEstados = qtdEstados;
		this.identEstadoCorreto = identEstadoCorreto;
		this.identEstadoErrado1 = identEstadoErrado1;
		this.identEstadoErrado2 = identEstadoErrado2;
		this.identEstadoErrado3 = identEstadoErrado3;
		this.pTransicao = pTransicao;
		this.perguntaCorreta = perguntaCorreta;
		this.perguntaErrada1 = perguntaErrada1;
		this.perguntaErrada2 = perguntaErrada2;
		this.perguntaErrada3 = perguntaErrada3;
		this.estadoInicial = estadoInicial;
		this.estadoFinal = estadoFinal;
		this.valorAdd = valorAdd;
		this.imgPergunta = imgPergunta;
	}
	
	public int getId() {
		return id;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}
	public int getQtdEstados() {
		return qtdEstados;
	}
	public void setQtdEstados(int qtdEstados) {
		this.qtdEstados = qtdEstados;
	}
	public String getIdentEstadoCorreto() {
		return identEstadoCorreto;
	}
	public void setIdentEstadoCorreto(String identEstadoCorreto) {
		this.identEstadoCorreto = identEstadoCorreto;
	}
	public String getIdentEstadoErrado1() {
		return identEstadoErrado1;
	}
	public void setIdentEstadoErrado1(String identEstadoErrado1) {
		this.identEstadoErrado1 = identEstadoErrado1;
	}
	public String getIdentEstadoErrado2() {
		return identEstadoErrado2;
	}
	public void setIdentEstadoErrado2(String identEstadoErrado2) {
		this.identEstadoErrado2 = identEstadoErrado2;
	}
	public String getIdentEstadoErrado3() {
		return identEstadoErrado3;
	}
	public void setIdentEstadoErrado3(String identEstadoErrado3) {
		this.identEstadoErrado3 = identEstadoErrado3;
	}
	public String getpTransicao() {
		return pTransicao;
	}
	public void setpTransicao(String pTransicao) {
		this.pTransicao = pTransicao;
	}
	public String getPerguntaCorreta() {
		return perguntaCorreta;
	}
	public void setPerguntaCorreta(String perguntaCorreta) {
		this.perguntaCorreta = perguntaCorreta;
	}
	public String getPerguntaErrada1() {
		return perguntaErrada1;
	}
	public void setPerguntaErrada1(String perguntaErrada1) {
		this.perguntaErrada1 = perguntaErrada1;
	}
	public String getPerguntaErrada2() {
		return perguntaErrada2;
	}
	public void setPerguntaErrada2(String perguntaErrada2) {
		this.perguntaErrada2 = perguntaErrada2;
	}
	public String getPerguntaErrada3() {
		return perguntaErrada3;
	}
	public void setPerguntaErrada3(String perguntaErrada3) {
		this.perguntaErrada3 = perguntaErrada3;
	}
	public String getEstadoInicial() {
		return estadoInicial;
	}
	public void setEstadoInicial(String estadoInicial) {
		this.estadoInicial = estadoInicial;
	}
	public String getEstadoFinal() {
		return estadoFinal;
	}
	public void setEstadoFinal(String estadoFinal) {
		this.estadoFinal = estadoFinal;
	}
	public int getValorAdd() {
		return valorAdd;
	}
	public void setValorAdd(int valorAdd) {
		this.valorAdd = valorAdd;
	}
	public ImagemPergunta getImgPergunta() {
		return imgPergunta;
	}
	public void setImgPergunta(ImagemPergunta imgPergunta) {
		this.imgPergunta = imgPergunta;
	}
}
