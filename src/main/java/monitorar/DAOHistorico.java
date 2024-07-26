package monitorar;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import app.Aplicacao;
import modelo.Historico;

public class DAOHistorico {

	public static EntityManagerFactory factory = Aplicacao.getEMF();
	public static EntityManager emHistorico;

	public DAOHistorico() {
		emHistorico = factory.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List<Historico> ListaHistoricoPorEstudante(int idEstudante) {
		return emHistorico.createQuery("FROM " + Historico.class.getName() + " h WHERE h.idEstudante = :idEstudante")
				.setParameter("idEstudante", idEstudante).getResultList();
	}

	public void salvarHistorico(Historico historico) {
	    try {
	        emHistorico.getTransaction().begin();
	        emHistorico.persist(historico);
	        emHistorico.getTransaction().commit();
	    } catch (Exception e) {
	        if (emHistorico.getTransaction().isActive()) {
	            emHistorico.getTransaction().rollback();
	        }
	    }
	}

	public static EntityManager getEmHistorico() {
		return emHistorico;
	}

	public static void fecharEmfHistorico() {
		if (getEmHistorico() != null) {
			factory.close();
			emHistorico.close();
		}
	}
}
