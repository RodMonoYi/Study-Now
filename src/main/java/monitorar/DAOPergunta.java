package monitorar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import app.Aplicacao;
import modelo.Pergunta;

public class DAOPergunta {

	public static EntityManagerFactory factory = Aplicacao.getEMF();
	public static EntityManager emPergunta;

	public DAOPergunta() {
		emPergunta = factory.createEntityManager();
	}

	public Pergunta BuscarPerguntaSingular(int categoria, int dificuldade, int idEstudante) {
		try {
			String query = "SELECT p FROM Pergunta p "
					+ "WHERE p.categoria = :categoria AND p.dificuldade = :dificuldade " + "AND (p.id NOT IN "
					+ "(SELECT h.pergunta.id FROM Historico h WHERE h.estudante.id = :idEstudante) " + "OR (p.id IN "
					+ "(SELECT h.pergunta.id FROM Historico h WHERE h.estudante.id = :idEstudante "
					+ "AND h.finalizado = false)))";
			return emPergunta.createQuery(query, Pergunta.class).setParameter("categoria", categoria)
					.setParameter("dificuldade", dificuldade).setParameter("idEstudante", idEstudante).setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Pergunta BuscarPerguntaDupla(final int categoria1, final int categoria2, int dificuldade, int idEstudante) {
		try {
			String query = "SELECT p FROM Pergunta p "
					+ "WHERE (p.categoria = :categoria1 OR p.categoria = :categoria2) AND p.dificuldade = :dificuldade "
					+ "AND (p.id NOT IN "
					+ "(SELECT h.pergunta.id FROM Historico h WHERE h.estudante.id = :idEstudante) " + "OR (p.id IN "
					+ "(SELECT h.pergunta.id FROM Historico h WHERE h.estudante.id = :idEstudante "
					+ "AND h.finalizado = false)))";
			return emPergunta.createQuery(query, Pergunta.class).setParameter("categoria1", categoria1)
					.setParameter("categoria2", categoria2).setParameter("dificuldade", dificuldade)
					.setParameter("idEstudante", idEstudante).setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Pergunta BuscarPerguntaTripla(final int categoria1, final int categoria2, final int categoria3,
			int dificuldade, int idEstudante) {
		try {
			String query = "SELECT p FROM Pergunta p "
					+ "WHERE (p.categoria = :categoria1 OR p.categoria = :categoria2 OR p.categoria = :categoria3) AND p.dificuldade = :dificuldade "
					+ "AND (p.id NOT IN "
					+ "(SELECT h.pergunta.id FROM Historico h WHERE h.estudante.id = :idEstudante) " + "OR (p.id IN "
					+ "(SELECT h.pergunta.id FROM Historico h WHERE h.estudante.id = :idEstudante "
					+ "AND h.finalizado = false)))";
			return emPergunta.createQuery(query, Pergunta.class).setParameter("categoria1", categoria1)
					.setParameter("categoria2", categoria2).setParameter("categoria3", categoria3)
					.setParameter("dificuldade", dificuldade).setParameter("idEstudante", idEstudante).setMaxResults(1)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Pergunta BuscarPerguntaGeral(final int categoria1, final int categoria2, final int categoria3,
			final int categoria4, int dificuldade, int idEstudante) {
		try {
			String query = "SELECT p FROM Pergunta p "
					+ "WHERE (p.categoria = :categoria1 OR p.categoria = :categoria2 OR p.categoria = :categoria3 OR p.categoria = :categoria4) AND p.dificuldade = :dificuldade "
					+ "AND (p.id NOT IN "
					+ "(SELECT h.pergunta.id FROM Historico h WHERE h.estudante.id = :idEstudante) " + "OR (p.id IN "
					+ "(SELECT h.pergunta.id FROM Historico h WHERE h.estudante.id = :idEstudante "
					+ "AND h.finalizado = false)))";
			return emPergunta.createQuery(query, Pergunta.class).setParameter("categoria1", categoria1)
					.setParameter("categoria2", categoria2).setParameter("categoria3", categoria3)
					.setParameter("categoria4", categoria4).setParameter("dificuldade", dificuldade)
					.setParameter("idEstudante", idEstudante).setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Pergunta BuscarPergunta(final String enunciado) {
		try {
			Pergunta perguntaSalva = (Pergunta) emPergunta
					.createQuery("select idPergunta from Pergunta " + "idPergunta where enunciadoPergunta = :enunciado")
					.setParameter("enunciado", enunciado).getSingleResult();
			return perguntaSalva;
		} catch (Exception e) {
			return null;
		}
	}

	public void SalvarPergunta(Pergunta pergunta) {
		try {
			emPergunta.getTransaction().begin();
			emPergunta.persist(pergunta);
			emPergunta.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (emPergunta.getTransaction().isActive()) {
				emPergunta.getTransaction().rollback();
			}
		}
	}

	public static EntityManager getEmPergunta() {
		return emPergunta;
	}

	public void fecharTransacao() {
		getEmPergunta().close();
	}

	public void fecharEmfPergunta() {
		if (getEmPergunta() != null) {
			factory.close();
			emPergunta.close();
		}
	}
}
