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
        admin.getTransaction().begin();
        admin.persist(cliente);
        admin.getTransaction().commit();
        admin.close();
    }

    public List<Cliente> listarTodos() {
        return null;
    }

    public Cliente listarPorId(int id) {
        return null;
    }

    public void actualizar(Cliente cliente) {
    }

    public void eliminar(int id) {
    }
}
