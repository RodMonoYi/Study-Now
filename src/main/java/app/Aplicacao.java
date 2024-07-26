package app;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.SwingUtilities;

import controle.ControllerTelaInicial;
import monitorar.DAOEstudante;
import monitorar.InicializarBanco;
import visao.Frame;
import visao.TelaInicial;

public class Aplicacao {

	static EntityManagerFactory emf;

	public static Frame janela;

	public Aplicacao() {
		janela = new Frame();
		janela.repaint();
		janela.revalidate();
	}

	public static void main(String[] args) throws Exception {
		new Aplicacao();
		emf = getEMF();
		if (bancoEstaVazio()) {
			inicializarBancoDeDados();
		}

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
		janela.setVisible(true);

		janela.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				fecharSistema();
			}
		});
	}

	public static EntityManagerFactory getEMF() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("appMarkov");
		}
		return emf;
	}

	public static void ReiniciarPanel() {
		SwingUtilities.invokeLater(() -> {
			janela.getContentPane().removeAll();
			janela.dispose();
			janela = new Frame();
			TelaInicial home = new TelaInicial();
			ControllerTelaInicial controleTelaInicial = new ControllerTelaInicial(home);
			janela.getContentPane().add(controleTelaInicial.getTelaHome());
			janela.setVisible(true);
			janela.repaint();
			janela.revalidate();
		});
	}

	public static void alterarTamanho(int largura, int altura) {
		janela.setSize(largura, altura);
		janela.repaint();
		janela.revalidate();
	}

	public static void retornarTamanho() {
		janela.setSize(707, 410);
		janela.repaint();
		janela.revalidate();
	}

	public static void fecharSistema() {
		DAOEstudante.fecharEmfEstudante();
		emf.close();
		System.exit(0);
	}

	private static boolean bancoEstaVazio() {
	    EntityManager entityManager = null;
	    try {
	        entityManager = emf.createEntityManager();
	        Query query = entityManager.createQuery("SELECT COUNT(e) FROM Pergunta e");
	        Long count = (Long) query.getSingleResult();
	        return count == 0;
	    } finally {
	        if (entityManager != null) {
	            entityManager.close();
	        }
	    }
	}


	private static void inicializarBancoDeDados() {
		InicializarBanco  i= new InicializarBanco();
		i.iniciaBanco();
	}

}
