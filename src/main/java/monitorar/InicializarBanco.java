package monitorar;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import modelo.ImagemPergunta;
import modelo.Pergunta;

public class InicializarBanco {

	public DAOPergunta perguntaMonitorada;
	public DAOImagem imagemMonitorada;
	public DAOEstudante estudanteMonitorado;
	
	public InicializarBanco() {
		perguntaMonitorada = new DAOPergunta();
		imagemMonitorada = new DAOImagem();
		estudanteMonitorado = new DAOEstudante();
	}
	
	public void iniciaBanco() {
		addRegistros();
	}

	public void addRegistros() {
		try {
			perguntaMonitorada.SalvarPergunta(getPergunta1());
			perguntaMonitorada.SalvarPergunta(getPergunta2());
			perguntaMonitorada.SalvarPergunta(getPergunta3());
			perguntaMonitorada.SalvarPergunta(getPergunta4());
			perguntaMonitorada.SalvarPergunta(getPergunta5());
			perguntaMonitorada.SalvarPergunta(getPergunta6());
			perguntaMonitorada.SalvarPergunta(getPergunta7());
			perguntaMonitorada.SalvarPergunta(getPergunta8());
			perguntaMonitorada.SalvarPergunta(getPergunta9());
			perguntaMonitorada.SalvarPergunta(getPergunta10());
			perguntaMonitorada.SalvarPergunta(getPergunta11());
			perguntaMonitorada.SalvarPergunta(getPergunta12());
			perguntaMonitorada.SalvarPergunta(getPergunta13());
			perguntaMonitorada.fecharTransacao();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Pergunta getPergunta1() {
		ImagemPergunta imgP = new ImagemPergunta();
		imgP.setImagemDiagrama(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Diagrama 1.png"))));
		imgP.setImagemEquacao(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Resposta 1.png"))));
		DAOImagem emImagem = new DAOImagem();
		emImagem.salvarImagem(imgP);
		Pergunta p = new Pergunta();
		p.setEnunciado("Um objeto de estudo dos demógrafos é o movimento das populações, ou grupos de pessoas, de uma região para outra. Vamos considerar um modelo simples para a variação da população de uma cidade e dos subúrbios vizinhos ao longo de um determinado período de anos. Suponha que um estudo demográfico mostre que em cada ano, aproximadamente 5% da população da cidade se mude para o subúrbio (isto significa que 95% permanecem na cidade) enquanto 3% da população dos subúrbios se mudam para a cidade (isto é, 97% permanecem no subúrbio). Sabendo que a população inicial na cidade é de 600.000 habitantes e no subúrbio 400.000 habitantes, analise os efeitos dessa migração ao longo de dois anos, verificando a quantidade de habitantes em cada lugar ao longo do tempo.");
		p.setCategoria(1);
		p.setDificuldade(1);
		p.setQtdEstados(2);
		p.setIdentEstadoCorreto("Habitantes da cidade,Habitantes do subúrbio");
		p.setIdentEstadoErrado1("Habitantes da zona urbana, Habitantes de áreas rurais");
		p.setIdentEstadoErrado2("Habitantes de metrópoles, Habitantes de vilarejos");
		p.setIdentEstadoErrado3("Habitantes de vilarejos,Habitantes do subúrbio");
		p.setpTransicao("95,5,3,97");
		p.setPerguntaCorreta("Nesta questão é solicitado o estado esperado do fenômeno em um tempo t específico.");
		p.setPerguntaErrada1("Nesta questão é solicitado determinar a trajetória do fenômeno com base em dados passados.");
		p.setPerguntaErrada2("Nesta questão é solicitado determinar a trajetória do fenômeno com base em dados passados.");
		p.setPerguntaErrada3("Nesta questão é solicitado analisar a variação do fenômeno sem considerar a influência do tempo.");
		p.setEstadoInicial("600.000,400.000");
		p.setEstadoFinal("565.440,434.560");
		p.setValorAdd(2);
		p.setImgPergunta(imgP);
		return p;
	}
	
	public Pergunta getPergunta2() {
		ImagemPergunta imgP = new ImagemPergunta();
		imgP.setImagemDiagrama(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Diagrama 2.png"))));
		imgP.setImagemEquacao(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Resposta 2.png"))));
		DAOImagem emImagem = new DAOImagem();
		emImagem.salvarImagem(imgP);
		Pergunta p = new Pergunta();
		p.setEnunciado("Em uma experiência, um psicólogo coloca um rato cada dia em uma gaiola com duas portas, A e B. O rato pode passar pela porta A, onde recebe um choque elétrico, ou pela porta B, onde recebe comida. Mantém-se o registro da porta usada pelo rato. No início do experimento, em uma segunda-feira, o rato tem a mesma probabilidade de escolher a porta A ou a B. Depois de passar pela porta A e receber um choque, a probabilidade de usar a mesma porta no próximo dia é 0,3. Depois de passar pela porta B e receber comida, a probabilidade de usar a mesma porta no próximo dia é 0,6. Qual a probabilidade do rato passar pela porta A, na quinta-feira, isto é, no terceiro dia após o experimento?");
		p.setCategoria(1);
		p.setDificuldade(2);
		p.setQtdEstados(3);
		p.setIdentEstadoCorreto("Porta A,Porta B");
		p.setIdentEstadoErrado1("Rato, Psicólogo");
		p.setIdentEstadoErrado2("Experimento do Psicólogo,Porta X");
		p.setIdentEstadoErrado3("Rato,Porta A");
		p.setpTransicao("30,70,40,60");
		p.setPerguntaCorreta("Nesta questão é solicitado o estado esperado do fenômeno em um tempo t específico.");
		p.setPerguntaErrada1("Nesta questão é solicitada a temperatura ideal para o experimento.");
		p.setPerguntaErrada2("Nesta questão é solicitada a quantidade de choques elétricos aplicados ao rato.");
		p.setPerguntaErrada3("Nesta questão é solicitado o impacto do choque elétrico na saúde do rato.");
		p.setEstadoInicial("0.5,0.5");
		p.setEstadoFinal("0.36,0.64");
		p.setValorAdd(3);
		p.setImgPergunta(imgP);
		return p;
	}
	
	public Pergunta getPergunta3() {
		ImagemPergunta imgP = new ImagemPergunta();
		imgP.setImagemDiagrama(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Diagrama 3.png"))));
		imgP.setImagemEquacao(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Resposta 3.png"))));
		DAOImagem emImagem = new DAOImagem();
		emImagem.salvarImagem(imgP);
		Pergunta p = new Pergunta();
		p.setEnunciado("Conferindo os registros de doações recebidas, uma entidade filantrópica observa que 80% dos seus associados que contribuem ao fundo da entidade em certo ano, também contribuem no ano seguinte e que 30% dos que não contribuem em certo ano, contribuem no ano seguinte. Isto pode ser visto como uma Cadeia de Markov de dois estados. O primeiro estado corresponde a um associado que contribui em um ano qualquer e o segundo estado corresponde a um associado que não contribui naquele ano. Como fica a situação de um associado que contribui no primeiro ano daqui a três anos.");
		p.setCategoria(1);
		p.setDificuldade(2);
		p.setQtdEstados(2);
		p.setIdentEstadoCorreto("Contribuinte,Não contribuinte");
		p.setIdentEstadoErrado1("Membro,Contribuinte");
		p.setIdentEstadoErrado2("Associado,Ausente");
		p.setIdentEstadoErrado3("Ajudante,Não Contribuinte");
		p.setpTransicao("80,20,30,70");
		p.setPerguntaCorreta("Nesta questão é solicitado o estado esperado do fenômeno em um tempo t específico.");
		p.setPerguntaErrada1("Nesta questão é solicitada a previsão do comportamento do fenômeno.");
		p.setPerguntaErrada2("Nesta questão é solicitada a análise dos estados do fenômeno.");
		p.setPerguntaErrada3("Nesta questão é solicitado o estado alterado do fenômeno em um tempo t específico.");
		p.setEstadoInicial("1,0");
		p.setEstadoFinal("0.65,0.35");
		p.setValorAdd(3);
		p.setImgPergunta(imgP);
		return p;
	}
	
	public Pergunta getPergunta4() {
		ImagemPergunta imgP = new ImagemPergunta();
		imgP.setImagemDiagrama(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Diagrama 4.png"))));
		imgP.setImagemEquacao(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Resposta 4.png"))));
		DAOImagem emImagem = new DAOImagem();
		emImagem.salvarImagem(imgP);
		Pergunta p = new Pergunta();
		p.setEnunciado("Uma planta pode ter flores vermelhas (V), cor de rosa (R) ou brancas (B), dependendo dos genótipos VV, VB e BB. Ao cruzar cada um desses genótipos com um genótipo VB, obtemos a seguinte tabela:<br>"
	            + "<table border=\"1\" cellpadding=\"5\">"
	            + "<tr>"
	            + "<td colspan=\"2\"><b>Problema n.º 4</b></td>"
	            + "</tr>"
	            + "<tr>"
	            + "<td rowspan=\"5\"><b>Flores da Planta Descendente</b></td>"
	            + "<td rowspan=\"4\"></td>"
	            + "<td><b>Flores da Planta Original</b></td>"
	            + "<td>V</td>"
	            + "<td>R</td>"
	            + "<td>B</td>"
	            + "</tr>"
	            + "<tr>"
	            + "<td>V</td>"
	            + "<td>0.50</td>"
	            + "<td>0.25</td>"
	            + "<td>0.00</td>"
	            + "</tr>"
	            + "<tr>"
	            + "<td>R</td>"
	            + "<td>0.50</td>"
	            + "<td>0.50</td>"
	            + "<td>0.50</td>"
	            + "</tr>"
	            + "<tr>"
	            + "<td>B</td>"
	            + "<td>0.00</td>"
	            + "<td>0.25</td>"
	            + "<td>0.50</td>"
	            + "</tr>"
	            + "</table>"
	            + "<br>Suponha que cada geração sucessiva é produzida cruzando-se apenas com plantas do genótipo VB. Quando o processo atingir o equilíbrio, que porcentagem das plantas terá flores vermelhas, cor-de-rosa ou brancas?\r\n");

		p.setCategoria(2);
		p.setDificuldade(1);
		p.setQtdEstados(3);
		p.setIdentEstadoCorreto("Flores Vermelhas, Flores Rosa, Flores Brancas");
		p.setIdentEstadoErrado1("Flores Azuis, Flores Rosa, Flores Vermelhas");
		p.setIdentEstadoErrado2("Flores Vermelhas, Flores Verdes, Flores Brancas");
		p.setIdentEstadoErrado3("Flores Vermelhas, Flores Brancas, Flores Pretas");
		p.setpTransicao("50,50, 0,25,50, 25,0,50,50");
		p.setPerguntaCorreta("Nesta questão é solicitada a estabilidade do fenômeno");
		p.setPerguntaErrada1("Nesta questão é solicitado determinar a taxa de variação do fenômeno.");
		p.setPerguntaErrada2("Nesta questão é solicitada a análise da dispersão das ocorrências do fenômeno.");
		p.setPerguntaErrada3("Nesta questão é solicitada a previsão das flutuações do fenômeno em diferentes cenários.");
		p.setEstadoInicial("0,1,0");
		p.setEstadoFinal("0.25,0.50,0.25");
		p.setValorAdd(-1);
		p.setImgPergunta(imgP);
		return p;
	}
	
	public Pergunta getPergunta5() {
		ImagemPergunta imgP = new ImagemPergunta();
		imgP.setImagemDiagrama(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Diagrama 5.png"))));
		imgP.setImagemEquacao(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Resposta 5.png"))));
		DAOImagem emImagem = new DAOImagem();
		emImagem.salvarImagem(imgP);
		Pergunta p = new Pergunta();
		p.setEnunciado("<p>Neste exemplo estuda-se a viabilidade para implantação de um novo sistema de transporte de massas (poderia ser um sistema de Metrô) numa certa cidade. As autoridades fizeram estudos que previam o percentual de pessoas que migrarão para esse novo sistema de transporte de massas (M), e o percentual de pessoas que continuarão a dirigir seus automóveis (A). Foi obtida a seguinte tabela:</p>"
	            + "<table border='1' cellpadding='5'>"
	            + "<tr>"
	            + "<td colspan='2'><b>Problema nº 5</b></td>"
	            + "</tr>"
	            + "<tr>"
	            + "<td><b>Próximo ano</b></td>"
	            + "<td><b>Esse ano</b></td>"
	            + "</tr>"
	            + "<tr>"
	            + "<td></td>"
	            + "<td></td>"
	            + "<td><b>M</b></td>"
	            + "<td><b>A</b></td>"
	            + "</tr>"
	            + "<tr>"
	            + "<td></td>"
	            + "<td><b>M</b></td>"
	            + "<td>0.7</td>"
	            + "<td>0.2</td>"
	            + "</tr>"
	            + "<tr>"
	            + "<td></td>"
	            + "<td><b>A</b></td>"
	            + "<td>0.3</td>"
	            + "<td>0.8</td>"
	            + "</tr>"
	            + "</table>"
	            + "<p>Suponha que a população da cidade permaneça constante e que, inicialmente, 30% das pessoas irão usar o transporte de massa e 70% irão usar seus carros. Qual o cenário nos próximos 2 anos?</p>");

		p.setCategoria(1);
		p.setDificuldade(1);
		p.setQtdEstados(2);
		p.setIdentEstadoCorreto("Metrô M,Automóvel A");
		p.setIdentEstadoErrado1("Metrô M,Metrô N");
		p.setIdentEstadoErrado2("Pessoas, Sistema de Transporte");
		p.setIdentEstadoErrado3("Pessoas,Automóvel A");
		p.setpTransicao("70,30,20,80");
		p.setPerguntaCorreta("Nesta questão é solicitado o estado esperado do fenômeno em um tempo t específico.");
		p.setPerguntaErrada1("Nesta questão é solicitada uma previsão sobre o impacto do novo sistema de transporte de massas no meio ambiente.");
		p.setPerguntaErrada2("Nesta questão é solicitada uma estimativa da demanda por transporte público em outras cidades.");
		p.setPerguntaErrada3("Nesta questão é solicitada uma análise dos custos envolvidos na implantação do novo sistema de transporte de massas.");
		p.setEstadoInicial("30,70");
		p.setEstadoFinal("0.375,0.625");
		p.setValorAdd(2);
		p.setImgPergunta(imgP);
		return p;
	}
	
	public Pergunta getPergunta6() {
		ImagemPergunta imgP = new ImagemPergunta();
		imgP.setImagemDiagrama(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Diagrama 6.png"))));
		imgP.setImagemEquacao(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Resposta 6.png"))));
		DAOImagem emImagem = new DAOImagem();
		emImagem.salvarImagem(imgP);
		Pergunta p = new Pergunta();
		p.setEnunciado("Numa determinada loja temos três produtos à venda do mesmo setor, a cada período de uma semana podemos notar que 50% dos compradores continuam comprando o mesmo produto. Dos que compravam o produto 1, 20% passam a comprar o produto 2 e 30% o produto 3. Dos que compravam o produto 2, 10% passam a comprar o produto 1 e 40% passam a comprar o produto 3. E dos que compravam o produto 3, 30% passam a comprar o produto 1 e 20% passam a comprar o produto 2. Analisando 50 compradores destes produtos, vemos que, inicialmente, 20 compravam o produto 1, 15 compravam o produto 2, e 15 o produto 3. Qual o percentual com que um comprador do produto 1, tem de comprar outro produto com o passar do tempo?");
		p.setCategoria(2);
		p.setDificuldade(1);
		p.setQtdEstados(3);
		p.setIdentEstadoCorreto("Produto 1,Produto 2,Produto 3");
		p.setIdentEstadoErrado1("Objeto A, Objeto B, Objeto D");
		p.setIdentEstadoErrado2("Artigo X, Artigo Y, Artigo Z");
		p.setIdentEstadoErrado3("Categoria 1, Categoria 2, Categoria 3");
		p.setpTransicao("50,20,30,10,50,40,30,20,50");
		p.setPerguntaCorreta("Nesta questão é solicitada a estabilidade do fenômeno.");
		p.setPerguntaErrada1("Nesta questão é solicitada a previsão do fenômeno em um período específico.");
		p.setPerguntaErrada2("Nesta questão é solicitada a comparação entre diferentes estados do fenômeno.");
		p.setPerguntaErrada3("Esta questão busca entender o início do fenômeno.");
		p.setEstadoInicial("1,0, 0");
		p.setEstadoFinal("0.30,0.29,0.41");
		p.setValorAdd(-1);
		p.setImgPergunta(imgP);
		return p;
	}
	
	public Pergunta getPergunta7() {
		ImagemPergunta imgP = new ImagemPergunta();
		imgP.setImagemDiagrama(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Diagrama 7.png"))));
		imgP.setImagemEquacao(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Resposta 7.png"))));
		DAOImagem emImagem = new DAOImagem();
		emImagem.salvarImagem(imgP);
		Pergunta p = new Pergunta();
		p.setEnunciado("Suponha a existência de três possíveis classificações sociais para um indivíduo de uma população: classes A, B e C. Têm-se aí três estados discretos, ou seja, não há meio termo entre as classes. De 150 pessoas que estão na classe C, em média 15 migram para a classe B e nenhum para a classe A. De 80 indivíduos que estão na classe B, 40 em média migram para a classe C e 16 migram para a classe A. De 30 indivíduos que estão na classe A, em média 15 migram para a classe B e 6 para a classe C. Estudos estatísticos observaram que estas médias são percentuais fixos de migração. Quais os percentuais de estabilidade entre as classes dessa população?");
		p.setCategoria(2);
		p.setDificuldade(2);
		p.setQtdEstados(3);
		p.setIdentEstadoCorreto("Classe A,Classe B,Classe C");
		p.setIdentEstadoErrado1("Nível A, Nível B, Nível D");
		p.setIdentEstadoErrado2("Grupo A, Equipe X, Categoria C");
		p.setIdentEstadoErrado3("Setor A, Setor B, Administração");
		p.setpTransicao("30,50,20,20,30,50,0,10,90");
		p.setPerguntaCorreta("Nesta questão é solicitada a estabilidade do fenômeno.");
		p.setPerguntaErrada1("Nesta questão é solicitado o impacto do fenômeno na população.");
		p.setPerguntaErrada2("Nesta questão é solicitada a causa do fenômeno.");
		p.setPerguntaErrada3("Nesta questão é solicitada a distribuição geográfica do fenômeno.");
		p.setEstadoInicial("30,80,150");
		p.setEstadoFinal("0.04,0.15,0.81");
		p.setValorAdd(-1);
		p.setImgPergunta(imgP);
		return p;
	}
	
	public Pergunta getPergunta8() {
		ImagemPergunta imgP = new ImagemPergunta();
		imgP.setImagemDiagrama(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Diagrama 8.png"))));
		imgP.setImagemEquacao(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Resposta 8.png"))));
		DAOImagem emImagem = new DAOImagem();
		emImagem.salvarImagem(imgP);
		Pergunta p = new Pergunta();
		p.setEnunciado("Em um censo populacional de uma cidade de médio porte, foi constatado que a cada ano 7% da população rural migra para a zona urbana e que 2% da população urbana migra para a zona rural. Supondo que este fenômeno social seja estável, não havendo mudanças nestas taxas, responda, qual o percentual de equilíbrio da população.");
		p.setCategoria(2);
		p.setDificuldade(1);
		p.setQtdEstados(2);
		p.setIdentEstadoCorreto("População urbana,População rural");
		p.setIdentEstadoErrado1("População rural, População industrial");
		p.setIdentEstadoErrado2("População urbana, Comunidade suburbana");
		p.setIdentEstadoErrado3("Moradores metropolitanos, População agrícola");
		p.setpTransicao("98,2,7,93");
		p.setPerguntaCorreta("Nesta questão é solicitada a estabilidade do fenômeno.");
		p.setPerguntaErrada1("Nesta questão é solicitada a taxa de crescimento do fenômeno.");
		p.setPerguntaErrada2("Nesta questão é solicitada a variação sazonal do fenômeno.");
		p.setPerguntaErrada3("Nesta questão é solicitada a análise histórica do fenômeno.");
		p.setEstadoInicial("50,50");
		p.setEstadoFinal("0.78,0.22");
		p.setValorAdd(-1);
		p.setImgPergunta(imgP);
		return p;
	}
	
	public Pergunta getPergunta9() {
		ImagemPergunta imgP = new ImagemPergunta();
		imgP.setImagemDiagrama(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Diagrama 9.png"))));
		imgP.setImagemEquacao(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Resposta 9.png"))));
		DAOImagem emImagem = new DAOImagem();
		emImagem.salvarImagem(imgP);
		Pergunta p = new Pergunta();
		p.setEnunciado("Um determinado fruto tem sua safra classificada como superior, média e pobre. Estudos revelam, após uma safra pobre, probabilidades de 0,6 e 0,3 da safra no ano posterior ser classificada como média ou superior, respectivamente. Após uma safra média, estudos apontam probabilidades de 0,4 e 0,1 da próxima safra ser classificada como superior ou pobre, respectivamente. E após uma safra superior, estes estudos apontam probabilidades de 0,5 e 0,1 da próxima safra ser classificada como média ou pobre, respectivamente. Qual a probabilidade dessa safra ser superior daqui a 4 anos considerando que esse ano a safra foi pobre?");
		p.setCategoria(2);
		p.setDificuldade(2);
		p.setQtdEstados(3);
		p.setIdentEstadoCorreto("Safra superior,Safra média,Safra pobre");
		p.setIdentEstadoErrado1("Fruto A, Fruto B, Fruto C");
		p.setIdentEstadoErrado2("Safra, Fruto, Lucro");
		p.setIdentEstadoErrado3("Lucro superior,Lucro médio,Lucro pobre");
		p.setpTransicao("40,50,10,40,50,10,30,60,10");
		p.setPerguntaCorreta("Nesta questão é solicitado o estado esperado do fenômeno em um tempo t específico.");
		p.setPerguntaErrada1("Nesta questão é solicitada a causa da classificação da safra como superior, média ou pobre.");
		p.setPerguntaErrada2("Nesta questão é solicitada a influência do clima na classificação da safra.");
		p.setPerguntaErrada3("Nesta questão é solicitada a média de anos para que a safra alcance o estado superior.");
		p.setEstadoInicial("0,0,1");
		p.setEstadoFinal("0.39,0.51,0.10");
		p.setValorAdd(4);
		p.setImgPergunta(imgP);
		return p;
	}
	
	public Pergunta getPergunta10() {
		ImagemPergunta imgP = new ImagemPergunta();
		imgP.setImagemDiagrama(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Diagrama 10.png"))));
		imgP.setImagemEquacao(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Resposta 10.png"))));
		DAOImagem emImagem = new DAOImagem();
		emImagem.salvarImagem(imgP);
		Pergunta p = new Pergunta();
		p.setEnunciado("Uma pesquisa de mercado de um produto comercializado em três diferentes marcas constatou as seguintes probabilidades:\r\n"
				+ "<br>1. Um consumidor da marca W deste produto, a cada compra, tem probabilidade 0,8 de manter-se fiel à marca, probabilidade 0,05 de escolher a marca G e probabilidade 0,15 de escolher a marca R;\r\n"
				+ "<br>2. Um consumidor da marca G deste produto, a cada compra, tem probabilidade 0,9 de manter-se fiel à marca, probabilidade 0,01 de escolher a marca W e probabilidade 0,09 de escolher a marca R;\r\n"
				+ "<br>3. Um consumidor da marca R deste produto, a cada compra, tem probabilidade 0,5 de manter-se fiel à marca, probabilidade 0,3 de escolher a marca G e probabilidade 0,2 de escolher a marca W.\r\n"
				+ "<br>Com base nestas informações, responda qual produto ter maior probabilidade de ser comercializado?\r\n"
				+ "");
		p.setCategoria(2);
		p.setDificuldade(1);
		p.setQtdEstados(3);
		p.setIdentEstadoCorreto("Marca W,Marca G,Marca R");
		p.setIdentEstadoErrado1("Versão 1, Versão 2, Versão X");
		p.setIdentEstadoErrado2("Serviço Alpha, Serviço Beta, Serviço Gama");
		p.setIdentEstadoErrado3("Empresa X, Empresa Y, Empresa Z");
		p.setpTransicao("80,5,15,1,90,9,20,30,50");
		p.setPerguntaCorreta("Nesta questão é solicitada a estabilidade do fenômeno.");
		p.setPerguntaErrada1("Nesta questão é solicitada a distribuição normal do fenômeno.");
		p.setPerguntaErrada2("Nesta questão é solicitado o estado inicial do fenômeno.");
		p.setPerguntaErrada3("Nesta questão é solicitada a média móvel do fenômeno.");
		p.setEstadoInicial("1,1,1");
		p.setEstadoFinal("0.204,0.622,0.173");
		p.setValorAdd(-1);
		p.setImgPergunta(imgP);
		return p;
	}
	
	public Pergunta getPergunta11() {
		ImagemPergunta imgP = new ImagemPergunta();
		imgP.setImagemDiagrama(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Diagrama 11.png"))));
		imgP.setImagemEquacao(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Resposta 11.png"))));
		DAOImagem emImagem = new DAOImagem();
		emImagem.salvarImagem(imgP);
		Pergunta p = new Pergunta();
		p.setEnunciado("Uma máquina pode estar em três estados: operando, estragada e em manutenção corretiva. Em levantamentos estatísticos anteriormente feitos verificou-se que, mensalmente, uma máquina, quando colocada em funcionamento, tem probabilidade 0,9 de continuar funcionando e 0,1 de vir a apresentar algum defeito. Uma máquina em manutenção tem probabilidade 0,4 de voltar a operar em um mês e 0,6 de continuar em manutenção. Já uma máquina estragada, tem probabilidade 0,8 de entrar em manutenção e 0,2 de continuar estragada aguardando manutenção. Com base nestas informações, responda se uma máquina entrar em operação hoje, qual a probabilidade de ela estar operando, estragada ou em manutenção com o passar do tempo?");
		p.setCategoria(2);
		p.setDificuldade(2);
		p.setQtdEstados(3);
		p.setIdentEstadoCorreto("Máquina operando,Máquina estragada,Máquina em manutenção corretiva");
		p.setIdentEstadoErrado1("Máquina funcionando,Máquina parada,Máquina Usada");
		p.setIdentEstadoErrado2("Máquina ociosa,Manutenção,Trabalhador");
		p.setIdentEstadoErrado3("Máquina funcionando,Máquina em reparo,Técnico");
		p.setpTransicao("90,10,0,0,20,80,40,0,60");
		p.setPerguntaCorreta("Nesta questão é solicitada a estabilidade do fenômeno.");
		p.setPerguntaErrada1("Nesta questão é solicitada a velocidade do fenômeno");
		p.setPerguntaErrada2("Esta questão trata da magnitude do fenômeno");
		p.setPerguntaErrada3("Nesta questão é solicitado o impacto do fenômeno");
		p.setEstadoInicial("1,0,0");
		p.setEstadoFinal("0.8,0.2,0.0");
		p.setValorAdd(-1);
		p.setImgPergunta(imgP);
		return p;
	}
	
	public Pergunta getPergunta12() {
		ImagemPergunta imgP = new ImagemPergunta();
		imgP.setImagemDiagrama(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Diagrama 12.png"))));
		imgP.setImagemEquacao(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Resposta 12.png"))));
		DAOImagem emImagem = new DAOImagem();
		emImagem.salvarImagem(imgP);
		Pergunta p = new Pergunta();
		p.setEnunciado("Numa certa região durante o período de chuvas, que dura cerca de seis meses a cada ano, os estados observados são dois: dias ensolarados e dias chuvosos, os quais serão designados pelos índices 0 e 1, respectivamente. A partir de observações históricas, foram obtidas para um passo (ou seja, um dia) as probabilidades de transição supostas constantes. A um dia chuvoso sucederá um dia chuvoso com probabilidade igual a 3/4 e, um dia ensolarado, com probabilidade 1/4. Dias ensolarados sucedem dias ensolarados com probabilidades iguais a 1/2, enquanto que, ao ocorrer um dia ensolarado, a probabilidade de chover no dia seguinte é 1/2. Desejamos estudar o regime de chuvas dessa região modelando o processo estocástico descrito como um processo de Markov. Em longo prazo, qual a probabilidade de chover ou fazer sol?");
		p.setCategoria(2);
		p.setDificuldade(1);
		p.setQtdEstados(2);
		p.setIdentEstadoCorreto("Dia de sol,Dia de chuva");
		p.setIdentEstadoErrado1("Dia de nublado,Dia de tempestade");
		p.setIdentEstadoErrado2("Dia de neblina,Dia de granizo");
		p.setIdentEstadoErrado3("Dia de geada,Dia de trovão");
		p.setpTransicao("50,50,25,75");
		p.setPerguntaCorreta("Nesta questão é solicitada a estabilidade do fenômeno.");
		p.setPerguntaErrada1("Nesta questão é solicitada a relação entre o fenômeno e o clima.");
		p.setPerguntaErrada2("Nesta questão é solicitada a causa primária do fenômeno.");
		p.setPerguntaErrada3("Nesta questão é solicitada a previsibilidade do fenômeno.");
		p.setEstadoInicial("1,1");
		p.setEstadoFinal("0.333,0.667");
		p.setValorAdd(-1);
		p.setImgPergunta(imgP);
		return p;
	}
	
	public Pergunta getPergunta13() {
		ImagemPergunta imgP = new ImagemPergunta();
		imgP.setImagemDiagrama(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Diagrama 13.png"))));
		imgP.setImagemEquacao(iconParaByte(new ImageIcon(InicializarBanco.class.getResource("/InicializacaoIcon/Resposta 13.png"))));
		DAOImagem emImagem = new DAOImagem();
		emImagem.salvarImagem(imgP);
		Pergunta p = new Pergunta();
		p.setEnunciado("Uma fábrica possui duas máquinas idênticas essenciais ao processo de manufatura e são operadas continuamente, exceto quando elas estão quebradas. Devido ao fato que essas máquinas são muito sensíveis e quebram frequentemente, é necessário remunerar em tempo integral um técnico para reparar a máquina quando ocorrer alguma falha. Suponha que o intervalo de tempo de observação seja de um dia e que a variável aleatória X, representa o número de máquinas quebradas no dia N. Os valores possíveis para a variável aleatória são Xn = 0, 1 e 2. Admita que durante cem dias de observações fossem anotadas as situações das duas máquinas, chegando-se às probabilidades de transições dos estados para 1 dia, que estão mostradas na matriz P: \\n\\n<table border=\\\"1\\\" cellpadding=\\\"5\\\">\\n    <tr>\\n        <td colspan=\\\"2\\\"><b>Problema nº 13</b></td>\\n    </tr>\\n    <tr>\\n        <td rowspan=\\\"4\\\"><b>Situação posterior</b></td>\\n        <td><b>Situação anterior</b></td>\\n        <td>0</td>\\n        <td>1</td>\\n        <td>2</td>\\n    </tr>\\n    <tr>\\n        <td>0</td>\\n        <td>0.7</td>\\n        <td>0.2</td>\\n        <td>0.2</td>\\n    </tr>\\n    <tr>\\n        <td>1</td>\\n        <td>0.3</td>\\n        <td>0.8</td>\\n        <td>0.2</td>\\n    </tr>\\n    <tr>\\n        <td>2</td>\\n        <td>0.3</td>\\n        <td>0.8</td>\\n        <td>0.2</td>\\n    </tr>\\n</table>\\n\\nSe ambas as máquinas se estragarem, a probabilidade que o tempo para consertar uma dessas máquinas seja de dois dias é quanto?");
		p.setCategoria(1);
		p.setDificuldade(1);
		p.setQtdEstados(3);
		p.setIdentEstadoCorreto("0 Máquinas quebradas,1 Máquina quebrada,2 Máquinas quebradas");
		p.setIdentEstadoErrado1("0 Máquinas em standby,1 Máquina em operação,2 Máquinas em manutenção");
		p.setIdentEstadoErrado2("0 Máquinas paradas,1 Máquina em produção,2 Máquinas em produção");
		p.setIdentEstadoErrado3("0 Máquinas inoperantes,1 Máquina em espera,2 Máquinas operacionais");
		p.setpTransicao("60,20,20,20,40,40,40,20,40");
		p.setPerguntaCorreta("Nesta questão é solicitado o estado esperado do fenômeno em um tempo t específico.");
		p.setPerguntaErrada1("Nesta questão é solicitada a causa principal do fenômeno em uma precisão específica.");
		p.setPerguntaErrada2("Nesta questão é solicitado o tempo esperado do fenômeno em um estado específico.");
		p.setPerguntaErrada3("Nesta questão é solicitada a análise histórica do fenômeno em um tempo t específico.");
		p.setEstadoInicial("0,0,1");
		p.setEstadoFinal("0.44,0.48,0.08");
		p.setValorAdd(2);
		p.setImgPergunta(imgP);
		return p;
	}
	
	public static byte[] iconParaByte(ImageIcon icon) {
        BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        icon.paintIcon(null, image.getGraphics(), 0, 0);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", baos);
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	
}
