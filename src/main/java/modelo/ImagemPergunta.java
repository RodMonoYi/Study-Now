package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "ImagemPergunta")
public class ImagemPergunta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idImagem")
	private int id;
	@Lob
	@Column(name = "imagemDiagrama", columnDefinition = "LONGBLOB")
	private byte[] imagemDiagrama;
	@Lob
	@Column(name = "imagemEquacao", columnDefinition = "LONGBLOB")
	private byte[] imagemEquacao;
	
	public ImagemPergunta() {
	}
	public ImagemPergunta(byte[] imagemDiagrama, byte[] imagemEquacao) {
		super();
		this.imagemDiagrama = imagemDiagrama;
		this.imagemEquacao = imagemEquacao;
	}

	public int getId() {
        return id;
    }

    public void setId(int idImagemPergunta) {
        this.id = idImagemPergunta;
    }

    public byte[] getImagemDiagrama() {
        return imagemDiagrama;
    }

    public void setImagemDiagrama(byte[] imagemDiagrama) {
        this.imagemDiagrama = imagemDiagrama;
    }

    public byte[] getImagemEquacao() {
        return imagemEquacao;
    }

    public void setImagemEquacao(byte[] imagemEquacao) {
        this.imagemEquacao = imagemEquacao;
    }
}
