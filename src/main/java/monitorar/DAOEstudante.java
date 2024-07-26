package monitorar;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

import app.Aplicacao;
import modelo.Estudante;

public class DAOEstudante {

	public static EntityManagerFactory factory = Aplicacao.getEMF();
	public static EntityManager emEstudante;

	public DAOEstudante() {
		emEstudante = factory.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List<Estudante> ListaEstudantes() {
		return emEstudante.createQuery("FROM " + Estudante.class.getName()).getResultList();
	}

	public Estudante BuscarEstudante(final String matricula) {
		try {
			Estudante alunoSalvo = (Estudante) emEstudante
					.createQuery("select idEstudante from Estudante " + "idEstudante where matricula = :matricula")
					.setParameter("matricula", matricula).getSingleResult();
			return alunoSalvo;
		} catch (Exception e) {
			return null;
		}
	}

	public Estudante BuscarUsuarioSenha(final String matricula, final String senha) {
		try {
			Estudante alunoSalvo = (Estudante) emEstudante.createQuery(
					"select idEstudante from Estudante idEstudante where matricula = :matricula and senha = :senha")
					.setParameter("matricula", matricula).setParameter("senha", senha).getSingleResult();
			return alunoSalvo;
		} catch (Exception e) {
			return null;
		} finally {
			emEstudante.close();
		}
	}

	public void SalvarEstudante(Estudante estudante) {
		try {
			emEstudante.getTransaction().begin();
			emEstudante.persist(estudante);
			emEstudante.getTransaction().commit();
		} catch (Exception e) {
			if (emEstudante.getTransaction().isActive()) {
				emEstudante.getTransaction().rollback();
			}
		}
	}

	public void RemoverEstudante(Estudante estudante) {
		if (BuscarEstudante(estudante.getMatricula()).getMatricula() == estudante.getMatricula()) {
			try {
				Estudante es = BuscarEstudante(estudante.getMatricula());
				emEstudante.getTransaction().begin();
				emEstudante.remove(es);
				emEstudante.getTransaction().commit();
			} catch (Exception e) {
				if (emEstudante.getTransaction().isActive()) {
					emEstudante.getTransaction().rollback();
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Estudante não encontrado!");
		}
	}

	public static EntityManager getEmEstudante() {
		return emEstudante;
	}

	public static void fecharEmfEstudante() {
		if (getEmEstudante() != null) {
			factory.close();
			emEstudante.close();
		}
	}

}
