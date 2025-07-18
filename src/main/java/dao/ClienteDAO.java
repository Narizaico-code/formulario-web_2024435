package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Cliente;

/**
 *
 * @author angel
 */
public class ClienteDAO {
    //CRUD

    //Entity Manager Factory - PU
    private EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("LibreriaPU");

    public void guardar(Cliente cliente) {
        //Entity Manager, manejar las transacciones.
        EntityManager admin = fabrica.createEntityManager();
        //BEGIN - proceso - commit -> close
        try {
            admin.getTransaction().begin();
            admin.persist(cliente);
            admin.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error al guardar cliente: " + e.getMessage());
        } finally {
            admin.close();
        }

    }

    public List<Cliente> listarTodos() {
        EntityManager admin = fabrica.createEntityManager();
        try {
            //getResultList -> lista de objetos
            
            //JPQL
            return admin.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        } finally {
            admin.close();
        }
    }

    public Cliente listarPorId(int id) {
        return null;
    }

    public void actualizar(Cliente cliente) {
    }

    public void eliminar(int id) {
    }
}
