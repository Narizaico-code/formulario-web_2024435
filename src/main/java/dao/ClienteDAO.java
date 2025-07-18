package dao;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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

    public Cliente buscarPorId(int id) {
        EntityManager admin = fabrica.createEntityManager();

        try {
            return admin.find(Cliente.class, id);
        } finally {
            admin.close();
        }
    }

    public void actualizar(Cliente cliente) {
        //entitymanager, entitytransation -> begin, proceso, commit | rollback --> close
        EntityManager admin = fabrica.createEntityManager();
        EntityTransaction transaccion = admin.getTransaction();
        try {
            transaccion.begin();
            admin.merge(cliente);
            transaccion.commit();
        } catch (Exception e) {
            if (transaccion.isActive()) {
                transaccion.rollback();
            }
        } finally {
            admin.close();
        }
    }

    public void eliminar(int id) {
        EntityManager admin = fabrica.createEntityManager();
        EntityTransaction tr = admin.getTransaction();

        try {
            tr.begin();
            Cliente cliente = admin.find(Cliente.class, id);
            if (cliente != null) {
                admin.remove(cliente);
            }
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) tr.rollback();
        } finally {
            admin.close();
        }
    }
}
