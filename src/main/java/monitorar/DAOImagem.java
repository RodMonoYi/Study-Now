package monitorar;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import app.Aplicacao;
import modelo.ImagemPergunta;

public class DAOImagem {

    private static EntityManager emImagemPergunta;
    private static EntityTransaction transaction;

    public DAOImagem() {
        emImagemPergunta = Aplicacao.getEMF().createEntityManager();
    }

    public EntityManager getEmImagem() {
        return emImagemPergunta;
    }

    public void fecharEmfPergunta() {
        if (getEmImagem() != null && getEmImagem().isOpen()) {
            getEmImagem().close();
        }
    }

    public void salvarImagem(ImagemPergunta imagem) {
        try {
            transaction = getEmImagem().getTransaction();
            transaction.begin();
            getEmImagem().persist(imagem);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
